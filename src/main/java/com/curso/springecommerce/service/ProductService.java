package com.curso.springecommerce.service;


import com.curso.springecommerce.model.Product;

import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    Optional<Product> get(Integer id);
    void update(Product product);
    void delete(Integer id);
}
