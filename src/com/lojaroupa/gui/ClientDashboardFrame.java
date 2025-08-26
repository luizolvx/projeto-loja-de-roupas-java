package com.lojaroupa.gui;

import com.lojaroupa.dao.ProdutoDAO;
import com.lojaroupa.model.Produto;
import com.lojaroupa.dao.PedidoDAO; // Importar PedidoDAO
import com.lojaroupa.model.Pedido; // Importar Pedido

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime; // Para data do pedido
import java.math.BigDecimal; // Para valor do pedido
import java.util.List;

public class ClientDashboardFrame extends JFrame {

    private static final long serialVersionUID = 1L; // Adicionado serialVersionUID para evitar warnings

    private JList<Produto> productList;
    private DefaultListModel<Produto> productListModel;

    public ClientDashboardFrame() {
        setTitle("Dashboard do Cliente - Loja de Roupa");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        setupLayout(); // Chamada para setupLayout
        loadProducts(); // Carrega produtos ao iniciar
    }

    private void initComponents() {
        productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite selecionar apenas um item
        productList.setLayoutOrientation(JList.VERTICAL);
        productList.setVisibleRowCount(-1); // Exibe todos os itens

        // Renderizador personalizado para exibir o produto de forma mais amigável
        productList.setCellRenderer(new DefaultListCellRenderer() {
            private static final long serialVersionUID = 1L; // Adicionado serialVersionUID para este anônimo
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Produto) {
                    Produto produto = (Produto) value;
                    setText(produto.getNome() + " - " + produto.getMarca() + " - R$" + produto.getPreco()); // Usa getPreco()
                }
                return this;
            }
        });
    }

    private void setupLayout() {
        // Declarações movidas para dentro do método
        JPanel panel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Produtos Disponíveis", SwingConstants.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton viewDetailsButton = new JButton("Ver Detalhes do Produto"); // Declaração movida para cá
        JButton comprarButton = new JButton("Comprar Item Selecionado"); // Declaração movida para cá


        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(productList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Adiciona listeners aos botões
        viewDetailsButton.addActionListener(e -> {
            Produto selectedProduct = productList.getSelectedValue();
            if (selectedProduct != null) {
                JOptionPane.showMessageDialog(this,
                    "Detalhes do Produto:\n" +
                    "ID: " + selectedProduct.getIdProduto() + "\n" +
                    "Nome: " + selectedProduct.getNome() + "\n" +
                    "Marca: " + selectedProduct.getMarca() + "\n" +
                    "Modelo: " + selectedProduct.getModelo() + "\n" +
                    "Descrição: " + selectedProduct.getDescricao() + "\n" +
                    "Preço: R$" + selectedProduct.getPreco() + "\n" +
                    "Cor: " + selectedProduct.getCor() + "\n" +
                    "Tamanho: " + selectedProduct.getTamanho(),
                    "Detalhes do Produto",
                    JOptionPane.INFORMATION_MESSAGE);
            } else { // Correção de sintaxe: remove o 'else' extra que estava aqui
                JOptionPane.showMessageDialog(this, "Selecione um produto para ver os detalhes.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
        buttonPanel.add(viewDetailsButton);

        comprarButton.addActionListener(e -> comprarProdutoSelecionado());
        buttonPanel.add(comprarButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void loadProducts() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listarTodos();
        productListModel.clear();
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum produto disponível no momento.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Produto produto : produtos) {
                productListModel.addElement(produto);
            }
        }
    }

    private void comprarProdutoSelecionado() {
        Produto selectedProduct = productList.getSelectedValue();
        if (selectedProduct == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para comprar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Deseja confirmar a compra de:\n" +
                selectedProduct.getNome() + " - R$" + selectedProduct.getPreco() + "?",
                "Confirmar Compra",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Pedido novoPedido = new Pedido();
                
                String idClienteStr = JOptionPane.showInputDialog(this, "Para qual ID de Cliente este pedido é (ex: 1 ou 2)?", "ID do Cliente", JOptionPane.QUESTION_MESSAGE);
                if (idClienteStr == null || idClienteStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "ID do Cliente é obrigatório para a compra.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int idCliente = Integer.parseInt(idClienteStr);

                novoPedido.setIdCliente(idCliente);
                // ESSENCIAL: Agora setIdFuncionario recebe Integer e pode ser null
                novoPedido.setIdFuncionario(null); // Define como null, pois não há um funcionário associado
                novoPedido.setDataPedido(LocalDateTime.now());
                novoPedido.setStatusPedido("Novo");
                novoPedido.setValorTotal(selectedProduct.getPreco());

                PedidoDAO pedidoDAO = new PedidoDAO();
                pedidoDAO.inserir(novoPedido);

                JOptionPane.showMessageDialog(this, "Compra realizada com sucesso!\nPedido criado. ID do Produto: " + selectedProduct.getIdProduto(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID do Cliente inválido. Insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao processar a compra: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClientDashboardFrame().setVisible(true);
        });
    }
}