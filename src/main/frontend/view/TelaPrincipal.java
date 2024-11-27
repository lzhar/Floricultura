package main.frontend.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton buttonCadastrar;
    private JButton buttonEncomendar;
    private JLabel imageLabel;

    public TelaPrincipal() {
        // Criando o frame principal
        frame = new JFrame("Floricultura Lírios do Vale");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // Configurando o painel principal
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Layout vertical

        // Adicionando a imagem
        ImageIcon imageIcon = new ImageIcon("src\\swing\\smith\\floricultura lirios do vale\\floricultura.jpg"); // Altere o caminho da imagem
        imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza a imagem

        // Criando o rótulo de boas-vindas
        label = new JLabel("Bem-vindo a Floricultura Lírios do Vale", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Criando os botões
        buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTelaDeCadastro();
            }
        });

        buttonEncomendar = new JButton("Encomendar");
        buttonEncomendar.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonEncomendar.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o botão
        buttonEncomendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTelaDeEncomenda();
            }
        });

        // Criando um painel horizontal para os botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0)); // Espaçamento horizontal entre os botões
        buttonPanel.add(buttonCadastrar);

        // Adicionando os componentes no painel principal
        panel.add(Box.createVerticalGlue());
        panel.add(imageLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(label);
        panel.add(Box.createVerticalStrut(20));
        panel.add(buttonPanel); // Adicionando o painel dos botões
        panel.add(Box.createVerticalStrut(20));
        panel.add(buttonEncomendar); // Adicionando o botão "Encomendar"
        panel.add(Box.createVerticalGlue());

        // Adiciona o painel no frame
        frame.add(panel);
    }

    public void exibir() {
        frame.setVisible(true);
    }

    private void mostrarTelaDeCadastro() {
        // Criando a tela de cadastro com dimensões dobradas
        JFrame cadastroFrame = new JFrame("Tela de Cadastro");
        cadastroFrame.setSize(400, 400); // Tela de cadastro agora tem o dobro de altura
        cadastroFrame.setLocationRelativeTo(null);
        cadastroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Painel principal com BoxLayout
        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(new BoxLayout(cadastroPanel, BoxLayout.Y_AXIS));
        cadastroPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espaçamento nas bordas

        // Campos de entrada
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField nomeField = new JTextField(20);
        nomeField.setMaximumSize(new Dimension(Integer.MAX_VALUE, nomeField.getPreferredSize().height));

        JLabel idadeLabel = new JLabel("Idade:");
        idadeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField idadeField = new JTextField(20);
        idadeField.setMaximumSize(new Dimension(Integer.MAX_VALUE, idadeField.getPreferredSize().height));

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField cpfField = new JTextField(20);
        cpfField.setMaximumSize(new Dimension(Integer.MAX_VALUE, cpfField.getPreferredSize().height));

        JLabel cepLabel = new JLabel("CEP:");
        cepLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField cepField = new JTextField(20);
        cepField.setMaximumSize(new Dimension(Integer.MAX_VALUE, cepField.getPreferredSize().height));

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField emailField = new JTextField(20);
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, emailField.getPreferredSize().height));

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPasswordField senhaField = new JPasswordField(20);
        senhaField.setMaximumSize(new Dimension(Integer.MAX_VALUE, senhaField.getPreferredSize().height));

        // Botão de cadastrar
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cadastrarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String idade = idadeField.getText();
            String cpf = cpfField.getText();
            String cep = cepField.getText();
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());

            // Validação simples
            if (nome.isEmpty() || idade.isEmpty() || cpf.isEmpty() || cep.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(cadastroFrame, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(cadastroFrame, "Cadastro realizado com sucesso!");
                cadastroFrame.dispose(); // Fecha a tela de cadastro
            }
        });

        // Adicionando os componentes ao painel
        cadastroPanel.add(nomeLabel);
        cadastroPanel.add(nomeField);
        cadastroPanel.add(Box.createVerticalStrut(10)); // Espaçamento
        cadastroPanel.add(idadeLabel);
        cadastroPanel.add(idadeField);
        cadastroPanel.add(Box.createVerticalStrut(10));
        cadastroPanel.add(cpfLabel);
        cadastroPanel.add(cpfField);
        cadastroPanel.add(Box.createVerticalStrut(10));
        cadastroPanel.add(cepLabel);
        cadastroPanel.add(cepField);
        cadastroPanel.add(Box.createVerticalStrut(10));
        cadastroPanel.add(emailLabel);
        cadastroPanel.add(emailField);
        cadastroPanel.add(Box.createVerticalStrut(10));
        cadastroPanel.add(senhaLabel);
        cadastroPanel.add(senhaField);
        cadastroPanel.add(Box.createVerticalStrut(20));
        cadastroPanel.add(cadastrarButton);

        // Adicionando o painel no frame de cadastro
        cadastroFrame.add(cadastroPanel);
        cadastroFrame.setVisible(true);
    }

    private void mostrarTelaDeEncomenda() {
        // Configurando a nova janela para a encomenda
        JFrame encomendaFrame = new JFrame("Encomenda");
        encomendaFrame.setSize(1200, 900); // Reduzindo 100px na altura e largura
        encomendaFrame.setLocationRelativeTo(frame);

        // Painel principal
        JPanel encomendaPanel = new JPanel();
        encomendaPanel.setLayout(new GridLayout(2, 2, 20, 20)); // Grid de 2x2 com espaçamento

        // Adicionando o painel de encomenda à janela
        encomendaFrame.add(encomendaPanel);
        encomendaFrame.setVisible(true);
    }


}
