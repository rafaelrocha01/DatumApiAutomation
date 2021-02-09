package org.br.datum.steps;

import cucumber.api.java.pt.*;
import org.br.datum.core.BaseTest;
import org.br.datum.core.RestLib;
import org.br.datum.page.UserPage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

public class UsersStep extends BaseTest {

    public UserPage userPage;

    @Dado("que eu possuo a url principal da api")
    public void queEuPossuoAUrlPrincipalDaApi() {
        userPage = new UserPage();
    }

    @Quando("eu realizar uma requisicao post para criar um usuario com o name {string} e o job {string}")
    public void euRealizarUmaRequisicaoPostParaCriarUmUsuarioComONameEOJob(String name, String job){
        JSONObject requestParams = new JSONObject();
        try {
            requestParams.put("name", name);
            requestParams.put("job", job);
            userPage.createUser(requestParams);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Entao("a api deve retornar o status {int}")
    public void aApiDeveRetornarOStatus(int status) {
        Assert.assertEquals(status, RestLib.status);
    }

    @E("a api deve retornar um json com dados do usuario criado, name {string} e job {string}")
    public void aApiDeveRetornarUmJsonComDadosDoUsuarioCriadoNameEJob(String name, String job){
        JSONObject json = null;
        try {
            json = new JSONObject(RestLib.resp.asString());
            System.out.println(RestLib.resp.asString());
            Assert.assertEquals(name, json.getString("name"));
            Assert.assertEquals(job, json.getString("job"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Dado("que eu possuo um usuário criado")
    public void queEuPossuoUmUsuarioCriado() {
        userPage = new UserPage();
    }

    @E("e que eu possuo a url principal da api")
    public void eQueEuPossuoAUrlPrincipalDaApi() {
    }

    @Quando("eu realizar uma requisição get para obter os dados do usuário com id {string}")
    public void euRealizarUmaRequisicaoGetParaObterOsDadosDoUsuarioComId(String id) {
        userPage.getUser(id);
    }

    @E("a api deve retornar um json com dados do usuario, id {string}, email {string}, firt name {string} last name {string}")
    public void aApiDeveRetornarUmJsonComDadosDoUsuarioIdEmailFirtNameLastName(String id, String email, String firstName, String lastName){
        JSONObject json = null;
        try {
            json = new JSONObject(RestLib.resp.asString());
            System.out.println(RestLib.resp.asString());
            JSONObject data = json.getJSONObject("data");
            Assert.assertEquals(id, data.getString("id"));
            Assert.assertEquals(email, data.getString("email"));
            Assert.assertEquals(firstName, data.getString("first_name"));
            Assert.assertEquals(lastName, data.getString("last_name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
