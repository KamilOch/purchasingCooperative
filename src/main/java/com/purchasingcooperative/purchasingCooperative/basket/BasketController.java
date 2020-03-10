package com.purchasingcooperative.purchasingCooperative.basket;

import com.purchasingcooperative.purchasingCooperative.customer.CustomerService;
import com.purchasingcooperative.purchasingCooperative.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BasketController {

    private final BasketService basketService;
    private final ProductService productService;
    private final CustomerService customerService;

    @Autowired
    public BasketController(BasketService basketService, ProductService productService, CustomerService customerService) {
        this.basketService = basketService;
        this.productService = productService;
        this.customerService = customerService;
    }

    @GetMapping("/showProducts")
    public String showProductsById(
            Model model,
            HttpServletRequest httpServletRequest


    ) {

        HttpSession session = httpServletRequest.getSession();

        model.addAttribute("customer", customerService.getCustomerById((Long)session.getAttribute("user")));
        model.addAttribute("showProducts", productService.getAllProducts());
        return "showProducts";
    }

    @GetMapping("/addToBasket/{id}")
    public String addToBasket(
            @RequestParam(value = "customerId", required = false) long customerId,
            @PathVariable long id,
            Model model
    ) {
        model.addAttribute("customer", customerService.getCustomerById(customerId));
        model.addAttribute("product", productService.findById(id));
        return "addingToBasket";
    }

    @GetMapping("/putProductToBasket")
    public String putProductToBasket(
            @RequestParam(value = "id", required = false) long id,
            @RequestParam(value = "quantity", required = false) double quantity
    ) {
        basketService.addToBasketProductAndQuantity(id, quantity);
        return "redirect:/showProducts";
    }

    @GetMapping("/showBasket")
    public String showBasket(
            HttpServletRequest httpServletRequest,
            Model model
    ) {

        HttpSession session = httpServletRequest.getSession();

        model.addAttribute("customer", customerService.getCustomerById((Long)session.getAttribute("user")));
        model.addAttribute("basket", basketService.getBasketList());
        model.addAttribute("total", basketService.basketSum());
        return "showBasket";
    }

    @GetMapping("/deleteProductFromBasket/{id}")
    public String deleteProductFromBasketById(
            @PathVariable long id
    ) {
        basketService.removeFromBasketProduct(id);
        return "redirect:/showBasket";
    }

    @GetMapping("/editQuantity/{id}")
    public String editQuantity(
            @PathVariable long id,
            @RequestParam(value = "newQuantity", required = false) Double newQuantity
    ) {
        if (null != newQuantity) {
            basketService.changeQuantity(id, newQuantity);
        }
        return "redirect:/showBasket";
    }

}
