package com.metro.crud.service;

import com.metro.crud.entity.Product;

import java.util.List;

public interface ProductService {

    // Save operation

    Product saveProduct(Product product);

    //Read opeartion
    List<Product> fetchProductList();

    //Update operation
    Product updateProduct(Product product, Long productId);

    //Delete operation
    void deleteProductById(Long productId);

}
