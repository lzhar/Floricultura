package main.backend.dao;

import main.backend.model.Cliente;

import java.sql.*;

public class ClienteDAO {
    private Connection conexaoNoBanco;

    public ClienteDAO(Connection conexaoNoBanco){
        this.conexaoNoBanco = conexaoNoBanco;
    }

    public void cadastrarCliente(Cliente cliente) throws SQLException{
        String sql = "INSERT INTO clientes (nome_cliente, idade_cliente, cpf_cliente, cep_cliente, email_cliente) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement statement = conexaoNoBanco.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, cliente.getNomeDoCliente());
            statement.setInt(2, cliente.getIdadeCliente());
            statement.setString(3, cliente.getCpfDoCliente());
            statement.setString(4, cliente.getCepCliente());
            statement.setString(5, cliente.getEmailDoCliente());

            int linhasAfetadas = statement.executeUpdate();
            if(linhasAfetadas > 0){
                try (ResultSet chavesGeradas = statement.getGeneratedKeys()) {
                    if (chavesGeradas.next()){
                        cliente.setId(chavesGeradas.getLong(5));
                    }
                }
            }
        }
    }
}
