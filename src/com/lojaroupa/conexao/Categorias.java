package com.lojaroupa.conexao;

public class Categorias {
    private int idCategoria;
    private String descricao;

    public Categorias() {
        // Construtor padrão
    }

    public Categorias(int idCategoria, String descricao) {
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }

    // Getters e Setters
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Categoria{" +
               "idCategoria=" + idCategoria +
               ", descricao='" + descricao + '\'' +
               '}';
    }
}