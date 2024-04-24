package com.curso.springecommerce.controller;

import com.curso.springecommerce.model.Product;
import com.curso.springecommerce.model.User;
import com.curso.springecommerce.service.ProductService;
import com.curso.springecommerce.service.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
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
        model.addAttribute("products", productService.findAll());
        return "products/show";
    }

    @GetMapping("/create")
    public String create() {
        return "products/create";
    }




    @PostMapping("/save")
    public String save(Product product, @RequestParam("image") MultipartFile file) throws IOException {
        LOGGER.info("The message this is {}", product);

        // Crear manualmente un objeto User con ID 1
        User u = new User();
        u.setId(1);
        product.setUser(u);

        //imagen
        if(product.getId() == null){
            // Obtener el contenido del archivo como un byte[]
            byte[] imageData = file.getBytes();
            // Asignar el byte[] al campo image de Product
            product.setImage(Arrays.toString(imageData));
        }
        productService.save(product);
        return "redirect:/product-s";
    }







    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Product product = new Product();
        Optional<Product> optionalProduct = productService.get(id);
        product = optionalProduct.get();

        LOGGER.info("Product searched:{}", product);
        model.addAttribute("product", product);

        return "products/edit";
    }









    @PostMapping("/update")
    public String update(Product product, @RequestParam("image") MultipartFile file) throws IOException {
        Product p = productService.get(product.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        if (!p.getImage().equals("default.jpg")) {
            upload.deleteImage(p.getImage());
            // Guardar la nueva imagen
            product.setImage(Arrays.toString(file.getBytes()));
        } else {
            // Conservar la imagen existente si no se proporciona un nuevo archivo
            product.setImage(p.getImage());
        }

        productService.update(product);
        return "redirect:/product-s";
    }





    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        Product p = new Product();
        p=productService.get(id).get();

        p.getImage();
        upload.deleteImage(Arrays.toString(new String[]{p.getImage()}));
        productService.delete(id);
        return "redirect:/product-s";
    }
}
