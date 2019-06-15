package com.system.operational.sgo.DAO;

public class URL {

    //ACESSO VIA LOCALHOST
    private static final String ROOT_URL = "http://192.168.0.109/ezentisApp/database/Api.php?apicall=";

    //ACESSO VIA FACULDADE
    //private static final String ROOT_URL = "http://192.168.0.188/ezentisApp/database/Api.php?apicall=";

    public static final String URL_LISTAR_ESTACAO = ROOT_URL + "atualizarEstacao";

    public static final String URL_VERIFICAR_USUARIO = ROOT_URL + "verificarUsuario&login=";

    //public static final String URL_AUTENTICAR_USUARIO = ROOT_URL + "";

    //public static final String URL_CADASTRAR_PENDENCIAS = ROOT_URL + "";
}
