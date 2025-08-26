package com.lojaroupa.dao;

import com.lojaroupa.conexao.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {

    public String autenticarUsuario(String email, String senha) {
        String sqlFuncionario = "SELECT * FROM funcionarios WHERE email = ? AND senha = ?";
        String sqlCliente = "SELECT * FROM clientes WHERE email = ? AND senha = ?";

        try (Connection conn = ConexaoDB.getConnection()) {

            PreparedStatement stmtFunc = conn.prepareStatement(sqlFuncionario);
            stmtFunc.setString(1, email);
            stmtFunc.setString(2, senha);
            ResultSet rsFunc = stmtFunc.executeQuery();
            if (rsFunc.next()) {
                return "admin";
            }

            PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente);
            stmtCliente.setString(1, email);
            stmtCliente.setString(2, senha);
            ResultSet rsCliente = stmtCliente.executeQuery();
            if (rsCliente.next()) {
                return "cliente";
            }

        } catch (SQLException e) {
            System.err.println("Erro ao autenticar usuário: " + e.getMessage());
        }

        return null;
    }
}
