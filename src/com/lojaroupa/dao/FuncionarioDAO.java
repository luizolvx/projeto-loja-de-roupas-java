// src/main/java/com/lojaroupa/dao/FuncionarioDAO.java
package com.lojaroupa.dao;

import com.lojaroupa.conexao.ConexaoDB;
import com.lojaroupa.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (login, senha, idNivelUsuario, nomeCompleto, cpf, endereco, cep, telefone, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getLogin());
            stmt.setString(2, funcionario.getSenha()); // Lembre-se do aviso de segurança sobre senhas!
            stmt.setInt(3, funcionario.getIdNivelUsuario());
            stmt.setString(4, funcionario.getNomeCompleto());
            stmt.setString(5, funcionario.getCpf());
            stmt.setString(6, funcionario.getEndereco());
            stmt.setString(7, funcionario.getCep());
            stmt.setString(8, funcionario.getTelefone());
            stmt.setString(9, funcionario.getAtivo());

            stmt.executeUpdate();
            System.out.println("Funcionário '" + funcionario.getNomeCompleto() + "' inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir funcionário: " + e.getMessage());
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

    public List<Funcionario> listarTodos() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT idFuncionario, login, senha, idNivelUsuario, nomeCompleto, cpf, endereco, cep, telefone, ativo FROM funcionarios ORDER BY nomeCompleto";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setIdNivelUsuario(rs.getInt("idNivelUsuario"));
                funcionario.setNomeCompleto(rs.getString("nomeCompleto"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setAtivo(rs.getString("ativo"));
                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar funcionários: " + e.getMessage());
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
        return funcionarios;
    }

    public Funcionario buscarPorId(int id) {
        Funcionario funcionario = null;
        String sql = "SELECT idFuncionario, login, senha, idNivelUsuario, nomeCompleto, cpf, endereco, cep, telefone, ativo FROM funcionarios WHERE idFuncionario = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setIdNivelUsuario(rs.getInt("idNivelUsuario"));
                funcionario.setNomeCompleto(rs.getString("nomeCompleto"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setAtivo(rs.getString("ativo"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar funcionário por ID: " + e.getMessage());
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
        return funcionario;
    }

    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET login = ?, senha = ?, idNivelUsuario = ?, nomeCompleto = ?, cpf = ?, endereco = ?, cep = ?, telefone = ?, ativo = ? WHERE idFuncionario = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getLogin());
            stmt.setString(2, funcionario.getSenha());
            stmt.setInt(3, funcionario.getIdNivelUsuario());
            stmt.setString(4, funcionario.getNomeCompleto());
            stmt.setString(5, funcionario.getCpf());
            stmt.setString(6, funcionario.getEndereco());
            stmt.setString(7, funcionario.getCep());
            stmt.setString(8, funcionario.getTelefone());
            stmt.setString(9, funcionario.getAtivo());
            stmt.setInt(10, funcionario.getIdFuncionario());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Funcionário de ID " + funcionario.getIdFuncionario() + " atualizado com sucesso!");
            } else {
                System.out.println("Nenhum funcionário encontrado com o ID " + funcionario.getIdFuncionario() + " para ser atualizado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar funcionário: " + e.getMessage());
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
        String sql = "DELETE FROM funcionarios WHERE idFuncionario = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexaoDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Funcionário de ID " + id + " deletado com sucesso!");
            } else {
                System.out.println("Nenhum funcionário encontrado com o ID " + id + " para ser deletado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar funcionário: " + e.getMessage());
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