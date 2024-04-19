package com.curso.springecommerce.controller;

import com.curso.springecommerce.model.Product;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product-s")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("")
    public String show() {

        return "products/show";

    }

    @GetMapping("/create")
    public String create(){
        return "products/create";
    }

    @PostMapping("/saving")
    public String save(Product product) {
        LOGGER.info("This is the product object {}",product);
        return "redirect:/product-s";
    }

}
