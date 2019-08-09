
package model;

import java.util.Random;


public class BauExplosivo extends Bau {
    private int dano;
    
    public BauExplosivo(Character simbolo, int i, int j) {
        this.simbolo = simbolo;
        linha = i;
        coluna = j;
        Random r = new Random();
        dano = r.nextInt((3 - 1) +1) + 1; //sorteando dano com valor de 1 a 3
        setPodeExplodir(true);
    }
    
    public void abrir(Heroi heroi){
        heroi.setQtdeVida(heroi.getQtdeVida() - dano);
        if(heroi.getQtdeVida() < 0) {
            heroi.setQtdeVida(0);
        }
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
    
    @Override
    public boolean podeSerDestruido(){
        return false;
    }
}
