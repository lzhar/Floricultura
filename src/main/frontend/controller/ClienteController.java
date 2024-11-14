package main.frontend.controller;

import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.Cliente;
import main.backend.service.ClienteAS;

import java.sql.SQLException;

public class ClienteController {
    public void teste() throws SQLException, FaltaDeInfoException {
        ClienteAS cliente = new ClienteAS();
        Cliente cliente1 = new Cliente("Lucas Homero", 20, "232.233.122-39", "132346", "lucas.homero@a.ucb.br");
        cliente.cadastrar(cliente1);
    }
}
