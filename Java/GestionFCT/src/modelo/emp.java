/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author David
 */

public class emp {

    private String codigo, nom_emp, cif, direccion, locali, cp, tip_jonada, dni_resp, nom_resp, apellido_resp, dni_tutor, nom_tutor, ape_tutor, mail_tutor, tlf_tutor;
    
    //
    public emp(){
        
    }

    public emp(String codigo, String nom_emp, String cif, String direccion, String locali, String cp, String tip_jonada, String dni_resp, String nom_resp, String apellido_resp, String dni_tutor, String nom_tutor, String ape_tutor, String mail_tutor, String tlf_tutor) {

        this.codigo = codigo;
        this.nom_emp = nom_emp;
        this.cif = cif;
        this.direccion = direccion;
        this.locali = locali;
        this.cp = cp;
        this.tip_jonada = tip_jonada;
        this.dni_resp = dni_resp;
        this.nom_resp = nom_resp;
        this.apellido_resp = apellido_resp;
        this.dni_tutor = dni_tutor;
        this.nom_tutor = nom_tutor;
        this.ape_tutor = ape_tutor;
        this.mail_tutor = mail_tutor;
        this.tlf_tutor = tlf_tutor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNom_emp() {
        return nom_emp;
    }

    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocali() {
        return locali;
    }

    public void setLocali(String locali) {
        this.locali = locali;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTip_jonada() {
        return tip_jonada;
    }

    public void setTip_jonada(String tip_jonada) {
        this.tip_jonada = tip_jonada;
    }

    public String getDni_resp() {
        return dni_resp;
    }

    public void setDni_resp(String dni_resp) {
        this.dni_resp = dni_resp;
    }

    public String getNom_resp() {
        return nom_resp;
    }

    public void setNom_resp(String nom_resp) {
        this.nom_resp = nom_resp;
    }

    public String getApellido_resp() {
        return apellido_resp;
    }

    public void setApellido_resp(String apellido_resp) {
        this.apellido_resp = apellido_resp;
    }

    public String getDni_tutor() {
        return dni_tutor;
    }

    public void setDni_tutor(String dni_tutor) {
        this.dni_tutor = dni_tutor;
    }

    public String getNom_tutor() {
        return nom_tutor;
    }

    public void setNom_tutor(String nom_tutor) {
        this.nom_tutor = nom_tutor;
    }

    public String getApe_tutor() {
        return ape_tutor;
    }

    public void setApe_tutor(String ape_tutor) {
        this.ape_tutor = ape_tutor;
    }

    public String getMail_tutor() {
        return mail_tutor;
    }

    public void setMail_tutor(String mail_tutor) {
        this.mail_tutor = mail_tutor;
    }

    public String getTlf_tutor() {
        return tlf_tutor;
    }

    public void setTlf_tutor(String tlf_tutor) {
        this.tlf_tutor = tlf_tutor;
    }
}
