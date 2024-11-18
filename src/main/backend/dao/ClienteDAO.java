package main.backend.dao;

import main.backend.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conexaoNoBanco;

    public ClienteDAO(Connection conexaoNoBanco) {
        this.conexaoNoBanco = conexaoNoBanco;
    }

    public void cadastrarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome_cliente, idade_cliente, cpf_cliente, cep_cliente, email_cliente, senha_cliente) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conexaoNoBanco.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, cliente.getNomeDoCliente());
            statement.setInt(2, cliente.getIdadeCliente());
            statement.setString(3, cliente.getCpfDoCliente());
            statement.setString(4, cliente.getCepCliente());
            statement.setString(5, cliente.getEmailDoCliente());
            statement.setString(6, cliente.getSenhaDoCliente());

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                try (ResultSet chavesGeradas = statement.getGeneratedKeys()) {
                    if (chavesGeradas.next()) {
                        cliente.setId(chavesGeradas.getLong(5));
                    }
                }
            }
        }
    }

    public List<Cliente> listarClientes() {
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT * FROM Clientes";

        try {
            st = conexaoNoBanco.prepareStatement(sql);
            rs = st.executeQuery();

            List<Cliente> resultado = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getString("nome_cliente"),
                        rs.getInt("idade_cliente"), rs.getString("cpf_cliente"),
                        rs.getString("cep_cliente"), rs.getString("email_cliente"),
                        rs.getString("senha_cliente"));

                resultado.add(cliente);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

}