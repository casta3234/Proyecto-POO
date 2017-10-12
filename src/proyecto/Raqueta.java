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
public class Raqueta extends JLabel implements KeyListener, ActionListener {

    private int x;
    private int y;
    private boolean lado;
    private Rectangle r;
    private int tecla;
    private Timer timer;
    private int largo;

    public Raqueta(String url, int x, int y, boolean l) {
        super();
        this.lado = l;
        this.x = x;
        this.y = y;
        ImageIcon i = new ImageIcon(url);
        setIcon(i);
        this.largo = i.getIconHeight();
        setSize(10, this.largo);
        this.r = new Rectangle(this.x, this.y, 10, this.largo);
        setLocation(this.x, this.y);
        setVisible(true);
        this.tecla = 0;
        this.timer = new Timer(4, (ActionListener) this);
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.tecla = e.getExtendedKeyCode();
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
        this.tecla = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.lado == true) {
            if (this.y > 9 && this.tecla == 87) {
                this.y--;
                
                setLocation(this.x, this.y);
                r.setLocation(this.x, this.y);

            }
            if ((this.y < (492 - this.largo)) && (this.tecla == 83)) {
                this.y++;
                
                setLocation(this.x, this.y);
                r.setLocation(this.x, this.y);

            }
        }
        if (this.lado == false) {
            if (this.y > 9 && this.tecla == 38) {
                this.y--;
               
                setLocation(this.x, this.y);
                r.setLocation(this.x, this.y);
            }
            if ((this.y < (492 - this.largo)) && (this.tecla == 40)) {
                this.y++;
               
                setLocation(this.x, this.y);
                r.setLocation(this.x, this.y);
            }
        }
    }
    
    public void setDelay(int newTimer) {
        this.timer.setDelay(newTimer);
    }
}
