package main.backend.model;

public enum LocalDeEntregaEnum {
    CASA("casa"),
    APARTAMENTO("apartamento");

    private final String tipoDeLocal;

    LocalDeEntregaEnum(String tipoDeLocal){
        this.tipoDeLocal = tipoDeLocal;
    }

    public String getTipoDeLocal(){
        return tipoDeLocal;
    }

    public static LocalDeEntregaEnum fromString(String tipoDeLocal){
        for(LocalDeEntregaEnum e : LocalDeEntregaEnum.values()){
            if (e.getTipoDeLocal().equalsIgnoreCase(tipoDeLocal)){
                return e;
            }
        }
            throw new IllegalArgumentException("O tipo de local que você tentou inserir não existe!");
    }
}
