/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import api.PozivLekari;
import api.PozivOpstine;
import api.PozivPacijenti;
import api.PozivPregledi;
import domen.Lekar;
import domen.NalazWeb;

import domen.NalazPKWeb;
import domen.Opstina;
import domen.Pacijent;
import domen.PregledWeb;
import domen.PregledPKWeb;
import domen.Tippregleda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dragana
 */
public class test {

    public static void main(String[] args) {

        Pacijent p = new Pacijent();
        p.setImePacijenta("Mikica");
        p.setPrezimePacijenta("Groj");
        p.setBrojZgrade(2);
        p.setNazivUlice("Avalska");

        Opstina o = new Opstina();
        o.setSifraOpstine(5);
        p.setOpstina(o);

        Lekar l = new Lekar();
        l.setLekarID(1);

        p.setLekar(l);
        p.setJMBGPacijenta("3331231231231");
        PozivPacijenti.izmeniPacijenta(p);
        
//        PozivPacijenti.obrisiPacijenta(p);
//
//        PregledWeb preg = new PregledWeb();
//
//        PregledPKWeb pk = new PregledPKWeb();
//
//        pk.setLekar(l.getLekarID());
//        pk.setPacijent(p.getJMBGPacijenta());
//
//        preg.setDatum(new Date());
//        preg.setPregledpk(pk);
//        preg.setLekar(l);
//        preg.setPacijent(p);
//
//        NalazWeb n1 = new NalazWeb();
//        NalazPKWeb npk = new NalazPKWeb();
//        npk.setLekar(l.getLekarID());
//        npk.setPacijent(p.getJMBGPacijenta());
//
//        n1.setNalazpk(npk);
//
//        n1.setPredlozenaTerapija("mnj");
//        n1.setTegobe("blj");
//
//        NalazWeb n2 = new NalazWeb();
//        NalazPKWeb npk2 = new NalazPKWeb();
//        npk2.setLekar(l.getLekarID());
//        npk2.setPacijent(p.getJMBGPacijenta());
//        n2.setTegobe("ish");
//        n2.setPredlozenaTerapija("jjj");
//        n2.setNalazpk(npk2);
//
//        Tippregleda t = new Tippregleda();
//        t.setSifraTipaPregleda(1);
//        preg.setTippregleda(t);
//
//        List<NalazWeb> listaNalaza = new ArrayList<>();
//        listaNalaza.add(n1);
//        listaNalaza.add(n2);
//
//        preg.setListaNalaza(listaNalaza);
//        System.out.println(preg.getPregledpk().getLekar() + " " + preg.getPregledpk().getPacijent());
//        PozivPregledi.sacuvajPregled(preg);
//        List<Opstina> opstine=PozivOpstine.vratiOpstine();
//        for (Opstina opstine1 : opstine) {
//            System.out.println(opstine1.getNazivOpstine());
//        }
//        Lekar l=new Lekar();
//        l.setBrojZgrade(12);
//        l.setImeLekara("Milena");
//        l.setPrezimeLekara("Maric");
//        l.setNazivUlice("Avalska");
//        l.setJMBGLekara("1231231231231");
//        l.setLekarID(1);
//        l.setPassword("Maric");
//        l.setUserName("Milena");
//        l.setBrojLicence(1234);
//        Opstina o=new Opstina();
//        o.setNazivOpstine("Vracar");
//        o.setSifraOpstine(1);
//        l.setOpstina(o);
//        PozivLekari.izmeniLekara(l);
    }
}
