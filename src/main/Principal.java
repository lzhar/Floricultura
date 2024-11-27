package main;

import main.backend.dao.ConexaoNoBanco;
import main.backend.dao.EncomendaDAO;
import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.*;
import main.backend.service.ClienteAS;
import main.backend.service.EncomendaAS;
import main.backend.service.LocalDeEntregaAS;
import main.backend.service.ProdutoAS;
import main.frontend.controller.ClienteController;
import main.frontend.controller.LocalDeEntregaController;
import main.frontend.controller.ProdutoController;
import main.frontend.view.TelaPrincipal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) throws SQLException, FaltaDeInfoException, ParseException {
//        Connection connection;
//        connection = ConexaoNoBanco.fazerConexao();
//
//        Cliente cliente = new Cliente("faadad", 29, "100-780-003.10", "1143-32", "avlee.exemplo@gmail.com", "23232daa");
//        ClienteController clienteController = new ClienteController();
//        clienteController.cadastrar(cliente);
//
//        LocalDeEntrega localDeEntrega = new LocalDeEntrega(LocalDeEntregaEnum.APARTAMENTO);
//        LocalDeEntregaController localDeEntregaController = new LocalDeEntregaController();
//        localDeEntregaController.cadastrar(localDeEntrega);  // Certifique-se que o ID foi gerado corretamente após essa linha
//
//
//        System.out.println("ID do Local de Entrega: " + localDeEntrega.getId());
//
//        Produto produto = new Produto(23.99, "chocolate azedo", ProdutoENUM.CHOCOLATE.getTipo());
//        ProdutoController produtoController = new ProdutoController();
//        produtoController.cadastrar(produto);
//
//        Produto produto2 = new Produto(33.99, "chocolate doce", ProdutoENUM.CHOCOLATE.getTipo());
//        produtoController.cadastrar(produto2);
//
//        ItemEncomendado item1 = new ItemEncomendado();
//        item1.setProduto(produto);
//        item1.setQtd(10);
//        item1.setPrecoUnitario(new BigDecimal(produto.getPrecoProduto()));
//
//        List<ItemEncomendado> itens = new ArrayList<>();
//        itens.add(item1);
//
//        Encomenda encomenda = new Encomenda(Date.valueOf(LocalDate.now()));
//
//        EncomendaDAO encomendaDAO = new EncomendaDAO(connection);
//
//
//        encomendaDAO.registrarEncomenda(encomenda, cliente, localDeEntrega);

        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.exibir();
    }
}