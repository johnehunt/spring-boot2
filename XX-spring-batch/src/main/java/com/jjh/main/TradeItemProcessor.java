package com.jjh.main;

import com.jjh.domain.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class TradeItemProcessor implements ItemProcessor<Trade, Trade> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeItemProcessor.class);

    @Override
    public Trade process(final Trade trade) throws Exception {
        String symbol = trade.getSymbol().toUpperCase();
        int amount = trade.getAmount();
        double price = trade.getPrice();
        Trade transformedTrade = new Trade(symbol, amount, price);
        transformedTrade.setValue(amount * price);
        LOGGER.info("Converting ( {} ) into ( {} )", trade, transformedTrade);
        return transformedTrade;
    }
}