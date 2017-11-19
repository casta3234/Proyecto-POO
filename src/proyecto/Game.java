/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.*;

/**
 * @author Cristian Chitiva
 * @email cychitivav@unal.edu.co
 */
public class Game extends JFrame {

    private Menu m;
    private Tablero t;

    public Game(String nombre, String urlTableros, String urlMenu, String urlRaquetas) {
        this.setTitle(nombre);
        this.setSize(1005, 530);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.t = new Tablero(this, urlTableros + "tablero_1.png", urlRaquetas + "Raqueta1", urlRaquetas + "Raqueta2");
        this.add(t);
        t.setVisible(false);

        this.m = new Menu(this, urlMenu);
        this.add(m);
        this.t.setVisible(true);

        this.setVisible(false);

        this.addMouseListener(m);
    }
}
