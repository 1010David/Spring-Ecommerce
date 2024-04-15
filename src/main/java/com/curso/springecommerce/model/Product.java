package com.curso.springecommerce.model;

public class Product {

    private Integer id;
    private String name;
    private String decription;
    private String imagen;
    private double price;
    private int amount;

    public Product() {
    }

    public Product(int amount, double price, String imagen, String decription, String name, Integer id) {
        this.amount = amount;
        this.price = price;
        this.imagen = imagen;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", decription='" + decription + '\'' +
                ", imagen='" + imagen + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
