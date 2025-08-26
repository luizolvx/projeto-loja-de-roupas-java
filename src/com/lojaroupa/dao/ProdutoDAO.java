package com.lojaroupa.dao;

import com.lojaroupa.conexao.ConexaoDB;
import com.lojaroupa.model.Produto;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void inserir(Produto produto) {
        String sql = "INSERT INTO produtos (nome, marca, modelo, idCategoria, descricao, unidadeMedida, cor, tamanho, preco, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getModelo());
            stmt.setInt(4, produto.getIdCategoria());
            stmt.setString(5, produto.getDescricao());
            stmt.setString(6, produto.getUnidadeMedida());
            stmt.setString(7, produto.getCor());
            stmt.setString(8, produto.getTamanho());
            stmt.setBigDecimal(9, produto.getPreco());
            stmt.setString(10, produto.getAtivo());

            stmt.executeUpdate();
            System.out.println("Produto '" + produto.getNome() + "' inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir produto: " + e.getMessage());
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

    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT idProduto, nome, marca, modelo, idCategoria, descricao, unidadeMedida, cor, tamanho, preco, ativo FROM produtos ORDER BY nome";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setModelo(rs.getString("modelo"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setUnidadeMedida(rs.getString("unidadeMedida"));
                produto.setCor(rs.getString("cor"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setPreco(rs.getBigDecimal("preco"));
                produto.setAtivo(rs.getString("ativo"));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
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
        return produtos;
    }

    public Produto buscarPorId(int id) {
        Produto produto = null;
        String sql = "SELECT idProduto, nome, marca, modelo, idCategoria, descricao, unidadeMedida, cor, tamanho, preco, ativo FROM produtos WHERE idProduto = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setModelo(rs.getString("modelo"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setUnidadeMedida(rs.getString("unidadeMedida"));
                produto.setCor(rs.getString("cor"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setPreco(rs.getBigDecimal("preco"));
                produto.setAtivo(rs.getString("ativo"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto por ID: " + e.getMessage());
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
        return produto;
    }

    public void atualizar(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, marca = ?, modelo = ?, idCategoria = ?, descricao = ?, unidadeMedida = ?, cor = ?, tamanho = ?, preco = ?, ativo = ? WHERE idProduto = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getModelo());
            stmt.setInt(4, produto.getIdCategoria());
            stmt.setString(5, produto.getDescricao());
            stmt.setString(6, produto.getUnidadeMedida());
            stmt.setString(7, produto.getCor());
            stmt.setString(8, produto.getTamanho());
            stmt.setBigDecimal(9, produto.getPreco());
            stmt.setString(10, produto.getAtivo());
            stmt.setInt(11, produto.getIdProduto());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Produto de ID " + produto.getIdProduto() + " atualizado com sucesso!");
            } else {
                System.out.println("Nenhum produto encontrado com o ID " + produto.getIdProduto() + " para ser atualizado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
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
        String sql = "DELETE FROM produtos WHERE idProduto = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Produto de ID " + id + " deletado com sucesso!");
            } else {
                System.out.println("Nenhum produto encontrado com o ID " + id + " para ser deletado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar produto: " + e.getMessage());
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
