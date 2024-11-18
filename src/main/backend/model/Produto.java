package main.backend.model;

public class Produto {
    private Long idProduto;
    private double precoProduto;
    private String nomeProduto;
    private ProdutoENUM tipoProduto;

    public Produto(double precoProduto, String nomeProduto, String tipoProduto){
        this.precoProduto = precoProduto;
        this.nomeProduto = nomeProduto;
        this.tipoProduto = ProdutoENUM.fromString(tipoProduto);
    }

    public void setIdProduto(Long id){
        this.idProduto = id;
    }
    public Long getIdProduto(){
        return idProduto;
    }

    public void setPrecoProduto(double precoProduto){
        this.precoProduto = precoProduto;
    }
    public double getPrecoProduto(){
        return precoProduto;
    }

    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }
    public String getNomeProduto(){
        return nomeProduto;
    }

    public String getTipoProduto(){
        return tipoProduto != null ? tipoProduto.getTipo() : null;
    }

    public void setTipoProduto(String tipoProduto){
        this.tipoProduto = ProdutoENUM.fromString(tipoProduto);
    }

    @Override
    public String toString(){
        return "Produto{" +
                "id produto='" + idProduto + '\''+
                "preco produto='" + precoProduto  + '\'' +
                ", nome produto=" + nomeProduto +
                ", tipo produto='" + tipoProduto.getTipo() + '\'' +
                '}';
    }

}
