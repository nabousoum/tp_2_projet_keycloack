package com.dev.project_keycloack.controllers;

import com.dev.project_keycloack.entities.Product;
import com.dev.project_keycloack.services.IProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProduct productService;

    @GetMapping
    public String getProducts(ModelMap model) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof JwtAuthenticationToken)) {
            model.addAttribute("error", "L'utilisateur n'est pas authentifié !");
            return "error";
        }

        JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) authentication;
        var list = productService.getProducts();
        model.addAttribute("products", list);
        model.addAttribute("product", new Product());
        model.addAttribute("username", jwtToken.getTokenAttributes().get("preferred_username"));
        model.addAttribute("name", jwtToken.getTokenAttributes().get("name"));
        return "product";
    }


    @PostMapping
    public String addProduct(ModelMap model, @ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }
}
