/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author sebastian
 */
public class Raqueta extends JLabel implements KeyListener, ActionListener {

    private int x;
    private int y;
    private int lado = 0;
    private Rectangle r;
    private int tecla;
    private final Set<Integer> pressed = new HashSet<>();
    private final int w = 87, s = 83, up = 38, down = 40;
    private Timer timer;
    private int largo;
    private String url;
    private ImageIcon inicio;
    private ImageIcon medio;
    private ImageIcon fin;
    private ServerSocket server;
    private java.net.Socket socket;
    private int host = 0;

    public Raqueta(String url, int x, int y, int l) {
        super();
        this.lado = l;
        this.x = x;
        this.y = y;
        this.largo = 3;
        this.tecla = 0;
        this.url = url;
        this.iniciar();
    }

    public Raqueta(int host, String ip, int puerto, String url, int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.largo = 3;
        this.tecla = 0;
        this.url = url;
        this.iniciar();
        this.host = host;

        if (this.host == 1) {
            try {
                this.server = new ServerSocket(puerto);
                this.socket = this.server.accept();
            } catch (IOException e) {
                System.out.println("Servidor no creado " + e.getMessage());
            }
        } else if (this.host == 2) {
            try {
                this.socket = new java.net.Socket(ip, puerto);
            } catch (IOException e) {
                System.out.println("Socket no creado " + e.getMessage());
            }
        }
    }

    public void movimiento() {
        if (this.lado == 1 || this.host == 1) {
            if (this.y > 9 && this.pressed.contains(this.w)) {
                this.y -= 3;
            }
            if ((this.y < (490 - (40 + (this.largo * 20))) && this.pressed.contains(this.s))) {
                this.y += 3;
            }
            this.setLocation(this.x, this.y);
            this.r.setLocation(this.x, this.y);
        }
        if (this.lado == 2 || this.host == 2) {
            if (this.y > 9 && this.pressed.contains(this.up)) {
                this.y -= 3;
            }
            if ((this.y < (490 - (40 + (this.largo * 20))) && this.pressed.contains(this.down))) {
                this.y += 3;
            }
            this.setLocation(this.x, this.y);
            this.r.setLocation(this.x, this.y);
        }
    }

    public void changeLargo(int aumento) {
        if ((this.largo + aumento >= 0) && (this.largo + aumento < 8)) {
            this.largo += aumento;

            this.setVisible(false);

            for (int i = 0; i < largo; i++) {
                this.medio = new ImageIcon(this.url + "/raquetaMedio.png");
                add(new JLabel(this.medio), i + 1);
            }

            this.fin = new ImageIcon(this.url + "/raquetaFin.png");
            this.add(new JLabel(this.fin), this.largo + 1);

            this.setSize(inicio.getIconWidth(), inicio.getIconHeight() * (this.largo + 2));
            this.setLocation(this.x, this.y);
            this.setVisible(true);

            this.r = new Rectangle(this.x, this.y, inicio.getIconWidth(), inicio.getIconHeight() * (this.largo + 2));
        }
    }

    public Rectangle getR() {
        return this.r;
    }

    public Timer getTimer() {
        return timer;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.pressed.add(e.getExtendedKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.pressed.remove(e.getExtendedKeyCode());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movimiento();
    }

    private void iniciar() {
        this.setLayout(new BoxLayout((this), BoxLayout.Y_AXIS));

        this.inicio = new ImageIcon(this.url + "/raquetaInicio.png");

        this.add(new JLabel(this.inicio), 0);

        for (int i = 0; i < largo; i++) {
            this.medio = new ImageIcon(this.url + "/raquetaMedio.png");
            this.add(new JLabel(this.medio), i + 1);
        }

        this.fin = new ImageIcon(this.url + "/raquetaFin.png");
        this.add(new JLabel(this.fin), this.largo + 1);

        this.setSize(inicio.getIconWidth(), inicio.getIconHeight() * (this.largo + 2));
        this.setLocation(this.x, this.y);
        this.setVisible(false);

        this.r = new Rectangle(this.x, this.y, inicio.getIconWidth(), inicio.getIconHeight() * (this.largo + 2));

        this.timer = new Timer(5, (ActionListener) this);
        this.timer.stop();
    }
}
