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
public class Lekar implements Serializable{
    public Lekar() {
    }
    private Integer lekarID;
    private String JMBGLekara;
    private String imeLekara;
    private String prezimeLekara;
     private Integer brojLicence;
    private String nazivUlice;
    private Integer brojZgrade;
    private Opstina opstina;
    private String userName;
    private String password;

    @Override
    public String toString() {
           return String.format("Lekar[%d, %s,%s,%s,%d,%s,%d]", lekarID, JMBGLekara,imeLekara,prezimeLekara,brojLicence,nazivUlice,brojZgrade);
    }
    
@Override
    public boolean equals(Object other) {
        return (other instanceof Lekar) && (lekarID != null)
            ? lekarID.equals(((Lekar) other).lekarID)
            : (other == this);
    }

    public Integer getLekarID() {
        return lekarID;
    }

    public void setLekarID(Integer lekarID) {
        this.lekarID = lekarID;
    }

    public String getJMBGLekara() {
        return JMBGLekara;
    }

    public void setJMBGLekara(String JMBGLekara) {
        this.JMBGLekara = JMBGLekara;
    }

    public String getImeLekara() {
        return imeLekara;
    }

    public void setImeLekara(String imeLekara) {
        this.imeLekara = imeLekara;
    }

    public String getPrezimeLekara() {
        return prezimeLekara;
    }

    public void setPrezimeLekara(String prezimeLekara) {
        this.prezimeLekara = prezimeLekara;
    }

    public Integer getBrojLicence() {
        return brojLicence;
    }

    public void setBrojLicence(Integer brojLicence) {
        this.brojLicence = brojLicence;
    }

    public String getNazivUlice() {
        return nazivUlice;
    }

    public void setNazivUlice(String nazivUlice) {
        this.nazivUlice = nazivUlice;
    }

    public Integer getBrojZgrade() {
        return brojZgrade;
    }

    public void setBrojZgrade(Integer brojZgrade) {
        this.brojZgrade = brojZgrade;
    }

    public Opstina getOpstina() {
        return opstina;
    }

    public void setOpstina(Opstina opstina) {
        this.opstina = opstina;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
}
