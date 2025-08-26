// src/main/java/com/lojaroupa/model/Estoque.java
package com.lojaroupa.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Estoque {
    private int idEstoque;
    private int idProduto; // FK para Produto
    private LocalDate dataMovimentacao;
    private int quantidade;
    private String notaFiscal;
    private BigDecimal precoCustoUnitario;
    private BigDecimal precoVendaUnitario;
    private int tipoMovimentacao; // 0 = entrada, 1 = saída (ou usar ENUM/classe TipoMovimentacao)

    public Estoque() {}

    public Estoque(int idEstoque, int idProduto, LocalDate dataMovimentacao, int quantidade, String notaFiscal,
                   BigDecimal precoCustoUnitario, BigDecimal precoVendaUnitario, int tipoMovimentacao) {
        this.idEstoque = idEstoque;
        this.idProduto = idProduto;
        this.dataMovimentacao = dataMovimentacao;
        this.quantidade = quantidade;
        this.notaFiscal = notaFiscal;
        this.precoCustoUnitario = precoCustoUnitario;
        this.precoVendaUnitario = precoVendaUnitario;
        this.tipoMovimentacao = tipoMovimentacao;
    }

    // Getters e Setters
    public int getIdEstoque() { return idEstoque; }
    public void setIdEstoque(int idEstoque) { this.idEstoque = idEstoque; }
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }
    public LocalDate getDataMovimentacao() { return dataMovimentacao; }
    public void setDataMovimentacao(LocalDate dataMovimentacao) { this.dataMovimentacao = dataMovimentacao; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public String getNotaFiscal() { return notaFiscal; }
    public void setNotaFiscal(String notaFiscal) { this.notaFiscal = notaFiscal; }
    public BigDecimal getPrecoCustoUnitario() { return precoCustoUnitario; }
    public void setPrecoCustoUnitario(BigDecimal precoCustoUnitario) { this.precoCustoUnitario = precoCustoUnitario; }
    public BigDecimal getPrecoVendaUnitario() { return precoVendaUnitario; }
    public void setPrecoVendaUnitario(BigDecimal precoVendaUnitario) { this.precoVendaUnitario = precoVendaUnitario; }
    public int getTipoMovimentacao() { return tipoMovimentacao; }
    public void setTipoMovimentacao(int tipoMovimentacao) { this.tipoMovimentacao = tipoMovimentacao; }

    @Override
    public String toString() {
        return "Estoque [idEstoque=" + idEstoque + ", idProduto=" + idProduto + ", dataMovimentacao=" + dataMovimentacao +
               ", quantidade=" + quantidade + ", notaFiscal=" + notaFiscal + ", precoCustoUnitario=" + precoCustoUnitario +
               ", precoVendaUnitario=" + precoVendaUnitario + ", tipoMovimentacao=" + tipoMovimentacao + "]";
    }
}