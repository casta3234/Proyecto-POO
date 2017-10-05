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

    private final Timer timer;
    private int x;
    private int y;
    private int anguloy;
    private int angulox;
    private Rectangle r;

    public Pelota(String url, int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.angulox = 1 + (int) (Math.random() * 10) % -10;
        this.anguloy = 1 + (int) (Math.random() * 10) % 10;
        this.r = new Rectangle(this.x, this.y, 25, 25);
        this.timer = new Timer(50, (ActionListener) this);
        setIcon(new ImageIcon(url));
        setSize(25, 25);
        setLocation(this.x, this.y);
        setVisible(true);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setLocation(this.x -= this.angulox, this.y -= this.anguloy);
        r.setBounds(this.x, this.y, 25, 25);
        if(y < 12 || y > 460){
            this.anguloy = -this.anguloy;
        }
    }

    public void setAngulox(int angulox) {
        this.angulox = angulox;
    }

    public int getAngulox() {
        return angulox;
    }

    public Rectangle getR() {
        return r;
    }

}