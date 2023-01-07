package com.metro.crud.service;

import com.metro.crud.entity.Product;
import com.metro.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

//Annotation
@Service
// Class implementing ProductService class
  public class ProductServiceImpl
        implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Save operation
    @Override
    public Product saveProduct(Product product)
    {
        return productRepository.save(product);
    }

    //Read operation
    @Override public List<Product> fetchProductList()
    {
        return (List<Product>)
                productRepository.findAll();
    }

    //Update operation
    @Override
    public Product
    updateProduct(Product product, Long productId)
    {
        Product depDB = productRepository.findById(productId).get();

        if (Objects.nonNull(product.getProductName())
            && !"".equalsIgnoreCase(
                    product.getProductName())) {
            depDB.setProductName(
                    product.getProductName());
    }
        if (Objects.nonNull(
            product.getProductPrice())
            && !"".equalsIgnoreCase(
                    product.getProductPrice())) {
        depDB.setProductPrice(
                product.getProductPrice());
    }
        if (Objects.nonNull(product.getProductQuantity())
                && !"".equalsIgnoreCase(
                product.getProductQuantity())) {
            depDB.setProductQuantity(
                   product.getProductQuantity());
    }
        if (Objects.nonNull(product.getProductCode())
                && !"".equalsIgnoreCase(
                product.getProductCode())) {
            depDB.setProductCode(
                    product.getProductCode());
        }

        return productRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteProductById(Long productId)
    {
        productRepository.deleteById(productId);
    }

    }