package com.system.operational.sgo.model;

public class UpdateStation {

    private int idEstacao;
    private int idUsuario;
    private String tipoDeAcesso;
    private String bateria;
    private String qtdBanco;
    private String fabriicanteFonte;
    private String qtdUr;
    private String folhaFonte;
    private String medidor;
    private String concentrador;

    public int getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(int idEstacao) {
        this.idEstacao = idEstacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getQtdBanco() {
        return qtdBanco;
    }

    public void setQtdBanco(String qtdBanco) {
        this.qtdBanco = qtdBanco;
    }

    public String getFabriicanteFonte() {
        return fabriicanteFonte;
    }

    public void setFabricanteFonte(String fabriicanteFonte) {
        this.fabriicanteFonte = fabriicanteFonte;
    }

    public String getQtdUr() {
        return qtdUr;
    }

    public void setQtdUr(String qtdUr) {
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
