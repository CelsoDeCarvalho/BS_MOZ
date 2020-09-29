package com.mz.model;


public class Administrador extends Pessoa{
    
    private int id;
    private String senha;
    private double saldo;
    
    public Administrador(){
        saldo=1000000;
    }

    public Administrador(int id, String senha, double saldo){
        super();
        this.id = id;
        this.senha = senha;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}