package com.system.operational.sgo.model;

public class Estacao {

    public int id_estacao;
    public String endid;
    public String nome;
    public String regional;
    public String uf;
    public String cidade;

    public Estacao(int id_estacao, String endid, String nome, String regional, String uf, String cidade) {
        this.id_estacao = id_estacao;
        this.endid = endid;
        this.nome = nome;
        this.regional = regional;
        this.uf = uf;
        this.cidade = cidade;
    }

    public int getId_estacao() {
        return id_estacao;
    }

    public void setId_estacao(int id_estacao) {
        this.id_estacao = id_estacao;
    }

    public String getEndid() {
        return endid;
    }

    public void setEndid(String endid) {
        this.endid = endid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
