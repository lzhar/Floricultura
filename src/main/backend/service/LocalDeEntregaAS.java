package main.backend.service;

import main.backend.dao.ConexaoNoBanco;
import main.backend.dao.LocalDeEntregaDAO;
import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.LocalDeEntrega;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class LocalDeEntregaAS {
    public void cadastrar(LocalDeEntrega localDeEntrega) throws SQLException, FaltaDeInfoException {
        Connection conexaoNoBanco = ConexaoNoBanco.fazerConexao();

        if(Objects.nonNull(localDeEntrega.getLocalDeEntrega())){
            LocalDeEntregaDAO localDeEntregaDAO = new LocalDeEntregaDAO(conexaoNoBanco);
            localDeEntregaDAO.cadastrarLocalDeEntrega(localDeEntrega);
        }else{
            throw new FaltaDeInfoException("As informações necessárias não foram inseridas!");
        }

    }
}
