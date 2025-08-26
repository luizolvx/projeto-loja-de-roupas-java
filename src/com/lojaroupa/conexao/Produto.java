package com.lojaroupa.conexao;

import java.math.BigDecimal;

public class Produto {
    private int idProduto;
    private String nome;
    private String marca;
    private String modelo;
    private int idCategoria;
    private String descricao;
    private String unidadeMedida;
    private String cor;
    private int estoqueMinimo;
    private String tamanho;
    private BigDecimal preco;

    public Produto() {
        // Construtor padrão
    }

    public Produto(int idProduto, String nome, String marca, String modelo, int idCategoria, String descricao, String unidadeMedida, String cor, int estoqueMinimo, String tamanho, BigDecimal preco) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.idCategoria = idCategoria;
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
        this.cor = cor;
        this.estoqueMinimo = estoqueMinimo;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

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

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "idProduto=" + idProduto +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", idCategoria=" + idCategoria +
                ", descricao='" + descricao + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", cor='" + cor + '\'' +
                ", estoqueMinimo=" + estoqueMinimo +
                ", tamanho='" + tamanho + '\'' +
                ", preco=" + preco +
                '}';
    }
}
