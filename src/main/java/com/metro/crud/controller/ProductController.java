package com.metro.crud.controller;

import com.metro.crud.entity.Product;
import com.metro.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired private ProductService productService;

    //save operation
    @PostMapping("/products")

    public Product saveProduct(
            @RequestBody Product product)
    {
        return productService.saveProduct(product);
    }

    //Read Operation
    @GetMapping("/products")

    public List<Product> fetchProductList()
    {
        return productService.fetchProductList();
    }

    // Update Operation
    @PutMapping("/products/{id}")
    public Product
    updateProduct(@RequestBody Product product,
                  @PathVariable("id") Long productId)
    {
        return productService.updateProduct(
                product, productId);
    }

    //Delete Operation
    @DeleteMapping("/products/{id}")

    public String deleteProductById(@PathVariable("id") Long productId)
    {
        productService.deleteProductById(productId);
        return "Deleted Successfully";
    }
}
