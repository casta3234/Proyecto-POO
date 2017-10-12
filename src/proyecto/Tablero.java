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
    private int count;

    public Tablero(JFrame v, String url, String urlR1, String urlR2) {
        super();
        this.r1 = new Raqueta(urlR1, 0, 180, true);
        this.r2 = new Raqueta(urlR2, 984, 180, false);
        add(r1);
        add(r2);
        v.addKeyListener(r1);
        v.addKeyListener(r2);
        this.p = new Pelota("imagenes/pelota_3.png", 487, 220);
        add(p);
        this.timer = new Timer(50, (ActionListener) this);
        ImageIcon i = new ImageIcon(url);
        this.img = i.getImage();
        setSize(v.getSize());
        setLocation(0, 0);
        setLayout(null);
        setVisible(true);
        this.timer.start();
        this.count = 0;
    }

    public void checkColision() {
        if (this.p.getR().intersects(this.r1.getR())) {
            this.p.setAngulox(-this.p.getAngulox());
            if (this.p.getDelay() > 30) {
                this.p.setDelay(this.p.getDelay() - 2);
                this.timer.setDelay(this.p.getDelay());
            }
        } else if (this.p.getR().intersects(this.r2.getR())) {
            this.p.setAngulox(-this.p.getAngulox());
            if (this.p.getDelay() > 30) {
                this.p.setDelay(this.p.getDelay() - 2);
                this.timer.setDelay(this.p.getDelay()); 
            }
        }
    }

    public void salida() {
        if ((this.p.getx() < -10) || (this.p.getx() > 1000)) {
            this.p.setx(487);
            this.p.sety(220);
            this.p.setAngulox(5 + (int) (Math.random() * 10) % -10);
            this.p.setAnguloy(5 + (int) (Math.random() * 10) % -10);
            this.p.setDelay(50);
            this.timer.setDelay(50);
            if (this.count < 3) {
                this.count++;
            } else {
                this.count -= 2;
            }
            this.p.setIcon(new ImageIcon("imagenes/pelota_" + this.count + ".png"));
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
