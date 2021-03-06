/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Cristian Chitiva
 * @email cychitivav@unal.edu.co
 */
public class Game extends JFrame implements ActionListener {

    private Menu m;
    private Tablero t;
    private Timer timer;
    private String urlTableros, urlRaquetas;

    public Game(String nombre, String urlTableros, String urlMenu, String urlRaquetas) {
        this.setTitle(nombre);
        this.setSize(1005, 530);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.urlTableros = urlTableros;
        this.urlRaquetas = urlRaquetas;

        this.m = new Menu(this, urlMenu);
        this.add(m);

        this.setVisible(false);
        this.addMouseListener(m);

        this.timer = new Timer(200, this);
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.m.setVisible(true);
        if (!this.m.getTimer().isRunning()) {
            this.m.setVisible(false);
            switch (this.m.getClick()) {
                case 1:
                    this.t = new Tablero(this, urlTableros, urlRaquetas);
                    this.add(t);
                    this.addKeyListener(this.t.getR1());
                    this.addKeyListener(this.t.getR2());
                    this.t.setVisible(true);
                    this.timer.stop();
                    this.m = null;
                    System.gc();
                    break;
                case 2:
                    boolean provisional = true;
                    this.t = new Tablero(this, urlTableros, urlRaquetas, provisional, "168.176.37.187", 8000);
                    this.add(t);
                    if (provisional) {
                        this.addKeyListener(this.t.getR1());
                    } else {
                        this.addKeyListener(this.t.getR2());
                    }
                    this.t.setVisible(true);
                    this.timer.stop();
                    this.m = null;
                    System.gc();
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
    }
}
