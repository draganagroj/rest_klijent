/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import api.PozivPregledi;
import domen.Tippregleda;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Dragana
 */
@ManagedBean
@SessionScoped
public class TipPregledaBean implements Serializable{
    private List<Tippregleda> listaTipovaPregleda;

    public List<Tippregleda> getListaTipovaPregleda() {
        return listaTipovaPregleda;
    }

    public void setListaTipovaPregleda(List<Tippregleda> listaTipovaPregleda) {
        this.listaTipovaPregleda = listaTipovaPregleda;
    }
    @PostConstruct
    public void init(){
        setListaTipovaPregleda(PozivPregledi.vratiListuTipovaPregleda());
    }
}
