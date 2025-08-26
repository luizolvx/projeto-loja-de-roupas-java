// Conteúdo COMPLETO do CategoriaDAO.java
package com.lojaroupa.dao; // <<< Deve ser este pacote

import com.lojaroupa.conexao.ConexaoDB; // Importa sua classe de conexão
import com.lojaroupa.model.Categoria;   // Importa a classe de Modelo Categoria

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public void inserir(Categoria categoria) {
        String sql = "INSERT INTO categorias (descricao) VALUES (?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
            stmt.executeUpdate();
            System.out.println("Categoria '" + categoria.getDescricao() + "' inserida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir categoria: " + e.getMessage());
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

    public List<Categoria> listarTodos() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT idCategoria, descricao FROM categorias ORDER BY descricao";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar categorias: " + e.getMessage());
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
        return categorias;
    }

    public Categoria buscarPorId(int id) {
        Categoria categoria = null;
        String sql = "SELECT idCategoria, descricao FROM categorias WHERE idCategoria = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar categoria por ID: " + e.getMessage());
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
        return categoria;
    }

    public void atualizar(Categoria categoria) {
        String sql = "UPDATE categorias SET descricao = ? WHERE idCategoria = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
            stmt.setInt(2, categoria.getIdCategoria());
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Categoria de ID " + categoria.getIdCategoria() + " atualizada para '" + categoria.getDescricao() + "'.");
            } else {
                System.out.println("Nenhuma categoria encontrada com o ID " + categoria.getIdCategoria() + " para ser atualizada.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar categoria: " + e.getMessage());
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
        String sql = "DELETE FROM categorias WHERE idCategoria = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Categoria de ID " + id + " deletada com sucesso!");
            } else {
                System.out.println("Nenhuma categoria encontrada com o ID " + id + " para ser deletada.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deletar categoria: " + e.getMessage());
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