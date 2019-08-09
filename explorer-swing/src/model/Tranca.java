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
public class Tranca extends ElementoTabuleiro {
    private String tipo;
    
    public Tranca(Character simbolo, int i, int j, String tipo){
        this.simbolo = simbolo;
        linha = i;
        coluna = j;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean podeAtravessar() {
        return false;
    }

    @Override
    public boolean podeSerAberto() {
        return false;
    }

    @Override
    public boolean podeSerDestruido() {
        return true;
    }
}
