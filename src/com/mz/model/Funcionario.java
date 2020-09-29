package com.mz.model;


public class Funcionario extends Pessoa{
    
    private String cargo,senha,linguas;
    private double salario,saldo;
    private int id;
    private boolean contratado;
    
    public Funcionario(){
        saldo=0;
        contratado=false;
    }

    public Funcionario(String cargo, String senha, double salario, double saldo, int id, boolean contratado,String linguas) {
        this.cargo = cargo;
        this.senha = senha;
        this.salario = salario;
        this.saldo = saldo;
        this.id = id;
        this.contratado = contratado;
        this.linguas=linguas;
    }



    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getContratado() {
        return contratado;
    }

    public void setContratado(boolean contratado) {
        this.contratado = contratado;
    }

    public String getLinguas() {
        return linguas;
    }

    public void setLinguas(String linguas) {
        this.linguas = linguas;
    }
    
    public String toString(){
        return nome+" "+apelido;
    }
    
}