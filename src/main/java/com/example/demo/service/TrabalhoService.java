package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Trabalho;
import com.example.demo.model.Pessoa;
import com.example.demo.dto.TrabalhoDTO;
import com.example.demo.repository.TrabalhoRepository;
import com.example.demo.repository.PessoaRepository;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<TrabalhoDTO> findAll() {
        return trabalhoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TrabalhoDTO findById(Long id) {
        return trabalhoRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Trabalho não encontrado com ID: " + id));
    }

    public TrabalhoDTO save(TrabalhoDTO trabalhoDTO) {
        Trabalho trabalho = convertToEntity(trabalhoDTO);
        return convertToDTO(trabalhoRepository.save(trabalho));
    }

    public void delete(Long id) {
        if (!trabalhoRepository.existsById(id)) {
            throw new EntityNotFoundException("Trabalho não encontrado com ID: " + id);
        }
        trabalhoRepository.deleteById(id);
    }

    private TrabalhoDTO convertToDTO(Trabalho trabalho) {
        TrabalhoDTO dto = new TrabalhoDTO();
        dto.setId(trabalho.getId());
        dto.setCargo(trabalho.getCargo());
        dto.setEmpresa(trabalho.getEmpresa());
        dto.setSalario(trabalho.getSalario());
        if (trabalho.getPessoa() != null) {
            dto.setPessoaId(trabalho.getPessoa().getId());
        }
        return dto;
    }

    private Trabalho convertToEntity(TrabalhoDTO dto) {
        Trabalho trabalho = new Trabalho();
        trabalho.setId(dto.getId());
        trabalho.setCargo(dto.getCargo());
        trabalho.setEmpresa(dto.getEmpresa());
        trabalho.setSalario(dto.getSalario());
        
        if (dto.getPessoaId() != null) {
            Pessoa pessoa = pessoaRepository.findById(dto.getPessoaId())
                    .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + dto.getPessoaId()));
            trabalho.setPessoa(pessoa);
        }
        
        return trabalho;
    }
} 