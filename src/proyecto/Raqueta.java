/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author sebastian
 */
public class Raqueta extends JLabel implements KeyListener {

    private int x;
    private int y;
    private int velocidad;
    private boolean lado;
    private Rectangle r;

    public Raqueta(String url, int x, int y, boolean l) {
        super();
        this.lado = l;
        this.x = x;
        this.y = y;
        this.velocidad = 10;
        this.r = new Rectangle(this.x, this.y, 10, 100);
        setIcon(new ImageIcon(url));
        setSize(10, 100);
        setLocation(this.x, this.y);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (this.lado == true) {
            if (y > 10 && e.getExtendedKeyCode() == KeyEvent.VK_W) {
                this.y--;
                this.y = this.y - this.velocidad;
                r.setLocation(this.x,this.y);
                setLocation(this.x, this.y);
            }
            if (y < 395 && e.getExtendedKeyCode() == KeyEvent.VK_S) {
                this.y++;
                this.y = this.y + this.velocidad;
                r.setLocation(this.x,this.y);
                setLocation(this.x, this.y);
            }
        }
        if (this.lado == false) {
            if (y > 10 && e.getExtendedKeyCode() == KeyEvent.VK_UP) {
                this.y--;
                this.y = this.y - this.velocidad;
                r.setLocation(this.x,this.y);
                setLocation(this.x, this.y);
              
            }
            if (y < 395 && e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
                this.y++;
                this.y = this.y + this.velocidad;
                r.setLocation(this.x,this.y);
                setLocation(this.x, this.y);
                
            }
        }

    }

    public Rectangle getR() {
        return r;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
