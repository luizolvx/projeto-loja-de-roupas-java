package com.lojaroupa.dao;

import com.lojaroupa.conexao.ConexaoDB;
import com.lojaroupa.model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types; // Importado para java.sql.Types.INTEGER
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public void inserir(Pedido pedido) {
        String sql = "INSERT INTO pedidos (idCliente, idFuncionario, dataPedido, status, valorTotal) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pedido.getIdCliente());

            // MUDANÇA ESSENCIAL AQUI: Lógica para lidar com idFuncionario null
            if (pedido.getIdFuncionario() != null) {
                stmt.setInt(2, pedido.getIdFuncionario());
            } else {
                stmt.setNull(2, Types.INTEGER); // Define o valor como NULL no banco de dados
            }

            stmt.setTimestamp(3, Timestamp.valueOf(pedido.getDataPedido()));
            stmt.setString(4, pedido.getStatusPedido());
            stmt.setBigDecimal(5, pedido.getValorTotal());

            stmt.executeUpdate();
            System.out.println("Pedido para cliente " + pedido.getIdCliente() + " inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir pedido: " + e.getMessage());
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

    public List<Pedido> listarTodos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT idPedido, idCliente, idFuncionario, dataPedido, status, valorTotal FROM pedidos ORDER BY dataPedido DESC";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdCliente(rs.getInt("idCliente"));
                
                // MUDANÇA ESSENCIAL AQUI: Lógica para ler idFuncionario que pode ser null
                Object idFuncionarioObj = rs.getObject("idFuncionario");
                if (idFuncionarioObj != null) {
                    pedido.setIdFuncionario((Integer) idFuncionarioObj);
                } else {
                    pedido.setIdFuncionario(null);
                }

                pedido.setDataPedido(rs.getTimestamp("dataPedido").toLocalDateTime());
                pedido.setStatusPedido(rs.getString("status"));
                pedido.setValorTotal(rs.getBigDecimal("valorTotal"));

                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar pedidos: " + e.getMessage());
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
        return pedidos;
    }

    public Pedido buscarPorId(int id) {
        Pedido pedido = null;
        String sql = "SELECT idPedido, idCliente, idFuncionario, dataPedido, status, valorTotal FROM pedidos WHERE idPedido = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdCliente(rs.getInt("idCliente"));
                
                // MUDANÇA ESSENCIAL AQUI: Lógica para ler idFuncionario que pode ser null
                Object idFuncionarioObj = rs.getObject("idFuncionario");
                if (idFuncionarioObj != null) {
                    pedido.setIdFuncionario((Integer) idFuncionarioObj);
                } else {
                    pedido.setIdFuncionario(null);
                }

                pedido.setDataPedido(rs.getTimestamp("dataPedido").toLocalDateTime());
                pedido.setStatusPedido(rs.getString("status"));
                pedido.setValorTotal(rs.getBigDecimal("valorTotal"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar pedido por ID: " + e.getMessage());
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
        return pedido;
    }

    public void atualizar(Pedido pedido) {
        String sql = "UPDATE pedidos SET idCliente = ?, idFuncionario = ?, dataPedido = ?, status = ?, valorTotal = ? WHERE idPedido = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pedido.getIdCliente());
            
            // MUDANÇA ESSENCIAL AQUI: Lógica para lidar com idFuncionario null
            if (pedido.getIdFuncionario() != null) {
                stmt.setInt(2, pedido.getIdFuncionario());
            } else {
                stmt.setNull(2, Types.INTEGER);
            }

            stmt.setTimestamp(3, Timestamp.valueOf(pedido.getDataPedido()));
            stmt.setString(4, pedido.getStatusPedido());
            stmt.setBigDecimal(5, pedido.getValorTotal());
            stmt.setInt(6, pedido.getIdPedido());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Pedido de ID " + pedido.getIdPedido() + " atualizado com sucesso!");
            } else {
                System.out.println("Nenhum pedido encontrado com o ID " + pedido.getIdPedido() + " para ser atualizado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar pedido: " + e.getMessage());
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
        String sql = "DELETE FROM pedidos WHERE idPedido = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Pedido de ID " + id + " deletado com sucesso!");
            } else {
                System.out.println("Nenhum pedido encontrado com o ID " + id + " para ser deletado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar pedido: " + e.getMessage());
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