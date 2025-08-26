package com.lojaroupa.conexao;

public class NivelUsuario {
    private int idNivelUsuario;
    private String nivel; // {"Cliente", "Caixa", "Vendedor", "Estoquista", "Gerente", "Fornecedor"}

    public NivelUsuario() {
        // Construtor padrão
    }

    public NivelUsuario(int idNivelUsuario, String nivel) {
        this.idNivelUsuario = idNivelUsuario;
        this.nivel = nivel;
    }

    // Getters e Setters
    public int getIdNivelUsuario() {
        return idNivelUsuario;
    }

    public void setIdNivelUsuario(int idNivelUsuario) {
        this.idNivelUsuario = idNivelUsuario;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "NivelUsuario{" +
               "idNivelUsuario=" + idNivelUsuario +
               ", nivel='" + nivel + '\'' +
               '}';
    }
}