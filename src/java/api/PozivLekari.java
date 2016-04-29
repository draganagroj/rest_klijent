/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import domen.Lekar;

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
public class PozivLekari {
    public static  final String baseUri="http://localhost:8080/RestAplikacija/api";
    public static List<Lekar> vratiLekare() {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(baseUri).path("lekari");
       
      List<Lekar> lekari=target.request().get(new GenericType<List<Lekar>>(){});
       
      return lekari;
    }
      public static int izmeniLekara(Lekar l){
     Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUri).path("lekari/{lekarID}");
        Response response=target.resolveTemplate("lekarID", l.getLekarID()).request().put(Entity.json(l));
          System.out.println(response.getStatus());
            return response.getStatus();
    
    }
}
