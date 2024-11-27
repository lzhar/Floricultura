package main.backend.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Encomenda {
    private Date dataDaEncomenda;
    private Long id;
    private List<ItemEncomendado> itens; // Lista de itens encomendados

    public Encomenda(Date dataDaEncomenda) {
        this.dataDaEncomenda = dataDaEncomenda;
        this.itens = new ArrayList<>(); // Inicializando a lista de itens
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDaEncomenda() {
        return new Date(dataDaEncomenda.getTime());
    }

    public void setDataDaEncomenda(Date dataDaEncomenda) {
        this.dataDaEncomenda = dataDaEncomenda;
    }

    public List<ItemEncomendado> getItens() {
        return itens;
    }

    public void setItens(List<ItemEncomendado> itens) {
        this.itens = itens;
    }

    public void adicionarItem(ItemEncomendado item) {
        this.itens.add(item); // Método utilitário para adicionar itens
    }
}