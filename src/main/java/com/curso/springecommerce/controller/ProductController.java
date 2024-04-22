package com.curso.springecommerce.controller;

import com.curso.springecommerce.model.Product;
import com.curso.springecommerce.model.User;
import com.curso.springecommerce.service.ProductService;
import com.curso.springecommerce.service.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Controller
@RequestMapping("/product-s")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private UploadFileService upload;


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
    public String save(Product product, @RequestParam("image") MultipartFile file) throws IOException {
        LOGGER.info("The message this is {}",product);

        // Crear manualmente un objeto User con ID 1
        User user = new User();
        user.setId(1);
        product.setUser(user);

        //image
        if (product.getId()==null) {                     // When a product is created
            String imageName = upload.saveImage(file);
            product.getImage(imageName);
        }

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
    public String update(Product product, @RequestParam("image") MultipartFile file) throws IOException {

        if (file.isEmpty()){
            Product p= new Product();
            p=productService.get(product.getId()).get();  //When we edit a product & we don't change image
            product.setImage(p.getImage());
        }else {                           // When we edit the image

            Product p = new Product();
            p=productService.get(product.getId()).get();

            if (!p.getImage().equals("default.jpg")){   // For delete when don't be defect image
                upload.deleteImage(p.getImage());
            }


            String nameImage= upload.saveImage(file);
            product.setImage(nameImage);

        }                                            // For delete when don't be defect image

        productService.update(product);
        return "redirect:/product-s";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){

        Product p = new Product();
        p=productService.get(id).get();

        if (!p.getImage().equals("default.jpg")){   // For delete when don't be defect image
            upload.deleteImage(p.getImage());
        }

        productService.delete(id);
        return "redirect:/product-s";
    }


}
