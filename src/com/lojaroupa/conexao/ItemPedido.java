package com.lojaroupa.conexao;

import java.time.LocalDateTime; // Importa para DATETIME

public class ItemPedido {
    private int idItemPedido;
    private int idPedido; // Chave estrangeira
    private int ordem;
    private int idEstoque; // Chave estrangeira
    private int qtdItem;
    private LocalDateTime dtDevolucao; // Pode ser null
    private String motivoDevolucao; // Pode ser null

    public ItemPedido() {
        // Construtor padrão
    }

    public ItemPedido(int idItemPedido, int idPedido, int ordem, int idEstoque, int qtdItem, LocalDateTime dtDevolucao, String motivoDevolucao) {
        this.idItemPedido = idItemPedido;
        this.idPedido = idPedido;
        this.ordem = ordem;
        this.idEstoque = idEstoque;
        this.qtdItem = qtdItem;
        this.dtDevolucao = dtDevolucao;
        this.motivoDevolucao = motivoDevolucao;
    }

    // Getters e Setters
    public int getIdItemPedido() { return idItemPedido; }
    public void setIdItemPedido(int idItemPedido) { this.idItemPedido = idItemPedido; }
    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }
    public int getOrdem() { return ordem; }
    public void setOrdem(int ordem) { this.ordem = ordem; }
    public int getIdEstoque() { return idEstoque; }
    public void setIdEstoque(int idEstoque) { this.idEstoque = idEstoque; }
    public int getQtdItem() { return qtdItem; }
    public void setQtdItem(int qtdItem) { this.qtdItem = qtdItem; }
    public LocalDateTime getDtDevolucao() { return dtDevolucao; }
    public void setDtDevolucao(LocalDateTime dtDevolucao) { this.dtDevolucao = dtDevolucao; }
    public String getMotivoDevolucao() { return motivoDevolucao; }
    public void setMotivoDevolucao(String motivoDevolucao) { this.motivoDevolucao = motivoDevolucao; }

    @Override
    public String toString() {
        return "ItemPedido{" +
               "idItemPedido=" + idItemPedido +
               ", idPedido=" + idPedido +
               ", ordem=" + ordem +
               ", idEstoque=" + idEstoque +
               ", qtdItem=" + qtdItem +
               ", dtDevolucao=" + dtDevolucao +
               ", motivoDevolucao='" + motivoDevolucao + '\'' +
               '}';
    }
}