/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import domen.NalazWeb;
import domen.Pacijent;
import domen.PregledWeb;
import domen.Tippregleda;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dragana
 */
public class PozivPregledi {
        public static  final String baseUri="http://localhost:8080/RestAplikacija/api";

    public static int sacuvajPregled(PregledWeb p) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUri).path("pacijenti/{pacijentiD}/pregledi");
        Entity e = Entity.json(p);
        System.out.println(json(p));
        Response response = target.resolveTemplate("pacijentiD", p.getPregledpk().getPacijent()).request().post(e);
        return response.getStatus();

    }

    public static List<Tippregleda> vratiListuTipovaPregleda() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUri).path("tip");
        List<Tippregleda> tipoviPrelgeda = target.request().get(new GenericType<List<Tippregleda>>() {
        });
        return tipoviPrelgeda;
    }

    public static List<PregledWeb> vratiListuPregleda(Pacijent p) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUri).path("pacijenti/{pacijentiD}/pregledi");
        List<PregledWeb> lista = target.resolveTemplate("pacijentiD", p.getJMBGPacijenta()).request().get(new GenericType<List<PregledWeb>>() {
        });
        return lista;
    }
    public static List<NalazWeb> vratiNalazePregleda(PregledWeb pr){
    Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUri).path("pacijenti/{pacijentiD}/pregledi/{preglediD}/nalazi");
        Map<String,Object> mapa=new HashMap<>();
        mapa.put("pacijentiD", pr.getPacijent().getJMBGPacijenta());
        mapa.put("preglediD", pr.getPregledpk().getBrojPregleda());
        List<NalazWeb> lista = target.resolveTemplates(mapa).request().get(new GenericType<List<NalazWeb>>() {
        });
        System.out.println(lista);
        return lista;
    }
}
