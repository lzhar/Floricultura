package main.backend.dao;

import main.backend.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EncomendaDAO {

    private Connection conexao;


    public EncomendaDAO(Connection conexao) {
        this.conexao = conexao;
    }


    public void registrarEncomenda(Encomenda encomenda, Cliente cliente, LocalDeEntrega localDeEntrega) throws SQLException {
        String sqlEncomenda = "INSERT INTO encomendas (data_da_encomenda, ID_local_de_entrega, ID_cliente) VALUES (?, ?, ?)";
        String sqlItensEncomendados = "INSERT INTO itens_encomendados (id_encomenda, id_produto, qtd, preco_unitario) VALUES (?, ?, ?, ?)";

        try {
            // Iniciar transação
            conexao.setAutoCommit(false);

            // Inserir a encomenda
            try (PreparedStatement statementEncomenda = conexao.prepareStatement(sqlEncomenda, Statement.RETURN_GENERATED_KEYS)) {
                statementEncomenda.setDate(1, encomenda.getDataDaEncomenda());
                statementEncomenda.setLong(2, localDeEntrega.getId());
                statementEncomenda.setLong(3, cliente.getId());

                int linhasAfetadas = statementEncomenda.executeUpdate();
                if (linhasAfetadas > 0) {
                    try (ResultSet chavesGeradas = statementEncomenda.getGeneratedKeys()) {
                        if (chavesGeradas.next()) {
                            long idEncomenda = chavesGeradas.getLong(1);
                            encomenda.setId(idEncomenda);
                        }
                    }
                } else {
                    throw new SQLException("Falha ao registrar a encomenda, nenhuma linha foi afetada.");
                }
            }

            // Inserir os itens encomendados
            try (PreparedStatement statementItens = conexao.prepareStatement(sqlItensEncomendados)) {
                for (ItemEncomendado item : encomenda.getItens()) {
                    statementItens.setLong(1, encomenda.getId());
                    statementItens.setLong(2, item.getProduto().getIdProduto());
                    statementItens.setInt(3, item.getQtd());
                    statementItens.setBigDecimal(4, item.getPrecoUnitario());
                    statementItens.addBatch();
                }
                statementItens.executeBatch();
            }

            // Confirmar a transação
            conexao.commit();
        } catch (SQLException e) {
            // Reverter a transação em caso de erro
            conexao.rollback();
            throw e;
        } finally {
            conexao.setAutoCommit(true);
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
