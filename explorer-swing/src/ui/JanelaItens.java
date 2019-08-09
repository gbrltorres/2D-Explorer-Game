package ui;

import javax.swing.DefaultListModel;
import model.Arma;
import model.Heroi;
import model.Item;
import model.PocaoCura;

public class JanelaItens extends javax.swing.JFrame {

    public JanelaItens(Heroi heroi, JogoDesenho jogoDesenho) {
        initComponents();
        this.heroi = heroi;
        init(jogoDesenho);
    }

    private JanelaItens() {
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listItens = new javax.swing.JList<>();
        btnUsar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bolsa Mágica");
        setResizable(false);

        jScrollPane1.setViewportView(listItens);

        btnUsar.setText("Usar");
        btnUsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUsar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnUsar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsarActionPerformed
        int index = listItens.getSelectedIndex();
        if(index != -1) {
           Item it = heroi.getBolsaMagica().get(index);
            if(!it.isDescartavel()) {
                heroi.trocarArma((Arma) it);
            }
            else
            {
                if(it.isDescartavel()) {
                    heroi.usarPocao((PocaoCura) it);
                    heroi.removerItem(it);
                }
            } 
            jogoDesenho.updateUI();
        }
        this.dispose();
    }//GEN-LAST:event_btnUsarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaItens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listItens;
    // End of variables declaration//GEN-END:variables

    private Heroi heroi;
    private JogoDesenho jogoDesenho;
    
    public void init(JogoDesenho jogoDesenho) {
        //this.setAlwaysOnTop(true);
        this.jogoDesenho = jogoDesenho;
        DefaultListModel dlm = new DefaultListModel();
        for(int i = 0; i < heroi.getBolsaMagica().size(); i++){
            dlm.addElement(heroi.getBolsaMagica().get(i).nome());
        }
        listItens.setModel(dlm);
    }
    
}
