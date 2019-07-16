package com.system.operational.sgo.model;

public class InformationStation {

    public int id_estacao;
    public String endid;
    public String nome;
    public String regional;
    public String uf;
    public String cidade;

    public InformationStation(int id_estacao, String endid, String nome, String regional, String uf, String cidade) {
        this.id_estacao = id_estacao;
        this.endid = endid;
        this.nome = nome;
        this.regional = regional;
        this.uf = uf;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }
}
