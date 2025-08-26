// src/main/java/com/lojaroupa/model/MovimentacaoEstoque.java
package com.lojaroupa.model;

import java.time.LocalDateTime;

public class MovimentacaoEstoque {
    private int idMovimentacaoEstoque;
    private int idProduto; // FK para Produto
    private LocalDateTime dataHora;
    private int quantidade;
    private String tipo; // Ex: "ENTRADA", "SAIDA"
    private String motivo; // Ex: "Venda", "Compra", "Ajuste"

    public MovimentacaoEstoque() {}

    public MovimentacaoEstoque(int idMovimentacaoEstoque, int idProduto, LocalDateTime dataHora, int quantidade, String tipo, String motivo) {
        this.idMovimentacaoEstoque = idMovimentacaoEstoque;
        this.idProduto = idProduto;
        this.dataHora = dataHora;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.motivo = motivo;
    }

    // Getters e Setters
    public int getIdMovimentacaoEstoque() { return idMovimentacaoEstoque; }
    public void setIdMovimentacaoEstoque(int idMovimentacaoEstoque) { this.idMovimentacaoEstoque = idMovimentacaoEstoque; }
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    @Override
    public String toString() {
        return "MovimentacaoEstoque [idMovimentacaoEstoque=" + idMovimentacaoEstoque + ", idProduto=" + idProduto +
               ", dataHora=" + dataHora + ", quantidade=" + quantidade + ", tipo=" + tipo + ", motivo=" + motivo + "]";
    }
}