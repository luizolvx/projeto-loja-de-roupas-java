package com.lojaroupa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {
    private int idPedido;
    private int idCliente;
    // MUDANÇA ESSENCIAL AQUI: de 'int' para 'Integer' para permitir 'null'
    private Integer idFuncionario; // Alterado para Integer

    private LocalDateTime dataPedido;
    private String statusPedido;
    private BigDecimal valorTotal;

    public Pedido() {}

    // Construtor ajustado para Integer idFuncionario
    public Pedido(int idPedido, int idCliente, Integer idFuncionario, LocalDateTime dataPedido, // Alterado para Integer
                  String statusPedido, BigDecimal valorTotal) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.valorTotal = valorTotal;
    }

    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    // MUDANÇA AQUI: Retorna Integer
    public Integer getIdFuncionario() { return idFuncionario; } // Alterado para Integer
    // MUDANÇA AQUI: Recebe Integer
    public void setIdFuncionario(Integer idFuncionario) { this.idFuncionario = idFuncionario; } // Alterado para Integer

    public LocalDateTime getDataPedido() { return dataPedido; }
    public void setDataPedido(LocalDateTime dataPedido) { this.dataPedido = dataPedido; }

    public String getStatusPedido() { return statusPedido; }
    public void setStatusPedido(String statusPedido) { this.statusPedido = statusPedido; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", idCliente=" + idCliente + ", idFuncionario=" + idFuncionario +
               ", dataPedido=" + dataPedido + ", statusPedido=" + statusPedido + ", valorTotal=" + valorTotal + "]";
    }
}