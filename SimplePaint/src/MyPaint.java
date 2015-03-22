/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.JColorChooser;


/**
 *
 * @author azza
 */
public class MyPaint extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public final static int LINE=0,FREEHAND=1,RECT=2,CIRCLE=3;
    Button rect,line,freeHand,circle;
    Button color;
    Checkbox fill;
    int currentChoose;
    int prevX, prevY;
  
    
   
    int x1,y1,x2,y2;
	boolean flag=false;
	Vector<Shapes>s;
	int count;
    public void init() {
        // TODO start asynchronous download of heavy resources
     
        setSize(350, 300);
        s=new Vector<Shapes>();
		count=0;
		this.addMouseMotionListener(new MyMouseListener());	
		this.addMouseListener(new MyMouseListener());
    }
   
    public void paint(Graphics g) {
        
        /*int width = getSize().width;//width of applet
        int height = getSize().height;//height of applet
        int toolsSpace=(height-56)/6;/*
        tools area and distance between every tool
        */
        // paint area
       /** g.setColor(Color.white);
        g.fillRect(3, 3, width-59, height-6);
        //Draw a 3-pixel border around the applet in gray.
        g.setColor(Color.gray);
        g.drawRect(0, 0, width-1, height-1);
        g.drawRect(1, 1, width-3, height-3);
        g.drawRect(2, 2, width-5, height-5);
        //Draw tools area
        g.fillRect(width-56, 0, 56, height);
        // draw raubber label
        g.setColor(Color.white);
        g.fillRect(width-53, height-53, 50, 50);
        g.setColor(Color.black);
        g.drawRect(width-53, height-53, 49, 49);
        Image im;
        im=getImage(getCodeBase(),"rubber.png");
	g.drawImage(im,width-52,height-52,48,48,this);
        //draw tools
        g.setColor(Color.black);
        g.drawRect(width-53, 3 + 0*toolsSpace, 50, toolsSpace-3);
        colorBtn.setLocation(width-53, 3+0*toolsSpace);
        colorBtn.setSize(50, toolsSpace-3);
        
        g.drawRect(width-53, 3 + 1*toolsSpace, 50, toolsSpace-3);
        fill.setLocation(width-53, 3 + 1*toolsSpace);
        fill.setSize( 50, toolsSpace-3);
        
        g.drawRect(width-53, 3 + 2*toolsSpace, 50, toolsSpace-3);
        
        g.drawOval(width-53, 3 + 3*toolsSpace, 50, toolsSpace-3);
        
        g.drawLine(width-53, 3 + 4*toolsSpace, width-3,(toolsSpace-3)+4*toolsSpace);
        
        g.drawRect(width-53, 3 + 5*toolsSpace, 50, toolsSpace-3);
        Image im1;
        im1=getImage(getCodeBase(),"pencil.jpg");
	g.drawImage(im1,width-52,(3+5*toolsSpace)-1,49,toolsSpace-2,this);
   
        //selection
        g.setColor(Color.white);
        g.drawRect(width-55, 1+currentChoose*toolsSpace, 53, toolsSpace);
        g.clearRect(width-54, 2+currentChoose*toolsSpace, 51, toolsSpace-2);*/
    }
    
  
    class MyMouseListener extends MouseAdapter{
		public void mouseDragged(MouseEvent e){
			
			if(flag){	
				
				x2=e.getX();
				
				y2=e.getY();
				repaint();
				}
				
				
			
		}
		public void mousePressed(MouseEvent e){
				
					
					x1=e.getX();
					
					y1=e.getY();	
				
				flag=true;
			
		
		}
		public void mouseReleased(MouseEvent e){
			
				//Shapes l =new Shapes();
				//l.setX1(x1);
				//l.setX2(x2);
				//l.setY1(y1);
				//l.setY2(y2);
				//s.add(l);	
				//flag=false;	
				//	count++;			
		
		}
	}
}
abstract class Shapes {
                protected int x1,x2,y1,y2;
		Graphics g ;
		abstract void draw();
}
class Rect extends Shapes{
        void setX1(int x){
        	
                    x1=x;
                }
		void setX2(int x){
			x2=x;
		}
		void setY1(int y){
			y1=y;
		}
		void setY2(int y){
			y2=y;
		}
		int getX1(){
			return x1;
		}
		int getX2(){
			return x2;
		}
		int getY1(){
			return y1;
		}
		int getY2(){
			return y2;
                        
}
                void draw(){
                g.drawRect(x1, y1, x2-x1, y2-y1);
                }
}
class Line extends Shapes{
    void setX1(int x){
        	
                    x1=x;
                }
		void setX2(int x){
			x2=x;
		}
		void setY1(int y){
			y1=y;
		}
		void setY2(int y){
			y2=y;
		}
		int getX1(){
			return x1;
		}
		int getX2(){
			return x2;
		}
		int getY1(){
			return y1;
		}
		int getY2(){
			return y2;
                        
}
                void draw(){
                g.drawLine(x1, y1, x2, y2);
                }
}
class Cirlce extends Shapes{

void setX1(int x){
        	
                    x1=x;
                }
		void setX2(int x){
			x2=x;
		}
		void setY1(int y){
			y1=y;
		}
		void setY2(int y){
			y2=y;
		}
		int getX1(){
			return x1;
		}
		int getX2(){
			return x2;
		}
		int getY1(){
			return y1;
		}
		int getY2(){
			return y2;
                        
}
                void draw(){
                g.drawOval(x1, y1, x2-x1, y2-y1);
                }
}