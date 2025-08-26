// src/main/java/com/lojinha/model/LogisticaPedido.java
package com.lojaroupa.conexao;

import java.time.LocalDateTime; // Importa a classe para DATETIME

public class LogisticaPedido {
    private int idLogistica;
    private int idPedido; // Chave estrangeira
    private LocalDateTime dtEnvio;
    private LocalDateTime dtRecebimento;
    private String rastreioFrete;

    public LogisticaPedido() {
        // Construtor padrão
    }

    public LogisticaPedido(int idLogistica, int idPedido, LocalDateTime dtEnvio, LocalDateTime dtRecebimento, String rastreioFrete) {
        this.idLogistica = idLogistica;
        this.idPedido = idPedido;
        this.dtEnvio = dtEnvio;
        this.dtRecebimento = dtRecebimento;
        this.rastreioFrete = rastreioFrete;
    }

    // Getters e Setters
    public int getIdLogistica() { return idLogistica; }
    public void setIdLogistica(int idLogistica) { this.idLogistica = idLogistica; }
    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }
    public LocalDateTime getDtEnvio() { return dtEnvio; }
    public void setDtEnvio(LocalDateTime dtEnvio) { this.dtEnvio = dtEnvio; }
    public LocalDateTime getDtRecebimento() { return dtRecebimento; }
    public void setDtRecebimento(LocalDateTime dtRecebimento) { this.dtRecebimento = dtRecebimento; }
    public String getRastreioFrete() { return rastreioFrete; }
    public void setRastreioFrete(String rastreioFrete) { this.rastreioFrete = rastreioFrete; }

    @Override
    public String toString() {
        return "LogisticaPedido{" +
               "idLogistica=" + idLogistica +
               ", idPedido=" + idPedido +
               ", dtEnvio=" + dtEnvio +
               ", dtRecebimento=" + dtRecebimento +
               ", rastreioFrete='" + rastreioFrete + '\'' +
               '}';
    }
}