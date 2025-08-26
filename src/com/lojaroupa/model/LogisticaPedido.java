// src/main/java/com/lojaroupa/model/LogisticaPedido.java
package com.lojaroupa.model;

import java.time.LocalDateTime;

public class LogisticaPedido {
    private int idLogistica;
    private int idPedido; // FK para Pedido
    private String status; // Ex: "Processando", "Em Transporte", "Entregue"
    private LocalDateTime dataAtualizacao;
    private String localizacaoAtual;
    private String transportadora;
    private String codigoRastreamento;

    public LogisticaPedido() {}

    public LogisticaPedido(int idLogistica, int idPedido, String status, LocalDateTime dataAtualizacao,
                           String localizacaoAtual, String transportadora, String codigoRastreamento) {
        this.idLogistica = idLogistica;
        this.idPedido = idPedido;
        this.status = status;
        this.dataAtualizacao = dataAtualizacao;
        this.localizacaoAtual = localizacaoAtual;
        this.transportadora = transportadora;
        this.codigoRastreamento = codigoRastreamento;
    }

    // Getters e Setters
    public int getIdLogistica() { return idLogistica; }
    public void setIdLogistica(int idLogistica) { this.idLogistica = idLogistica; }
    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getDataAtualizacao() { return dataAtualizacao; }
    public void setDataAtualizacao(LocalDateTime dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }
    public String getLocalizacaoAtual() { return localizacaoAtual; }
    public void setLocalizacaoAtual(String localizacaoAtual) { this.localizacaoAtual = localizacaoAtual; }
    public String getTransportadora() { return transportadora; }
    public void setTransportadora(String transportadora) { this.transportadora = transportadora; }
    public String getCodigoRastreamento() { return codigoRastreamento; }
    public void setCodigoRastreamento(String codigoRastreamento) { this.codigoRastreamento = codigoRastreamento; }

    @Override
    public String toString() {
        return "LogisticaPedido [idLogistica=" + idLogistica + ", idPedido=" + idPedido + ", status=" + status +
               ", dataAtualizacao=" + dataAtualizacao + ", transportadora=" + transportadora + "]";
    }
}