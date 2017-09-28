/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author sebastian
 */
public class Pelota extends JLabel implements ActionListener {

    private Timer timer;
    private int x;
    private int y;

    public Pelota(String url, int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.timer = new Timer(50, (ActionListener) this);
        setIcon(new ImageIcon(url));
        setSize(25, 25);
        setLocation(this.x, this.y);
        setVisible(true);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setLocation(this.x-=5, this.y+=2);
    }

}
