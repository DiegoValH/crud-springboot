package com.diegovalencia.crudsystem.controller;

import com.diegovalencia.crudsystem.model.Professor;
import com.diegovalencia.crudsystem.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor updated) {
        Professor professor = professorRepository.findById(id).orElseThrow();
        professor.setNome(updated.getNome());
        professor.setEmail(updated.getEmail());
        professor.setSalario(updated.getSalario());
        professor.setStatus(updated.getStatus());
        return professorRepository.save(professor);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorRepository.deleteById(id);
    }
}
