package br.com.attornatus.desafio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
	@GetMapping(path = "/api/status")
    public String check() {
        return "This application is on-line";
    }

}
