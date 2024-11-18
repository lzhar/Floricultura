package main.backend.dao;

import main.backend.model.Encomenda;
import main.backend.model.LocalDeEntrega;
import main.backend.model.Cliente;
import main.backend.model.Produto;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EncomendaDAO {

    private Connection conexao;




    public EncomendaDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void registrarEncomenda(Encomenda encomenda, Cliente cliente, Produto produto, int quantidade, LocalDeEntrega localDeEntrega) throws SQLException {
        String sql = "INSERT INTO encomendas (data_encomenda, ID_local_de_entrega, ID_cliente) VALUES (?, ?, ?)";

        try(PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setDate(1, encomenda.getDataDaEncomenda());
            statement.setLong(2, localDeEntrega.getId());
            statement.setLong(3, cliente.getId());

            int linhasAfetadas = statement.executeUpdate();
            if(linhasAfetadas > 0){
                try(ResultSet chavesGeradas = statement.getGeneratedKeys()){
                    if(chavesGeradas.next()){
                        encomenda.setId(chavesGeradas.getLong(2));
                    }
                }
            }
        }

    }

//    public void registrarItensEncomendados(Encomenda encomenda, Produto produto, Long qtd, double preco_unitario) throws SQLException{
//        String sql = "INSERT INTO ItensEncomendados (ID_encomenda, ID_produto, qtd, preco_unitario) VALUES (?, ?, ?, ?)";
//
//        try(PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
//            statement.setLong(1, encomenda.getId());
//            statement.setLong(2, produto.getIdProduto());
//            statement.setLong(3, qtd);
//            statement.setDouble(4, preco_unitario);
//
//            int linhasAfetadas = statement.executeUpdate();
//            if(linhasAfetadas > 0){
//                try(ResultSet chavesGeradas = statement.getGeneratedKeys()){
//                    if(chavesGeradas.next()){
//
//                    }
//                }
//            }
//        }
//    }
}
