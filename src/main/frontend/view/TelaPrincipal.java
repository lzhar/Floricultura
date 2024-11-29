package main.frontend.view;

import main.backend.dao.ConexaoNoBanco;
import main.backend.dao.EncomendaDAO;
import main.backend.dao.ProdutoDAO;
import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.*;
import main.backend.service.EncomendaAS;
import main.frontend.controller.ClienteController;
import main.frontend.controller.EncomendaController;
import main.frontend.controller.LocalDeEntregaController;
import main.frontend.controller.ProdutoController;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TelaPrincipal {

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton buttonCadastrar;
    private JButton buttonCadastrarProduto;
    private JButton buttonLogin;

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

        buttonLogin = new JButton("Login");
        buttonLogin.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonLogin.addActionListener(e -> fazerLogin());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

        panel.add(Box.createVerticalGlue());
        panel.add(Box.createVerticalStrut(20));
        buttonPanel.add(buttonCadastrar);
        panel.add(Box.createVerticalStrut(20));
        panel.add(Box.createVerticalStrut(20));
        panel.add(label);
        panel.add(Box.createVerticalStrut(20));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(buttonCadastrarProduto);
        panel.add(Box.createVerticalStrut(20));
        panel.add(buttonLogin);
        panel.add(Box.createVerticalStrut(20));
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

        // Criação de campos e labels
        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeCampo = new JTextField(20);
        nomeCampo.setMaximumSize(new Dimension(200, 25));

        JLabel idadeLabel = new JLabel("Idade:");
        JTextField idadeCampo = new JTextField(20);
        idadeCampo.setMaximumSize(new Dimension(200, 25));

        JLabel cpfLabel = new JLabel("Cpf:");
        JTextField cpfCampo = new JTextField(20);
        cpfCampo.setMaximumSize(new Dimension(200, 25));

        JLabel cepLabel = new JLabel("Cep:");
        JTextField cepCampo = new JTextField(20);
        cepCampo.setMaximumSize(new Dimension(200, 25));

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailCampo = new JTextField(20);
        emailCampo.setMaximumSize(new Dimension(200, 25));

        JLabel senhaLabel = new JLabel("Senha:");
        JTextField senhaCampo = new JPasswordField(20);
        senhaCampo.setMaximumSize(new Dimension(200, 25));

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

    public void mostrarTelaDeCadastroProduto() {
        JFrame cadastrarProduto = new JFrame("Tela de cadastro de produto");
        cadastrarProduto.setSize(500, 500);
        cadastrarProduto.setLocationRelativeTo(null);
        cadastrarProduto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel cadastrarProdutoPainel = new JPanel();
        cadastrarProdutoPainel.setLayout(new BoxLayout(cadastrarProdutoPainel, BoxLayout.Y_AXIS));
        cadastrarProdutoPainel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Labels e campos de input
        JLabel precoProdutoLabel = new JLabel("Preço do produto:");
        JTextField precoProdutoCampo = new JTextField();
        precoProdutoCampo.setMaximumSize(new Dimension(200, 25));

        JLabel nomeProdutoLabel = new JLabel("Nome do produto");
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

            if (precoProdutoStr.isEmpty() || nomeProduto.isEmpty() || produtoENUM == null) {
                JOptionPane.showMessageDialog(cadastrarProduto, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double precoProduto = Double.parseDouble(precoProdutoStr);

                Produto produto = new Produto(precoProduto, nomeProduto, produtoENUM.getTipo());
                ProdutoController produtoController = new ProdutoController();
                produtoController.cadastrar(produto);

                JOptionPane.showMessageDialog(cadastrarProduto, "Cadastro realizado com sucesso!");
                cadastrarProduto.dispose();
            } catch (SQLException | FaltaDeInfoException ex) {
                JOptionPane.showMessageDialog(cadastrarProduto, "Erro ao cadastrar produto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        cadastrarProdutoPainel.add(precoProdutoLabel);
        cadastrarProdutoPainel.add(precoProdutoCampo);
        cadastrarProdutoPainel.add(Box.createVerticalStrut(10));
        cadastrarProdutoPainel.add(nomeProdutoLabel);
        cadastrarProdutoPainel.add(nomeProdutoCampo);
        cadastrarProdutoPainel.add(Box.createVerticalStrut(10));
        cadastrarProdutoPainel.add(tipoProdutoLabel);
        cadastrarProdutoPainel.add(tipoProdutoComboBox);
        cadastrarProdutoPainel.add(Box.createVerticalStrut(20));
        cadastrarProdutoPainel.add(botaoDeCadastrarProduto);

        cadastrarProduto.add(cadastrarProdutoPainel);
        cadastrarProduto.setVisible(true);
    }

    private void fazerLogin() {
        JFrame realizarLogin = new JFrame();
        realizarLogin.setSize(500, 300);
        realizarLogin.setLocationRelativeTo(null);
        realizarLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painelDeLogin = new JPanel();
        painelDeLogin.setLayout(new BoxLayout(painelDeLogin, BoxLayout.Y_AXIS));
        painelDeLogin.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel emailLabel = new JLabel("Email");
        JTextField emailCampo = new JTextField(20);

        JLabel senhaLabel = new JLabel("Senha");
        JPasswordField senhaCampo = new JPasswordField(20);

        JButton botaoDeFazerLogin = new JButton("Login");
        botaoDeFazerLogin.addActionListener(e -> {
            String email = emailCampo.getText();
            String senha = new String(senhaCampo.getPassword());

            if (email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(realizarLogin, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                ClienteController clienteController = new ClienteController();
                if (clienteController.login(email, senha)) {
                    JOptionPane.showMessageDialog(realizarLogin, "Login realizado com sucesso!");
                    realizarLogin.dispose();
                    fazerEncomenda();
                } else {
                    JOptionPane.showMessageDialog(realizarLogin, "Senha errada!");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });


        painelDeLogin.add(emailLabel);
        painelDeLogin.add(Box.createVerticalStrut(5));
        painelDeLogin.add(emailCampo);
        painelDeLogin.add(Box.createVerticalStrut(10));
        painelDeLogin.add(senhaLabel);
        painelDeLogin.add(Box.createVerticalStrut(5));
        painelDeLogin.add(senhaCampo);
        painelDeLogin.add(Box.createVerticalStrut(15));
        painelDeLogin.add(botaoDeFazerLogin);

        realizarLogin.add(painelDeLogin);
        realizarLogin.setVisible(true);
    }

    public void fazerEncomenda() throws SQLException {
        JFrame realizarEncomenda = new JFrame();
        realizarEncomenda.setSize(500, 500);
        realizarEncomenda.setLocationRelativeTo(null);
        realizarEncomenda.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painelDeFazerEncomenda = new JPanel();
        painelDeFazerEncomenda.setLayout(new BoxLayout(painelDeFazerEncomenda, BoxLayout.Y_AXIS));
        painelDeFazerEncomenda.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel cpfLabel = new JLabel("CPF");
        JTextField cpfCampo = new JTextField(20);

        JLabel dataLabel = new JLabel("Data");
        JTextField dataCampo = new JTextField(20);

        JLabel qtdLabel = new JLabel("Quantidade");
        JTextField qtdCampo = new JTextField(20);

        JLabel nomeProdutoLabel = new JLabel("Nome do produto");
        JTextField nomeProdutoCampo = new JTextField(20);

        JLabel precoLabel = new JLabel("Preço");
        JTextField precoCampo = new JTextField(20);

        JLabel tipoDeLocalDeEntregaLabel = new JLabel("Tipo de local");
        JComboBox<LocalDeEntregaEnum> tipoDeLocalDeEntrega = new JComboBox<>(LocalDeEntregaEnum.values());
        tipoDeLocalDeEntrega.setPreferredSize(new Dimension(200, 25)); // Ajuste do tamanho da ComboBox

        JLabel tipoDeProdutoLabel = new JLabel("Tipo de produto");
        JComboBox<ProdutoENUM> tipoProdutoComboBox = new JComboBox<>(ProdutoENUM.values());
        tipoProdutoComboBox.setPreferredSize(new Dimension(200, 25)); // Ajuste do tamanho da ComboBox

        JButton botaoDeFazerEncomenda = new JButton("Encomendar");
        botaoDeFazerEncomenda.addActionListener(e -> {
            String cpf = cpfCampo.getText();
            String data = dataCampo.getText();
            String qtd = qtdCampo.getText();
            String nomeProdutoF = nomeProdutoCampo.getText();
            String preco = precoCampo.getText();
            LocalDeEntregaEnum localDeEntregaEnum = (LocalDeEntregaEnum) tipoDeLocalDeEntrega.getSelectedItem();
            ProdutoENUM produtoENUM = (ProdutoENUM) tipoProdutoComboBox.getSelectedItem();

            if (cpf.isEmpty() || data.isEmpty() || qtd.isEmpty() || nomeProdutoF.isEmpty() || preco.isEmpty() || localDeEntregaEnum == null || produtoENUM == null) {
                JOptionPane.showMessageDialog(realizarEncomenda, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                java.util.Date utilDate = sdf.parse(data);
                Date sqlDate = new Date(utilDate.getTime());
                Integer quantidade = Integer.parseInt(qtd);
                Double precoD = Double.parseDouble(preco);

                LocalDeEntrega localDeEntrega = LocalDeEntrega.fromEnum(localDeEntregaEnum);
                LocalDeEntregaController localDeEntregaController = new LocalDeEntregaController();
                localDeEntregaController.cadastrar(localDeEntrega);

                ClienteController clienteController = new ClienteController();
                Cliente cliente = clienteController.retornoDoCliente(cpf);

                Encomenda encomenda = new Encomenda(sqlDate);
                EncomendaController encomendaController = new EncomendaController();

                encomendaController.cadastrarEncomenda(encomenda, cliente, localDeEntrega);

                Produto produto = new Produto(precoD, nomeProdutoF, ((ProdutoENUM) tipoProdutoComboBox.getSelectedItem()).getTipo());
                ProdutoController produtoController = new ProdutoController();
                produtoController.cadastrar(produto);


                encomendaController.encomendarUmProduto(encomenda, produto, Integer.parseInt(qtd), precoD);


                Double totalCompra = quantidade * precoD;


                JPanel painelSucesso = new JPanel();
                painelSucesso.setLayout(new BoxLayout(painelSucesso, BoxLayout.Y_AXIS));
                painelSucesso.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                JLabel sucessoLabel = new JLabel("Produto: " + nomeProdutoF + " foi encomendado por " + cliente.getNomeDoCliente());
                JLabel totalLabel = new JLabel("Total da compra: R$ " + String.format("%.2f", totalCompra));

                painelSucesso.add(sucessoLabel);
                painelSucesso.add(totalLabel);

                JFrame sucessoFrame = new JFrame("Sucesso");
                sucessoFrame.setSize(400, 200);
                sucessoFrame.setLocationRelativeTo(null);
                sucessoFrame.add(painelSucesso);
                sucessoFrame.setVisible(true);

            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (FaltaDeInfoException ex) {
                throw new RuntimeException(ex);
            }
        });

        painelDeFazerEncomenda.add(Box.createVerticalStrut(2));
        painelDeFazerEncomenda.add(cpfLabel);
        painelDeFazerEncomenda.add(cpfCampo);
        painelDeFazerEncomenda.add(Box.createVerticalStrut(2));
        painelDeFazerEncomenda.add(dataLabel);
        painelDeFazerEncomenda.add(dataCampo);
        painelDeFazerEncomenda.add(Box.createVerticalStrut(2));
        painelDeFazerEncomenda.add(qtdLabel);
        painelDeFazerEncomenda.add(qtdCampo);
        painelDeFazerEncomenda.add(Box.createVerticalStrut(2));
        painelDeFazerEncomenda.add(Box.createVerticalStrut(2));
        painelDeFazerEncomenda.add(nomeProdutoLabel);
        painelDeFazerEncomenda.add(nomeProdutoCampo);
        painelDeFazerEncomenda.add(Box.createVerticalStrut(2));
        painelDeFazerEncomenda.add(precoLabel);
        painelDeFazerEncomenda.add(precoCampo);
        painelDeFazerEncomenda.add(Box.createVerticalStrut(2));
        painelDeFazerEncomenda.add(tipoDeLocalDeEntregaLabel);
        painelDeFazerEncomenda.add(tipoDeLocalDeEntrega);
        painelDeFazerEncomenda.add(Box.createVerticalStrut(2));
        painelDeFazerEncomenda.add(tipoDeProdutoLabel);
        painelDeFazerEncomenda.add(tipoProdutoComboBox);
        painelDeFazerEncomenda.add(Box.createVerticalStrut(2));
        painelDeFazerEncomenda.add(botaoDeFazerEncomenda);
        painelDeFazerEncomenda.add(Box.createVerticalStrut(2));

        realizarEncomenda.add(painelDeFazerEncomenda);
        realizarEncomenda.setVisible(true);
    }

    public static void main(String[] args) {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.exibir();
    }
}