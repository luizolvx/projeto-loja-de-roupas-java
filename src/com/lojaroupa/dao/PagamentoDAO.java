// src/main/java/com/lojaroupa/dao/PagamentoDAO.java
package com.lojaroupa.dao;

import com.lojaroupa.conexao.ConexaoDB;
import com.lojaroupa.model.Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {

    public void inserir(Pagamento pagamento) {
        String sql = "INSERT INTO pagamentos (idPedido, tipoPagamento, valorPago, dataPagamento, status) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pagamento.getIdPedido());
            stmt.setString(2, pagamento.getTipoPagamento());
            stmt.setBigDecimal(3, pagamento.getValorPago());
            stmt.setTimestamp(4, Timestamp.valueOf(pagamento.getDataPagamento()));
            stmt.setString(5, pagamento.getStatus());

            stmt.executeUpdate();
            System.out.println("Pagamento para pedido " + pagamento.getIdPedido() + " inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir pagamento: " + e.getMessage());
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

    public List<Pagamento> listarTodos() {
        List<Pagamento> pagamentos = new ArrayList<>();
        String sql = "SELECT idPagamento, idPedido, tipoPagamento, valorPago, dataPagamento, status FROM pagamentos ORDER BY dataPagamento DESC";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setIdPagamento(rs.getInt("idPagamento"));
                pagamento.setIdPedido(rs.getInt("idPedido"));
                pagamento.setTipoPagamento(rs.getString("tipoPagamento"));
                pagamento.setValorPago(rs.getBigDecimal("valorPago"));
                pagamento.setDataPagamento(rs.getTimestamp("dataPagamento").toLocalDateTime());
                pagamento.setStatus(rs.getString("status"));
                pagamentos.add(pagamento);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar pagamentos: " + e.getMessage());
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
        return pagamentos;
    }

    public Pagamento buscarPorId(int id) {
        Pagamento pagamento = null;
        String sql = "SELECT idPagamento, idPedido, tipoPagamento, valorPago, dataPagamento, status FROM pagamentos WHERE idPagamento = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                pagamento = new Pagamento();
                pagamento.setIdPagamento(rs.getInt("idPagamento"));
                pagamento.setIdPedido(rs.getInt("idPedido"));
                pagamento.setTipoPagamento(rs.getString("tipoPagamento"));
                pagamento.setValorPago(rs.getBigDecimal("valorPago"));
                pagamento.setDataPagamento(rs.getTimestamp("dataPagamento").toLocalDateTime());
                pagamento.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar pagamento por ID: " + e.getMessage());
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
        return pagamento;
    }

    public void atualizar(Pagamento pagamento) {
        String sql = "UPDATE pagamentos SET idPedido = ?, tipoPagamento = ?, valorPago = ?, dataPagamento = ?, status = ? WHERE idPagamento = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pagamento.getIdPedido());
            stmt.setString(2, pagamento.getTipoPagamento());
            stmt.setBigDecimal(3, pagamento.getValorPago());
            stmt.setTimestamp(4, Timestamp.valueOf(pagamento.getDataPagamento()));
            stmt.setString(5, pagamento.getStatus());
            stmt.setInt(6, pagamento.getIdPagamento());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Pagamento de ID " + pagamento.getIdPagamento() + " atualizado com sucesso!");
            } else {
                System.out.println("Nenhum pagamento encontrado com o ID " + pagamento.getIdPagamento() + " para ser atualizado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar pagamento: " + e.getMessage());
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
        String sql = "DELETE FROM pagamentos WHERE idPagamento = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Pagamento de ID " + id + " deletado com sucesso!");
            } else {
                System.out.println("Nenhum pagamento encontrado com o ID " + id + " para ser deletado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar pagamento: " + e.getMessage());
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