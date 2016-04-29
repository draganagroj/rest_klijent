/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import api.PozivPacijenti;
import api.PozivPregledi;
import domen.Lekar;
import domen.NalazPKWeb;
import domen.NalazWeb;
import domen.Opstina;
import domen.Pacijent;
import domen.PregledPKWeb;
import domen.PregledWeb;
import domen.Tippregleda;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Dragana
 */
@ManagedBean
@SessionScoped
public class PacijentiBean implements Serializable {

    private List<Pacijent> pacijenti;
    private Pacijent trenutni;
    private Opstina trenutnaOpstina;
    private Lekar trenutniLekar;
    private Opstina pacijent_opstina;
    private Lekar pacijent_lekar;
    private Pacijent noviPacijent = new Pacijent();
    private int status_novi = 0;
    private int status = 0;
    private int status_brisanje=0;
    private List<Pacijent> filtriraniPacijenti;
    private PregledWeb pregled = new PregledWeb();
    private int status_novi_pregled = 0;
    private Tippregleda tip;
    @ManagedProperty(value = "#{tipPregledaBean}")
    private TipPregledaBean tipovi;
    @ManagedProperty(value = "#{logovanje}")
    private Logovanje logovanje;
    private List<NalazWeb> listaNalaza = new ArrayList<>();
    private String tegobe;
    private String terapija;
    private int brojNalaza;
    private List<PregledWeb> listaPregledaPacijenta;
    private List<PregledWeb> filtriraniPregledi;
private PregledWeb trenutniPregled;
private List<NalazWeb> trenutniNalazi;
private Tippregleda tipPregleda;
    @PostConstruct
    public void init() {
        setPacijenti(PozivPacijenti.vratiPacijente());

    }

    public List<Pacijent> getPacijenti() {
        return pacijenti;
    }

    public void obrisiPacijenta(Pacijent pac) {
        System.out.println(pac);
        pacijenti.remove(pac);
        setStatus_brisanje(PozivPacijenti.obrisiPacijenta(pac));
        System.out.println(getStatus_brisanje());
    }

    public Pacijent getTrenutni() {
        return trenutni;
    }

    public void setTrenutni(Pacijent trenutni) {
        this.trenutni = trenutni;
    }

    public void postaviTrenutnogPacijenta(Pacijent p) {
        setTrenutni(p);
        setTrenutnaOpstina(p.getOpstina());
        setTrenutniLekar(p.getLekar());

    }

    public String izmeniPacijenta(Pacijent p) {
        postaviTrenutnogPacijenta(p);
        return "izmena_pacijenta.xhtml?faces-redirect=true";

    }

    public String prikaziPacijenta(Pacijent p) {
        postaviTrenutnogPacijenta(p);
        prikaziPregledePacijenta(p);
        return "prikaz_pacijenta.xhtml";
    }

    public void sacuvajIzmene() {

        setStatus(PozivPacijenti.izmeniPacijenta(trenutni));
        System.out.println(getStatus());

    }

    public Opstina getTrenutnaOpstina() {
        return trenutnaOpstina;
    }

    public void setTrenutnaOpstina(Opstina trenutnaOpstina) {
        this.trenutnaOpstina = trenutnaOpstina;
    }

    public Lekar getTrenutniLekar() {
        return trenutniLekar;
    }

    public void setTrenutniLekar(Lekar trenutniLekar) {
        this.trenutniLekar = trenutniLekar;
    }

