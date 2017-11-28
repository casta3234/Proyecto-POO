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
 * @author Estudiante
 */
public class Menu extends JPanel implements MouseListener, ActionListener {

    private Image img;
    private Image reloj;
    private JLabel botonOff, botonOn, botonOpt;
    private final Timer timer;
    private double angulo;
    private int click;
    private boolean rotate;
    private String ip;
    private int puerto;
    private final String url;

    public Menu(JFrame v, String url) {
        super();
        this.setFocusable(true);
        this.url = url;
        this.img = new ImageIcon(url + "Fondo.png").getImage();
        this.reloj = new ImageIcon(url + "carga.png").getImage();
        this.angulo = 0.0;
        this.click = 0;
        this.rotate = false;

        this.setSize(v.getSize());
        this.setLocation(0, 0);
        this.setLayout(null);
        this.setVisible(false);

        ImageIcon iOff = new ImageIcon(url + "local.png");
        botonOff = new JLabel(iOff);
        botonOff.setSize(iOff.getIconWidth(), iOff.getIconHeight());
        botonOff.setLocation(500 - (iOff.getIconWidth() / 2), 100 - (83 / 2));
        botonOff.setVisible(true);
        this.add(botonOff);

        ImageIcon iOn = new ImageIcon(url + "online.png");
        botonOn = new JLabel(iOn);
        botonOn.setSize(iOn.getIconWidth(), iOn.getIconHeight());
        botonOn.setLocation(500 - (iOn.getIconWidth() / 2), 300 - (82 / 2));
        botonOn.setVisible(true);
        this.add(botonOn);
        
        ImageIcon opt = new ImageIcon(url + "gear.png");
        botonOpt = new JLabel(opt);
        botonOpt.setSize(opt.getIconWidth(), opt.getIconHeight());
        botonOpt.setLocation(950 - (opt.getIconWidth() / 2), 450 - (81 / 2));
        botonOpt.setVisible(true);
        this.add(botonOpt);

        this.timer = new Timer(250, this);
        this.timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (this.rotate) {
            botonOff.setVisible(false);
            botonOn.setVisible(false);
            botonOpt.setVisible(false);
            Graphics2D g2d = (Graphics2D) g;
            g.drawImage(this.img, 0, 0, null);
            g2d.rotate(this.angulo, 500, 250);
            g2d.drawImage(this.reloj, 500 - (84 / 2), 250 - (141 / 2), null);
        } else {
            botonOff.setVisible(true);
            botonOn.setVisible(true);
            botonOpt.setVisible(true);
            g.drawImage(this.img, 0, 0, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if ((botonOff.getX() < x) && (botonOff.getX() + botonOff.getWidth() > x)
                && (botonOff.getY() < y) && (botonOff.getY() + botonOff.getHeight() > y)) {
            this.click = 1;
        } else if ((botonOn.getX() < x) && (botonOn.getX() + botonOn.getWidth() > x)
                && (botonOn.getY() < y) && (botonOn.getY() + botonOn.getHeight() > y)) {
            this.click = 2;
        } else if ((botonOpt.getX() < x) && (botonOpt.getX() + botonOpt.getWidth() > x)
                && (botonOpt.getY() < y) && (botonOpt.getY() + botonOpt.getHeight() > y)) {
            this.click = 3;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.click == 1) {
            this.rotate = true;
            this.img = new ImageIcon(this.url + "letras.png").getImage();
            this.repaint();
            if (this.angulo > -((int) (300 * Math.random()))) {
                this.angulo -= 15;
            } else {
                this.timer.stop();
            }
        } else if (this.click == 2) {
            ImageIcon iOff = new ImageIcon(url + "Cliente.png");
            botonOff.setIcon(iOff);
            botonOff.setSize(iOff.getIconWidth(), iOff.getIconHeight());
            botonOff.setLocation(500 - (iOff.getIconWidth() / 2), 100 - (83 / 2));

            ImageIcon iOn = new ImageIcon(url + "Servidor.png");
            botonOn.setIcon(iOn);
            botonOn.setSize(iOn.getIconWidth(), iOn.getIconHeight());
            botonOn.setLocation(500 - (iOn.getIconWidth() / 2), 300 - (82 / 2));
            
            this.img = new ImageIcon(this.url + "conexion.png").getImage();
            this.rotate = true;
            this.repaint();
            this.timer.stop();
        } else if(this.click == 3){
            ImageIcon nombreUsuario = new ImageIcon(url + "");
            botonOff.setIcon(nombreUsuario);
            botonOff.setSize(nombreUsuario.getIconWidth(), nombreUsuario.getIconHeight());
            botonOff.setLocation(500 - (nombreUsuario.getIconWidth() / 2), 100 - (83 / 2));
            
            ImageIcon hScores = new ImageIcon(url + "leaderboardsComplex.png");
            botonOn.setIcon(hScores);
            botonOn.setSize(hScores.getIconWidth(), hScores.getIconHeight());
            botonOn.setLocation(500 - (hScores.getIconWidth() / 2), 300 - (82 / 2));
            
            ImageIcon regresar = new ImageIcon(url + "");
            botonOpt.setIcon(regresar);
            botonOpt.setSize(regresar.getIconWidth(), regresar.getIconHeight());
            botonOpt.setLocation(950 - (regresar.getIconWidth() / 2), 450 - (81 / 2));
            
            //this.img = new ImageIcon(this.url + "Fondo.png").getImage();
            this.rotate = true;
            this.repaint();
            this.timer.stop();
     }
    }

    public Timer getTimer() {
        return timer;
    }

    public int getClick() {
        return click;
    }
}
