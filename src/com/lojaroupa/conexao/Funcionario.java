package com.lojaroupa.conexao;

public class Funcionario {
    private int idFuncionario;
    private String email;
    private int idNivelUsuario; // Chave estrangeira
    private String nome;
    private String cpf;
    private String endereco;
    private String cep;
    private String telefone;
    private String ativo; // 'S' ou 'N'

    public Funcionario() {
        // Construtor padrão
    }

    public Funcionario(int idFuncionario, String email, int idNivelUsuario, String nome, String cpf, String endereco, String cep, String telefone, String ativo) {
        this.idFuncionario = idFuncionario;
        this.email = email;
        this.idNivelUsuario = idNivelUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
        this.ativo = ativo;
    }

    // Getters e Setters
    public int getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getIdNivelUsuario() { return idNivelUsuario; }
    public void setIdNivelUsuario(int idNivelUsuario) { this.idNivelUsuario = idNivelUsuario; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
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
        return "Funcionario{" +
               "idFuncionario=" + idFuncionario +
               ", email='" + email + '\'' +
               ", idNivelUsuario=" + idNivelUsuario +
               ", nome='" + nome + '\'' +
               ", cpf='" + cpf + '\'' +
               ", endereco='" + endereco + '\'' +
               ", cep='" + cep + '\'' +
               ", telefone='" + telefone + '\'' +
               ", ativo='" + ativo + '\'' +
               '}';
    }
}