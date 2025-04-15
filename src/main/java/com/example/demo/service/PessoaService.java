package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Pessoa;
import com.example.demo.dto.PessoaDTO;
import com.example.demo.repository.PessoaRepository;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDTO> findAll() {
        return pessoaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO findById(Long id) {
        return pessoaRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + id));
    }

    public PessoaDTO save(PessoaDTO pessoaDTO) {
        Pessoa pessoa = convertToEntity(pessoaDTO);
        return convertToDTO(pessoaRepository.save(pessoa));
    }

    public void delete(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new EntityNotFoundException("Pessoa não encontrada com ID: " + id);
        }
        pessoaRepository.deleteById(id);
    }

    private PessoaDTO convertToDTO(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setCpf(pessoa.getCpf());
        return dto;
    }

    private Pessoa convertToEntity(PessoaDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(dto.getId());
        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        return pessoa;
    }
} 