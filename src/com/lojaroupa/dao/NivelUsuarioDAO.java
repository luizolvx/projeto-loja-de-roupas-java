// src/main/java/com/lojaroupa/dao/NivelUsuarioDAO.java
package com.lojaroupa.dao;

import com.lojaroupa.conexao.ConexaoDB;
import com.lojaroupa.model.NivelUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NivelUsuarioDAO {

    public void inserir(NivelUsuario nivelUsuario) {
        String sql = "INSERT INTO niveis_usuario (descricao) VALUES (?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nivelUsuario.getDescricao());

            stmt.executeUpdate();
            System.out.println("Nível de Usuário '" + nivelUsuario.getDescricao() + "' inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir nível de usuário: " + e.getMessage());
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

    public List<NivelUsuario> listarTodos() {
        List<NivelUsuario> niveisUsuario = new ArrayList<>();
        String sql = "SELECT idNivelUsuario, descricao FROM niveis_usuario ORDER BY descricao";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                NivelUsuario nivelUsuario = new NivelUsuario();
                nivelUsuario.setIdNivelUsuario(rs.getInt("idNivelUsuario"));
                nivelUsuario.setDescricao(rs.getString("descricao"));
                niveisUsuario.add(nivelUsuario);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar níveis de usuário: " + e.getMessage());
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
        return niveisUsuario;
    }

    public NivelUsuario buscarPorId(int id) {
        NivelUsuario nivelUsuario = null;
        String sql = "SELECT idNivelUsuario, descricao FROM niveis_usuario WHERE idNivelUsuario = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                nivelUsuario = new NivelUsuario();
                nivelUsuario.setIdNivelUsuario(rs.getInt("idNivelUsuario"));
                nivelUsuario.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar nível de usuário por ID: " + e.getMessage());
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
        return nivelUsuario;
    }

    public void atualizar(NivelUsuario nivelUsuario) {
        String sql = "UPDATE niveis_usuario SET descricao = ? WHERE idNivelUsuario = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nivelUsuario.getDescricao());
            stmt.setInt(2, nivelUsuario.getIdNivelUsuario());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Nível de Usuário de ID " + nivelUsuario.getIdNivelUsuario() + " atualizado para '" + nivelUsuario.getDescricao() + "'.");
            } else {
                System.out.println("Nenhum nível de usuário encontrado com o ID " + nivelUsuario.getIdNivelUsuario() + " para ser atualizado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar nível de usuário: " + e.getMessage());
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
        String sql = "DELETE FROM niveis_usuario WHERE idNivelUsuario = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Nível de Usuário de ID " + id + " deletado com sucesso!");
            } else {
                System.out.println("Nenhum nível de usuário encontrado com o ID " + id + " para ser deletado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar nível de usuário: " + e.getMessage());
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