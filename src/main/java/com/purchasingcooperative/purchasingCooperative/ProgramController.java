package com.purchasingcooperative.purchasingCooperative;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramController {

    @GetMapping("/")
    public String startPage(){
        return "startPage";
    }
}
