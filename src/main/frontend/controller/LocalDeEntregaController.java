package main.frontend.controller;

import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.model.LocalDeEntrega;
import main.backend.model.LocalDeEntregaEnum;
import main.backend.service.EncomendaAS;
import main.backend.service.LocalDeEntregaAS;

import java.sql.SQLException;

public class LocalDeEntregaController   {
    public void cadastrar(LocalDeEntrega localDeEntrega) throws SQLException, FaltaDeInfoException {
        LocalDeEntregaAS localDeEntregaAS = new LocalDeEntregaAS();
        localDeEntregaAS.cadastrar(localDeEntrega);
    }
}
