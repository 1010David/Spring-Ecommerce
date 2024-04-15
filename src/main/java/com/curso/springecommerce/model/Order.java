package com.curso.springecommerce.model;


import java.util.Date;

public class Order {

    private Integer id;
    private String number;
    private Date crationDate;
    private Date receiptDate;
    private double total;

    public Order() {
    }

    public Order(double total, Date receiptDate, Date crationDate, String number, Integer id) {
        this.total = total;
        this.receiptDate = receiptDate;
        this.crationDate = crationDate;
        this.number = number;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCrationDate() {
        return crationDate;
    }

    public void setCrationDate(Date crationDate) {
        this.crationDate = crationDate;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", crationDate=" + crationDate +
                ", receiptDate=" + receiptDate +
                ", total=" + total +
                '}';
    }
}
