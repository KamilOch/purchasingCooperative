package com.purchasingcooperative.purchasingCooperative.customer;

import com.purchasingcooperative.purchasingCooperative.basket.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/addCustomer")
    public String addCustomer(
            @RequestParam(value = "email", required = false) String email
    ) {
        if (email != null) {
            service.addCustomer(email);
        }
        return "addingCustomer";
    }

    @GetMapping("/customers")
    public String customers(
            Model model
    ) {
        model.addAttribute("customers", service.getAllCustomers());
        return "customers";
    }

    @GetMapping("/login")
    public String login(
            Model model,
            @RequestParam(value = "customerId", required = false) long customerId,
            HttpServletRequest req
    ) {
        req.getSession().invalidate();
        req.getSession().setAttribute("user", customerId);
        req.getSession().setAttribute("basket", new Basket());
        model.addAttribute("customers", service.getAllCustomers());
        return "customers";
    }

}
