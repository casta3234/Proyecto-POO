/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Estudiante
 */
public class Bala extends Rectangle {

    public Bala(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    public void paint (Graphics g){
      g.drawRect(this.x, this.y, this.width, this.height);
    }
}
