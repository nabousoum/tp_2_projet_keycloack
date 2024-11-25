package com.dev.project_keycloack.services;

import com.dev.project_keycloack.entities.Product;

import java.util.List;

public interface IProduct {
    void addProduct(Product product);
    List<Product> getProducts();
}
