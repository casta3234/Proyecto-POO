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
public class Pelota extends JLabel implements ActionListener {

    private Timer timer;
    private int x;
    private int y;
    private int anguloy;
    private int angulox;
    private Rectangle r;
    private int contador;

    public Pelota(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.angulox = 1 + (int) (Math.random() * 10) % 3;
        this.anguloy = 1 + (int) (Math.random() * 10) % 3;
        
        ImageIcon img = new ImageIcon("imagenes/Pelotas/pelota_3.png");
        setIcon(img);
        
        setSize(img.getIconWidth(), img.getIconHeight());
        setLocation(this.x, this.y);
        setVisible(true);
        
        this.r = new Rectangle(this.x, this.y, img.getIconWidth(), img.getIconHeight());
        
        this.timer = new Timer(5, (ActionListener) this);
        timer.start();
        
        this.contador = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.x -= this.angulox;
        this.y -= this.anguloy;
        r.setBounds(this.x, this.y, 25, 25);
        setLocation(this.x , this.y );
        if (y < 15 || y > 460) {
            this.anguloy = -this.anguloy;
        }
    }

    public void setAngulox(int angulox) {
        this.angulox = angulox;
    }

    public void setAnguloy(int anguloy) {
        this.anguloy = anguloy;
    }

    public int getAngulox() {
        return angulox;
    }

    public int getAnguloy() {
        return anguloy;
    }

    public void setx(int x) {
        this.x = x;
    }

    public int getx() {
        return x;
    }
    public void sety(int y) {
        this.y = y;
    }

    public int gety() {
        return y;
    }

    public Rectangle getR() {
        return r;
    }

    public int getDelay() {
        return this.timer.getDelay();
    }

    public void setDelay(int newTimer) {
        this.timer.setDelay(newTimer);
    }
    
    public void changePelota() {
        if (this.contador < 3) {
                this.contador++;
            } else {
                this.contador -= 2;
            }
            this.setIcon(new ImageIcon("imagenes/Pelotas/pelota_" + this.contador + ".png"));
    }
}