package com.diegovalencia.crudsystem.controller;

import com.diegovalencia.crudsystem.model.Student;
import com.diegovalencia.crudsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updated) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setNome(updated.getNome());
        student.setStudentNumber(updated.getStudentNumber());
        student.setPhoto(updated.getPhoto());
        student.setStatus(updated.getStatus());
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
