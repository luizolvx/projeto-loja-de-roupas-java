package com.lojaroupa.conexao;

import java.time.LocalDateTime; // Importa a classe para DATETIME

public class Pedido {
    private int idPedido;
    private Integer idFuncionario; // Pode ser null na DB, então usar Integer (wrapper class)
    private int idCliente;
    private int idVendedor;
    private LocalDateTime dtPedido; // Para DATETIME
    private int tipoFrete; // { 0=Retirada, 1=PAC, 2=SEDEX, 3=MOTOBOY, 4=TRANSPORTADORA }
    private String entregaEndereco;
    private String entregaCEP;
    private String entregaTelefone;
    private LocalDateTime dtDevolucao; // Pode ser null
    private String motivoDevolucao; // Pode ser null

    public Pedido() {
        // Construtor padrão
    }

    public Pedido(int idPedido, Integer idFuncionario, int idCliente, int idVendedor, LocalDateTime dtPedido, int tipoFrete, String entregaEndereco, String entregaCEP, String entregaTelefone, LocalDateTime dtDevolucao, String motivoDevolucao) {
        this.idPedido = idPedido;
        this.idFuncionario = idFuncionario;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.dtPedido = dtPedido;
        this.tipoFrete = tipoFrete;
        this.entregaEndereco = entregaEndereco;
        this.entregaCEP = entregaCEP;
        this.entregaTelefone = entregaTelefone;
        this.dtDevolucao = dtDevolucao;
        this.motivoDevolucao = motivoDevolucao;
    }

    // Getters e Setters
    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }
    public Integer getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(Integer idFuncionario) { this.idFuncionario = idFuncionario; }
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public int getIdVendedor() { return idVendedor; }
    public void setIdVendedor(int idVendedor) { this.idVendedor = idVendedor; }
    public LocalDateTime getDtPedido() { return dtPedido; }
    public void setDtPedido(LocalDateTime dtPedido) { this.dtPedido = dtPedido; }
    public int getTipoFrete() { return tipoFrete; }
    public void setTipoFrete(int tipoFrete) { this.tipoFrete = tipoFrete; }
    public String getEntregaEndereco() { return entregaEndereco; }
    public void setEntregaEndereco(String entregaEndereco) { this.entregaEndereco = entregaEndereco; }
    public String getEntregaCEP() { return entregaCEP; }
    public void setEntregaCEP(String entregaCEP) { this.entregaCEP = entregaCEP; }
    public String getEntregaTelefone() { return entregaTelefone; }
    public void setEntregaTelefone(String entregaTelefone) { this.entregaTelefone = entregaTelefone; }
    public LocalDateTime getDtDevolucao() { return dtDevolucao; }
    public void setDtDevolucao(LocalDateTime dtDevolucao) { this.dtDevolucao = dtDevolucao; }
    public String getMotivoDevolucao() { return motivoDevolucao; }
    public void setMotivoDevolucao(String motivoDevolucao) { this.motivoDevolucao = motivoDevolucao; }

    @Override
    public String toString() {
        return "Pedido{" +
               "idPedido=" + idPedido +
               ", idFuncionario=" + idFuncionario +
               ", idCliente=" + idCliente +
               ", idVendedor=" + idVendedor +
               ", dtPedido=" + dtPedido +
               ", tipoFrete=" + tipoFrete +
               ", entregaEndereco='" + entregaEndereco + '\'' +
               ", entregaCEP='" + entregaCEP + '\'' +
               ", entregaTelefone='" + entregaTelefone + '\'' +
               ", dtDevolucao=" + dtDevolucao +
               ", motivoDevolucao='" + motivoDevolucao + '\'' +
               '}';
    }
}