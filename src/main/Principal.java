package main;

import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.service.ClienteAS;
import main.frontend.controller.ClienteController;
import main.frontend.controller.ProdutoController;

import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws SQLException, FaltaDeInfoException {
        System.out.println("Olá mundo!");
        ProdutoController testeDeController = new ProdutoController();

        ClienteController clienteTeste = new ClienteController();
        clienteTeste.teste();
    }
}
