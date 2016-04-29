/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import api.PozivLekari;
import domen.Lekar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Dragana
 */
@ManagedBean
public class LekariBean {
    List<Lekar> lekari;
    
    @PostConstruct
    public void init() {
        lekari=PozivLekari.vratiLekare();
    }

    public List<Lekar> getLekari() {
        return lekari;
    }

   
    
}
