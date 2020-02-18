package com.purchasingcooperative.purchasingCooperative;

import com.purchasingcooperative.purchasingCooperative.product.ProductService;
import com.purchasingcooperative.purchasingCooperative.product.ProductUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
            @RequestParam(value = "unit", required = false) ProductUnit unit
    ) {
        if(name != null && unit != null){
            service.addProduct(name,unit);
        }
        return "addingProduct";
    }
}
