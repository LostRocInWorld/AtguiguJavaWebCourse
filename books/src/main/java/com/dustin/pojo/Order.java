package com.dustin.pojo;

import java.math.BigDecimal;

/**
 * @Classname Order
 * @Descrption TODO
 * @Date 2021/7/6上午 04:34
 * @Created By Dustin_Peng
 */
public class Order {
    private String orderId;
    //使用字符串来代替输出时间，DbUtils在处理java.sql.Date转换成结果集时会报错:Cannot set createTime:incompitable types.
    private String createTime;
    //0未发货，1已发货，2已签收
    private BigDecimal totalPrice;
    private Integer status = 0;
    private Integer userId;

    public Order() {
    }

    public Order(String orderId, String createTime, BigDecimal totalPrice, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.totalPrice = totalPrice;
        this.status = status;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
