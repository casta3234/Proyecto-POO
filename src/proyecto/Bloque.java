/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Rectangle;
import javax.swing.*;

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
private int vida;
private Rectangle r;
private ImageIcon img;
        
    public Bloque(JPanel tablero) {
        super();
        this.vida = 1;
        this.numero=(int) (5 * Math.random() + 1);
        this.img = new ImageIcon("imagenes/Bloques/bloque_"+ this.numero+".png");       
        
        this.largo = img.getIconHeight();
        this.ancho = img.getIconWidth();
        this.x = (int) ((400 - this.ancho) * Math.random() + 300);
        this.y = (int) ((475 - this.largo) * Math.random() + 15);
        
        this.setLocation(this.x, this.y);
        this.setIcon(img);
        this.setSize(img.getIconWidth(), img.getIconHeight());
        this.setVisible(true);
        
        this.r = new Rectangle(this.x, this.y, this.ancho, this.largo);
    }

    public Rectangle getR() {
        return r;
    }
    public void MenosVida(){
        this.vida--;
    }

    public int getVida() {
        return vida;
    }
    
}