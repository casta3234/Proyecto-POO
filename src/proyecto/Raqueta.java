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
    private ImageIcon inicio;
    private ImageIcon medio;
    private ImageIcon fin;
    private ServerSocket server;
    private Socket socket;

    public Raqueta(String url, int x, int y, boolean l) {
        super();
        this.lado = l;
        this.x = x;
        this.y = y;
        this.largo = 3;
        this.tecla = 0;
        this.url = url;
        this.iniciar();
    }

    public Raqueta(boolean host, String ip, int puerto, String url, int x, int y, boolean l) {
        super();
        this.lado = l;
        this.x = x;
        this.y = y;
        this.largo = 3;
        this.tecla = 0;
        this.url = url;
        this.iniciar();

        if (host) {
            try {
                this.server = new ServerSocket(puerto);
                this.socket = this.server.accept();
            } catch (IOException e) {
                System.out.println("Servidor no creado " + e.getMessage());
            }
        } else {
            try {
                this.socket = new Socket(ip, puerto);
            } catch (IOException e) {
                System.out.println("Socket no creado " + e.getMessage());
            }
        }
    }

    public void movimiento() {
        if (this.lado == true) {
            if (this.y > 9 && tecla == 87) {
                this.y -= 3;
                this.setLocation(this.x, this.y);
                this.r.setLocation(this.x, this.y);
            }
            if ((this.y < (490 - (40 + (this.largo * 20)))) && (tecla == 83)) {
                this.y += 3;
                this.setLocation(this.x, this.y);
                this.r.setLocation(this.x, this.y);
            }
        }
        if (this.lado == false) {
            if (this.y > 9 && tecla == 38) {
                this.y -= 3;
                this.setLocation(this.x, this.y);
                this.r.setLocation(this.x, this.y);
            }
            if ((this.y < (490 - (40 + (this.largo * 20)))) && (tecla == 40)) {
                this.y += 3;
                this.setLocation(this.x, this.y);
                this.r.setLocation(this.x, this.y);
            }
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
        this.tecla = e.getExtendedKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.tecla = 0;
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
