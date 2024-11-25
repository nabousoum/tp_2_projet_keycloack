package com.dev.project_keycloack.controllers;

import com.dev.project_keycloack.entities.Product;
import com.dev.project_keycloack.services.IProduct;
import lombok.RequiredArgsConstructor;
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
//        OAuth2AuthenticationToken authentication =
//                (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        var list = productService.getProducts();
        model.addAttribute("products", list);
        model.addAttribute("product", new Product());
//        model.addAttribute("username", authentication.getPrincipal().getAttribute("preferred_username"));
//        model.addAttribute("name", authentication.getPrincipal().getAttribute("name"));
        return "product";
    }

    @PostMapping
    public String addProduct(ModelMap model, @ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/product";
    }
}
