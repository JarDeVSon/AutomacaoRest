package steps;


import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.LoginMap;
import maps.UsuariosMap;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class UsuarioSteps {

    private Map<String, String> getHeadersComAuth() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", LoginMap.token);
        return headers;
    }

    @Dado("que tenho um payload valido da API de Usuarios")
    public void queTenhoUmPayloadValidoDaAPIDeUsuarios() {
        UsuariosMap.initUsuario();
    }

    @Quando("envio uma requisicao do tipo POST de Usuarios")
    public void envioUmaRequisicaoDoTipoPOSTDeUsuarios() {
        RestUtils.postHeader(getHeadersComAuth(), UsuariosMap.getUsuario(), ContentType.JSON, "usuarios");
    }

    @Entao("armazeno o id do usuario que recebo do response de Usuarios")
    public void armazenoOIdDoUsuarioQueReceboDoResponseDeUsuarios() {
        UsuariosMap.idUsuario = RestUtils.getResponse().jsonPath().get("_id");
    }

    @Quando("envio uma requisicao do tipo GET para listar Usuarios")
    public void envioUmaRequisicaoDoTipoGETParaListarUsuarios() {
        RestUtils.get(getHeadersComAuth(), "usuarios");
    }

    @Quando("envio uma requisicao do tipo GET para consultar Usuario por ID")
    public void envioUmaRequisicaoDoTipoGETParaConsultarUsuarioPorID() {
        RestUtils.get(getHeadersComAuth(), "usuarios/" + UsuariosMap.idUsuario);
    }

    @Dado("que altero o campo nome do payload de Usuarios para {string}")
    public void queAlteroOCampoNomeDoPayloadDeUsuariosPara(String novoNome) {
        UsuariosMap.getUsuario().put("nome", novoNome);
    }

    @Quando("envio uma requisicao do tipo PUT de Usuarios")
    public void envioUmaRequisicaoDoTipoPUTDeUsuarios() {
        RestUtils.put(getHeadersComAuth(), UsuariosMap.getUsuario(), ContentType.JSON, "usuarios/" + UsuariosMap.idUsuario);
    }

    @Quando("envio uma requisicao do tipo DELETE de Usuarios")
    public void envioUmaRequisicaoDoTipoDELETEDeUsuarios() {
        RestUtils.delete(getHeadersComAuth(), "usuarios/" + UsuariosMap.idUsuario);
    }
}
