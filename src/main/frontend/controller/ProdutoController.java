package main.frontend.controller;

import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.Produto;
import main.backend.model.ProdutoENUM;
import main.backend.service.ProdutoAS;

import java.sql.SQLException;

public class ProdutoController {
    public void teste() throws SQLException, FaltaDeInfoException {
        ProdutoAS produtoTeste = new ProdutoAS();
        Produto novoProduto = new Produto(20.50, "bis", ProdutoENUM.CHOCOLATE);
        produtoTeste.cadastrar(novoProduto);
    }


}
