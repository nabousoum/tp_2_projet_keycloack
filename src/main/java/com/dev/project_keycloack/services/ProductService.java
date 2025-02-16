package com.dev.project_keycloack.services;

import com.dev.project_keycloack.entities.Product;
import com.dev.project_keycloack.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService implements IProduct {
    private final ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        product.setRef(UUID.randomUUID().toString());
        productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
