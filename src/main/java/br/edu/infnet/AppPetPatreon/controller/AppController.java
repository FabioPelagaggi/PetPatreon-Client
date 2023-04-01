package br.edu.infnet.AppPetPatreon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping(value = "/home")
    public String indexScreen() {
        return "index";
    }

}
