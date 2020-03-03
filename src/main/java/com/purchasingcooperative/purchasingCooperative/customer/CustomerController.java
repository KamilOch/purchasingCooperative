package com.purchasingcooperative.purchasingCooperative.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
