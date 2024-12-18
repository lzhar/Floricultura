package main.backend.dao;

import main.backend.model.LocalDeEntrega;
import main.backend.model.LocalDeEntregaEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalDeEntregaDAO {

    private Connection conexao;

    public LocalDeEntregaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrarLocalDeEntrega(LocalDeEntrega localDeEntrega) throws SQLException {
        String sql = "INSERT INTO LocaisDeEntrega (tipo_de_local) VALUES (?)";

        try (PreparedStatement statement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, localDeEntrega.getLocalDeEntrega().getTipoDeLocal());  // Corretamente pega o tipo de local

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                try (ResultSet chavesGeradas = statement.getGeneratedKeys()) {
                    if (chavesGeradas.next()) {
                        localDeEntrega.setId(chavesGeradas.getLong(1));  // Certificando-se de pegar o ID gerado
                    }
                }
            } else {
                throw new SQLException("Falha ao cadastrar local de entrega, nenhuma linha foi inserida.");
            }
        }
    }
}