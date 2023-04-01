package br.edu.infnet.AppPetPatreon.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.AppPetPatreon.model.domain.Agency;

public interface AgencyRepository extends CrudRepository<Agency, Integer> {
    
}
