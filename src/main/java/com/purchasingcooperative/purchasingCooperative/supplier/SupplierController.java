package com.purchasingcooperative.purchasingCooperative.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SupplierController {

    private final SupplierService service;

    @Autowired
    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @GetMapping("/addSupplier")
    public String addSupplier(
            @RequestParam(value = "name", required = false) String name

    ) {
        if (name != null) {
            service.addSupplier(name);
        }
        return "addingSupplier";
    }
}
