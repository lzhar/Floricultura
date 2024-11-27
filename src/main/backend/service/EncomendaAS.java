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
    public void registrarEncomenda(Encomenda encomenda, Cliente cliente, LocalDeEntrega localDeEntrega) throws SQLException, FaltaDeInfoException {
        Connection conexaoNoBanco = ConexaoNoBanco.fazerConexao();

        EncomendaDAO encomendaDAO = new EncomendaDAO(conexaoNoBanco);
        encomendaDAO.registrarEncomenda(encomenda, cliente, localDeEntrega);

    }
}
