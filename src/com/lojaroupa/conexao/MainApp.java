package com.lojaroupa.conexao;

import javax.swing.SwingUtilities;
import com.lojaroupa.gui.LoginFrame;

public class MainApp {
    public static void main(String[] args) {
        // Executa a GUI na thread correta
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Chama o LoginFrame que é a tela de login
                new LoginFrame().setVisible(true);
            }
        });
    }
}
