package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.TrabalhoDTO;
import com.example.demo.service.TrabalhoService;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping
    public ResponseEntity<List<TrabalhoDTO>> findAll() {
        List<TrabalhoDTO> trabalhos = trabalhoService.findAll();
        return ResponseEntity.ok(trabalhos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhoDTO> findById(@PathVariable Long id) {
        TrabalhoDTO trabalho = trabalhoService.findById(id);
        if (trabalho != null) {
            return ResponseEntity.ok(trabalho);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TrabalhoDTO> create(@Valid @RequestBody TrabalhoDTO trabalhoDTO) {
        try {
            TrabalhoDTO savedTrabalho = trabalhoService.save(trabalhoDTO);
            return ResponseEntity.ok(savedTrabalho);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabalhoDTO> update(@PathVariable Long id, @Valid @RequestBody TrabalhoDTO trabalhoDTO) {
        try {
            trabalhoDTO.setId(id);
            TrabalhoDTO updatedTrabalho = trabalhoService.save(trabalhoDTO);
            return ResponseEntity.ok(updatedTrabalho);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            trabalhoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
} 