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
public abstract class ElementoTabuleiro {
    protected int linha;
    protected int coluna;
    protected Character simbolo;

    public Character getSimbolo() {
        return simbolo;
    }

    public abstract boolean podeAtravessar();
    
    public abstract boolean podeSerAberto();
    
    public abstract boolean podeSerDestruido();
    
    public void setSimbolo(Character simbolo) {
        this.simbolo = simbolo;
    }
    
    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public String getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void abrir(Heroi aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
