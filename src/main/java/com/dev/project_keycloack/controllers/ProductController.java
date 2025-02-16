package com.dev.project_keycloack.controllers;

import com.dev.project_keycloack.entities.Product;
import com.dev.project_keycloack.services.IProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProduct productService;

    @GetMapping
    @ResponseBody
    public List<Product> getProducts() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof JwtAuthenticationToken)) {
            throw new RuntimeException("L'utilisateur n'est pas authentifié !");
        }

        return productService.getProducts();
    }

    @PostMapping
    @ResponseBody
    public String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "Produit ajouté avec succès !";
    }
}
