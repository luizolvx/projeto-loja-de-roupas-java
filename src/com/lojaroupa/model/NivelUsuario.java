// src/main/java/com/lojaroupa/model/NivelUsuario.java
package com.lojaroupa.model;

public class NivelUsuario {
    private int idNivelUsuario;
    private String descricao;

    public NivelUsuario() {}

    public NivelUsuario(int idNivelUsuario, String descricao) {
        this.idNivelUsuario = idNivelUsuario;
        this.descricao = descricao;
    }

    // Getters e Setters
    public int getIdNivelUsuario() { return idNivelUsuario; }
    public void setIdNivelUsuario(int idNivelUsuario) { this.idNivelUsuario = idNivelUsuario; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() {
        return "NivelUsuario [idNivelUsuario=" + idNivelUsuario + ", descricao=" + descricao + "]";
    }
}