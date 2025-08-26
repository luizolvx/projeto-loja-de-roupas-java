package com.lojaroupa.conexao;

import java.math.BigDecimal; // Importa para valores monetários
import java.time.LocalDate; // Importa para DATE

public class Estoque {
    private int idEstoque;
    private int idProduto; // Chave estrangeira
    private LocalDate dtEntrada; // Para DATE
    private int quantidade;
    private String nfCompra;
    private BigDecimal precoCompra; // Para valores monetários
    private BigDecimal precoVenda;  // Para valores monetários
    private int qtdVendida;

    public Estoque() {
        // Construtor padrão
    }

    public Estoque(int idEstoque, int idProduto, LocalDate dtEntrada, int quantidade, String nfCompra, BigDecimal precoCompra, BigDecimal precoVenda, int qtdVendida) {
        this.idEstoque = idEstoque;
        this.idProduto = idProduto;
        this.dtEntrada = dtEntrada;
        this.quantidade = quantidade;
        this.nfCompra = nfCompra;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.qtdVendida = qtdVendida;
    }

    // Getters e Setters
    public int getIdEstoque() { return idEstoque; }
    public void setIdEstoque(int idEstoque) { this.idEstoque = idEstoque; }
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }
    public LocalDate getDtEntrada() { return dtEntrada; }
    public void setDtEntrada(LocalDate dtEntrada) { this.dtEntrada = dtEntrada; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public String getNfCompra() { return nfCompra; }
    public void setNfCompra(String nfCompra) { this.nfCompra = nfCompra; }
    public BigDecimal getPrecoCompra() { return precoCompra; }
    public void setPrecoCompra(BigDecimal precoCompra) { this.precoCompra = precoCompra; }
    public BigDecimal getPrecoVenda() { return precoVenda; }
    public void setPrecoVenda(BigDecimal precoVenda) { this.precoVenda = precoVenda; }
    public int getQtdVendida() { return qtdVendida; }
    public void setQtdVendida(int qtdVendida) { this.qtdVendida = qtdVendida; }

    @Override
    public String toString() {
        return "Estoque{" +
               "idEstoque=" + idEstoque +
               ", idProduto=" + idProduto +
               ", dtEntrada=" + dtEntrada +
               ", quantidade=" + quantidade +
               ", nfCompra='" + nfCompra + '\'' +
               ", precoCompra=" + precoCompra +
               ", precoVenda=" + precoVenda +
               ", qtdVendida=" + qtdVendida +
               '}';
    }
}