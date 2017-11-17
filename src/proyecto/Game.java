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
 * @author Cristian Chitiva
 * @email cychitivav@unal.edu.co
 */
public class Game extends JFrame implements ActionListener {

    private Menu m;
    private Tablero t;
    private Timer timer;

    public Game(String nombre, String urlTableros, String urlMenu, String urlRaquetas) {
        this.setTitle(nombre);
        this.setSize(1005, 530);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.t = new Tablero(this, urlTableros + "tablero_1.png", urlRaquetas + "Raqueta1", urlRaquetas + "Raqueta2");
        this.add(t);

        this.m = new Menu(this, urlMenu + "tablero_2.png");
        this.add(m);
        this.m.setVisible(true);

        this.setVisible(false);

        this.addMouseListener(m);
        this.timer = new Timer(5, (ActionListener) this);
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if (this.m.isClick()) {
            this.m.setVisible(false);
            //this.m = null;
            this.t.setVisible(true);
            System.gc();
            //this.t.getTimer().start();
            this.timer.stop();
        //}
    }
}
