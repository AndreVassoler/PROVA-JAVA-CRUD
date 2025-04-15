package com.example.demo.dto;

public class TrabalhoDTO {
    private Long id;
    

    private String cargo;
    

    private String empresa;
    

    private Double salario;
    

    private Long pessoaId;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public String getEmpresa() {
        return empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public Double getSalario() {
        return salario;
    }
    
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
    public Long getPessoaId() {
        return pessoaId;
    }
    
    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }
} 