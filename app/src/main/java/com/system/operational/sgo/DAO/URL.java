package com.system.operational.sgo.DAO;

public class URL {

    //ACESSO VIA LOCALHOST
    private static final String ROOT_URL = "http://192.168.0.102/ezentisApp/database/Api.php?apicall=";

    //ACESSO VIA FACULDADE
    //private static final String ROOT_URL = "http://192.168.0.188/ezentisApp/database/Api.php?apicall=";

    public static final String URL_LISTAR_ESTACAO = ROOT_URL + "listarEstacao";

    public static final String URL_VERIFICAR_USUARIO = ROOT_URL + "verificarUsuario&login=";

    public static final String URL_ATUALIZAR_ESTACAO = ROOT_URL + "atualizarEstacao&acesso=";


    //public static final String URL_CADASTRAR_PENDENCIAS = ROOT_URL + "";

    public static final int CODE_GET_REQUEST = 1024;

    public static final int CODE_POST_REQUEST = 1025;
}
