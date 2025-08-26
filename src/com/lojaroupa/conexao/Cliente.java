package com.lojaroupa.conexao;

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private String cep;

    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String cpf, String email, String telefone, String endereco, String cep) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
    }

    // Getters e Setters
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

    @Override
    public String toString() {
        return "Cliente{" +
               "idCliente=" + idCliente +
               ", nome='" + nome + '\'' +
               ", cpf='" + cpf + '\'' +
               ", email='" + email + '\'' +
               ", telefone='" + telefone + '\'' +
               ", endereco='" + endereco + '\'' +
               ", cep='" + cep + '\'' +
               '}';
    }
}