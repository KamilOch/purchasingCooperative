package com.purchasingcooperative.purchasingCooperative.product;

import com.purchasingcooperative.purchasingCooperative.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class ProductController {

    private final ProductService productService;
    private final SupplierService supplierService;

    @Autowired
    public ProductController(ProductService productService, SupplierService supplierService) {
        this.productService = productService;
        this.supplierService = supplierService;
    }

    @GetMapping("/addProduct")
    public String addProduct(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "productUnit", required = false) ProductUnit productUnit,
            @RequestParam(value = "supplierId", required = false) Long supplierId,
            @RequestParam(value = "price", required = false) BigDecimal price,
            Model model

    ) {
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        if (name != null && productUnit != null) {
            productService.addProduct(name, productUnit, supplierId, price);
        }
        return "addingProduct";
    }

    @GetMapping("/products")
    public String products(
            Model model
    ) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProductById(
            @PathVariable long id
    ) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/editProduct/{id}")
    public String editProductById(
            @PathVariable long id,
            Model model
    ) {
        model.addAttribute("product", productService.findById(id));
        return "editingProduct";
    }

    @GetMapping("/saveEditedProduct")
    public String saveEditedProduct(
            @RequestParam(value = "id", required = false) long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "productUnit", required = false) ProductUnit productUnit
    ) {
        productService.editProduct(id, name, productUnit);
        return "redirect:/products";
    }
}
