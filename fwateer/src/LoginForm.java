
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class LoginForm extends JFrame {
    private Handle hd = new Handle();
    private JButton[]buttons=new JButton[6];
    private JPanel panel = new JPanel();
    public LoginForm(){
        setVisible(true);
        setSize(300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("برنامج مبيعات");
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        addButtons();
    }
    void addButtons(){
        for(int i=0;i<buttons.length;i++){
            buttons[i]=new JButton();
        }
        panel.setLayout(new GridLayout(6, 1, 0, 25));
        buttons[0].setText("العملاء");
        buttons[1].setText("المبيعات");
        buttons[2].setText("التحصيلات");
        buttons[3].setText("الخصومات");
        buttons[4].setText("التقارير");
        buttons[5].setText("الخروج");
        
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 30, 10, 30);
        panel.setBorder(emptyBorder);
        
        for(int i=0;i<buttons.length;i++){
            buttons[i].addActionListener(hd);
            buttons[i].setFont(new Font("Arial",Font.BOLD,20));
            panel.add(buttons[i]);
        }
        add(panel,BorderLayout.CENTER);
    }
    class Handle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton selected = (JButton)e.getSource();
            if(selected==buttons[0])
                new Agents();
            setVisible(false);
        }
        
    }
}
