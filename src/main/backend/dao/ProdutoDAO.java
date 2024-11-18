package main.backend.dao;

import main.backend.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Produto> listarProdutos() {
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT * FROM Produtos";

        try{
            st = conexao.prepareStatement(sql);
            rs = st.executeQuery();

            List<Produto> resultado = new ArrayList<>();

            while (rs.next()){
                Produto produto = new Produto(rs.getDouble("preco_produto"),
                        rs.getString("nome_produto"), rs.getString("tipo_produto"));

                produto.setIdProduto(rs.getLong("id_produto"));

                resultado.add(produto);
            }
            return resultado;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return List.of();
    }

}
