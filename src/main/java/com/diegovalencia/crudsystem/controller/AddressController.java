package com.diegovalencia.crudsystem.controller;

import com.diegovalencia.crudsystem.model.Address;
import com.diegovalencia.crudsystem.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address updated) {
        Address address = addressRepository.findById(id).orElseThrow();
        address.setRua(updated.getRua());
        address.setCidade(updated.getCidade());
        address.setEstado(updated.getEstado());
        return addressRepository.save(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
    }
}
