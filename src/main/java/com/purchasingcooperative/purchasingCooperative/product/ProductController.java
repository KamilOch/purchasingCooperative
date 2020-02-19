package com.purchasingcooperative.purchasingCooperative.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/addProduct")
    public String addProduct(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "productUnit", required = false) ProductUnit productUnit

    ) {
        if (name != null && productUnit != null) {
            service.addProduct(name, productUnit);
        }
        return "addingProduct";
    }

    @GetMapping("/products")
    public String products(
            Model model
    ) {
        model.addAttribute("products", service.getAllProducts());
        return "products";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProductById(
            @PathVariable long id
    ) {
        service.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/editProduct/{id}")
    public String editProductById(
            @PathVariable long id,
            Model model
    ) {
        model.addAttribute("product", service.findById(id));
        return "editingProduct";
    }

    @GetMapping("/saveEditedProduct")
    public String saveEditedProduct(
            @RequestParam(value = "id", required = false) long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "productUnit", required = false) ProductUnit productUnit
    ) {
        service.editProduct(id, name, productUnit);
        return "redirect:/products";
    }
}
