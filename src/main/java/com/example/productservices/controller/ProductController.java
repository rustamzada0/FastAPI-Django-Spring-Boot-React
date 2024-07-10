package com.example.productservices.controller;

import com.example.productservices.model.Product;
import com.example.productservices.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @PostMapping("/newProduct")
//    @ModelAttribute --- > form-data atsaq
    public Product newProduct(@RequestBody Product product) {
        System.out.println(product);
        System.out.println(product.getClass());

        return productService.createProduct(product);
    }


    @PostMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {

        return productService.updateProduct(id, product);
    }
}
