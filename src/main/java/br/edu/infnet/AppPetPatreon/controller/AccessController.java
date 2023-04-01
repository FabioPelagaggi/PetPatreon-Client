package br.edu.infnet.AppPetPatreon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.AppPetPatreon.model.domain.Patreon;
import br.edu.infnet.AppPetPatreon.service.PatreonService;

@Controller
@SessionAttributes("logedPatreon")
public class AccessController {

    Patreon logedPatreon = null;

    @Autowired
    private PatreonService patreonService;

    @GetMapping(value = "/login")
    public String loginScreen() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {

        status.setComplete();
        session.removeAttribute("logedPatreon");
        logedPatreon = null;

        return "redirect:/home";
    }

    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam String email, @RequestParam String password) {

        logedPatreon = patreonService.validate(email, password);

        if (logedPatreon != null) {

            model.addAttribute("logedPatreon", logedPatreon);

            return "redirect:/home";
        } else {

            model.addAttribute("errorMsg", "Invalid Email or Password");

            return "login";
        }
    }

}
