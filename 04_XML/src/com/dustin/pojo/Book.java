package com.dustin.pojo;

import java.math.BigDecimal;

/**
 * @Classname Book
 * @Descrption TODO
 * @Date 2021/6/17上午 04:12
 * @Created By Dustin_Peng
 */
public class Book {
    private String sn;
    private String name;
    private BigDecimal price;
    private String author;

    public Book() {
    }

    public Book(String sn, String name, BigDecimal price, String author) {
        this.sn = sn;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }

    public String getSn() {
        return sn;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
