package com.purchasingcooperative.purchasingCooperative;

import com.purchasingcooperative.purchasingCooperative.product.ProductService;
import com.purchasingcooperative.purchasingCooperative.product.ProductUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProgramController {

    private final ProductService service;


    @Autowired
    public ProgramController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String startPage() {
        return "startPage";
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


}
