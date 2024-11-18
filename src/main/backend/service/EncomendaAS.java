package main.backend.service;

import main.backend.dao.ConexaoNoBanco;
import main.backend.dao.EncomendaDAO;
import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.Cliente;
import main.backend.model.Encomenda;
import main.backend.model.LocalDeEntrega;
import main.backend.model.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class EncomendaAS {
    public void cadastrar(Encomenda encomenda, Cliente cliente, Produto produto, int quantidade, LocalDeEntrega localDeEntrega) throws SQLException, FaltaDeInfoException {
        Connection conexaoNoBanco = ConexaoNoBanco.fazerConexao();

        if(Objects.nonNull(encomenda.getDataDaEncomenda()) && Objects.nonNull(cliente) && quantidade > 0 && Objects.nonNull(localDeEntrega.getLocalDeEntrega())){
            EncomendaDAO encomendaDAO = new EncomendaDAO(conexaoNoBanco);
            encomendaDAO.registrarEncomenda(encomenda, cliente, produto, quantidade, localDeEntrega);
        }else{
            throw new FaltaDeInfoException("As informações necessárias não foram inseridas!");
        }

    }
}
