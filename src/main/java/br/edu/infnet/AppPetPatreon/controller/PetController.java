package br.edu.infnet.AppPetPatreon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.AppPetPatreon.model.domain.Patreon;
import br.edu.infnet.AppPetPatreon.service.PetService;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    String message = "";
    String messageError = "";

    @GetMapping(value = "/pet")
    public String registerScreen() {
        return "pet/register";
    }

    @PostMapping(value = "/pet/add")
    public String add(String pet) {

        switch (pet) {
            case "Dog":
                return "pet/regDog";
            case "Bird":
                return "pet/regBird";
            case "Horse":
                return "pet/regHorse";
            default:
                return "pet/register";
        }
    }

    @GetMapping(value = "/pet/{id}/remove")
    public String remove(@PathVariable Integer id) {

        try{
            message = "Pet " + petService.get(id).getName() + " was removed.";
            petService.remove(id);
        } catch (Exception e) {
            message = "";
            messageError = "Pet " + petService.get(id).getName() + " can't be removed.";
        }

        return "redirect:/pet/table";
    }

    @GetMapping(value = "/pet/table")
    public String petsTableScreen(Model model, @SessionAttribute("logedPatreon") Patreon logedPatreon) {

        model.addAttribute("pets", petService.getPets());
        model.addAttribute("message", message);
        model.addAttribute("messageError", messageError);

        message = "";
        messageError = "";

        return "pet/table";
    }

    @GetMapping(value = "/pet/tableAgency")
    public String petsTableAgencyScreen(Model model, @SessionAttribute("logedPatreon") Patreon logedPatreon) {

        model.addAttribute("pets", petService.getPets(logedPatreon.getAgency()));
        model.addAttribute("message", message);
        model.addAttribute("messageError", messageError);

        message = "";
        messageError = "";

        return "pet/table";
    }

    @GetMapping(value = "/pet/tableDog")
    public String petsTableDogScreen(Model model, @SessionAttribute("logedPatreon") Patreon logedPatreon) {

        model.addAttribute("pets", petService.getDogs());
        model.addAttribute("message", message);
        model.addAttribute("messageError", messageError);

        message = "";
        messageError = "";

        return "pet/tableDog";
    }

    @GetMapping(value = "/pet/tableBird")
    public String petsTableBirdScreen(Model model, @SessionAttribute("logedPatreon") Patreon logedPatreon) {

        model.addAttribute("pets", petService.getBirds());
        model.addAttribute("message", message);
        model.addAttribute("messageError", messageError);

        message = "";
        messageError = "";

        return "pet/tableBird";
    }

    @GetMapping(value = "/pet/tableHorse")
    public String petsTableHorseScreen(Model model, @SessionAttribute("logedPatreon") Patreon logedPatreon) {

        model.addAttribute("pets", petService.getHorses());
        model.addAttribute("message", message);
        model.addAttribute("messageError", messageError);

        message = "";
        messageError = "";

        return "pet/tableHorse";
    }

}
