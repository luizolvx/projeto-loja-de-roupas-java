// src/main/java/com/lojaroupa/model/Pagamento.java
package com.lojaroupa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {
    private int idPagamento;
    private int idPedido; // FK para Pedido
    private String tipoPagamento; // Ex: "Cartão", "Pix", "Boleto"
    private BigDecimal valorPago;
    private LocalDateTime dataPagamento;
    private String status; // Ex: "Aprovado", "Pendente", "Rejeitado"

    public Pagamento() {}

    public Pagamento(int idPagamento, int idPedido, String tipoPagamento, BigDecimal valorPago, LocalDateTime dataPagamento, String status) {
        this.idPagamento = idPagamento;
        this.idPedido = idPedido;
        this.tipoPagamento = tipoPagamento;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.status = status;
    }

    // Getters e Setters
    public int getIdPagamento() { return idPagamento; }
    public void setIdPagamento(int idPagamento) { this.idPagamento = idPagamento; }
    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }
    public String getTipoPagamento() { return tipoPagamento; }
    public void setTipoPagamento(String tipoPagamento) { this.tipoPagamento = tipoPagamento; }
    public BigDecimal getValorPago() { return valorPago; }
    public void setValorPago(BigDecimal valorPago) { this.valorPago = valorPago; }
    public LocalDateTime getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDateTime dataPagamento) { this.dataPagamento = dataPagamento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Pagamento [idPagamento=" + idPagamento + ", idPedido=" + idPedido + ", tipoPagamento=" + tipoPagamento +
               ", valorPago=" + valorPago + ", dataPagamento=" + dataPagamento + ", status=" + status + "]";
    }
}