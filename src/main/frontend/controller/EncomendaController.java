package main.frontend.controller;

import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.Cliente;
import main.backend.model.Encomenda;
import main.backend.model.LocalDeEntrega;
import main.backend.model.Produto;
import main.backend.service.EncomendaAS;

import java.sql.Date;
import java.sql.SQLException;

public class EncomendaController {
    public void cadastrar(Encomenda novaEncomenda,Cliente cliente, Produto produto, int qtd, LocalDeEntrega localDeEntrega) throws SQLException, FaltaDeInfoException {
        EncomendaAS encomenda = new EncomendaAS();
        encomenda.cadastrar(novaEncomenda, cliente, produto, qtd, localDeEntrega);
    }
}
