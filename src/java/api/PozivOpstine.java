/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import domen.Opstina;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Dragana
 */
public class PozivOpstine {

    public static List<Opstina> vratiOpstine() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/RestAplikacija/api").path("opstine");

        List<Opstina> opstine = target.request().get(new GenericType<List<Opstina>>() {
        });

        return opstine;
    }
}
