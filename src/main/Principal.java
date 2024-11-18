package main;

import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.Cliente;
import main.backend.service.ClienteAS;
import main.backend.service.ProdutoAS;
import main.frontend.controller.ClienteController;
import main.frontend.controller.ProdutoController;

import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws SQLException, FaltaDeInfoException {
        Cliente cliente = new Cliente("Ciclano", 55, "038.223.533-23"
        ,"3232-33", "teste@mail.com", "2323");


        ClienteController clienteController = new ClienteController();
//        clienteController.cadastrar(cliente);
        clienteController.listar();
    }
}
