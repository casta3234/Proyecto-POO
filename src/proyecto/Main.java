/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author sebastian
 */
public class Main  {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("titulo");
        ventana.setSize(1000, 530);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        Tablero t = new Tablero(ventana, "imagenes/tablero_referencia.png","imagenes/raqueta_1.png","imagenes/raqueta_2.png");
        ventana.add(t);
        ventana.setVisible(true);
        //ventana.addMouseListener(r1);
//        if (p1.getR().intersects(r1.getR())) {
//            System.out.println("choco");
//            p1.setAngulox(-p1.getAngulox());
//        }

    }

}
