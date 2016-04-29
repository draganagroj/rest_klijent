/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Dragana
 */
public class Util {
    public static HttpSession getSession(){
    
    return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }
    public static HttpServletRequest getRequest(){
    
    return (HttpServletRequest) (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
}
