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
import javax.xml.bind.SchemaOutputResolver;

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
            // @RequestParam(value = "id", required = false) long customerId,
            Model model,
            HttpServletRequest httpServletRequest
            //,
//            @RequestParam String dupa,
//            @RequestParam String kupa

    ) {

        HttpSession session = httpServletRequest.getSession();
//        session.setAttribute("dupa", dupa);
//        session.setAttribute("k", kupa);
        //TODO
       // long customerId = 1;

       // model.addAttribute("customer", customerService.getCustomerById(customerId));
        model.addAttribute("customer", customerService.getCustomerById((Long)session.getAttribute("user")));
        model.addAttribute("showProducts", productService.getAllProducts());
        return "showProducts";
    }

//    @GetMapping("/showProducts")
//    public String showProducts(
//            Model model
//    ) {
//        model.addAttribute("showProducts", productService.getAllProducts());
//        return "showProducts";
//    }

    @GetMapping("/addToBasket/{id}")
    public String addToBasket(
//            @RequestParam("customerId") long customerId,
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
            @RequestParam(value = "customerId", required = false) long customerId,
            Model model
    ) {
        model.addAttribute("customer", customerService.getCustomerById(customerId));
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
