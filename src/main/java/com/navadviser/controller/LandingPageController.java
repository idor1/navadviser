package com.navadviser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {
    @GetMapping(path = "/")
    public String redirectToLandingPage() {
        return "index.html";
    }
}
