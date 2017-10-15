/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.JFrame;

/**
 *
 * @author sebastian
 */
public class Main {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Brick Game");
        ventana.setSize(1000, 530);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        Tablero t = new Tablero(ventana, "imagenes/tablero_referencia.png", "imagenes/Raqueta1", "imagenes/Raqueta2");
        ventana.add(t);
        ventana.setVisible(true);
    }

}