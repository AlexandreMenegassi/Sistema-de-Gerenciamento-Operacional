package com.system.operational.sgo.DAO;

public class URL {

    public static final int CODE_GET_REQUEST = 1024;
    public static final int CODE_POST_REQUEST = 1025;

    private static final String ROOT_URL = "http://192.168.0.106/sgoApp/database/Api.php?apicall=";
    //private static final String ROOT_URL = "http://192.168.0.188/sgoApp/database/Api.php?apicall=";

    public static final String URL_LISTAR_ESTACAO = ROOT_URL + "listarEstacao";

    public static final String URL_VERIFICAR_USUARIO = ROOT_URL + "verificarUsuario&login=";

    public static final String URL_ADICIONAR_DADOS_ESTACAO = ROOT_URL + "adicionarDadosEstacao&acesso=";

    public static final String URL_ATUALIZAR_DADOS_ESTACAO = ROOT_URL + "atualizarDadosEstacao&acesso=";

    public static final String URL_CADASTRAR_PENDENCIA = ROOT_URL + "cadastrarPendencia&pendencia=";

    public static final String URL_DADOS_ESTACAO = ROOT_URL + "dadosEstacao&id=";
}
