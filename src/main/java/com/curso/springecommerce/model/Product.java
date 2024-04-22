package com.curso.springecommerce.model;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @Transient // Esto evita que JPA intente persistir este campo
    private MultipartFile image;    private double price;
    private int amount;

    @ManyToOne
    private User user;

    public Product() {
    }

    public Product(Integer id, String name, String description, MultipartFile image, double price, int amount, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.amount = amount;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
                ", description='" + description + '\'' +
                ", image='" + Arrays.toString(new MultipartFile[]{image}) + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
