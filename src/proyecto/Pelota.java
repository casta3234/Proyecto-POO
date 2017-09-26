/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author sebastian
 */
public class Pelota extends JLabel{
    private int x;
    private int y;

    public Pelota(String url, int x, int y) {
        super();
        this.x = x;
        this.y = y;
        setIcon(new ImageIcon(url));
        setSize(25, 25);
        setLocation(this.x, this.y);
        setVisible(true);
    }


    
}
