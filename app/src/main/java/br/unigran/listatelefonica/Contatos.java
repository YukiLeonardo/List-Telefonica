package br.unigran.listatelefonica;

public class Contatos {
    private Integer id;
    private String nome;
    private String telefone;
    private String datanasc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    @Override
    public String toString() {
        return  nome + " / " +telefone + " / " + datanasc;
    }
}


