package com.purchasingcooperative.purchasingCooperative.basket;

import com.purchasingcooperative.purchasingCooperative.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BasketController {

    private final BasketService basketService;
    private final ProductService productService;

    @Autowired
    public BasketController(BasketService basketService, ProductService productService) {
        this.basketService = basketService;
        this.productService = productService;
    }

    @GetMapping("/showProducts")
    public String showProducts(
            Model model
    ) {
        model.addAttribute("showProducts", productService.getAllProducts());
        return "showProducts";
    }

    @GetMapping("/addToBasket/{id}")
    public String addToBasket(
            @PathVariable long id,
            Model model
    ) {
        model.addAttribute("product", productService.findById(id) );
        return "addingToBasket";
    }


}
