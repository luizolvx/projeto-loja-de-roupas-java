package com.lojaroupa.gui;

import com.lojaroupa.dao.ClienteDAO;
import com.lojaroupa.dao.PedidoDAO;
import com.lojaroupa.model.Cliente;
import com.lojaroupa.model.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdminDashboardFrame extends JFrame {

    private static final long serialVersionUID = 1L; // Adicionado serialVersionUID

    private JTable clientesTable;
    private DefaultTableModel clientesTableModel;
    private JTable pedidosTable;
    private DefaultTableModel pedidosTableModel;

    public AdminDashboardFrame() {
        setTitle("Admin Dashboard - Loja de Roupa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Clientes", createClientesPanel());
        tabbedPane.addTab("Pedidos", createPedidosPanel());
        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createClientesPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Removido "Data Cadastro" das colunas da tabela de clientes
        clientesTableModel = new DefaultTableModel(
                new Object[]{"ID", "Nome", "CPF", "Email", "Telefone", "Endereço", "CEP"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Torna as células não editáveis diretamente na tabela
                return false;
            }
        };
        clientesTable = new JTable(clientesTableModel);
        panel.add(new JScrollPane(clientesTable), BorderLayout.CENTER);

        JButton carregarBtn = new JButton("Carregar Clientes");
        carregarBtn.addActionListener(e -> carregarClientes());

        JButton novoBtn = new JButton("Novo Cliente");
        novoBtn.addActionListener(e -> abrirFormularioNovoCliente());

        // Novo botão para Excluir Cliente
        JButton excluirClienteBtn = new JButton("Excluir Cliente Selecionado");
        excluirClienteBtn.addActionListener(e -> excluirClienteSelecionado());

        JPanel btnPanel = new JPanel();
        btnPanel.add(carregarBtn);
        btnPanel.add(novoBtn);
        btnPanel.add(excluirClienteBtn); // Adiciona o botão de exclusão
        panel.add(btnPanel, BorderLayout.SOUTH);

        // Carrega os clientes ao iniciar o painel
        carregarClientes();

        return panel;
    }

    private JPanel createPedidosPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Removido "ID Funcionário" das colunas da tabela de pedidos
        pedidosTableModel = new DefaultTableModel(
                new Object[]{"ID Pedido", "ID Cliente", "Data Pedido", "Status", "Valor Total"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Torna as células não editáveis diretamente na tabela
                return false;
            }
        };
        pedidosTable = new JTable(pedidosTableModel);
        panel.add(new JScrollPane(pedidosTable), BorderLayout.CENTER);

        JButton carregarBtn = new JButton("Carregar Pedidos");
        carregarBtn.addActionListener(e -> carregarPedidos());

        // Novo botão para Liberar Pedido
        JButton liberarPedidoBtn = new JButton("Liberar Pedido Selecionado");
        liberarPedidoBtn.addActionListener(e -> liberarPedidoSelecionado());

        JPanel btnPanel = new JPanel();
        btnPanel.add(carregarBtn);
        btnPanel.add(liberarPedidoBtn); // Adiciona o botão de liberar pedido
        panel.add(btnPanel, BorderLayout.SOUTH);

        // Carrega os pedidos ao iniciar o painel
        carregarPedidos();

        return panel;
    }

    private void carregarClientes() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> list = dao.listarTodos();
        clientesTableModel.setRowCount(0); // Limpa a tabela
        for (Cliente c : list) {
            clientesTableModel.addRow(new Object[]{
                    c.getIdCliente(),
                    c.getNome(),
                    c.getCpf(),
                    c.getEmail(),
                    c.getTelefone(),
                    c.getEndereco(),
                    c.getCep()
            });
        }
    }

    private void carregarPedidos() {
        PedidoDAO dao = new PedidoDAO();
        List<Pedido> list = dao.listarTodos();
        pedidosTableModel.setRowCount(0); // Limpa a tabela
        for (Pedido p : list) {
            pedidosTableModel.addRow(new Object[]{
                    p.getIdPedido(),
                    p.getIdCliente(),
                    p.getDataPedido(),
                    p.getStatusPedido(), // Este é o valor na coluna de índice 3
                    p.getValorTotal()    // Este é o valor na coluna de índice 4
            });
        }
    }

    private void abrirFormularioNovoCliente() {
        JTextField nomeField = new JTextField(20);
        JTextField cpfField = new JTextField(14);
        JTextField emailField = new JTextField(20);
        JTextField telefoneField = new JTextField(15);
        JTextField enderecoField = new JTextField(30);
        JTextField cepField = new JTextField(9);

        JPanel form = new JPanel(new GridLayout(0, 2));
        form.add(new JLabel("Nome:"));    form.add(nomeField);
        form.add(new JLabel("CPF:"));     form.add(cpfField);
        form.add(new JLabel("Email:"));   form.add(emailField);
        form.add(new JLabel("Telefone:"));form.add(telefoneField);
        form.add(new JLabel("Endereço:"));form.add(enderecoField);
        form.add(new JLabel("CEP:"));     form.add(cepField);

        int result = JOptionPane.showConfirmDialog(
                this, form, "Novo Cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            Cliente c = new Cliente();
            c.setNome(nomeField.getText());
            c.setCpf(cpfField.getText());
            c.setEmail(emailField.getText());
            c.setTelefone(telefoneField.getText());
            c.setEndereco(enderecoField.getText());
            c.setCep(cepField.getText());
            // Se você quiser que novos clientes tenham uma senha inicial, você precisaria adicionar uma aqui
            // Ex: c.setSenha("senhaPadrao"); // Se Cliente.java tiver o campo senha

            new ClienteDAO().inserir(c);
            carregarClientes(); // Recarrega a lista de clientes para mostrar o novo
        }
    }

    private void excluirClienteSelecionado() {
        int selectedRow = clientesTable.getSelectedRow();
        if (selectedRow >= 0) {
            int idCliente = (int) clientesTableModel.getValueAt(selectedRow, 0); // ID está na primeira coluna
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja excluir o cliente com ID: " + idCliente + "?",
                    "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                new ClienteDAO().deletar(idCliente);
                carregarClientes(); // Recarrega a tabela após a exclusão
                JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void liberarPedidoSelecionado() {
        int selectedRow = pedidosTable.getSelectedRow();
        if (selectedRow >= 0) {
            int idPedido = (int) pedidosTableModel.getValueAt(selectedRow, 0); // ID está na primeira coluna
            // AQUI ESTÁ A CORREÇÃO: Pegar o status da coluna de índice 3
            String currentStatus = (String) pedidosTableModel.getValueAt(selectedRow, 3); // Status está na quarta coluna (índice 3)

            // Uma lógica simples: apenas liberar se o status não for "Liberado" ou "Entregue"
            if (currentStatus != null && (currentStatus.equals("Liberado") || currentStatus.equals("Entregue"))) {
                JOptionPane.showMessageDialog(this, "Pedido já está com status de 'Liberado' ou 'Entregue'.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja LIBERAR (excluir) o pedido com ID: " + idPedido + "?\n" +
                    "Esta ação geralmente significa que o pedido foi processado e pode ser removido do painel.",
                    "Confirmar Liberação/Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // No contexto de "Liberar", podemos atualizar o status ou, como pedido, "excluir" do painel de pendentes.
                // Aqui estamos usando o método 'deletar' do DAO, que remove o pedido do BD.
                new PedidoDAO().deletar(idPedido);
                carregarPedidos(); // Recarrega a tabela após a "liberação"
                JOptionPane.showMessageDialog(this, "Pedido liberado (excluído) com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um pedido para liberar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Apenas para teste independente, o LoginFrame iniciará isso
            new AdminDashboardFrame().setVisible(true);
        });
    }
}