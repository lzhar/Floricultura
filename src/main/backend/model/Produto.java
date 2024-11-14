package main.backend.model;

public class Produto {
    private Long idProduto;
    private double precoProduto;
    private String nomeProduto;
    private ProdutoENUM tipoProduto;

    public Produto(double precoProduto, String nomeProduto, ProdutoENUM tipoProduto){
        this.precoProduto = precoProduto;
        this.nomeProduto = nomeProduto;
        this.tipoProduto = tipoProduto;
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

}
