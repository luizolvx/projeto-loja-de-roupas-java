package com.lojaroupa.gui;

import com.lojaroupa.dao.AuthDAO;
import com.lojaroupa.conexao.ConexaoDB;
import com.lojaroupa.dao.FuncionarioDAO;
import com.lojaroupa.dao.ClienteDAO;
import com.lojaroupa.model.Funcionario;
import com.lojaroupa.model.Cliente;
import com.lojaroupa.model.NivelUsuario;
import com.lojaroupa.dao.NivelUsuarioDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LoginFrame extends JFrame {

    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {
        setTitle("Login - Loja de Roupa");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        setupLayout();
        addListeners();
    }

    private void initComponents() {
        userField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
    }

    private void setupLayout() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Usuário/Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        add(panel, BorderLayout.CENTER);
    }

    private void addListeners() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attemptLogin();
            }
        });

        userField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attemptLogin();
            }
        });

        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {
        String username = userField.getText();
        String password = new String(passwordField.getPassword());

        // Aqui você testa a conexão com o banco de dados
        try (Connection conn = ConexaoDB.getConnection()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Erro: Não foi possível conectar ao banco de dados.", "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao testar conexão com o banco de dados: " + ex.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return;
        }

        // Autentica o usuário
        AuthDAO authDAO = new AuthDAO();
        String userType = authDAO.autenticarUsuario(username, password);  // Chama o método correto de autenticação

        if ("admin".equals(userType)) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido como Admin!");
            this.dispose();
            new AdminDashboardFrame().setVisible(true);
        } else if ("cliente".equals(userType)) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido como Cliente!");
            this.dispose();
            new ClientDashboardFrame().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Tenta conectar ao banco de dados
        try {
            ConexaoDB.getConnection();
        } catch (SQLException e) {
            System.err.println("Erro crítico: Falha ao conectar ao banco de dados na inicialização.");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.", "Erro de Inicialização", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // Executa a GUI na thread correta
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
