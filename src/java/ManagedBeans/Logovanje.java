package ManagedBeans;

import api.PozivLekari;
import domen.Lekar;
import domen.Opstina;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dragana
 */
@ManagedBean
@SessionScoped
public class Logovanje implements Serializable {

    public Logovanje() {
    }
    private String theUserName = "";
    private String password = "";

    private int status = 0;

    private List<Lekar> lekari;
    Lekar ulogovaniLekar;
    private Opstina opstina;
    private boolean logged=false;

    public String getTheUserName() {
        return theUserName;
    }

    public void setTheUserName(String theUserName) {
        this.theUserName = theUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @PostConstruct
    public void SviLekari() {
        setLekari(PozivLekari.vratiLekare());

    }

    public Lekar getUlogovaniLekar() {
        return ulogovaniLekar;
    }

    private void setUlogovaniLekar(Lekar ulogovaniLekar) {
        this.ulogovaniLekar = ulogovaniLekar;
    }

    public String login() {
        for (Lekar lekari1 : lekari) {
            if (theUserName.equals(lekari1.getUserName()) && password.equals(lekari1.getPassword())) {
                HttpSession ht = Util.getSession();
                ht.setAttribute("lekar", lekari1);
                setUlogovaniLekar(lekari1);
                setOpstina(lekari1.getOpstina());
                setLogged(true);
                return "pocetna.xhtml?faces-redirect=true";
            } 
        }
           
       
        
        FacesMessage fm = new FacesMessage("greska kod logovanja", "ERROR MSG");
        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "logovanje.xhtml";

    }

    public String logout() {
        HttpSession hs = Util.getSession();
        hs.invalidate();
        setUlogovaniLekar(null);
        setTheUserName("");
        setPassword("");
        setLogged(false);
        return "logovanje.xhtml?faces-redirect=true";
    }

    public void sacuvaIzmene() {
        ulogovaniLekar.setOpstina(opstina);

        setStatus(PozivLekari.izmeniLekara(ulogovaniLekar));

    }

//    public String getGreeting() {
//        if (theUserName == null || theUserName.equals("")) {
//            return "unesite vase ime";
//        } else {
//            return "cao " + theUserName;
//        }
//    }
    public Opstina getOpstina() {
        return opstina;
    }

    public void setOpstina(Opstina opstina) {
        this.opstina = opstina;
    }

    public List<Lekar> getLekari() {
        return lekari;
    }

    public void setLekari(List<Lekar> lekari) {
        this.lekari = lekari;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

}
