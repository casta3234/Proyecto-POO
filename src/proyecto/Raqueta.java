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
    private String url;

    public Raqueta(String url, int x, int y, boolean l) {
        super();
        this.lado = l;
        this.x = x;
        this.y = y;
        this.largo = 3;
        this.tecla = 0;
        this.url = url;

        setLayout(new BoxLayout((this), BoxLayout.Y_AXIS));
        setSize(10, 40 + (this.largo * 20));

        add(new JLabel(new ImageIcon(this.url + "/raquetaInicio.png")));
        
        for (int i = 0; i < largo; i++) {
            add(new JLabel(new ImageIcon(this.url + "/raquetaMedio.png")));
        }
        
        add(new JLabel(new ImageIcon(this.url + "/raquetaFin.png")));

        setLocation(this.x, this.y);
        setVisible(true);

        this.r = new Rectangle(this.x, this.y, 10, 40 + (this.largo * 20));

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

    private void movimiento(int numtecla) {
        if (this.lado == true) {
            if (this.y > 9 && numtecla == 87) {
                this.y -= 3;
                setLocation(this.x, this.y);
                r.setLocation(this.x, this.y);
            }
            if ((this.y < (490 - (40 + (this.largo * 20)))) && (numtecla == 83)) {
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
            if ((this.y < (490 - (40 + (this.largo * 20)))) && (numtecla == 40)) {
                this.y += 3;
                setLocation(this.x, this.y);
                r.setLocation(this.x, this.y);
            }
        }
    }

    public void setDelay(int newTimer) {
        this.timer.setDelay(newTimer);
    }

    public void changeLargo(int aumento) {
        if ((this.largo + aumento >= 0) && (this.largo + aumento < 8)) {
            this.largo += aumento;
            
            setVisible(false);

            setSize(10, 40 + (this.largo * 20));

            for (int i = 0; i < this.largo; i++) {
                add(new JLabel(new ImageIcon(this.url + "/raquetaMedio.png")), i + 1);
            }

            add(new JLabel(new ImageIcon(this.url + "/raquetaFin.png")), this.largo + 1);

            setLocation(this.x, this.y);
            setVisible(true);
            this.r = new Rectangle(this.x, this.y, 10, 40 + (this.largo * 20));
        }
    }
}
