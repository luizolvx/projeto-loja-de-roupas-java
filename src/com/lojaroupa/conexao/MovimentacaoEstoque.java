package com.lojaroupa.conexao;

import java.time.LocalDateTime; // Importa para DATETIME

public class MovimentacaoEstoque {
    private int idMovimentacao;
    private int idEstoque; // Chave estrangeira
    private String tipoMovimentacao; // {"Entrada", "Saída", "Devolução", "Ajuste"}
    private int quantidade;
    private LocalDateTime dataMovimentacao;
    private String observacao;

    public MovimentacaoEstoque() {
        // Construtor padrão
    }

    public MovimentacaoEstoque(int idMovimentacao, int idEstoque, String tipoMovimentacao, int quantidade, LocalDateTime dataMovimentacao, String observacao) {
        this.idMovimentacao = idMovimentacao;
        this.idEstoque = idEstoque;
        this.tipoMovimentacao = tipoMovimentacao;
        this.quantidade = quantidade;
        this.dataMovimentacao = dataMovimentacao;
        this.observacao = observacao;
    }

    // Getters e Setters
    public int getIdMovimentacao() { return idMovimentacao; }
    public void setIdMovimentacao(int idMovimentacao) { this.idMovimentacao = idMovimentacao; }
    public int getIdEstoque() { return idEstoque; }
    public void setIdEstoque(int idEstoque) { this.idEstoque = idEstoque; }
    public String getTipoMovimentacao() { return tipoMovimentacao; }
    public void setTipoMovimentacao(String tipoMovimentacao) { this.tipoMovimentacao = tipoMovimentacao; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public LocalDateTime getDataMovimentacao() { return dataMovimentacao; }
    public void setDataMovimentacao(LocalDateTime dataMovimentacao) { this.dataMovimentacao = dataMovimentacao; }
    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    @Override
    public String toString() {
        return "MovimentacaoEstoque{" +
               "idMovimentacao=" + idMovimentacao +
               ", idEstoque=" + idEstoque +
               ", tipoMovimentacao='" + tipoMovimentacao + '\'' +
               ", quantidade=" + quantidade +
               ", dataMovimentacao=" + dataMovimentacao +
               ", observacao='" + observacao + '\'' +
               '}';
    }
}