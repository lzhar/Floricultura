package main.backend.model;

import java.util.Date;

public class Encomenda {
    private Date dataDaEncomenda;
    private Long id;

    public Encomenda(Date dataDaEncomenda){
        this.dataDaEncomenda=dataDaEncomenda;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setDataDaEncomenda(Date dataDaEncomenda){
        this.dataDaEncomenda = dataDaEncomenda;
    }
    public java.sql.Date getDataDaEncomenda(){
        return (java.sql.Date) dataDaEncomenda;
    }
}
