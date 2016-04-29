/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import domen.Pacijent;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dragana
 */
public class PozivPacijenti {
public static  final String baseUri="http://localhost:8080/RestAplikacija/api";
    public static List<Pacijent> vratiPacijente() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUri).path("pacijenti");

        List<Pacijent> pacijenti = target.request().get(new GenericType<List<Pacijent>>() {
        });

        return pacijenti;
    }

    public static Pacijent vratiPacijenta(String jmbg) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUri).path("pacijenti/{jmbg}");
        Pacijent pacijent = target.resolveTemplate("jmbg", jmbg).request().get(Pacijent.class);
        return pacijent;
    }
    public static int sacuvajPacijenta(Pacijent p){
     Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUri).path("pacijenti");
        Response response=target.request().post(Entity.json(p));
            return response.getStatus();
    
    }
    public static int izmeniPacijenta(Pacijent p){
     Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUri).path("pacijenti/{pacijentID}");
        Response response=target.resolveTemplate("pacijentID", p.getJMBGPacijenta()).request().put(Entity.json(p));
            return response.getStatus();
    
    }
    public static int obrisiPacijenta(Pacijent p){
    
      Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUri).path("pacijenti/{pacijentID}");
        Response response=target.resolveTemplate("pacijentID", p.getJMBGPacijenta()).request().delete();
            return response.getStatus();
    
    }
}
