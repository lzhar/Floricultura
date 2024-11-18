package main.backend.service;

import main.backend.dao.ConexaoNoBanco;
import main.backend.dao.EncomendaDAO;
import main.backend.dao.LocalDeEntregaDAO;
import main.backend.dao.ProdutoDAO;
import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ProdutoAS {



    public void cadastrar(Produto produto) throws SQLException, FaltaDeInfoException {

        Connection conexao = ConexaoNoBanco.fazerConexao();

        if (Objects.nonNull(produto.getNomeProduto()) &&
                Objects.nonNull(produto.getPrecoProduto()) && Objects.nonNull(produto.getTipoProduto())) {
            ProdutoDAO produtoDAO = new ProdutoDAO(conexao);
            produtoDAO.cadastrarProduto(produto);
        }else{
            throw new FaltaDeInfoException("As informações necessárias não foram inseridas!");
        }

    }

}
