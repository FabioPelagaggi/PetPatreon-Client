package br.edu.infnet.AppPetPatreon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.AppPetPatreon.model.domain.Agency;
import br.edu.infnet.AppPetPatreon.model.domain.Patreon;
import br.edu.infnet.AppPetPatreon.service.AgencyService;
import br.edu.infnet.AppPetPatreon.service.PatreonService;

@Controller
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @Autowired
    private PatreonService PatreonService;

    String message = "";
    String messageError = "";

    @GetMapping(value = "/agency/register")
    public String registerScreen() {
        return "agency/register";
    }

    @GetMapping(value = "/agency/registerFirst")
    public String registerFirstScreen() {
        return "agency/registerFirst";
    }

    @GetMapping(value = "/agency/updateAgency")
    public String updateAgencyScreen(Model model) {
        model.addAttribute("agencies", agencyService.getAgencies());

        return "agency/updateAgency";
    }

    @PostMapping(value = "/agency/update")
    public String update(int agencyId, @SessionAttribute("logedPatreon") Patreon logedPatreon) {

        Agency agency = agencyService.get(agencyId);
        logedPatreon.setAgency(agency);

        PatreonService.update(logedPatreon);

        message = "Your Agency was updated to" + agency.getName() + ".";

        return "redirect:/agency/table";
    }

    @PostMapping(value = "/agency/add")
    public String add(Agency agency, @SessionAttribute("logedPatreon") Patreon logedPatreon) {

        agency.addPatreon(logedPatreon);

        List<Agency> agenciesList = agencyService.getAgencies();

        for (Agency agencyList : agenciesList) {
            if (agencyList.getName().equals(agency.getName())) {
                messageError = "Agency " + agency.getName() + " already exists.";
                return "redirect:/agency/table";
            } else if (agencyList.getEmail().equals(agency.getEmail())) {
                messageError = "Agency with e-mail " + agency.getEmail() + " already exists.";
                return "redirect:/agency/table";
            }
        }

        agencyService.add(agency);

        logedPatreon.setAgency(agency);

        message = "Agency " + agency.getName() + " was added.";

        return "redirect:/agency/table";
    }

    @PostMapping(value = "/agency/addFirst")
    public String addFirst(Agency agency) {

        List<Agency> agenciesList = agencyService.getAgencies();

        for (Agency agencyList : agenciesList) {
            if (agencyList.getName().equals(agency.getName())) {
                messageError = "Agency " + agency.getName() + " already exists.";
                return "redirect:/home";
            } else if (agencyList.getEmail().equals(agency.getEmail())) {
                messageError = "Agency with e-mail " + agency.getEmail() + " already exists.";
                return "redirect:/home";
            }
        }

        agencyService.add(agency);

        message = "Agency " + agency.getName() + " was added.";

        return "redirect:/patreon/register";
    }

    @GetMapping(value = "/agency/{id}/remove")
    public String remove(@PathVariable Integer id) {

        try {
            message = "Agency " + agencyService.get(id).getName() + " was removed.";
            agencyService.remove(id);
        } catch (Exception e) {
            message = "";
            messageError = "Agency " + agencyService.get(id).getName() + " can't be removed.";
        }

        return "redirect:/agency/table";
    }

    @GetMapping(value = "/agency/table")
    public String agencysTableScreen(Model model) {

        model.addAttribute("agencies", agencyService.getAgencies());
        model.addAttribute("message", message);
        model.addAttribute("messageError", messageError);

        message = "";
        messageError = "";

        return "agency/table";
    }
}
