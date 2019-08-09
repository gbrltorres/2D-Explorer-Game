package ui;

import file.FileUtil;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import model.Heroi;
import model.Tabuleiro;

public class JogoJanela extends javax.swing.JFrame {

    public JogoJanela() throws IOException {
        initComponents();
        init();
        setTheme();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInfo = new javax.swing.JPanel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lblVida = new javax.swing.JLabel();
        lblArma = new javax.swing.JLabel();
        btnBolsa = new javax.swing.JButton();
        pnlJogo = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        itemInstrucao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GameBeta1.0");
        setBackground(new java.awt.Color(1, 1, 1));
        setResizable(false);

        pnlInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/heart.png"))); // NOI18N

        lbl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/sword.png"))); // NOI18N

        lblVida.setText("Vida");

        lblArma.setText("Arma");

        btnBolsa.setText("Bolsa Mágica");
        btnBolsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBolsaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblVida))
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(lbl3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblArma)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 476, Short.MAX_VALUE)
                .addComponent(btnBolsa, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBolsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVida)
                    .addComponent(lbl2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblArma)
                    .addComponent(lbl3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlJogo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlJogo.setLayout(new java.awt.CardLayout());

        jMenu.setText("Ajuda");

        itemInstrucao.setText("Instruções");
        itemInstrucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInstrucaoActionPerformed(evt);
            }
        });
        jMenu.add(itemInstrucao);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                    .addComponent(pnlInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemInstrucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInstrucaoActionPerformed
        JanelaInstrucao ji = new JanelaInstrucao();
        ji.setLocationRelativeTo(this);
        ji.setVisible(true);
    }//GEN-LAST:event_itemInstrucaoActionPerformed

    private void btnBolsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBolsaActionPerformed
        JanelaItens ji = new JanelaItens(heroi, jogoDesenho);
        ji.setLocationRelativeTo(this);
        ji.setVisible(true);
    }//GEN-LAST:event_btnBolsaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBolsa;
    private javax.swing.JMenuItem itemInstrucao;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lblArma;
    private javax.swing.JLabel lblVida;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlJogo;
    // End of variables declaration//GEN-END:variables

    private JogoDesenho jogoDesenho;
    private Heroi heroi;
    private Tabuleiro tabuleiro;
    
    
    public void setTheme() {
        try 
        {
            for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                
                if("GTK+".equals(info.getName())) {
                    
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            
        }
    }
    
    private void init() throws IOException {
        settings();
        jogoDesenho = new JogoDesenho(tabuleiro, heroi, lblVida, lblArma);
        pnlJogo.add(jogoDesenho);
        addKeyListener(jogoDesenho);
    }
        
    public void settings() throws IOException {
        this.setLocationRelativeTo(null);
        FileUtil fl = new FileUtil();
        int linha = fl.getLinha();
        int coluna = fl.getColuna();
        tabuleiro = new Tabuleiro(linha, coluna);
        fl.insereArquivo(tabuleiro);
        heroi = getHeroi(tabuleiro);
        lblVida.setText(Integer.toString(heroi.getQtdeVida()));
        lblArma.setText(heroi.getArmaAtual().nome());
        btnBolsa.setFocusable(false);
        
    }
    
    public static Heroi getHeroi(Tabuleiro tab){
        Heroi h = null;
        for (int i = 0; i < tab.getNumLinha(); i++) {
            for (int j = 0; j < tab.getNumColuna(); j++) {
                if(tab.getArea()[i][j] != null && tab.getArea()[i][j].getSimbolo() == '#'){
                    h = (Heroi) tab.getArea()[i][j];
                    break;
                }
            }
        }
        return h;
    }
}
