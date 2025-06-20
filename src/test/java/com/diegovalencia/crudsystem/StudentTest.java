package com.diegovalencia.crudsystem;

import com.diegovalencia.crudsystem.model.Student;
import com.diegovalencia.crudsystem.model.Status;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testStudentCreation() {
        Student student = new Student();
        student.setNome("João da Silva");
        student.setStudentNumber("123456");
        student.setStatus(Status.ATIVO);

        assertEquals("João da Silva", student.getNome());
        assertEquals("123456", student.getStudentNumber());
        assertEquals(Status.ATIVO, student.getStatus());
    }
}
