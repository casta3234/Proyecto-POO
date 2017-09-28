/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author sebastian
 */
public class Raqueta extends JLabel implements KeyListener{

    private int x;
    private int y;
    private int velocidad;

    public Raqueta(String url, int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.velocidad = 5;
        setIcon(new ImageIcon(url));
        setSize(10, 100);
        setLocation(this.x, this.y);
        setVisible(true);
    }
        @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if( y>10 && e.getExtendedKeyCode() == KeyEvent.VK_W){
             this.y--;          
             this.y= this.y-this.velocidad;
             setLocation(this.x,this.y);
         }
         if( y<395 && e.getExtendedKeyCode() == KeyEvent.VK_S){
            this.y++;            
             this.y= this.y+this.velocidad;
             setLocation(this.x,this.y);
         }
   
             
         
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
