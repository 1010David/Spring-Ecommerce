package com.curso.springecommerce.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    private Date crationDate;
    private Date receiptDate;
    private double total;

    @ManyToOne()
    private User user;

    @OneToOne(mappedBy = "order")
    private OrderDetail detail;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderDetail getDetail() {
        return detail;
    }

    public void setDetail(OrderDetail detail) {
        this.detail = detail;
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
