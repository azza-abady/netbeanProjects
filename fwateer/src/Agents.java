
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azza
 */
public class Agents extends JFrame {
    private JPanel infoPanel=new JPanel();//show data about clint
    private JPanel tranPanel=new JPanel();//add,save,new,delete
    private JPanel postionPanel=new JPanel();//next,prev,first,last
    private JPanel operationPanel=new JPanel();//exit,reset do operation
    
    private JTextField clientID =new JTextField(12);
    private JTextField clientName =new JTextField(12);
    private JDateChooser addDate =new JDateChooser();
    //transaction buttions
    private JButton newEntity = new JButton("جديد");
    private JButton save = new JButton("حفظ");
    private JButton delete = new JButton("حذف");
    private JButton search = new JButton("بحث");
    ///
    //postion Panel button
    private JButton first = new JButton("الأول");
    private JButton last = new JButton("الأخير");
    private JButton next = new JButton("التالي");
    private JButton previous = new JButton("السابق");
    //
    // operation panel buttons
    private JButton back = new JButton("العودة");
    private JButton exit = new JButton("الخروج");
    private JButton reset = new JButton("اعادة ضبط");
    private JButton sale = new JButton("اجراء صفقة مبيعات");
    private JButton collect = new JButton("اجراء عملية تحصيل");
    //
    Agents(){
        setVisible(true);
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("العملاء");
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e){
                infoPanel.setPreferredSize(new Dimension(getWidth()*80/100, getHeight()*40/100));
                postionPanel.setPreferredSize(new Dimension(getWidth()*80/100, getHeight()*20/100));
            }
        });
        InfoPanel();
        TranPanel();
        PostionPanel();
        OperationPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.HORIZONTAL;
        
        c.gridx=1;
        c.gridy=0;
        infoPanel.setPreferredSize(new Dimension(getWidth()*80/100, getHeight()*40/100));
        add(infoPanel,c);
        c.gridx=1;
        c.gridy=1;
        postionPanel.setPreferredSize(new Dimension(getWidth()*80/100, getHeight()*20/100));
        add(postionPanel,c);
        c.gridx=0;
        c.gridy=0;
        c.gridheight=2;
        add(tranPanel,c);
        c.gridx=0;
        c.gridy=2;
        c.gridwidth=2;
        add(operationPanel,c);
    }
    void InfoPanel(){
       infoPanel.setLayout(new GridBagLayout());
       
       Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
       Border titleBorder = BorderFactory.createTitledBorder(null,"بيانات العميل",
               TitledBorder.RIGHT,TitledBorder.DEFAULT_JUSTIFICATION,new Font("SansSerif",Font.BOLD,14));
       infoPanel.setBorder(BorderFactory.createCompoundBorder(titleBorder, emptyBorder));
       GridBagConstraints c = new GridBagConstraints();
       c.weightx=1;
       c.weighty=1;
       c.fill=GridBagConstraints.NONE;
       c.gridx=0;
       c.gridy=0;
       c.anchor=GridBagConstraints.CENTER;
       c.fill=GridBagConstraints.HORIZONTAL;
       infoPanel.add(clientID,c);
       c.gridx=1;
       c.gridy=0;
       c.anchor=GridBagConstraints.LINE_END;
       c.fill=GridBagConstraints.NONE;
       JLabel lb=new JLabel("رقم العميل");
       lb.setFont(new Font("SansSerif",Font.BOLD,14));
       infoPanel.add(lb,c);
       c.gridx=0;
       c.gridy=1;
       c.anchor=GridBagConstraints.CENTER;
       c.fill=GridBagConstraints.HORIZONTAL;
       infoPanel.add(clientName,c);
       c.gridx=1;
       c.gridy=1;
       c.anchor=GridBagConstraints.LINE_END;
       c.fill=GridBagConstraints.NONE;
       lb=new JLabel("اسم العميل");
       lb.setFont(new Font("SansSerif",Font.BOLD,14));
       infoPanel.add(lb,c);
       c.gridx=0;
       c.gridy=2;
       c.anchor=GridBagConstraints.CENTER;
       addDate.setDateFormatString("d/MM/YYYY");
       c.fill=GridBagConstraints.HORIZONTAL;
       infoPanel.add(addDate,c);
       c.fill=GridBagConstraints.NONE;
       c.gridx=1;
       c.gridy=2;
       c.anchor=GridBagConstraints.LINE_END;
       lb=new JLabel("تاريخ الأضافة");
       lb.setFont(new Font("SansSerif",Font.BOLD,14));
       infoPanel.add(lb,c); 
    }
    void TranPanel(){
        tranPanel.setLayout(new GridLayout(4, 1, 10, 10));
        Border emptyBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        Border titleBorder = BorderFactory.createTitledBorder("");
        tranPanel.setBorder(BorderFactory.createCompoundBorder(emptyBorder, titleBorder));
        newEntity.setFont(new Font("SansSerif",Font.BOLD,14));
        save.setFont(new Font("SansSerif",Font.BOLD,14));
        delete.setFont(new Font("SansSerif",Font.BOLD,14));
        search.setFont(new Font("SansSerif",Font.BOLD,14));

        tranPanel.add(newEntity);
        tranPanel.add(save);
        tranPanel.add(delete);
        tranPanel.add(search);
        
        
    }
    void PostionPanel(){
        postionPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        Border emptyBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        Border titleBorder = BorderFactory.createTitledBorder("");
        postionPanel.setBorder(BorderFactory.createCompoundBorder(emptyBorder, titleBorder));
        first.setFont(new Font("SansSerif",Font.BOLD,14));
        last.setFont(new Font("SansSerif",Font.BOLD,14));
        next.setFont(new Font("SansSerif",Font.BOLD,14));
        previous.setFont(new Font("SansSerif",Font.BOLD,14));

        postionPanel.add(first);
        postionPanel.add(last);
        postionPanel.add(next);
        postionPanel.add(previous);
        
    }
    void OperationPanel(){
        operationPanel.setLayout(new GridBagLayout());
       /* Border emptyBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        Border bevelBorder = BorderFactory.createLoweredBevelBorder();
        operationPanel.setBorder(BorderFactory.createCompoundBorder(bevelBorder, emptyBorder));*/
        back.setFont(new Font("SansSerif",Font.BOLD,16));
        exit.setFont(new Font("SansSerif",Font.BOLD,16));
        reset.setFont(new Font("SansSerif",Font.BOLD,16));
        sale.setFont(new Font("SansSerif",Font.BOLD,16));
        collect.setFont(new Font("SansSerif",Font.BOLD,16));

        GridBagConstraints c =new GridBagConstraints();
        c.weightx=1;
        c.weighty=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        
        c.gridx=0;
        c.gridy=0;
        operationPanel.add(back,c);
        
        c.gridx=1;
        c.gridy=0;
        operationPanel.add(exit,c);
        
        c.gridx=2;
        c.gridy=0;
        operationPanel.add(reset,c);
        
        c.gridx=0;
        c.gridy=1;
        operationPanel.add(sale,c);
        
        c.gridx=1;
        c.gridy=1;
        operationPanel.add(collect,c); 
    }
    public static void main(String [] args){
    new Agents();
    }
} 
