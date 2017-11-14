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
        ventana.setSize(1005, 530);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);

        Tablero t = new Tablero(ventana, "imagenes/Tableros/tablero_1.png", "imagenes/Raqueta1", "imagenes/Raqueta2");
        ventana.add(t);

        t.setVisible(true);

        ventana.setVisible(true);
    }
}
