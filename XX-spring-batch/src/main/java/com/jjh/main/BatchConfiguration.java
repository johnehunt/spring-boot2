package com.jjh.main;

import com.jjh.domain.Trade;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Value("${file.input}")
    private String fileInput;

    @Bean
    public FlatFileItemReader<Trade> reader() {
        final FlatFileItemReader coffeeItemReader = new FlatFileItemReaderBuilder().name("tradeItemReader")
                .resource(new ClassPathResource(fileInput))
                .delimited()
                .names(new String[]{"symbol", "amount", "price"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper() {{
                    setTargetType(Trade.class);
                }})
                .build();
        return coffeeItemReader;
    }

    @Bean
    public TradeItemProcessor processor() {
        return new TradeItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO trades (symbol, amount, price, value) VALUES (:symbol, :amount, :price, :value)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Trade> writer) {
        final TaskletStep step1 = stepBuilderFactory.get("step1")
                .<Trade, Trade>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
        return step1;
    }



}
