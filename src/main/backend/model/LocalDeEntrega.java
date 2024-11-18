package main.backend.model;

import main.backend.dao.LocalDeEntregaDAO;

public class LocalDeEntrega {
    private LocalDeEntregaEnum localDeEntrega;
    private Long id;

    public LocalDeEntrega(LocalDeEntregaEnum localDeEntrega){
        this.localDeEntrega = localDeEntrega;
    }
    public void setLocalDeEntrega(LocalDeEntregaEnum localDeEntrega){
        this.localDeEntrega = localDeEntrega;
    }
    public LocalDeEntregaEnum getLocalDeEntrega(){
        return localDeEntrega;
    }
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
}
