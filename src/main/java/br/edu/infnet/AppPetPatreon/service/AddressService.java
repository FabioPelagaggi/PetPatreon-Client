package br.edu.infnet.AppPetPatreon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.infnet.AppPetPatreon.model.domain.Address;
import br.edu.infnet.AppPetPatreon.repository.AddressRepository;

public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;

    public Address add(Address address) {   
        System.out.println("Adding New Address ---");
        System.out.println(address);
        return addressRepository.save(address);
    }

    public void remove(Integer cep) {
        System.out.println("Removing Address ---");
        System.out.println("ID: " + cep);
        addressRepository.deleteById(cep);
    }

    public Address get(Integer cep) {
        System.out.println("Getting Address ---");
        System.out.println("ID: " + cep);
        return addressRepository.findById(cep).get();
    }

    public List<Address> getAddresss() {
        return (List<Address>) addressRepository.findAll();
    }
}