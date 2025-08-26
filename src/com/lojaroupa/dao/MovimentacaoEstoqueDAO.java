// src/main/java/com/lojaroupa/dao/MovimentacaoEstoqueDAO.java
package com.lojaroupa.dao;

import com.lojaroupa.conexao.ConexaoDB;
import com.lojaroupa.model.MovimentacaoEstoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoEstoqueDAO {

    public void inserir(MovimentacaoEstoque movimentacaoEstoque) {
        String sql = "INSERT INTO movimentacoes_estoque (idProduto, dataHora, quantidade, tipo, motivo) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, movimentacaoEstoque.getIdProduto());
            stmt.setTimestamp(2, Timestamp.valueOf(movimentacaoEstoque.getDataHora()));
            stmt.setInt(3, movimentacaoEstoque.getQuantidade());
            stmt.setString(4, movimentacaoEstoque.getTipo());
            stmt.setString(5, movimentacaoEstoque.getMotivo());

            stmt.executeUpdate();
            System.out.println("Movimentação de estoque para produto " + movimentacaoEstoque.getIdProduto() + " inserida com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir movimentação de estoque: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                ConexaoDB.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public List<MovimentacaoEstoque> listarTodos() {
        List<MovimentacaoEstoque> movimentacoes = new ArrayList<>();
        String sql = "SELECT idMovimentacaoEstoque, idProduto, dataHora, quantidade, tipo, motivo FROM movimentacoes_estoque ORDER BY dataHora DESC";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
                movimentacao.setIdMovimentacaoEstoque(rs.getInt("idMovimentacaoEstoque"));
                movimentacao.setIdProduto(rs.getInt("idProduto"));
                movimentacao.setDataHora(rs.getTimestamp("dataHora").toLocalDateTime());
                movimentacao.setQuantidade(rs.getInt("quantidade"));
                movimentacao.setTipo(rs.getString("tipo"));
                movimentacao.setMotivo(rs.getString("motivo"));
                movimentacoes.add(movimentacao);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar movimentações de estoque: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                ConexaoDB.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return movimentacoes;
    }

    public MovimentacaoEstoque buscarPorId(int id) {
        MovimentacaoEstoque movimentacao = null;
        String sql = "SELECT idMovimentacaoEstoque, idProduto, dataHora, quantidade, tipo, motivo FROM movimentacoes_estoque WHERE idMovimentacaoEstoque = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                movimentacao = new MovimentacaoEstoque();
                movimentacao.setIdMovimentacaoEstoque(rs.getInt("idMovimentacaoEstoque"));
                movimentacao.setIdProduto(rs.getInt("idProduto"));
                movimentacao.setDataHora(rs.getTimestamp("dataHora").toLocalDateTime());
                movimentacao.setQuantidade(rs.getInt("quantidade"));
                movimentacao.setTipo(rs.getString("tipo"));
                movimentacao.setMotivo(rs.getString("motivo"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar movimentação de estoque por ID: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                ConexaoDB.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return movimentacao;
    }

    public void atualizar(MovimentacaoEstoque movimentacaoEstoque) {
        String sql = "UPDATE movimentacoes_estoque SET idProduto = ?, dataHora = ?, quantidade = ?, tipo = ?, motivo = ? WHERE idMovimentacaoEstoque = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, movimentacaoEstoque.getIdProduto());
            stmt.setTimestamp(2, Timestamp.valueOf(movimentacaoEstoque.getDataHora()));
            stmt.setInt(3, movimentacaoEstoque.getQuantidade());
            stmt.setString(4, movimentacaoEstoque.getTipo());
            stmt.setString(5, movimentacaoEstoque.getMotivo());
            stmt.setInt(6, movimentacaoEstoque.getIdMovimentacaoEstoque());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Movimentação de estoque de ID " + movimentacaoEstoque.getIdMovimentacaoEstoque() + " atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma movimentação de estoque encontrada com o ID " + movimentacaoEstoque.getIdMovimentacaoEstoque() + " para ser atualizada.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar movimentação de estoque: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                ConexaoDB.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM movimentacoes_estoque WHERE idMovimentacaoEstoque = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Movimentação de estoque de ID " + id + " deletada com sucesso!");
            } else {
                System.out.println("Nenhuma movimentação de estoque encontrada com o ID " + id + " para ser deletada.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar movimentação de estoque: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                ConexaoDB.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}