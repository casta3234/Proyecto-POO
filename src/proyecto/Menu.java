/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import javax.swing.*;

/**
 *
 * @author Estudiante
 */
public class Menu extends JPanel implements MouseListener, ActionListener {

    private Image imgMenu;
    private Image imgCarga;
    private Image reloj;
    private boolean click;
    private JLabel boton;
    private Timer timer;
    private double angulo;

    public Menu(JFrame v, String url) {
        super();
        this.setFocusable(true);

        this.imgMenu = new ImageIcon(url + "tablero_2.png").getImage();
        this.imgCarga = new ImageIcon(url + "letras.png").getImage();
        this.reloj = new ImageIcon(url + "carga.png").getImage();
        this.click = false;
        this.angulo = 0.0;

        this.setSize(v.getSize());
        this.setLocation(0, 0);
        this.setLayout(null);
        this.setVisible(false);

        ImageIcon i = new ImageIcon(url + "carga.png");
        boton = new JLabel(i);
        boton.setSize(i.getIconWidth(), i.getIconHeight());
        boton.setLocation(500 - (84 / 2), 250 - (141 / 2));
        boton.setVisible(true);
        this.add(boton);

        this.timer = new Timer(200, this);
        this.timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (this.click) {
            boton.setVisible(false);
            g.drawImage(this.imgCarga, 0, 0, null);
            Graphics2D g2d = (Graphics2D) g;
            g2d.rotate(this.angulo, 500, 250);
            g2d.drawImage(this.reloj, 500 - (84 / 2), 250 - (141 / 2), null);
        } else {
            g.drawImage(this.imgMenu, 0, 0, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if ((boton.getX() < x) && (boton.getX() + boton.getWidth() > x)
                && (boton.getY() < y) && (boton.getY() + boton.getHeight() > y)) {
            this.click = true;
        } else {
            this.click = false;
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

    public boolean isClick() {
        return click;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.click) {
            this.repaint();
            if (this.angulo > -330) {
                this.angulo -= 15;
            } else {
                this.timer.stop();
            }
        }
    }
}
