/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author gabriel
 */
public class PocaoCura implements Item {
    private int potencial;
    
    public PocaoCura() {
        Random r = new Random();
        potencial = r.nextInt((3 - 1) +1) + 1;
    }
    
    @Override
    public String nome() {
        return "Poção de Cura";
    }
    
    @Override
    public void usar(Heroi heroi) {
        heroi.setQtdeVida(heroi.getQtdeVida() + potencial);
        if(heroi.getQtdeVida() > 6) {
            heroi.setQtdeVida(6);
        }
    }
    
    public int getPotencial() {
        return potencial;
    }

    public void setPotencial(int potencial) {
        this.potencial = potencial;
    }

    @Override
    public boolean isDescartavel() {
        return true;
    }
}
