package com.system.operational.sgo.model;

public class StationSituation {

    private int idEstacao;
    private String tipoDeAcesso;
    private String bateria;
    private int qtdBanco;
    private String fabriicanteFonte;
    private int qtdUr;
    private String folhaFonte;
    private String medidor;
    private String concentrador;

    public int getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(int idEstacao) {
        this.idEstacao = idEstacao;
    }

    public String getTipoDeAcesso() {
        return tipoDeAcesso;
    }

    public void setTipoDeAcesso(String tipoDeAcesso) {
        this.tipoDeAcesso = tipoDeAcesso;
    }

    public String getBateria() {
        return bateria;
    }

    public void setBateria(String bateria) {
        this.bateria = bateria;
    }

    public int getQtdBanco() {
        return qtdBanco;
    }

    public void setQtdBanco(int qtdBanco) {
        this.qtdBanco = qtdBanco;
    }

    public String getFabriicanteFonte() {
        return fabriicanteFonte;
    }

    public void setFabriicanteFonte(String fabriicanteFonte) {
        this.fabriicanteFonte = fabriicanteFonte;
    }

    public int getQtdUr() {
        return qtdUr;
    }

    public void setQtdUr(int qtdUr) {
        this.qtdUr = qtdUr;
    }

    public String getFolhaFonte() {
        return folhaFonte;
    }

    public void setFolhaFonte(String folhaFonte) {
        this.folhaFonte = folhaFonte;
    }

    public String getMedidor() {
        return medidor;
    }

    public void setMedidor(String medidor) {
        this.medidor = medidor;
    }

    public String getConcentrador() {
        return concentrador;
    }

    public void setConcentrador(String concentrador) {
        this.concentrador = concentrador;
    }
}
