package main.frontend.view;

import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.Cliente;
import main.backend.model.Produto;
import main.backend.model.ProdutoENUM;
import main.frontend.controller.ClienteController;
import main.frontend.controller.ProdutoController;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class TelaPrincipal {

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton buttonCadastrar;
    private JButton buttonCadastrarProduto;
    private JLabel imageLabel;

    public TelaPrincipal() {
        frame = new JFrame("Floricultura Lírios do Vale");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        label = new JLabel("Bem-vindo a Floricultura Lírios do Vale", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonCadastrar.addActionListener(e -> mostrarTelaDeCadastro());

        buttonCadastrarProduto = new JButton("Cadastrar produtos");
        buttonCadastrarProduto.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonCadastrarProduto.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonCadastrarProduto.addActionListener(e -> mostrarTelaDeCadastroProduto());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.add(buttonCadastrar);

        panel.add(Box.createVerticalGlue());

        panel.add(Box.createVerticalStrut(20));
        panel.add(label);
        panel.add(Box.createVerticalStrut(20));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(buttonCadastrarProduto);
        panel.add(Box.createVerticalGlue());

        frame.add(panel);
    }

    public void exibir() {
        frame.setVisible(true);
    }

    private void mostrarTelaDeCadastro() {
        JFrame cadastro = new JFrame("Tela de cadastro");
        cadastro.setSize(500, 500);
        cadastro.setLocationRelativeTo(null);
        cadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel cadastroPainel = new JPanel();
        cadastroPainel.setLayout(new BoxLayout(cadastroPainel, BoxLayout.Y_AXIS));
        cadastroPainel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeCampo = new JTextField(20);

        JLabel idadeLabel = new JLabel("Idade:");
        JTextField idadeCampo = new JTextField(20);

        JLabel cpfLabel = new JLabel("Cpf:");
        JTextField cpfCampo = new JTextField(20);

        JLabel cepLabel = new JLabel("Cep:");
        JTextField cepCampo = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailCampo = new JTextField(20);

        JLabel senhaLabel = new JLabel("Senha:");
        JTextField senhaCampo = new JPasswordField(20);

        JButton cadastrarBotao = new JButton("Cadastrar");
        cadastrarBotao.addActionListener(e -> {

            String nome = nomeCampo.getText();
            String idadeStr = idadeCampo.getText();
            String cpf = cpfCampo.getText();
            String cep = cepCampo.getText();
            String email = emailCampo.getText();
            String senha = senhaCampo.getText();

            if (nome.isEmpty() || idadeStr.isEmpty() || cpf.isEmpty() || cep.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(cadastro, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int idade = Integer.parseInt(idadeStr);
                Cliente cliente = new Cliente(nome, idade, cpf, cep, email, senha);
                ClienteController clienteController = new ClienteController();
                clienteController.cadastrar(cliente);

                JOptionPane.showMessageDialog(cadastro, "Cadastro realizado com sucesso!");
                cadastro.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(cadastro, "A idade deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException | FaltaDeInfoException ex) {
                JOptionPane.showMessageDialog(cadastro, "Erro ao cadastrar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        cadastroPainel.add(nomeLabel);
        cadastroPainel.add(nomeCampo);
        cadastroPainel.add(Box.createVerticalStrut(10));
        cadastroPainel.add(idadeLabel);
        cadastroPainel.add(idadeCampo);
        cadastroPainel.add(Box.createVerticalStrut(10));
        cadastroPainel.add(cpfLabel);
        cadastroPainel.add(cpfCampo);
        cadastroPainel.add(Box.createVerticalStrut(10));
        cadastroPainel.add(cepLabel);
        cadastroPainel.add(cepCampo);
        cadastroPainel.add(Box.createVerticalStrut(10));
        cadastroPainel.add(emailLabel);
        cadastroPainel.add(emailCampo);
        cadastroPainel.add(Box.createVerticalStrut(10));
        cadastroPainel.add(senhaLabel);
        cadastroPainel.add(senhaCampo);
        cadastroPainel.add(Box.createVerticalStrut(20));
        cadastroPainel.add(cadastrarBotao);

        cadastro.add(cadastroPainel);
        cadastro.setVisible(true);
    }

    public void mostrarTelaDeCadastroProduto(){
        JFrame cadastrarProduto = new JFrame("Tela de cadastro de produto");
        cadastrarProduto.setSize(500, 500);
        cadastrarProduto.setLocationRelativeTo(null);
        cadastrarProduto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel cadastrarProdutoPainel = new JPanel();
        cadastrarProdutoPainel.setLayout(new BoxLayout(cadastrarProdutoPainel, BoxLayout.Y_AXIS));
        cadastrarProdutoPainel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JLabel precoProdutoLabel = new JLabel("preço do produto:");
        JTextField precoProdutoCampo = new JTextField();
        precoProdutoCampo.setMaximumSize(new Dimension(200, 25));

        JLabel nomeProdutoLabel = new JLabel("nome do produto");
        JTextField nomeProdutoCampo = new JTextField();
        nomeProdutoCampo.setMaximumSize(new Dimension(200, 25));

        JLabel tipoProdutoLabel = new JLabel("Tipo do produto:");

        JComboBox<ProdutoENUM> tipoProdutoComboBox = new JComboBox<>(ProdutoENUM.values());
        tipoProdutoComboBox.setMaximumSize(new Dimension(200, 25));

        JButton botaoDeCadastrarProduto = new JButton("Cadastrar produto");
        botaoDeCadastrarProduto.addActionListener(e -> {
            String precoProdutoStr = precoProdutoCampo.getText();
            String nomeProduto = nomeProdutoCampo.getText();
            ProdutoENUM produtoENUM = (ProdutoENUM) tipoProdutoComboBox.getSelectedItem();

            if(precoProdutoStr.isEmpty() || nomeProduto.isEmpty() || produtoENUM == null){
                JOptionPane.showMessageDialog(cadastrarProduto, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try{
                double precoProduto = Double.parseDouble(precoProdutoStr);

                Produto produto = new Produto(precoProduto, nomeProduto, produtoENUM.getTipo());
                ProdutoController produtoController = new ProdutoController();
                produtoController.cadastrar(produto);

                JOptionPane.showMessageDialog(cadastrarProduto, "Cadastro realizado com sucesso!");
                cadastrarProduto.dispose();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (FaltaDeInfoException ex) {
                throw new RuntimeException(ex);
            }
        });

        cadastrarProdutoPainel.add(precoProdutoLabel);
        cadastrarProdutoPainel.add(precoProdutoCampo);
        cadastrarProdutoPainel.add(Box.createVerticalStrut(2));
        cadastrarProdutoPainel.add(nomeProdutoLabel);
        cadastrarProdutoPainel.add(nomeProdutoCampo);
        cadastrarProdutoPainel.add(Box.createVerticalStrut(2));
        cadastrarProdutoPainel.add(tipoProdutoLabel);
        cadastrarProdutoPainel.add(tipoProdutoComboBox);
        cadastrarProdutoPainel.add(Box.createVerticalStrut(2));
        cadastrarProdutoPainel.add(botaoDeCadastrarProduto);

        cadastrarProduto.add(cadastrarProdutoPainel);
        cadastrarProduto.setVisible(true);
    }



}