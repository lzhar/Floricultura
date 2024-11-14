package main.backend.model;

public class Cliente {
    private String nomeDoCliente;
    private Integer idadeCliente;
    private String cpfDoCliente;
    private String cepCliente;
    private Long id;
    private String emailDoCliente;

    public Cliente(String nomeDoCliente, Integer idadeCliente, String cpfDoCliente, String cepCliente, String emailDoCliente){
        this.nomeDoCliente = nomeDoCliente;
        this.idadeCliente = idadeCliente;
        this.cpfDoCliente = cpfDoCliente;
        this.cepCliente = cepCliente;
        this.emailDoCliente = emailDoCliente;
    }


    public void setNomeDoCliente(String nomeDoCliente){
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getNomeDoCliente(){
        return nomeDoCliente;
    }

    public void setIdadeCliente(int idadeCliente){
        this.idadeCliente = idadeCliente;
    }

    public Integer getIdadeCliente(){
        return idadeCliente;
    }

    public void setCpfDoCliente(String cpfDoCliente){
        this.cpfDoCliente = cpfDoCliente;
    }

    public String getCpfDoCliente(){
        return cpfDoCliente;
    }

    public void setCepCliente(String cepCliente){
        this.cepCliente = cepCliente;
    }

    public String getCepCliente(){
        return cepCliente;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public void setEmailDoCliente(String emailDoCliente){
        this.emailDoCliente = emailDoCliente;
    }

    public String getEmailDoCliente(){
        return emailDoCliente;
    }

}
