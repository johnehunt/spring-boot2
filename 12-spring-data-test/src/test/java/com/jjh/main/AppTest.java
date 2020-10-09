package com.jjh.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test the configuration of the Application
 */
@SpringBootTest(classes = { TestConfig.class} )
class AppTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    StudentRepository repo;

    @Test
    public void contextLoads() {
        assertThat(context).isNotNull();
    }

    @Test
    public void checkAllBeansLoaded() {
        int totalBeans = this.context.getBeanDefinitionCount();
        assertThat(totalBeans).isEqualTo(93);
    }

    @Test
    public void repoConfigured() {
        assertThat(repo).isNotNull();
    }

    @Test
    public void saveToRepo() {
        Student student = new Student(8,
                "Jill",
                "Matthews",
                "Law",
                "jm@my.com",
                "2");
        repo.save(student);
        Student result = repo.findById(8).get();
        assertThat(result.getName()).isEqualTo("Jill");
    }

}