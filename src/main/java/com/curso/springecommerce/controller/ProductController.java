package com.curso.springecommerce.controller;

import com.curso.springecommerce.model.Product;
import com.curso.springecommerce.model.User;
import com.curso.springecommerce.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
@RequestMapping("/product-s")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;



    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", productService.findAll());
        return "products/show";

    }


    @GetMapping("/create")
    public String create(){
        return "products/create";
    }
    @PostMapping("/save")
    public String save(Product product) {
        LOGGER.info("The message this is {}",product);

        // Crear manualmente un objeto User con ID 1
        User user = new User();
        user.setId(1);

        product.setUser(user);
        productService.save(product);

        return "redirect:/product-s";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Product product= new Product();
        Optional<Product> optionProduct=productService.get(id);
        product= optionProduct.get();

        LOGGER.info("Product searched:{}",product);
        model.addAttribute("product", product);

        return "products/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/product-s";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/product-s";
    }

}
