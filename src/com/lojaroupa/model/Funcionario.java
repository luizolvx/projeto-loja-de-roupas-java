// src/main/java/com/lojaroupa/model/Funcionario.java
package com.lojaroupa.model;

public class Funcionario {
    private int idFuncionario;
    private String login;
    private String senha; // CUIDADO: Senhas NUNCA devem ser armazenadas em texto puro em produção!
    private int idNivelUsuario; // FK para NivelUsuario
    private String nomeCompleto;
    private String cpf;
    private String endereco;
    private String cep;
    private String telefone;
    private String ativo; // 'S' ou 'N'

    public Funcionario() {}

    public Funcionario(int idFuncionario, String login, String senha, int idNivelUsuario, String nomeCompleto,
                       String cpf, String endereco, String cep, String telefone, String ativo) {
        this.idFuncionario = idFuncionario;
        this.login = login;
        this.senha = senha;
        this.idNivelUsuario = idNivelUsuario;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
        this.ativo = ativo;
    }

    // Getters e Setters
    public int getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public int getIdNivelUsuario() { return idNivelUsuario; }
    public void setIdNivelUsuario(int idNivelUsuario) { this.idNivelUsuario = idNivelUsuario; }
    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getAtivo() { return ativo; }
    public void setAtivo(String ativo) { this.ativo = ativo; }

    @Override
    public String toString() {
        return "Funcionario [idFuncionario=" + idFuncionario + ", login=" + login + ", idNivelUsuario=" + idNivelUsuario +
               ", nomeCompleto=" + nomeCompleto + ", cpf=" + cpf + ", ativo=" + ativo + "]";
    }
}