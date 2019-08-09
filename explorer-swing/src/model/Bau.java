/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class Bau extends ElementoTabuleiro {
    private List<Item> itens;
    private boolean podeExplodir;

    public Bau(Character simbolo, int i, int j) {
        this.simbolo = simbolo;
        linha = i;
        coluna = j;
        itens = new ArrayList<>();
        podeExplodir = false;
    }

    public Bau() {
        
    }
    
    public void abrir(Heroi heroi){
        heroi.getBolsaMagica().addAll(itens);
    }
    
    @Override
    public boolean podeAtravessar() {
        return false;
    }
    
    public List<Item> getItens() {
        return itens;
    }

    public void addItens(Item item) {
        this.itens.add(item);
    }

    @Override
    public boolean podeSerAberto() {
        return true;
    }
  
    public boolean podeExplodir() {
        return podeExplodir;
    }

    public void setPodeExplodir(boolean podeExplodir) {
        this.podeExplodir = podeExplodir;
    }

    @Override
    public boolean podeSerDestruido() {
        return false;
    }
}
