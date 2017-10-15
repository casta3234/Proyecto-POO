/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.*;
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
    

    public Raqueta(String url, int x, int y, boolean l, int largo) {
        super();
        this.lado = l;
        this.x = x;
        this.y = y;
        this.largo = 40 + (largo * 20);
        this.tecla = 0;
        
        setLayout(new BoxLayout((this), BoxLayout.Y_AXIS));
        setSize(10, this.largo);
        
        add(new JLabel(new ImageIcon(url + "/raquetaInicio.png")));
        for (int i = 0; i < largo; i++) {
            add(new JLabel(new ImageIcon(url + "/raquetaMedio.png")));
        }       
        add(new JLabel(new ImageIcon(url + "/raquetaFin.png")));
        
        setLocation(this.x, this.y);
        setVisible(true);
        this.r = new Rectangle(this.x, this.y, 10, this.largo);
        
        this.timer = new Timer(5, (ActionListener) this);
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
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.tecla = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movimiento(this.tecla);
    }
    
    private void movimiento (int numtecla) {
        if (this.lado == true) {
            if (this.y > 9 && numtecla == 87) {
                this.y -= 3;                
                setLocation(this.x, this.y);
                r.setLocation(this.x, this.y);
            }
            if ((this.y < (492 - this.largo)) && (numtecla == 83)) {
                this.y += 3;                
                setLocation(this.x, this.y);
                r.setLocation(this.x, this.y);
            }
        }
        if (this.lado == false) {
            if (this.y > 9 && numtecla == 38) {
                this.y -= 3;               
                setLocation(this.x, this.y);
                r.setLocation(this.x, this.y);
            }
            if ((this.y < (492 - this.largo)) && (numtecla == 40)) {
                this.y += 3;               
                setLocation(this.x, this.y);
                r.setLocation(this.x, this.y);
            }
        }
    }
    
    public void setDelay(int newTimer) {
        this.timer.setDelay(newTimer);
    }
}
