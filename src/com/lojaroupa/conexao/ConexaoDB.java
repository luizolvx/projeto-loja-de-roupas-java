package com.lojaroupa.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:mysql://localhost:3306/lojaroupa?useTimezone=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = ""; // Senha removida, já que não há senha configurada

    public static Connection getConnection() throws SQLException {
        try {
            System.out.println("Tentando conectar ao banco de dados...");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw e;
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão fechada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) { // Método de teste
        Connection conn = null;
        try {
            conn = ConexaoDB.getConnection();
            if (conn != null) {
                System.out.println("Conexão bem-sucedida!");
            }
        } catch (SQLException e) {
            System.err.println("Falha na conexão de teste.");
            e.printStackTrace();
        } finally {
            ConexaoDB.closeConnection(conn);
        }
    }
}
