package com.stackdriverpoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        log.info("/ Controller hit", appName);
        return "home";
    }
}

