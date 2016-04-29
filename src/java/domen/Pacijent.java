/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dragana
 */
@XmlRootElement
public class Pacijent implements Serializable{
    
    private String JMBGPacijenta;
    private String imePacijenta;
    private String prezimePacijenta;
    private String NazivUlice;
    private Integer brojZgrade;

    public String getJMBGPacijenta() {
        return JMBGPacijenta;
    }

    public void setJMBGPacijenta(String JMBGPacijenta) {
        this.JMBGPacijenta = JMBGPacijenta;
    }

    public String getImePacijenta() {
        return imePacijenta;
    }

    public void setImePacijenta(String imePacijenta) {
        this.imePacijenta = imePacijenta;
    }

    public String getPrezimePacijenta() {
        return prezimePacijenta;
    }

    public void setPrezimePacijenta(String prezimePacijenta) {
        this.prezimePacijenta = prezimePacijenta;
    }

    public String getNazivUlice() {
        return NazivUlice;
    }

    public void setNazivUlice(String NazivUlice) {
        this.NazivUlice = NazivUlice;
    }

    public Integer getBrojZgrade() {
        return brojZgrade;
    }

    public void setBrojZgrade(Integer brojZgrade) {
        this.brojZgrade = brojZgrade;
    }

    public Lekar getLekar() {
        return lekar;
    }

    public void setLekar(Lekar lekar) {
        this.lekar = lekar;
    }

    public Opstina getOpstina() {
        return opstina;
    }

    public void setOpstina(Opstina opstina) {
        this.opstina = opstina;
    }

    public List<PregledWeb> getListaPregleda() {
        return listaPregleda;
    }

    public void setListaPregleda(List<PregledWeb> listaPregleda) {
        this.listaPregleda = listaPregleda;
    }
    private Lekar lekar;
    private Opstina opstina;
    private List<PregledWeb> listaPregleda;

    @Override
    public String toString() {
        return imePacijenta +" "+ prezimePacijenta;
    }
    
}
