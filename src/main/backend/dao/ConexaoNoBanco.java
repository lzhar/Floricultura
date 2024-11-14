package main.backend.dao;

import java.sql.*;

public class ConexaoNoBanco {
    public static Connection fazerConexao() throws SQLException{

        Connection conexao = null;

        try{
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/floricultura_db",
                    "postgres", "root");
            System.out.println("Você está conectado!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return conexao;
    }


}
