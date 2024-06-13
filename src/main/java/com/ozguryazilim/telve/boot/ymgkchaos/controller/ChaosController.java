package com.ozguryazilim.telve.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Controller
public class ChaosController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("result", "");
        return "index";
    }

    @PostMapping("/chaosmonkey/assaults")
    public String applyChaos(@RequestParam("level") int level, Model model) {
        String url = "http://hybrid-circle-426017-j4.rj.r.appspot.com/actuator/chaosmonkey/assaults";
        String payload = String.format("{\"level\": \"%d\", \"latencyActive\": false, \"exceptionsActive\": true}",
                level);
        ResponseEntity<String> response = restTemplate.postForEntity(url, payload, String.class);

        model.addAttribute("result", response.getBody());
        return "index";
    }
}
