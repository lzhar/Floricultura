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
    public void cadastrarEncomenda(Encomenda encomenda, Cliente cliente, LocalDeEntrega localDeEntrega) throws SQLException, FaltaDeInfoException {
        EncomendaAS encomendaAS = new EncomendaAS();
        encomendaAS.registrarEncomenda(encomenda, cliente, localDeEntrega);
    }
}
