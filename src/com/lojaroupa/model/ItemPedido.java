// src/main/java/com/lojaroupa/model/ItemPedido.java
package com.lojaroupa.model;

import java.math.BigDecimal;

public class ItemPedido {
    private int idItemPedido;
    private int idPedido;  // FK para Pedido
    private int idProduto; // FK para Produto
    private int quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;

    public ItemPedido() {}

    public ItemPedido(int idItemPedido, int idPedido, int idProduto, int quantidade, BigDecimal precoUnitario, BigDecimal subtotal) {
        this.idItemPedido = idItemPedido;
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.subtotal = subtotal;
    }

    // Getters e Setters
    public int getIdItemPedido() { return idItemPedido; }
    public void setIdItemPedido(int idItemPedido) { this.idItemPedido = idItemPedido; }
    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(BigDecimal precoUnitario) { this.precoUnitario = precoUnitario; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }

    @Override
    public String toString() {
        return "ItemPedido [idItemPedido=" + idItemPedido + ", idPedido=" + idPedido + ", idProduto=" + idProduto +
               ", quantidade=" + quantidade + ", precoUnitario=" + precoUnitario + ", subtotal=" + subtotal + "]";
    }
}