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
        timer.start();

    }

    public void checkColision() {
        if (this.p.getR().intersects(this.r1.getR())) {
            this.p.setAngulox(-(this.p.getAngulox() + 2));
        } else if (this.p.getR().intersects(this.r2.getR())) {
            this.p.setAngulox(-(this.p.getAngulox() - 2));
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.img, 0, 0, null);
        g.setColor(Color.black);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkColision();
    }
}
