package main.backend.service;

import main.backend.model.Cliente;
import main.backend.dao.ClienteDAO;
import main.backend.exceptions.FaltaDeInfo.FaltaDeInfoException;
import main.backend.dao.ConexaoNoBanco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static java.util.Objects.*;


public class ClienteAS {


    public void cadastrar(Cliente cliente) throws SQLException, FaltaDeInfoException {

        Connection conexao = ConexaoNoBanco.fazerConexao();

        if (nonNull(cliente.getNomeDoCliente()) && nonNull(cliente.getIdadeCliente()) && nonNull(cliente.getCpfDoCliente()) &&
                nonNull(cliente.getCepCliente()) && nonNull(cliente.getEmailDoCliente()) && nonNull(cliente.getSenhaDoCliente())) {
            ClienteDAO clienteDAO = new ClienteDAO(conexao);
            clienteDAO.cadastrarCliente(cliente);
        } else {
            throw new FaltaDeInfoException("As informações necessárias não foram inseridas!");
        }
    }

    public void listarClientes() throws SQLException{
        Connection conexao = ConexaoNoBanco.fazerConexao();

        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        List<Cliente> clientes = clienteDAO.listarClientes();

        if(clientes.isEmpty()){
            System.out.println("nenhum cliente foi encontrado");
        }else{
            for (Cliente cliente : clientes){
                System.out.println(cliente.toString());
            }
        }
    }
}
