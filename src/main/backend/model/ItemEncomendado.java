package main.backend.model;

import java.math.BigDecimal;

public class ItemEncomendado {
    private Produto produto;
    private int qtd;
    private BigDecimal precoUnitario;

    public void setProduto(Produto produto){
        this.produto = produto;
    }
    public Produto getProduto(){
        return produto;
    }

    public void setQtd(int qtd){
        this.qtd = qtd;
    }
    public int getQtd(){
        return qtd;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario){
        this.precoUnitario = precoUnitario;
    }
    public BigDecimal getPrecoUnitario(){
        return precoUnitario;
    }



}
