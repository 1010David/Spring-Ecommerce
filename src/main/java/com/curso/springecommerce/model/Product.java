package com.curso.springecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String decription;
    private String image;
    private double price;
    private int amount;

    @ManyToOne
    private User user;

    public Product() {
    }

    public Product(User user, int amount, double price, String imagen, String decription, String name, Integer id) {
        this.user = user;
        this.amount = amount;
        this.price = price;
        this.image = imagen;
        this.decription = decription;
        this.name = name;
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", decription='" + decription + '\'' +
                ", imagen='" + image + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
