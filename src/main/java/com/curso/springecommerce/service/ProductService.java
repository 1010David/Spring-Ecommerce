package com.curso.springecommerce.service;


import com.curso.springecommerce.model.Product;

import java.util.Optional;

public interface ProductService {
    public Product save(Product product);
    public Optional<Product> get(Integer id);
    public void update(Product product);
    public void delete(Integer id);
}
