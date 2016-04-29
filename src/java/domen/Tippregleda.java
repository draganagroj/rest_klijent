/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dragana
 */
@XmlRootElement
public class Tippregleda implements Serializable{
    
  private Integer sifraTipaPregleda;
 private String nazivTipaPregleda;

    public Integer getSifraTipaPregleda() {
        return sifraTipaPregleda;
    }

    public void setSifraTipaPregleda(Integer sifraTipaPregleda) {
        this.sifraTipaPregleda = sifraTipaPregleda;
    }

    public String getNazivTipaPregleda() {
        return nazivTipaPregleda;
    }

    public void setNazivTipaPregleda(String nazivTipaPregleda) {
        this.nazivTipaPregleda = nazivTipaPregleda;
    }

    @Override
    public String toString() {
        return sifraTipaPregleda+" "+nazivTipaPregleda;
    }
    
    
}
