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
public class Menu extends JPanel implements MouseListener {

    private Image img;
    private boolean click;
    private JLabel boton;

    public Menu(JFrame v, String url) {
        super();
        this.setFocusable(true);

        this.img = new ImageIcon(url).getImage();
        this.click = false;

        this.setSize(v.getSize());
        this.setLocation(0,0);
        this.setLayout(null);
        this.setVisible(false);

        ImageIcon i = new ImageIcon("imagenes/Menu/carga.png");
        boton = new JLabel(i);
        boton.setSize(i.getIconWidth(), i.getIconHeight());
        boton.setLocation(500 - (84 / 2), 250 - (141 / 2));
        boton.setVisible(true);
        this.add(boton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.img, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if ((boton.getX() < x) && (boton.getX() + boton.getWidth() > x)
                && (boton.getY() < y) && (boton.getY() + boton.getHeight() > y)) {
            this.click = true;
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

    public boolean isC() {
        return click;
    }
}
