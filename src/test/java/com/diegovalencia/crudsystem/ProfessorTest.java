package com.diegovalencia.crudsystem;

import com.diegovalencia.crudsystem.model.Professor;
import com.diegovalencia.crudsystem.model.Status;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfessorTest {

    @Test
    public void testProfessorCreation() {
        Professor professor = new Professor();
        professor.setNome("Maria Oliveira");
        professor.setEmail("maria@universidade.com");
        professor.setSalario(8500.0);
        professor.setStatus(Status.ATIVO);

        assertEquals("Maria Oliveira", professor.getNome());
        assertEquals("maria@universidade.com", professor.getEmail());
        assertEquals(8500.0, professor.getSalario());
        assertEquals(Status.ATIVO, professor.getStatus());
    }
}
