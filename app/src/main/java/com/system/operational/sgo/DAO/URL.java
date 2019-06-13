package com.system.operational.sgo.DAO;

public class URL {

    private static final String ROOT_URL = "http://192.168.0.188/opt/lampp/htdocs/ezentis/application/config/Api.php?apicall=";

    public static final String URL_ATUALIZAR_ESTACAO = ROOT_URL + "createhero";
    public static final String URL_LISTAR_ESTACAO = ROOT_URL + "getheroes";

    public static final String URL_CADASTRAR_PENDENCIAS = ROOT_URL + "updatehero";
    public static final String URL_LISTAR_PENDENCIA = ROOT_URL + "deletehero&id=";

}
