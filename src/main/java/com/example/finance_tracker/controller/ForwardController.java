package com.example.finance_tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForwardController {

    // Forward all routes except /api and static resources (JS, CSS, images) to Angular
    @GetMapping(value = "/{path:^(?!api$|.*\\..*$).*$}/**")
    public String forward() {
        return "forward:/browser/login/index.html";
    }
}
