package com.ntt.dio.productcatalog.controller;

import com.ntt.dio.productcatalog.dto.ProductDTO;
import com.ntt.dio.productcatalog.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Resource(name = "productService")
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product) {
        ProductDTO createdProduct = productService.create(product);
        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.listAll());
    }

    @GetMapping("/list-by-name")
    public  ResponseEntity<List<ProductDTO>> getProductsByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.findByName(name));
    }

    @GetMapping("/list-by-description")
    public  ResponseEntity<List<ProductDTO>> getProductsByDescription(@RequestParam String description) {
        return ResponseEntity.ok(productService.findByDescription(description));
    }

    @GetMapping("/list-by-price")
    public  ResponseEntity<List<ProductDTO>> getProductsByPrice(@RequestParam Double price) {
        return ResponseEntity.ok(productService.findByPrice(price));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductsById(@PathVariable Long id) {

        Optional<ProductDTO> product = productService.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}