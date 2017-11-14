/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Graphics;
import java.awt.Image;
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

    public Menu(JFrame v, String url) {
        super();
        this.setFocusable(true);

        this.setSize(v.getSize());
        this.setLocation(0, 0);
        this.setLayout(null);
        this.setVisible(true);

        this.click = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.img, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.click = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.click = false;
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
}
