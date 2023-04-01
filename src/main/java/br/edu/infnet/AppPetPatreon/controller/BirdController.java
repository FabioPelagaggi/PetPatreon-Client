package br.edu.infnet.AppPetPatreon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.AppPetPatreon.model.domain.Bird;
import br.edu.infnet.AppPetPatreon.model.domain.Patreon;
import br.edu.infnet.AppPetPatreon.service.PetService;

@Controller
public class BirdController {

    @Autowired
    private PetService petService;

    @PostMapping(value = "/pet/addBird")
    public String addBird(Bird bird, @SessionAttribute("logedPatreon") Patreon logedPatreon) {
        
        bird.setAgency(logedPatreon.getAgency());
        petService.add(bird);

        return "redirect:/pet/table";
    }
}
