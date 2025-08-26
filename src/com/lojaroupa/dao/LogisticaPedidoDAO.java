// src/main/java/com/lojaroupa/dao/LogisticaPedidoDAO.java
package com.lojaroupa.dao;

import com.lojaroupa.conexao.ConexaoDB;
import com.lojaroupa.model.LogisticaPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp; // Para lidar com LocalDateTime
import java.util.ArrayList;
import java.util.List;

public class LogisticaPedidoDAO {

    public void inserir(LogisticaPedido logisticaPedido) {
        String sql = "INSERT INTO logistica_pedido (idPedido, status, dataAtualizacao, localizacaoAtual, transportadora, codigoRastreamento) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, logisticaPedido.getIdPedido());
            stmt.setString(2, logisticaPedido.getStatus());
            stmt.setTimestamp(3, Timestamp.valueOf(logisticaPedido.getDataAtualizacao())); // Converte LocalDateTime para Timestamp
            stmt.setString(4, logisticaPedido.getLocalizacaoAtual());
            stmt.setString(5, logisticaPedido.getTransportadora());
            stmt.setString(6, logisticaPedido.getCodigoRastreamento());

            stmt.executeUpdate();
            System.out.println("Logística para pedido " + logisticaPedido.getIdPedido() + " inserida com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir logística de pedido: " + e.getMessage());
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

    public List<LogisticaPedido> listarTodos() {
        List<LogisticaPedido> logisticas = new ArrayList<>();
        String sql = "SELECT idLogistica, idPedido, status, dataAtualizacao, localizacaoAtual, transportadora, codigoRastreamento FROM logistica_pedido ORDER BY dataAtualizacao DESC";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                LogisticaPedido logistica = new LogisticaPedido();
                logistica.setIdLogistica(rs.getInt("idLogistica"));
                logistica.setIdPedido(rs.getInt("idPedido"));
                logistica.setStatus(rs.getString("status"));
                logistica.setDataAtualizacao(rs.getTimestamp("dataAtualizacao").toLocalDateTime()); // Converte Timestamp para LocalDateTime
                logistica.setLocalizacaoAtual(rs.getString("localizacaoAtual"));
                logistica.setTransportadora(rs.getString("transportadora"));
                logistica.setCodigoRastreamento(rs.getString("codigoRastreamento"));
                logisticas.add(logistica);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar logísticas de pedido: " + e.getMessage());
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
        return logisticas;
    }

    public LogisticaPedido buscarPorId(int id) {
        LogisticaPedido logistica = null;
        String sql = "SELECT idLogistica, idPedido, status, dataAtualizacao, localizacaoAtual, transportadora, codigoRastreamento FROM logistica_pedido WHERE idLogistica = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                logistica = new LogisticaPedido();
                logistica.setIdLogistica(rs.getInt("idLogistica"));
                logistica.setIdPedido(rs.getInt("idPedido"));
                logistica.setStatus(rs.getString("status"));
                logistica.setDataAtualizacao(rs.getTimestamp("dataAtualizacao").toLocalDateTime());
                logistica.setLocalizacaoAtual(rs.getString("localizacaoAtual"));
                logistica.setTransportadora(rs.getString("transportadora"));
                logistica.setCodigoRastreamento(rs.getString("codigoRastreamento"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar logística de pedido por ID: " + e.getMessage());
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
        return logistica;
    }

    public void atualizar(LogisticaPedido logisticaPedido) {
        String sql = "UPDATE logistica_pedido SET idPedido = ?, status = ?, dataAtualizacao = ?, localizacaoAtual = ?, transportadora = ?, codigoRastreamento = ? WHERE idLogistica = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, logisticaPedido.getIdPedido());
            stmt.setString(2, logisticaPedido.getStatus());
            stmt.setTimestamp(3, Timestamp.valueOf(logisticaPedido.getDataAtualizacao()));
            stmt.setString(4, logisticaPedido.getLocalizacaoAtual());
            stmt.setString(5, logisticaPedido.getTransportadora());
            stmt.setString(6, logisticaPedido.getCodigoRastreamento());
            stmt.setInt(7, logisticaPedido.getIdLogistica());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Logística de pedido de ID " + logisticaPedido.getIdLogistica() + " atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma logística de pedido encontrada com o ID " + logisticaPedido.getIdLogistica() + " para ser atualizada.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar logística de pedido: " + e.getMessage());
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
        String sql = "DELETE FROM logistica_pedido WHERE idLogistica = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Logística de pedido de ID " + id + " deletada com sucesso!");
            } else {
                System.out.println("Nenhuma logística de pedido encontrada com o ID " + id + " para ser deletada.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar logística de pedido: " + e.getMessage());
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