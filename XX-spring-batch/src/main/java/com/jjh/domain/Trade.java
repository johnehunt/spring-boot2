package com.jjh.domain;

public class Trade {

    private String symbol;
    private int amount;
    private double price;
    private double value;

    /**
     * Required zero parameter constructor
     */
    public Trade() {}

    public Trade(String symbol, int amount, double price) {
        this(symbol, amount, price, 0.0);
    }

    public Trade(String symbol, int amount, double price, double value) {
        this.symbol = symbol;
        this.amount = amount;
        this.price = price;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "symbol='" + symbol + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", value=" + value +
                '}';
    }
}
