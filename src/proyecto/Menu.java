/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Estudiante
 */
public class Menu extends JPanel {

    private Image img;

    public Menu(JFrame v, String url) {
        super();
        this.setFocusable(true);

        ImageIcon i = new ImageIcon(url);
        this.img = i.getImage();
        this.setSize(v.getSize());
        this.setLocation(0, 0);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.img, 0, 0, null);
    }
}
