/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.ImageIcon;
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
private int numero;
        
    public Bloque() {
        super();
        this.numero=(int) (2 * Math.random() + 1);
        ImageIcon img = new ImageIcon("imagenes/Bloques/bloque_"+ this.numero+".png");
        this.setIcon(img);
        this.setSize(img.getIconWidth(), img.getIconHeight());
        this.largo = img.getIconHeight();
        this.ancho = img.getIconWidth();
        this.x = (int) (400 * Math.random() + 300) - this.ancho;
        this.y = (int) (Math.random() * 475 + 15) - this.largo;
        this.setLocation(this.x, this.y);
        this.setVisible(true);
    }
 
}
