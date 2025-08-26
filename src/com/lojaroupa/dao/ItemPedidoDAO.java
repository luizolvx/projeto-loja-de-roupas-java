// src/main/java/com/lojaroupa/dao/ItemPedidoDAO.java
package com.lojaroupa.dao;

import com.lojaroupa.conexao.ConexaoDB;
import com.lojaroupa.model.ItemPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoDAO {

    public void inserir(ItemPedido itemPedido) {
        String sql = "INSERT INTO itens_pedido (idPedido, idProduto, quantidade, precoUnitario, subtotal) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, itemPedido.getIdPedido());
            stmt.setInt(2, itemPedido.getIdProduto());
            stmt.setInt(3, itemPedido.getQuantidade());
            stmt.setBigDecimal(4, itemPedido.getPrecoUnitario());
            stmt.setBigDecimal(5, itemPedido.getSubtotal());

            stmt.executeUpdate();
            System.out.println("Item de pedido para pedido " + itemPedido.getIdPedido() + " e produto " + itemPedido.getIdProduto() + " inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir item de pedido: " + e.getMessage());
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

    public List<ItemPedido> listarTodos() {
        List<ItemPedido> itensPedido = new ArrayList<>();
        String sql = "SELECT idItemPedido, idPedido, idProduto, quantidade, precoUnitario, subtotal FROM itens_pedido ORDER BY idPedido, idItemPedido";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setIdItemPedido(rs.getInt("idItemPedido"));
                itemPedido.setIdPedido(rs.getInt("idPedido"));
                itemPedido.setIdProduto(rs.getInt("idProduto"));
                itemPedido.setQuantidade(rs.getInt("quantidade"));
                itemPedido.setPrecoUnitario(rs.getBigDecimal("precoUnitario"));
                itemPedido.setSubtotal(rs.getBigDecimal("subtotal"));
                itensPedido.add(itemPedido);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar itens de pedido: " + e.getMessage());
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
        return itensPedido;
    }

    public ItemPedido buscarPorId(int id) {
        ItemPedido itemPedido = null;
        String sql = "SELECT idItemPedido, idPedido, idProduto, quantidade, precoUnitario, subtotal FROM itens_pedido WHERE idItemPedido = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                itemPedido = new ItemPedido();
                itemPedido.setIdItemPedido(rs.getInt("idItemPedido"));
                itemPedido.setIdPedido(rs.getInt("idPedido"));
                itemPedido.setIdProduto(rs.getInt("idProduto"));
                itemPedido.setQuantidade(rs.getInt("quantidade"));
                itemPedido.setPrecoUnitario(rs.getBigDecimal("precoUnitario"));
                itemPedido.setSubtotal(rs.getBigDecimal("subtotal"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar item de pedido por ID: " + e.getMessage());
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
        return itemPedido;
    }

    public void atualizar(ItemPedido itemPedido) {
        String sql = "UPDATE itens_pedido SET idPedido = ?, idProduto = ?, quantidade = ?, precoUnitario = ?, subtotal = ? WHERE idItemPedido = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, itemPedido.getIdPedido());
            stmt.setInt(2, itemPedido.getIdProduto());
            stmt.setInt(3, itemPedido.getQuantidade());
            stmt.setBigDecimal(4, itemPedido.getPrecoUnitario());
            stmt.setBigDecimal(5, itemPedido.getSubtotal());
            stmt.setInt(6, itemPedido.getIdItemPedido());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Item de pedido de ID " + itemPedido.getIdItemPedido() + " atualizado com sucesso!");
            } else {
                System.out.println("Nenhum item de pedido encontrado com o ID " + itemPedido.getIdItemPedido() + " para ser atualizado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar item de pedido: " + e.getMessage());
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
        String sql = "DELETE FROM itens_pedido WHERE idItemPedido = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Item de pedido de ID " + id + " deletado com sucesso!");
            } else {
                System.out.println("Nenhum item de pedido encontrado com o ID " + id + " para ser deletado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar item de pedido: " + e.getMessage());
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