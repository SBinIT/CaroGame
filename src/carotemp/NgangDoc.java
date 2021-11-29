/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carotemp;

/**
 *
 * @author Admin
 */
public class NgangDoc {
    private String ngang;
    private String doc;

    public NgangDoc(String ngang, String doc) {
        this.ngang = ngang;
        this.doc = doc;
    }

    public String getNgang() {
        return ngang;
    }

    public void setNgang(String ngang) {
        this.ngang = ngang;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
    
}

