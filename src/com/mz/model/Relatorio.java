package com.mz.model;

import java.io.Serializable;

/**
 *
 * @author celso
 */
public class Relatorio implements Serializable{

   private String sms,data,assunto,mandatario;

    public Relatorio(String sms, String data, String assunto, String mandatario) {
        this.sms = sms;
        this.data = data;
        this.assunto = assunto;
        this.mandatario = mandatario;
    }

    public Relatorio() {
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMandatario() {
        return mandatario;
    }

    public void setMandatario(String mandatario) {
        this.mandatario = mandatario;
    }
   
   
    
    
    
}
