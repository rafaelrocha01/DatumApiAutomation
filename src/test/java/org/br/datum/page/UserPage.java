package org.br.datum.page;

import org.br.datum.core.BasePage;
import org.br.datum.core.RestLib;
import org.json.JSONObject;

public class UserPage extends BasePage {

    public void createUser(JSONObject body){
        restLib = new RestLib();
        restLib.post(body, "users");
    }

    public void getUser(String id){
        restLib = new RestLib();
        restLib.get(id, "users/");
    }
}
