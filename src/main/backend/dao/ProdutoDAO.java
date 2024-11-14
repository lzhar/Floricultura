package main.backend.dao;

import main.backend.model.Produto;

import java.sql.*;

public class ProdutoDAO {

    private Connection conexao;

    public ProdutoDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void cadastrarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO produtos (preco_produto, nome_produto, tipo_produto) VALUES (?, ?, ?)";

        try(PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setDouble(1 , produto.getPrecoProduto());
            statement.setString(2, produto.getNomeProduto());
            statement.setString(3, produto.getTipoProduto());

            int linhasAfetadas = statement.executeUpdate();
            if(linhasAfetadas > 0){
                try(ResultSet chavesGeradas = statement.getGeneratedKeys()){
                    if(chavesGeradas.next()){
                        produto.setIdProduto(chavesGeradas.getLong(4));
                    }
                }
            }
        }

    }
}
