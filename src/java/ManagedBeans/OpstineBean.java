/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import api.PozivOpstine;
import domen.Opstina;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Dragana
 */
 @SessionScoped
@ManagedBean
public class OpstineBean implements Serializable{
    private List<Opstina> opstine;
    
   @PostConstruct
   public void init(){
   
       setOpstine(PozivOpstine.vratiOpstine());
           
   }

    public List<Opstina> getOpstine() {
        return opstine;
    }

    private void setOpstine(List<Opstina> opstine) {
        this.opstine = opstine;
    }

   
}
