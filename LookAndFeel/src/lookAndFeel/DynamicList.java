/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lookAndFeel;

/**
 *
 * @author azza
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;


/** 
 * Create a JList whose KeyListener adds/removes elements from
 * the lists DefaultListModel.
 */

public class DynamicList
{
    public static void main(String[] args) 
    {
	final DefaultListModel model = new DefaultListModel();

	KeyListener keyTypedListener = new KeyAdapter() {
	    public void keyTyped(KeyEvent e) {
		if ((e.getKeyChar() == '\b') && (model.getSize() > 0)) {
		    model.removeElementAt(model.getSize() - 1);
		}
		else if (e.getKeyChar() != '\b') {
		    model.addElement("Added " + e.getKeyChar());
		}
	    }
	};

	JList list = new JList(model);
	list.addKeyListener(keyTypedListener);
	
	JFrame frame = new JFrame("DefaultListModel JList Demo");

	WindowListener l = new WindowAdapter() {
	    public void windowClosing(WindowEvent e) { System.exit(0); }
	};
	frame.addWindowListener(l);
	
	JScrollPane scrollPane = new JScrollPane(list);
	scrollPane.setBorder(new TitledBorder("Type to add list elements, backspace to remove"));

	frame.getContentPane().add(scrollPane, BorderLayout.CENTER);	
	frame.pack();
	frame.setVisible(true);
    }

}
/*public class test {
    
}*/
