package com.mz.model;

import java.io.Serializable;

public class Pessoa implements Serializable{

    String nome;
    String apelido;
    
    private String dataNascimento,nacionalidade,email,bi,nivelAcademico,estadoCivil,caminhoImg;
    private long contacto;
    private String genero;
    
    public Pessoa(){
       caminhoImg="/com/mz/fotos/perfil.png"; 
    }

    public Pessoa(String nome, String apelido, String dataNascimento, String nacionalidade, String email, String bi, String nivelAcademico, String estadoCivil, String caminhoImg, long contacto, String genero) {
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.bi = bi;
        this.nivelAcademico = nivelAcademico;
        this.estadoCivil = estadoCivil;
        this.caminhoImg = caminhoImg;
        this.contacto = contacto;
        this.genero = genero;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public long getContacto() {
        return contacto;
    }

    public void setContacto(long contacto) {
        this.contacto = contacto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCaminhoImg() {
        return caminhoImg;
    }

    public void setCaminhoImg(String caminhoImg) {
        this.caminhoImg = caminhoImg;
    }


    
    
}
