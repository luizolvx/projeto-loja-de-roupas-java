// src/main/java/com/lojaroupa/model/Cliente.java
package com.lojaroupa.model;

import java.time.LocalDate; // Importa para o tipo LocalDate

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private String cep;
    private LocalDate dataCadastro; // Exemplo: data de cadastro do cliente
    private String senha; // Adicionei o campo senha aqui

    public Cliente() {}

    // Construtor original (sem senha, dataCadastro padrão)
    public Cliente(int idCliente, String nome, String cpf, String email, String telefone, String endereco, String cep) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
        this.dataCadastro = LocalDate.now(); // Define a data de cadastro como a data atual
        this.senha = null; // Inicializa a senha como null ou vazia
    }

    // Construtor completo incluindo dataCadastro e senha (útil para recuperar do BD e para criar com senha)
    public Cliente(int idCliente, String nome, String cpf, String email, String telefone, String endereco, String cep, LocalDate dataCadastro, String senha) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
        this.dataCadastro = dataCadastro;
        this.senha = senha;
    }

    // Getters e Setters para TODOS os campos
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }

    // Getter e Setter para o novo campo senha
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email +
               ", telefone=" + telefone + ", endereco=" + endereco + ", cep=" + cep + ", dataCadastro=" + dataCadastro + ", senha=" + (senha != null ? "****" : "null") + "]";
    }
}