/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Estudiante
 */
public class Game extends JLabel implements ActionListener {

    private JFrame ventana;
    private boolean cambio;
    private Menu m;
    private Tablero t;
    private Timer timer;

    public Game() {
        this.ventana = new JFrame("Brick Game");
        this.ventana.setSize(1005, 530);
        this.ventana.setLayout(null);
        this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setResizable(false);

        this.m = new Menu(ventana, "imagenes/Tableros/tablero_2.png");
        this.ventana.add(m);

        this.t = new Tablero(ventana, "imagenes/Tableros/tablero_1.png", "imagenes/Raqueta1", "imagenes/Raqueta2");
        this.ventana.add(t);

        this.addMouseListener(m);

        this.cambio = false;
        this.timer = new Timer(5, (ActionListener) this);
        this.timer.start();
        this.ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (m.isClick()) {
            this.m.setVisible(false);
            this.t.setVisible(true);
            this.timer.stop();
        }
    }
}
