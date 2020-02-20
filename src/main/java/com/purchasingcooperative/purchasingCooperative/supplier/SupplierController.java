package com.purchasingcooperative.purchasingCooperative.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/suppliers")
    public String suppliers(
            Model model
    ) {
        model.addAttribute("suppliers", service.getAllSuppliers());
        return "suppliers";
    }

    @GetMapping("/deleteSupplier/{id}")
    public String deleteSupplierById(
            @PathVariable long id
    ) {
        service.deleteSupplier(id);
        return "redirect:/suppliers";
    }

    @GetMapping("/editSupplier/{id}")
    public String editSupplierById(
            @PathVariable long id,
            Model model
    ){
        model.addAttribute("supplier", service.findById(id));
        return "editingSupplier";
    }

    @GetMapping("/saveEditedSupplier")
    public String saveEditedSupplier(
            @RequestParam(value = "id", required = false) long id,
            @RequestParam(value = "name", required = false) String name
    ){
        service.editSupplier(id, name);
        return "redirect:/suppliers";
    }
}
