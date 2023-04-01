package br.edu.infnet.AppPetPatreon.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.AppPetPatreon.model.domain.Patreon;

@Repository
public interface PatreonRepository extends CrudRepository<Patreon, Integer> {

    @Query("from Patreon p where p.email = :email and p.password = :password")
    Patreon validate(String email, String password);
}