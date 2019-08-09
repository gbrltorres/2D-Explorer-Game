/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabriel
 */
public class Arma implements Item {
    private String nome;
    private String tipo;
    
    public Arma (String tipo, String nome){
        this.tipo = tipo;
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String nome() {
        return nome;
    }

    @Override
    public void usar(Heroi heroi) {
        heroi.setArmaAtual(this);
    }

    @Override
    public String toString() {
        return nome()+" ("+tipo+")";
    }   

    @Override
    public boolean isDescartavel() {
        return false;
    }
    
}
