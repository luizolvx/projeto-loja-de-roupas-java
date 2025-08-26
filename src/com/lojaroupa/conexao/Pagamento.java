package com.lojaroupa.conexao;

import java.math.BigDecimal; // Importa para valores monetários
import java.time.LocalDateTime; // Importa para DATETIME

public class Pagamento {
    private int idPagamento;
    private int idPedido; // Chave estrangeira
    private String metodoPagamento;
    private String statusPagamento;
    private BigDecimal valorPago; // Para valores monetários
    private LocalDateTime dtPagamento;
    private String notaFiscal;
    private LocalDateTime dtNotaFiscal;

    public Pagamento() {
        // Construtor padrão
    }

    public Pagamento(int idPagamento, int idPedido, String metodoPagamento, String statusPagamento, BigDecimal valorPago, LocalDateTime dtPagamento, String notaFiscal, LocalDateTime dtNotaFiscal) {
        this.idPagamento = idPagamento;
        this.idPedido = idPedido;
        this.metodoPagamento = metodoPagamento;
        this.statusPagamento = statusPagamento;
        this.valorPago = valorPago;
        this.dtPagamento = dtPagamento;
        this.notaFiscal = notaFiscal;
        this.dtNotaFiscal = dtNotaFiscal;
    }

    // Getters e Setters
    public int getIdPagamento() { return idPagamento; }
    public void setIdPagamento(int idPagamento) { this.idPagamento = idPagamento; }
    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }
    public String getMetodoPagamento() { return metodoPagamento; }
    public void setMetodoPagamento(String metodoPagamento) { this.metodoPagamento = metodoPagamento; }
    public String getStatusPagamento() { return statusPagamento; }
    public void setStatusPagamento(String statusPagamento) { this.statusPagamento = statusPagamento; }
    public BigDecimal getValorPago() { return valorPago; }
    public void setValorPago(BigDecimal valorPago) { this.valorPago = valorPago; }
    public LocalDateTime getDtPagamento() { return dtPagamento; }
    public void setDtPagamento(LocalDateTime dtPagamento) { this.dtPagamento = dtPagamento; }
    public String getNotaFiscal() { return notaFiscal; }
    public void setNotaFiscal(String notaFiscal) { this.notaFiscal = notaFiscal; }
    public LocalDateTime getDtNotaFiscal() { return dtNotaFiscal; }
    public void setDtNotaFiscal(LocalDateTime dtNotaFiscal) { this.dtNotaFiscal = dtNotaFiscal; }

    @Override
    public String toString() {
        return "Pagamento{" +
               "idPagamento=" + idPagamento +
               ", idPedido=" + idPedido +
               ", metodoPagamento='" + metodoPagamento + '\'' +
               ", statusPagamento='" + statusPagamento + '\'' +
               ", valorPago=" + valorPago +
               ", dtPagamento=" + dtPagamento +
               ", notaFiscal='" + notaFiscal + '\'' +
               ", dtNotaFiscal=" + dtNotaFiscal +
               '}';
    }
}