/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lookAndFeel;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.seaglasslookandfeel.SeaGlassLookAndFeel;
import org.jdesktop.laffy.Laffy;


/**
 *
 * @author azza
 */
public class LookAndFeel extends javax.swing.JFrame {

    /**
     * Creates new form LookAndFeel
     */
    public LookAndFeel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Windowsbtn = new javax.swing.JButton();
        Motifbtn = new javax.swing.JButton();
        Metalbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Windowsbtn.setText("Windows");
        Windowsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WindowsbtnActionPerformed(evt);
            }
        });

        Motifbtn.setText("Motif");
        Motifbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MotifbtnActionPerformed(evt);
            }
        });

        Metalbtn.setText("Nimbus");
        Metalbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MetalbtnActionPerformed(evt);
            }
        });

        jButton1.setText("seaGlass");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Windowsbtn)
                        .addGap(37, 37, 37)
                        .addComponent(Motifbtn)
                        .addGap(28, 28, 28)
                        .addComponent(Metalbtn)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Windowsbtn)
                    .addComponent(Motifbtn)
                    .addComponent(Metalbtn))
                .addGap(44, 44, 44)
                .addComponent(jButton1)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WindowsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WindowsbtnActionPerformed
        com.sun.java.swing.plaf.windows.WindowsLookAndFeel lf = new com.sun.java.swing.plaf.windows.WindowsLookAndFeel ();
        try {
            UIManager.setLookAndFeel(lf);
             SwingUtilities.updateComponentTreeUI(this);
        }
         catch(Exception e){
             e.printStackTrace();
         }   
            // TODO add your handling code here:
    }//GEN-LAST:event_WindowsbtnActionPerformed

    private void MotifbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MotifbtnActionPerformed
        com.sun.java.swing.plaf.motif.MotifLookAndFeel lm=new com.sun.java.swing.plaf.motif.MotifLookAndFeel();
        try{
            UIManager.setLookAndFeel(lm);
        
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_MotifbtnActionPerformed

    private void MetalbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MetalbtnActionPerformed
        com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel ln=new com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel();
        try {
            UIManager.setLookAndFeel(ln);
            SwingUtilities.updateComponentTreeUI(this);
        }catch(Exception e){
        
            e.printStackTrace();
        }
        // TODO add your handling code here:
        
    }//GEN-LAST:event_MetalbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
com.seaglasslookandfeel.SeaGlassLookAndFeel l=new SeaGlassLookAndFeel();
try {
            UIManager.setLookAndFeel(l);
            SwingUtilities.updateComponentTreeUI(this);
        }catch(Exception e){
        
            e.printStackTrace();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(LookAndFeel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LookAndFeel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LookAndFeel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LookAndFeel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LookAndFeel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Metalbtn;
    private javax.swing.JButton Motifbtn;
    private javax.swing.JButton Windowsbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
