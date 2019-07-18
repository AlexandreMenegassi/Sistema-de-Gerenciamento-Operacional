package com.system.operational.sgo.model;

public class Pendency {

    private int idEstacao;
    private int idUsuario;
    private String pendencia;
    private String recuperar;
    private String reparocompete;
    private String layer;
    private String usuarioMod;

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

    public String getPendencia() {
        return pendencia;
    }

    public void setPendencia(String pendencia) {
        this.pendencia = pendencia;
    }

    public String getRecuperar() {
        return recuperar;
    }

    public void setRecuperar(String recuperar) {
        this.recuperar = recuperar;
    }

    public String getReparocompete() {
        return reparocompete;
    }

    public void setReparocompete(String reparocompete) {
        this.reparocompete = reparocompete;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getUsuarioMod() {
        return usuarioMod;
    }

    public void setUsuarioMod(String usuarioMod) {
        this.usuarioMod = usuarioMod;
    }
}
