/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
    private final int width;
    private ArrayList<Bloque> bloques;
    private final String url;

    public Tablero(JFrame v, String url, String urlR1, String urlR2) {
        super();
        this.url = url;
        this.width = v.getWidth();

        this.r1 = new Raqueta(urlR1, 0, 180, 1);
        this.r2 = new Raqueta(urlR2, 990, 180, 2);
        this.iniciar(v);
    }

    public Tablero(JFrame v, String url, String urlR1, String urlR2, boolean host, String ip, int puerto) {
        super();
        this.url = url;
        this.width = v.getWidth();

        if (host) {
            this.r1 = new Raqueta(urlR1, 0, 180, 1, ip, puerto);
            this.r2 = new Raqueta(urlR2, 990, 180, 2);
            //this.r2 = new Raqueta(urlR2, 990, 180, 2, ip, puerto);
        } else {
            this.r1 = new Raqueta(urlR1, 0, 180, 2, ip, puerto);
            this.r2 = new Raqueta(urlR2, 990, 180, 2);
            //this.r2 = new Raqueta(urlR2, 990, 180, 2, ip, puerto);
        }
        this.iniciar(v);
    }

    public void makeBloque() {
        Bloque newBloque = new Bloque(this);
        boolean libre = true;
        if (this.p.getR().intersects(newBloque.getR())) {
            libre = false;
        }
        for (Bloque b : this.bloques) {
            if (b.getR().intersects(newBloque.getR())) {
                libre = false;
            }
        }
        if (libre) {
            this.bloques.add(newBloque);
            for (Bloque b : this.bloques) {
                this.add(b);
                b.setVisible(false);
                b.setVisible(true);
            }

        } else {
            newBloque = null;
            System.gc();
        }
    }

    public void checkColision() {
        if (this.p.intersectsVertical(this.r1.getR())) {
            this.p.setAngulox(-this.p.getAngulox());
            if (this.timer.getDelay() > 2) {
                this.timer.setDelay(this.timer.getDelay() - 2);
            }
        } else if (this.p.intersectsHorizontal(this.r1.getR())) {
            this.p.setAnguloy(-this.p.getAnguloy());
            if (this.timer.getDelay() > 2) {
                this.timer.setDelay(this.timer.getDelay() - 2);
            }
        }

        if (this.p.intersectsVertical(this.r2.getR())) {
            this.p.setAngulox(-this.p.getAngulox());
            if (this.timer.getDelay() > 2) {
                this.timer.setDelay(this.timer.getDelay() - 2);
            }
        } else if (this.p.intersectsHorizontal(this.r2.getR())) {
            this.p.setAnguloy(-this.p.getAnguloy());
            if (this.timer.getDelay() > 2) {
                this.timer.setDelay(this.timer.getDelay() - 2);
            }
        }

        for (Bloque b : this.bloques) {
            if (this.p.intersectsVertical(b.getR())) {
                this.p.setAngulox(-this.p.getAngulox());
                b.MenosVida();
            } else if (this.p.intersectsHorizontal(b.getR())) {
                this.p.setAnguloy(-this.p.getAnguloy());
                b.MenosVida();
            }
        }
    }

    public void BorrarBloques() {
        Bloque b1 = null;
        for (Bloque b : this.bloques) {

            if (b.getVida() < 1) {
                b.setVisible(false);
                b1 = b;
            }
        }
        this.bloques.remove(b1);
        System.gc();
    }

    public void salida() {
        if (this.p.getx() < 0) {
            this.p.setx(this.width - this.r2.getWidth() - this.p.getWidth() - 10);
            this.p.sety(this.r2.getY() + (this.r2.getHeight() / 2) + 5);
            this.p.setAngulox(1 + (int) (Math.random() * 10) % 3);
            this.p.setAnguloy(1 + (int) (Math.random() * 10) % 3);
            this.timer.setDelay(10);
            this.timer.setDelay(10);
            this.p.changePelota();
        }

        if (this.p.getx() > 1010) {
            this.p.setx(this.r1.getWidth());
            this.p.sety(this.r1.getY() + (this.r1.getHeight() / 2) + 5);
            this.p.setAngulox(-1 * (1 + (int) (Math.random() * 10) % 3));
            this.p.setAnguloy(-1 * (1 + (int) (Math.random() * 10) % 3));
            this.timer.setDelay(10);
            this.timer.setDelay(10);
            this.p.changePelota();
        }
        this.r1.setVisible(false);
        this.r1.setVisible(true);
        this.r2.setVisible(false);
        this.r2.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.img, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.checkColision();
        this.salida();
//        this.BorrarBloques();       
//        if (this.bloques.size() < 10) {
//            this.makeBloque();
//        }
    }

    public final void iniciar(JFrame v) {
        this.setFocusable(true);
        this.bloques = new ArrayList<>();

        this.add(r1);
        this.add(r2);
        this.addKeyListener(r1);
        this.addKeyListener(r2);

        this.p = new Pelota(487, 220);
        this.add(p);

        ImageIcon i = new ImageIcon(url);
        this.img = i.getImage();
        this.setSize(v.getSize());
        this.setLocation(0, 0);
        this.setLayout(null);
        this.setVisible(false);

        this.timer = new Timer(10, this);
        this.timer.start();
        this.timer.addActionListener(p);
        this.r1.getTimer().start();
        this.r2.getTimer().start();
    }

    public Raqueta getR1() {
        return r1;
    }

    public Raqueta getR2() {
        return r2;
    }
}
