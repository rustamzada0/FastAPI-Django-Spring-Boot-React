package com.example.productservices.service;

import com.example.productservices.model.Product;
import com.example.productservices.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
//        productRepository.deleteById(Long.valueOf(id)); paramterden "id"-ni Integer gonderse idik, repositorye "Long" gondermeli idik (Repository Long alir)
        productRepository.deleteById(id);
    }

    public ResponseEntity<?> updateProduct(Long id, Product product) {
//      1-ci version
//        try {
//            Product foundedProduct2 = productRepository.findById(id).get();
//
//            foundedProduct2.setName(product.getName());
//            foundedProduct2.setDescription(product.getDescription());
//            foundedProduct2.setPrice(product.getPrice());
//            productRepository.save(foundedProduct2);
//
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }


//        2 - ci version
        Optional<Product> foundedProduct = productRepository.findById(id);

        if (foundedProduct.isPresent()) {

            foundedProduct.get().setName(product.getName());
            foundedProduct.get().setPrice(product.getPrice());
            foundedProduct.get().setDescription(product.getDescription());

            Product updatedProduct = productRepository.save(foundedProduct.get());

            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
//        return null;
    }
}
