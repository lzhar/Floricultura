package main.backend.model;

public enum ProdutoENUM {
    FLORES("flores"),
    CHOCOLATE("chocolate"),
    CARTOES("cartao_de_presente"),
    BUQUE("buque"),
    CESTA("cesta_de_cafe_da_manha");

    private final String tipo;

    ProdutoENUM(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }


    public static ProdutoENUM fromString(String tipo){
        for (ProdutoENUM e : ProdutoENUM.values()){
            if(e.tipo.equalsIgnoreCase(tipo)){
                return e;
            }
        }
        throw new IllegalArgumentException("O tipo de produto que você tentou cadastrar não existe!" + tipo);
    }


}
