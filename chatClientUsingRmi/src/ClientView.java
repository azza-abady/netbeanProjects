
import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azza
 */
public class ClientView extends javax.swing.JFrame implements ViewInterface {

    /**
     * Creates new form ClientView
     */
    ClientContoller _c;
    boolean flag = true;

    //   String message=new String();
    void setController(ClientContoller clientContoller) {
        _c = clientContoller;
    }

    public ClientView() {
        initComponents();
        //   message= inputTextArea.getText();
    }

    public void display(String msg) {

        //chatTextArea.getHighlighter().removeAllHighlights(); 
        chatTextArea.append(msg + "\n");
        inputTextArea.setText(" ");
    }

    private Highlighter.HighlightPainter painter;

    public void displayFile(  final byte[] file, final String fileName) {
        Thread th = new Thread(new Runnable() {

            @Override
            public void run() {
                chatTextArea.append(fileName +"  recived"+"\n");
                  int res=JOptionPane.showConfirmDialog(null,"Do you want to save file?","You Received a File: "+fileName,JOptionPane.YES_NO_CANCEL_OPTION);
        if(res==JOptionPane.YES_OPTION){
            JFileChooser jf = new JFileChooser();

            int retval = jf.showSaveDialog(ClientView.this);
            if (retval == JFileChooser.APPROVE_OPTION) {
                String path = jf.getSelectedFile().getPath();
                try {
                    FileOutputStream save = new FileOutputStream(path + fileName);

                    byte[] b = file;
                    save.write(b);
                    save.flush();
                    save.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }//To change body of generated methods, choose Tools | Templates.
            }
        });
        
th.start();
//        if (JOptionPane.showConfirmDialog(null, "Do you want to save file", "SAVE FILE",
//                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//            JFileChooser jf = new JFileChooser();
//
//            int retval = jf.showSaveDialog(ClientView.this);
//            if (retval == JFileChooser.APPROVE_OPTION) {
//                String path = jf.getSelectedFile().getPath();
//                try {
//                    FileOutputStream save = new FileOutputStream(path + fileName);
//
//                    byte[] b = file;
//                    save.write(b);
//                    save.flush();
//                    save.close();
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        } else {
//            dispose();
//        }
//        try {
//                 int fileLine=chatTextArea.getLineCount()-1;
//                painter=new DefaultHighlighter.DefaultHighlightPainter(Color.GRAY);
//                
//                chatTextArea.getHighlighter().addHighlight(chatTextArea.getLineStartOffset(fileLine), chatTextArea.getLineEndOffset(fileLine), painter);
//            } catch (BadLocationException ex) {
//                ex.printStackTrace();
//            }
//        int dialogButton = JOptionPane.YES_NO_OPTION;
//        int dialogResult = JOptionPane.showConfirmDialog(ClientView.this, "Would You Like to Save file?");
      

// String[]btn={"Yes","No"};
//   JOptionPane.showOptionDialog(ClientView.this,
//                            "Are you sure to confirm the action you've made?",
//                            "JOptionPane Demo",
//                            JOptionPane.YES_NO_OPTION,
//                            JOptionPane.OK_CANCEL_OPTION, // icon
//                            null,
//                            btn,
//                            "");
//        JFrame frame = new JFrame();
//        int response = JOptionPane.showConfirmDialog(frame, "Do you want to continue?", "Confirm",
//        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//    if (response == JOptionPane.NO_OPTION) {
//      System.out.println("No button clicked");
//    } else if (response == JOptionPane.YES_OPTION) {
//      System.out.println("Yes button clicked");
//    } else if (response == JOptionPane.CLOSED_OPTION) {
//      System.out.println("JOptionPane closed");
//    }
        //if (== JOptionPane.YES_OPTION) {
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chatScrollPane = new javax.swing.JScrollPane();
        chatTextArea = new javax.swing.JTextArea();
        inputScrollPane = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        sendFileButton = new javax.swing.JButton();
        reciveFileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chatTextArea.setEditable(false);
        chatTextArea.setColumns(20);
        chatTextArea.setRows(5);
        chatScrollPane.setViewportView(chatTextArea);

        inputTextArea.setColumns(20);
        inputTextArea.setRows(5);
        inputScrollPane.setViewportView(inputTextArea);
        inputTextArea.getAccessibleContext().setAccessibleName("");

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        sendFileButton.setText("send file");
        sendFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendFileButtonActionPerformed(evt);
            }
        });

        reciveFileButton.setText("recive file");
        reciveFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reciveFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(sendFileButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(reciveFileButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
                    .addComponent(chatScrollPane))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chatScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendFileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reciveFileButton))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        _c.getMsg(inputTextArea.getText());      // TODO add your handling code here:
    }//GEN-LAST:event_sendButtonActionPerformed
//byte[]b;
    private void sendFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendFileButtonActionPerformed

        // b=sendFile();
        Thread th=new Thread(new Runnable() {

            @Override
            public void run() {
                  JFileChooser jf = new JFileChooser();
        int retVal = jf.showOpenDialog(ClientView.this);
        if (retVal == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream file = null;
                String path = jf.getSelectedFile().getPath();
                String fileName = jf.getSelectedFile().getName();
                file = new FileInputStream(path);
                int size = file.available();
                byte[] fileSend = new byte[size];
                file.read(fileSend);
                _c.getFile(fileSend, fileName);
                file.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }//To change body of generated methods, choose Tools | Templates.
            }
        });
        th.start();
        
    }//GEN-LAST:event_sendFileButtonActionPerformed

    private void reciveFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reciveFileButtonActionPerformed
//        FormatDialog ff = new FormatDialog(this, true);
//
//        ff.setLocationRelativeTo(this);
//        ff.setVisible(true);
//        if (ff.apply) {
//            inputTextArea.setForeground(ff.curColor);
//            inputTextArea.setFont(ff.curFont);
        //saveFile(b);        // TODO add your handling code here:
    }//GEN-LAST:event_reciveFileButtonActionPerformed
    /*public byte[] sendFile(){
     byte[]fileSend = null;
     JFileChooser jf =new JFileChooser();
     int retval=jf.showOpenDialog(this);
     if(retval==JFileChooser.APPROVE_OPTION){
     FileInputStream file=null;
     try {
     String path=jf.getSelectedFile().getPath();
     String filename=jf.getSelectedFile().getName();
     file = new FileInputStream(path);
     int size = file.available();
     fileSend = new byte[size];
     file.read(fileSend);
               
     } catch (FileNotFoundException ex) {
     ex.printStackTrace();
     } catch (IOException ex) {
     ex.printStackTrace();
     } finally {
     try {
     file.close();
     } catch (IOException ex) {
     ex.printStackTrace();
     }
     }
     }
    
     return fileSend;
     }*/

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
     /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    /*        try {
     for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
     if ("Nimbus".equals(info.getName())) {
     javax.swing.UIManager.setLookAndFeel(info.getClassName());
     break;
     }
     }
     } catch (ClassNotFoundException ex) {
     java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (InstantiationException ex) {
     java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (IllegalAccessException ex) {
     java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
     java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }
     //</editor-fold>

     /* Create and display the form */
    /* java.awt.EventQueue.invokeLater(new Runnable() {
     public void run() {
     new ClientView().setVisible(true);
     }
     });
     }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane chatScrollPane;
    private javax.swing.JTextArea chatTextArea;
    private javax.swing.JScrollPane inputScrollPane;
    public javax.swing.JTextArea inputTextArea;
    private javax.swing.JButton reciveFileButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton sendFileButton;
    // End of variables declaration//GEN-END:variables
}
