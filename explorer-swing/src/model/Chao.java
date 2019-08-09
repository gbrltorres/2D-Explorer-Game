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
public class Chao extends ElementoTabuleiro {

    public Chao(int i, int j) {
        this.simbolo = ' ';
        linha = i;
        coluna = j;
    }
    
    @Override
    public boolean podeAtravessar() {
        return true;
    }

    @Override
    public boolean podeSerAberto() {
        return false;
    }

    @Override
    public boolean podeSerDestruido() {
        return false;
    }

}
