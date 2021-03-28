package com.etm.racc.map.prop;

public abstract class Card {
    /**
     * 编号
     */
    protected Integer number;

    /**
     * 标题
     */
    protected String title;

    public Card(Integer number, String title) {
        this.number = number;
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.getClass() + ": number: " + this.number + ", title: " + this.title;
    }
}
