package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.ElementoTabuleiro;
import model.Heroi;
import model.Tabuleiro;
import model.Tranca;

public class JogoDesenho extends JPanel implements KeyListener {
    
    private Tabuleiro tabuleiro;
    private Heroi heroi;
    private JLabel lblArma;
    private JLabel lblVida;
    private BufferedImage agua; 
    private BufferedImage ar;
    private BufferedImage fogo;
    private BufferedImage terra;
    private BufferedImage bau;
    private BufferedImage bonecoCosta;
    private BufferedImage bonecoFrente;
    private BufferedImage bonecoEsq;
    private BufferedImage bonecoDir;
    private BufferedImage parede;
    private BufferedImage chao;
    private BufferedImage pilar;
    private BufferedImage teto;
    private String path = "insert path of res folder here";
    
    public JogoDesenho(Tabuleiro tabuleiro, Heroi heroi, JLabel lblVida, JLabel lblArma) throws IOException {
        this.tabuleiro = tabuleiro;
        this.heroi = heroi;
        this.lblArma = lblArma;
        this.lblVida = lblVida;
        try
        {
            agua = ImageIO.read(new File(path+"agua.png"));
            ar = ImageIO.read(new File(path+"ar.png"));
            fogo = ImageIO.read(new File(path+"fogo.png"));
            terra = ImageIO.read(new File(path+"terra.png"));
            bau = ImageIO.read(new File(path+"bau1.png"));
            bonecoFrente = ImageIO.read(new File(path+"bonecobaixo.png"));
            bonecoCosta = ImageIO.read(new File(path+"bonecocima.png"));
            bonecoEsq = ImageIO.read(new File(path+"bonecoesq.png"));
            bonecoDir = ImageIO.read(new File(path+"bonecodir.png"));
            parede = ImageIO.read(new File(path+"parede.png"));
            chao = ImageIO.read(new File(path+"chao.png"));
            pilar = ImageIO.read(new File(path+"pilar.png"));
            teto = ImageIO.read(new File(path+"teto.png"));
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
            
    @Override
    public void paint(Graphics g) {  
        lblArma.setText(heroi.getArmaAtual().toString());
        lblVida.setText(Integer.toString(heroi.getQtdeVida()));
        Graphics2D g2d = (Graphics2D) g;
        
        int w = getWidth();
        int h = getHeight();
        
        int linha = tabuleiro.getNumLinha();
        int coluna = tabuleiro.getNumColuna();
        
        int cw = w / coluna;
        int ch = h / linha;
        
        for (int i = 0; i < linha; i++)
        {
            for (int j = 0; j < coluna; j++) 
            {
                switch (tabuleiro.getArea()[i][j].getSimbolo())
                {
                    case 'W':
                        g2d.drawImage(chao, j * cw, i * ch, null);
                        g2d.drawImage(agua, j * cw, i * ch, null);
                        break;
                    case 'E':
                        g2d.drawImage(chao, j * cw, i * ch, null);
                        g2d.drawImage(terra, j * cw, i * ch, null);
                        break;
                    case 'F':
                        g2d.drawImage(chao, j * cw, i * ch, null);
                        g2d.drawImage(fogo, j * cw, i * ch, null);
                        break;
                    case 'A':
                        g2d.drawImage(chao, j * cw, i * ch, null);
                        g2d.drawImage(ar, j * cw, i * ch, null);
                        break;
                    case 'R':
                        g2d.drawImage(chao, j * cw, i * ch, null);
                        g2d.drawImage(pilar, j * cw, i * ch, null);
                        break;
                    case 'B':
                        g2d.drawImage(chao, j * cw, i * ch, null);
                        g2d.drawImage(bau, j * cw, i * ch, null);
                        break;
                    case 'X':
                        g2d.drawImage(chao, j * cw, i * ch, null);
                        g2d.drawImage(bau, j * cw, i * ch, null);
                        break;
                    case '*':
                        g2d.drawImage(parede, j * cw, i * ch, null);
                        break;
                    case 'T':
                        g2d.drawImage(teto, j * cw, i * ch, null);
                        break;
                    case '#':
                        if(heroi.getDirecao().equals("cima")) {
                            g2d.drawImage(chao, j * cw, i * ch, null);
                            g2d.drawImage(bonecoCosta, j * cw, i * ch, null);
                        }
                        else
                        {
                            if(heroi.getDirecao().equals("baixo")) {
                                g2d.drawImage(chao, j * cw, i * ch, null);
                                g2d.drawImage(bonecoFrente, j * cw, i * ch, null);
                            }
                            else
                            {
                                if(heroi.getDirecao().equals("esquerda")) {
                                    g2d.drawImage(chao, j * cw, i * ch, null);
                                    g2d.drawImage(bonecoEsq, j * cw, i * ch, null);
                                }
                                else
                                {
                                    if(heroi.getDirecao().equals("direita")) {
                                        g2d.drawImage(chao, j * cw, i * ch, null);
                                        g2d.drawImage(bonecoDir, j * cw, i * ch, null);
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        g2d.drawImage(chao, j * cw, i * ch, null);
                        break;
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
        switch (ke.getKeyCode())
            {
                case KeyEvent.VK_A:
                    heroi.moverEsquerda(tabuleiro);
                    updateUI();
                    break;
                case KeyEvent.VK_D:
                    heroi.moverDireita(tabuleiro);
                    updateUI();
                    break;
                case KeyEvent.VK_W:
                    heroi.moverCima(tabuleiro);
                    updateUI();
                    break;
                case KeyEvent.VK_S:
                    heroi.moverBaixo(tabuleiro);
                    updateUI();
                    break;
                case KeyEvent.VK_E: 
                    heroi.abrirBau(tabuleiro);
                    updateUI();
                    if(heroi.getQtdeVida() <= 0) {
                        JOptionPane.showMessageDialog(this, "VOCÊ MORREU");
                        System.exit(0);
                    }
                    break;
                case KeyEvent.VK_C: 
                    heroi.atacar(tabuleiro);
                    updateUI();
                    if(tabuleiro.verificaTranca()) {
                        JOptionPane.showMessageDialog(this, "TODAS AS TRANCAS FORAM DESTRUÍDAS, VOCÊ VENCEU");
                        System.exit(0);
                    }
                    break;
                case KeyEvent.VK_X:
                    ElementoTabuleiro e = tabuleiro.getArea()[heroi.getLinha() - 1][heroi.getColuna()];
                    if(e instanceof Tranca && heroi.getDirecao().equals("cima")) {
                        JOptionPane.showMessageDialog(null, "Tranca elemental de "+e.getTipo());
                    }
            }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}    