    public void setPacijenti(List<Pacijent> pacijenti) {
        this.pacijenti = pacijenti;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Pacijent getNoviPacijent() {
        return noviPacijent;
    }

    public void setNoviPacijent(Pacijent noviPacijent) {
        this.noviPacijent = noviPacijent;
    }

    public int getStatus_novi() {
        return status_novi;
    }

    public void setStatus_novi(int status_novi) {
        this.status_novi = status_novi;
    }

    public void dodajNovog() {
        noviPacijent.setLekar(getPacijent_lekar());
        noviPacijent.setOpstina(getPacijent_opstina());
        setStatus_novi(PozivPacijenti.sacuvajPacijenta(noviPacijent));

    }

    public Opstina getPacijent_opstina() {
        return pacijent_opstina;
    }

    public void setPacijent_opstina(Opstina pacijent_opstina) {
        this.pacijent_opstina = pacijent_opstina;
    }

    public Lekar getPacijent_lekar() {
        return pacijent_lekar;
    }

    public void setPacijent_lekar(Lekar pacijent_lekar) {
        this.pacijent_lekar = pacijent_lekar;
    }

    public String dodajPacijenta() {
        setPacijent_opstina(getPacijenti().get(0).getOpstina());
        setPacijent_lekar(getPacijenti().get(0).getLekar());
        return "novi_pacijent";
    }

    public String dodajPregled(Pacijent p) {

        pregled.setPacijent(p);
        pregled.setDatum(new Date());
        setTip(tipovi.getListaTipovaPregleda().get(0));
        pregled.setLekar(logovanje.getUlogovaniLekar());
        return "dodavanje_pregleda.xhtml";
    }

    public List<Pacijent> getFiltriraniPacijenti() {
        return filtriraniPacijenti;
    }

    public void setFiltriraniPacijenti(List<Pacijent> filtriraniPacijenti) {
        this.filtriraniPacijenti = filtriraniPacijenti;
    }

    public PregledWeb getPregled() {
        return pregled;
    }

    public void setPregled(PregledWeb pregled) {
        this.pregled = pregled;
    }

    public int getStatus_novi_pregled() {
        return status_novi_pregled;
    }

    public void setStatus_novi_pregled(int status_novi_pregled) {
        this.status_novi_pregled = status_novi_pregled;
    }

    public Tippregleda getTip() {
        return tip;
    }

    public void setTip(Tippregleda tip) {
        this.tip = tip;
    }

    public TipPregledaBean getTipovi() {
        return tipovi;
    }

    public void setTipovi(TipPregledaBean tipovi) {
        this.tipovi = tipovi;
    }

    public Logovanje getLogovanje() {
        return logovanje;
    }

    public void setLogovanje(Logovanje logovanje) {
        this.logovanje = logovanje;
    }

    public List<NalazWeb> getListaNalaza() {
        return listaNalaza;
    }

    public void setListaNalaza(List<NalazWeb> listaNalaza) {
        this.listaNalaza = listaNalaza;
    }

    public void dodajNalaz() {
        NalazWeb n = new NalazWeb();
        n.setPredlozenaTerapija(terapija);
        n.setTegobe(tegobe);
        n.setRedniBroj(brojNalaza);
        listaNalaza.add(n);
    }

    public String getTegobe() {
        return tegobe;
    }

    public void setTegobe(String tegobe) {
        this.tegobe = tegobe;
    }

    public String getTerapija() {
        return terapija;
    }

    public void setTerapija(String terapija) {
        this.terapija = terapija;
    }

    public int getBrojNalaza() {
        return brojNalaza;
    }

    public void setBrojNalaza(int brojNalaza) {
        this.brojNalaza = brojNalaza;
    }

    public void sacuvajPregled() {
        PregledPKWeb pk = new PregledPKWeb();
        pk.setLekar(pregled.getLekar().getLekarID());
        pk.setPacijent(pregled.getPacijent().getJMBGPacijenta());
        pregled.setPregledpk(pk);
        pregled.setTippregleda(tip);
        for (NalazWeb nalazi : listaNalaza) {
            NalazPKWeb npk = new NalazPKWeb();
            npk.setLekar(pregled.getLekar().getLekarID());
            npk.setPacijent(pregled.getPacijent().getJMBGPacijenta());
            nalazi.setNalazpk(npk);
            nalazi.setPredlozenaTerapija(terapija);
            nalazi.setTegobe(tegobe);
        }
        pregled.setListaNalaza(listaNalaza);
        setStatus_novi_pregled(PozivPregledi.sacuvajPregled(pregled));
        System.out.println(getStatus_novi_pregled());
        listaNalaza.clear();
        setTerapija("");
        setTegobe("");
        setBrojNalaza(0);
    }

    public List<PregledWeb> getListaPregledaPacijenta() {
        return listaPregledaPacijenta;
    }

    public void setListaPregledaPacijenta(List<PregledWeb> listaPregledaPacijenta) {
        this.listaPregledaPacijenta = listaPregledaPacijenta;
    }

    public void prikaziPregledePacijenta(Pacijent p) {
        setListaPregledaPacijenta(PozivPregledi.vratiListuPregleda(p));
        System.out.println(getListaPregledaPacijenta());
        
    }

    public List<PregledWeb> getFiltriraniPregledi() {
        return filtriraniPregledi;
    }

    public void setFiltriraniPregledi(List<PregledWeb> filtriraniPregledi) {
        this.filtriraniPregledi = filtriraniPregledi;
    }

    public  String datePattern() {
        return "dd.MM.yyyy";
    }

    public  String customFormatDate(Date date) {
        if (date != null) {
            DateFormat format = new SimpleDateFormat(datePattern());
          
            String datum=format.format(date);
            System.out.println(datum);
            return datum;
        }
        return "";
    }
  

    public PregledWeb getTrenutniPregled() {
        return trenutniPregled;
    }

    public void setTrenutniPregled(PregledWeb trenutniPregled) {
        this.trenutniPregled = trenutniPregled;
    }

    public List<NalazWeb> getTrenutniNalazi() {
        return trenutniNalazi;
    }

    public void setTrenutniNalazi(List<NalazWeb> trenutniNalazi) {
        this.trenutniNalazi = trenutniNalazi;
    }
    public String detalji(PregledWeb pr){
        setTrenutniPregled(pr);
        setTipPregleda(pr.getTippregleda());
   
        setTrenutniNalazi(PozivPregledi.vratiNalazePregleda(pr));
        
    return "detalji_pregleda.xhtml";
    }

    public Tippregleda getTipPregleda() {
        return tipPregleda;
    }

    public void setTipPregleda(Tippregleda tipPregleda) {
        this.tipPregleda = tipPregleda;
    }

    public int getStatus_brisanje() {
        return status_brisanje;
    }

    public void setStatus_brisanje(int status_brisanje) {
        this.status_brisanje = status_brisanje;
    }
    
    public String osveziPregledePacijenta(Pacijent p){
        prikaziPregledePacijenta(p);
        return "prikaz_pregleda.xhtml?faces-redurect=true";
    }
}
