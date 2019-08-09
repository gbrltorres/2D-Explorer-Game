
package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.*;


public class FileUtil {
    
    private String path = "insert path of res folder here";
    
    public int getLinha() throws FileNotFoundException, IOException{ //retorna o número de linhas do arquivo
        BufferedReader reader = new BufferedReader(new FileReader(path));
        int numLinha = 0;
        while (reader.readLine() != null){
            numLinha++; 
        }
        reader.close();
        return numLinha;
    }
    
    public int getColuna() throws FileNotFoundException, IOException{ //retorna o número de colunas do arquivo
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String linha = reader.readLine(); //atribuindo a primeira linha do arquivo em uma string 
        int numColuna = linha.length(); //usando a string para saber o número de colunas da matriz
        reader.close();
        return numColuna;
    }

    public int getQtdeBaus(Tabuleiro tabuleiro){
        int cont = 0;
        for(int i = 0; i < tabuleiro.getNumLinha(); i++)
        {
            for(int j = 0; j < tabuleiro.getNumColuna(); j++)
            {
                ElementoTabuleiro e = tabuleiro.getArea()[i][j];
                if(e.getSimbolo() == 'B')
                {
                    cont++;
                }
            }
        }
        return cont;
    }
    
    public void insereItens(Tabuleiro tabuleiro){
        List<Item> itens = new ArrayList<>();
        itens.add(new Arma("fogo", "Martelo de Guerra Daedrico"));
        itens.add(new Arma("terra", "Cajado de Druida Celestial"));
        itens.add(new Arma("ar", "Flauta dos Ciclones"));
        itens.add(new Arma("água", "Tridente de Aegir"));
        int q = itens.size();
        for(int i = 0; i < getQtdeBaus(tabuleiro) - q ; i++)
        {
            itens.add(new PocaoCura());
        }
        for(int i = 0; i < tabuleiro.getNumLinha(); i++)
        {
            for(int j = 0; j < tabuleiro.getNumColuna(); j++)
            {
                ElementoTabuleiro e = tabuleiro.getArea()[i][j]; 
                if(e.getSimbolo() == 'B')
                {
                   int num = new Random().nextInt(itens.size());
                   ((Bau) e).addItens(itens.get(num));
                   itens.remove(num);
                }
            }
        }
    }
    
    public void insereArquivo(Tabuleiro tabuleiro) throws FileNotFoundException, IOException{ //insere o arquivo em uma matriz de Object e retorna objeto 
        BufferedReader reader = new BufferedReader(new FileReader(path));              //da classe Tabuleiro que possui a matriz
        String linha = reader.readLine();  
        for(int i=0; i < getLinha(); i++)                  
        {                                                               
            for(int j=0; j < getColuna(); j++)
            {
                char c = linha.charAt(j); 
                switch (c)
                {
                    case 'W':
                        tabuleiro.getArea()[i][j] = new Tranca(c, i, j, "água");
                        tabuleiro.getPosTrancaAgua()[0] = i;
                        tabuleiro.getPosTrancaAgua()[1] = j;
                        break;
                    case 'E':
                        tabuleiro.getArea()[i][j] = new Tranca(c, i, j, "terra");
                        tabuleiro.getPosTrancaTerra()[0] = i;
                        tabuleiro.getPosTrancaTerra()[1] = j;
                        break;
                    case 'F':
                        tabuleiro.getArea()[i][j] = new Tranca(c, i, j, "fogo");
                        tabuleiro.getPosTrancaFogo()[0] = i;
                        tabuleiro.getPosTrancaFogo()[1] = j;
                        break;
                    case 'A':
                        tabuleiro.getArea()[i][j] = new Tranca(c, i, j, "ar");
                        tabuleiro.getPosTrancaAr()[0] = i;
                        tabuleiro.getPosTrancaAr()[1] = j;
                        break;
                    case 'R':
                        tabuleiro.getArea()[i][j] = new Rocha(c, i, j);
                        break;
                    case 'B':
                        tabuleiro.getArea()[i][j] = new Bau(c, i, j);
                        break;
                    case 'X':
                        tabuleiro.getArea()[i][j] = new BauExplosivo(c, i, j);
                        break;
                    case '*':
                        tabuleiro.getArea()[i][j] = new Parede(c, i, j);
                        break;
                    case 'T':
                        tabuleiro.getArea()[i][j] = new Teto(c, i, j);
                        break;
                    case '#':
                        tabuleiro.getArea()[i][j] = new Heroi(c, i, j);
                        break;
                    default:
                        tabuleiro.getArea()[i][j] = new Chao(i, j);
                        break;
                }
            }
            linha = reader.readLine();
        }
        reader.close();
        insereItens(tabuleiro);
    }
}
