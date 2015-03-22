
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.LOWER_RIGHT_CORNER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azza
 */
public class picturePreview extends javax.swing.JFrame {

    /**
     * Creates new form picturePreview
     */
    public picturePreview() {
        initComponents();
        JButton choos= new JButton("...");
        final JScrollPane js = new JScrollPane();
        js.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        js.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
        choos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            JFileChooser jf =new JFileChooser();
            MyFilterJBG filter = new MyFilterJBG();
            MyFileView view = new MyFileView();
            jf.setFileFilter(filter);
            jf.setFileView(view);
            jf.setAccessory(new ImagePreview(jf));
            int retval=jf.showSaveDialog(new picturePreview());
            if(retval==JFileChooser.APPROVE_OPTION){
                 JLabel setImg=new JLabel(new ImageIcon(jf.getSelectedFile().getPath()));
                
                 js.setViewportView(setImg);
                
                }   //To change body of generated methods, choose Tools | Templates.
            }
        });
       
        js.setCorner(LOWER_RIGHT_CORNER, choos);
        setLayout(new BorderLayout());
        this.add(js,"Center");
    }
    class MyFilterJBG extends FileFilter{
        public boolean accept(File f){
            if((f.getName().toLowerCase().endsWith(".jpg"))||(f.isDirectory()))
                return true;
            else 
                return false;
        }
        public  String getDescription(){
            return "Jbg Files (.jpg)";
        }
    }
    class MyFileView extends FileView{
        public Icon getIcon(File f){
            if((f.getName().toLowerCase().endsWith(".jpg"))){
                Image img= Toolkit.getDefaultToolkit().getImage("C:\\Users\\azza\\Pictures\\032.jpg").getScaledInstance(32,32,Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                return icon;
            }
            else
                return null;
        }
    }
   
    public class ImagePreview extends JComponent implements PropertyChangeListener
{
   final static int WIDTH = 150;
   final static int HEIGHT = 100;
   private ImageIcon icon;
   public ImagePreview(JFileChooser fc)
   {
      fc.addPropertyChangeListener(this);
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
   }
   @Override
   protected void paintComponent(Graphics g)
   {
      if (icon != null)
      {
         Graphics2D g2d = (Graphics2D) g;
         Rectangle bounds = new Rectangle(0, 0, icon.getIconWidth(),icon.getIconHeight());
         g.setColor(Color.white);
         g2d.fill(bounds);
         icon.paintIcon(this, g, 0, 0);
      }
   }
   @Override
   public void propertyChange(PropertyChangeEvent e)
   { 
      String propName = e.getPropertyName();            
      if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(propName))
      {
         icon = null;
         repaint();
         return;
      }                  
      if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(propName))
      {
         File file = (File) e.getNewValue();
         if (file == null)
         {
            icon = null;
            repaint();
            return;
         }
         icon = new ImageIcon(file.getPath());
         if (icon.getIconWidth() == -1)
         {
            icon.getImage().flush();
            icon = new ImageIcon(file.getPath());
         }
         if (icon.getIconWidth() > WIDTH)
            icon = new ImageIcon(icon.getImage().getScaledInstance (WIDTH, -1,
                                                          Image.SCALE_DEFAULT));
         repaint();
      }
   }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(picturePreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(picturePreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(picturePreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(picturePreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new picturePreview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
