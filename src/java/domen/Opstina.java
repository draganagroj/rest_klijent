/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dragana
 */
@XmlRootElement
public class Opstina implements Serializable{

    public Opstina() {
    }

    public Integer getSifraOpstine() {
        return SifraOpstine;
    }

    public void setSifraOpstine(Integer SifraOpstine) {
        this.SifraOpstine = SifraOpstine;
    }

    public String getNazivOpstine() {
        return nazivOpstine;
    }

    public void setNazivOpstine(String nazivOpstine) {
        this.nazivOpstine = nazivOpstine;
    }
    private Integer SifraOpstine;
  private String nazivOpstine;

    @Override
    public String toString() {
        return String.format("Opstina[%d, %s]", SifraOpstine, nazivOpstine);
    }
 @Override
    public boolean equals(Object other) {
        return (other instanceof Opstina) && (SifraOpstine != null)
            ? SifraOpstine.equals(((Opstina) other).SifraOpstine)
            : (other == this);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.SifraOpstine);
        hash = 59 * hash + Objects.hashCode(this.nazivOpstine);
        return hash;
    }

    public Opstina(Integer SifraOpstine, String nazivOpstine) {
        this.SifraOpstine = SifraOpstine;
        this.nazivOpstine = nazivOpstine;
    }
}
