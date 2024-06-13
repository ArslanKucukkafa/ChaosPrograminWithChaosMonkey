package com.ozguryazilim.telve.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ChaosController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/chaosmonkey/assaults")
    public String applyChaos(@RequestParam("level") int level) {
        String url = "http://localhost:8080/actuator/chaosmonkey/assaults?level=" + level;
        restTemplate.postForObject(url, null, String.class);
        return "redirect:/";
    }
}
