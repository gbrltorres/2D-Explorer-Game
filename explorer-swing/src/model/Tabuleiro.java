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
public class Tabuleiro {
    private ElementoTabuleiro area[][];
    private int numLinha;
    private int numColuna;
    private int posTrancaAr[];
    private int posTrancaAgua[];
    private int posTrancaFogo[];
    private int posTrancaTerra[];
    
    public Tabuleiro(int numLinha, int numColuna) {

        this.numLinha = numLinha;
        this.numColuna = numColuna;
        area = new ElementoTabuleiro[numLinha][numColuna];
        posTrancaAr = new int [2];
        posTrancaAgua = new int [2];
        posTrancaFogo = new int [2];
        posTrancaTerra = new int [2];
    }
    
    public void imprimeTabuleiro() {
        for (int i = 0; i < numLinha; i++) {
            for (int j = 0; j < numColuna; j++) {
                if(area[i][j].getSimbolo() == 'B' || area[i][j].getSimbolo() == 'X')
                    System.out.print("? ");
                else
                    System.out.print(area[i][j].getSimbolo() + " "); //pegando o value do Object posicionado na matriz area posição ij
            }
            System.out.println();
        }
    }
    
    public ElementoTabuleiro[][] getArea() {
        return area;
    }

    public void setArea(ElementoTabuleiro[][] area) {
        this.area = area;
    }

    public int getNumLinha() {
        return numLinha;
    }

    public void setNumLinha(int numLinha) {
        this.numLinha = numLinha;
    }

    public int getNumColuna() {
        return numColuna;
    }

    public int[] getPosTrancaAr() {
        return posTrancaAr;
    }

    public int[] getPosTrancaAgua() {
        return posTrancaAgua;
    }

    public int[] getPosTrancaFogo() {
        return posTrancaFogo;
    }

    public int[] getPosTrancaTerra() {
        return posTrancaTerra;
    }

    
    public boolean verificaTranca() {
        return area[posTrancaAgua[0]][posTrancaAgua[1]].simbolo == ' ' && area[posTrancaAr[0]][posTrancaAr[1]].simbolo == ' ' && 
                area[posTrancaFogo[0]][posTrancaFogo[1]].simbolo == ' ' && area[posTrancaTerra[0]][posTrancaTerra[1]].simbolo == ' ';
    }
    
}
