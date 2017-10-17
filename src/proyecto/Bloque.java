/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.JLabel;

/**
 *
 * @author Estudiante
 */
public class Bloque extends JLabel {
    
private int x;
private int y;
private int ancho;
private int largo;
private String url;
        
    public Bloque(String url) {
        super();
        this.x = (int) (700 * Math.random() + 300);
        this.y = (int) (Math.random() * 490 + 15);
    }
 
}
