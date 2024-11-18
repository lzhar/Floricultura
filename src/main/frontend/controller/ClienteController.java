package main.frontend.controller;

import main.backend.dao.ClienteDAO;
import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.Cliente;
import main.backend.service.ClienteAS;

import java.sql.SQLException;

public class ClienteController {
    public void cadastrar(Cliente clienteNovo) throws SQLException, FaltaDeInfoException {
        ClienteAS cliente = new ClienteAS();
        cliente.cadastrar(clienteNovo);
    }
    public void listar() throws SQLException{
        ClienteAS clienteAS = new ClienteAS();
        clienteAS.listarClientes();
    }

}
