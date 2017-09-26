/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import com.sun.java.accessibility.util.AWTEventMonitor;
import javax.swing.JFrame;

/**
 *
 * @author sebastian
 */
public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("titulo");
        ventana.setSize(1000, 530);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        Tablero t = new Tablero(ventana,"imagenes/tablero_referencia.png");
        ventana.add(t);
        Raqueta r1 = new Raqueta("imagenes/raqueta_1.png", 0, 180);
        Raqueta r2 = new Raqueta("imagenes/raqueta_2.png", 984, 180);
        Pelota p1 = new Pelota("imagenes/pelota_1.png",487,220);
        t.add(r1);
        t.add(r2);
        t.add(p1);
        ventana.addKeyListener(r1);
        ventana.addKeyListener(r2);
        ventana.setVisible(true);
    }
    
}
