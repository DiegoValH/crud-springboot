package com.diegovalencia.crudsystem;

import com.diegovalencia.crudsystem.model.Address;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    @Test
    public void testAddressCreation() {
        Address address = new Address();
        address.setRua("Rua das Flores");
        address.setCidade("Curitiba");
        address.setEstado("PR");

        assertEquals("Rua das Flores", address.getRua());
        assertEquals("Curitiba", address.getCidade());
        assertEquals("PR", address.getEstado());
    }
}
