// src/main/java/com/lojaroupa/dao/EstoqueDAO.java
package com.lojaroupa.dao;

import com.lojaroupa.conexao.ConexaoDB;
import com.lojaroupa.model.Estoque;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {

    public void inserir(Estoque estoque) {
        String sql = "INSERT INTO estoque (idProduto, dataMovimentacao, quantidade, notaFiscal, precoCustoUnitario, precoVendaUnitario, tipoMovimentacao) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, estoque.getIdProduto());
            stmt.setDate(2, Date.valueOf(estoque.getDataMovimentacao()));
            stmt.setInt(3, estoque.getQuantidade());
            stmt.setString(4, estoque.getNotaFiscal());
            stmt.setBigDecimal(5, estoque.getPrecoCustoUnitario());
            stmt.setBigDecimal(6, estoque.getPrecoVendaUnitario());
            stmt.setInt(7, estoque.getTipoMovimentacao());

            stmt.executeUpdate();
            System.out.println("Movimentação de estoque para produto " + estoque.getIdProduto() + " inserida com sucesso!");

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

    public List<Estoque> listarTodos() {
        List<Estoque> estoques = new ArrayList<>();
        String sql = "SELECT idEstoque, idProduto, dataMovimentacao, quantidade, notaFiscal, precoCustoUnitario, precoVendaUnitario, tipoMovimentacao FROM estoque ORDER BY dataMovimentacao DESC";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Estoque estoque = new Estoque();
                estoque.setIdEstoque(rs.getInt("idEstoque"));
                estoque.setIdProduto(rs.getInt("idProduto"));
                estoque.setDataMovimentacao(rs.getDate("dataMovimentacao").toLocalDate());
                estoque.setQuantidade(rs.getInt("quantidade"));
                estoque.setNotaFiscal(rs.getString("notaFiscal"));
                estoque.setPrecoCustoUnitario(rs.getBigDecimal("precoCustoUnitario"));
                estoque.setPrecoVendaUnitario(rs.getBigDecimal("precoVendaUnitario"));
                estoque.setTipoMovimentacao(rs.getInt("tipoMovimentacao"));
                estoques.add(estoque);
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
        return estoques;
    }

    public Estoque buscarPorId(int id) {
        Estoque estoque = null;
        String sql = "SELECT idEstoque, idProduto, dataMovimentacao, quantidade, notaFiscal, precoCustoUnitario, precoVendaUnitario, tipoMovimentacao FROM estoque WHERE idEstoque = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                estoque = new Estoque();
                estoque.setIdEstoque(rs.getInt("idEstoque"));
                estoque.setIdProduto(rs.getInt("idProduto"));
                estoque.setDataMovimentacao(rs.getDate("dataMovimentacao").toLocalDate());
                estoque.setQuantidade(rs.getInt("quantidade"));
                estoque.setNotaFiscal(rs.getString("notaFiscal"));
                estoque.setPrecoCustoUnitario(rs.getBigDecimal("precoCustoUnitario"));
                estoque.setPrecoVendaUnitario(rs.getBigDecimal("precoVendaUnitario"));
                estoque.setTipoMovimentacao(rs.getInt("tipoMovimentacao"));
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
        return estoque;
    }

    public void atualizar(Estoque estoque) {
        String sql = "UPDATE estoque SET idProduto = ?, dataMovimentacao = ?, quantidade = ?, notaFiscal = ?, precoCustoUnitario = ?, precoVendaUnitario = ?, tipoMovimentacao = ? WHERE idEstoque = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, estoque.getIdProduto());
            stmt.setDate(2, Date.valueOf(estoque.getDataMovimentacao()));
            stmt.setInt(3, estoque.getQuantidade());
            stmt.setString(4, estoque.getNotaFiscal());
            stmt.setBigDecimal(5, estoque.getPrecoCustoUnitario());
            stmt.setBigDecimal(6, estoque.getPrecoVendaUnitario());
            stmt.setInt(7, estoque.getTipoMovimentacao());
            stmt.setInt(8, estoque.getIdEstoque());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Movimentação de estoque de ID " + estoque.getIdEstoque() + " atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma movimentação de estoque encontrada com o ID " + estoque.getIdEstoque() + " para ser atualizada.");
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
        String sql = "DELETE FROM estoque WHERE idEstoque = ?";
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