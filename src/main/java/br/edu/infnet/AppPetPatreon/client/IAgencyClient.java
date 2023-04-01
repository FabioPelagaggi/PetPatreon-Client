package br.edu.infnet.AppPetPatreon.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.AppPetPatreon.model.domain.Agency;

@FeignClient(name = "agencyClient", url = "http://localhost:8090/api/agency")
public interface IAgencyClient {

    @GetMapping(value = "/list")
    public List<Agency> getAgencies();

    @PostMapping(value = "/add")
    public Agency addAgency(@RequestBody String agencyJson);

    @PutMapping(value = "/update")
    public void updateAgency(@RequestBody String agency);

    @DeleteMapping(value = "/delete")
    public void deleteAgency(@RequestBody String agency);        

}
