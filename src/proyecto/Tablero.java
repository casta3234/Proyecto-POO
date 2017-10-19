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
public class Tablero extends JPanel implements ActionListener {

    private Timer timer;
    private Image img;
    private Raqueta r1, r2;
    private Pelota p;
    private int width;

    public Tablero(JFrame v, String url, String urlR1, String urlR2) {
        super();        
        this.r1 = new Raqueta(urlR1, 0, 180, true);
        this.r2 = new Raqueta(urlR2, 984, 180, false);
        v.add(r1);
        v.add(r2);
        v.addKeyListener(r1);
        v.addKeyListener(r2);
        
        this.width = v.getWidth();
        
        this.p = new Pelota(487, 220);
        add(p);
                
        ImageIcon i = new ImageIcon(url);
        this.img = i.getImage();
        setSize(v.getSize());
        setLocation(0, 0);
        setLayout(null);
        setVisible(true);
        
        this.timer = new Timer(5, (ActionListener) this);
        this.timer.start();
        this.p.setDelay(this.timer.getDelay());
    }

    public void checkColision() {
        if (this.p.getR().intersects(this.r1.getR())) {
            this.p.setAngulox(-this.p.getAngulox());
            if (this.p.getDelay() > 2) {
                this.p.setDelay(this.p.getDelay() - 2);
                this.timer.setDelay(this.p.getDelay());
            }
        } else if (this.p.getR().intersects(this.r2.getR())) {
            this.p.setAngulox(-this.p.getAngulox());
            if (this.p.getDelay() > 2) {
                this.p.setDelay(this.p.getDelay() - 2);
                this.timer.setDelay(this.p.getDelay()); 
            }
        }
    }

    public void salida() {
        if (this.p.getx() < 0) {
            this.p.setx(this.r1.getWidth());
            this.p.sety(this.r1.getY() + (this.r1.getHeight()/2));
            this.p.setAngulox(-1 * (1 + (int) (Math.random() * 10) % 3));
            this.p.setAnguloy(-1 * (1 + (int) (Math.random() * 10) % 3));
            this.p.setDelay(10);
            this.timer.setDelay(10);
            this.p.changePelota();
            this.r1.changeLargo(-1);
            this.r2.changeLargo(1);
        }
        
        if(this.p.getx() > 1000){
            this.p.setx(this.width - this.r2.getWidth() - this.p.getWidth());
            this.p.sety(this.r2.getY() + (this.r2.getHeight()/2));
            this.p.setAngulox(1 + (int) (Math.random() * 10) % 3);
            this.p.setAnguloy(1 + (int) (Math.random() * 10) % 3);
            this.p.setDelay(10);
            this.timer.setDelay(10);
            this.p.changePelota();
            this.r2.changeLargo(-1);
            this.r1.changeLargo(1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.img, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkColision();
        salida();
    }
}
