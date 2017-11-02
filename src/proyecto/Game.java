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
public class Game extends JLabel{

    private JFrame ventana;
    private Menu m;
    private Tablero t;

    public Game() {
        this.ventana = new JFrame("Brick Game");
        this.ventana.setSize(1005, 530);
        this.ventana.setLayout(null);
        this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setResizable(false);
        
//        this.m = new Menu(ventana, "imagenes/Tableros/tablero_2.png");
//        this.ventana.add(m);
        
        this.t = new Tablero(ventana, "imagenes/Tableros/tablero_1.png", "imagenes/Raqueta1", "imagenes/Raqueta2");
        this.ventana.add(t);
        
        t.setVisible(true);
        
        this.ventana.setVisible(true);
    }
}
