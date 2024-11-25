package com.dev.project_keycloack.services;

import com.dev.project_keycloack.entities.Product;
import com.dev.project_keycloack.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService implements IProduct{
    private final ProductRepository productRepository;

    public void addProduct(Product product) {
        Product newProduct = new Product();
        newProduct.setRef(UUID.randomUUID().toString());
        newProduct.setName(product.getName());
        productRepository.save(newProduct);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
