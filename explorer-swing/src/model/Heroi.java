/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class Heroi extends ElementoTabuleiro {
    private String nome;
    private int qtdeVida;
    private List<Item> bolsaMagica;
    private Arma armaAtual;
    private  String direcao;
    
    public Heroi(Character simbolo, int i, int j) throws IOException {
        nome = "";
        qtdeVida = 6;
        this.simbolo = simbolo;
        linha = i;
        coluna = j;
        direcao = "baixo";
        bolsaMagica = new ArrayList<>();
        armaAtual = new Arma("sem elemento", "Picareta");
        bolsaMagica.add(armaAtual);
    }
    
    public void mvAtaque(Tabuleiro tabuleiro, int l, int c)
    {
        ElementoTabuleiro e = tabuleiro.getArea()[l][c];
        if(e.podeSerDestruido()) 
        {
            if(e.getTipo().equals(armaAtual.getTipo())){
                tabuleiro.getArea()[l][c] = new Chao(l, c);
            }
        }
    }
    
    public void atacar(Tabuleiro tabuleiro) {
        int l = getLinha() - 1;
        int c = getColuna();
        mvAtaque(tabuleiro, l, c);
        l = getLinha() + 1;
        c = getColuna();
        mvAtaque(tabuleiro, l, c);
        l = getLinha();
        c = getColuna() - 1;
        mvAtaque(tabuleiro, l, c);
        l = getLinha();
        c = getColuna() + 1;
        mvAtaque(tabuleiro, l, c);
    }
    
    public void mvMover(Tabuleiro tabuleiro, int l, int c){
        if(l >= 0 && l <= tabuleiro.getNumLinha() && c >= 0 && c <= tabuleiro.getNumColuna()) { //verifica se movimento está dentro da matriz
            if(tabuleiro.getArea()[l][c].podeAtravessar())
            {
                tabuleiro.getArea()[this.getLinha()][this.getColuna()] = new Chao(this.getLinha(), this.getColuna());
                tabuleiro.getArea()[l][c] = this;
                setLinha(l);
                setColuna(c);
            }
        }
    }
    
    public void moverCima(Tabuleiro tabuleiro) {
        int l = getLinha() - 1;
        int c = getColuna();
        mvMover(tabuleiro, l, c);
        direcao = "cima";
    }
    
    public void moverBaixo(Tabuleiro tabuleiro) {
        int l = getLinha() + 1;
        int c = getColuna();
        mvMover(tabuleiro, l, c);
        direcao = "baixo";
    }
    
    public void moverEsquerda(Tabuleiro tabuleiro) {
        int l = getLinha();
        int c = getColuna() - 1;
        mvMover(tabuleiro, l, c);
        direcao = "esquerda";
    }
    
    public void moverDireita(Tabuleiro tabuleiro) {
        int l = getLinha();
        int c = getColuna() + 1;
        mvMover(tabuleiro, l, c);
        direcao = "direita";
    }
    
    public void mvAbrir(Tabuleiro tabuleiro, int l, int c){
        ElementoTabuleiro e = tabuleiro.getArea()[l][c];  //acima
        if(e.podeSerAberto()) { 
            e.abrir(this);
            tabuleiro.getArea()[l][c] = new Chao(l, c);
        }
    }
    
    public void abrirBau(Tabuleiro tabuleiro) {
        int l = getLinha() - 1;
        int c = getColuna();
        mvAbrir(tabuleiro, l, c);
        l = getLinha() + 1;
        c = getColuna();
        mvAbrir(tabuleiro, l, c);
        l = getLinha();
        c = getColuna() - 1;
        mvAbrir(tabuleiro, l, c);
        l = getLinha();
        c = getColuna() + 1;
        mvAbrir(tabuleiro, l, c);
    }
    
    public String listarItens() {
        String s = "";
        for(int i=0;  i < bolsaMagica.size(); i++ ) {
            s += bolsaMagica.get(i).nome()+"\n";
        }
        return s;
    }
    
    public boolean removerItem(Item item) {
        return bolsaMagica.remove(item);
    }
    
    public void trocarArma(Arma arma) {
        arma.usar(this);
    }

    public void usarPocao(PocaoCura pocao) {
        pocao.usar(this);
    }
    
    public String getNome() {
        return nome;
    }

    public int getQtdeVida() {
        return qtdeVida;
    }

    public void setQtdeVida(int qtdeVida) {
        this.qtdeVida = qtdeVida;
    }

    public Arma getArmaAtual() {
        return armaAtual;
    }

    public void setArmaAtual(Arma armaAtual) {
        this.armaAtual = armaAtual;
    }

    public List<Item> getBolsaMagica() {
        return bolsaMagica;
    }

    public void setBolsaMagica(List<Item> bolsaMagica) {
        this.bolsaMagica = bolsaMagica;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
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
