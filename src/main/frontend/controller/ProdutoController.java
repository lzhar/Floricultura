package main.frontend.controller;

import main.backend.dao.EncomendaDAO;
import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.Produto;
import main.backend.model.ProdutoENUM;
import main.backend.service.ProdutoAS;

import java.sql.SQLException;

public class ProdutoController {
    public void cadastrar() throws SQLException, FaltaDeInfoException {
        ProdutoAS produtoTeste = new ProdutoAS();
        Produto novoProduto = new Produto(20.50, "bis", ProdutoENUM.CHOCOLATE.getTipo());
        produtoTeste.cadastrar(novoProduto);
    }

    public void listar() throws SQLException{
        ProdutoAS produtoAS = new ProdutoAS();
        produtoAS.listar();
    }


}
