/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.*;

/*
 *
 * @author sebastian
 */
public class Pelota extends JLabel implements ActionListener {

    private int x;
    private int y;
    private int anguloy;
    private int angulox;
    private Rectangle r;
    private int contador;
    private int width, height;
    private int raqueta;

    public Pelota(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.angulox = 1 + (int) (Math.random() * 10) % 3;
        this.anguloy = 1 + (int) (Math.random() * 10) % 3;

        ImageIcon img = new ImageIcon("imagenes/Pelotas/pelota_3.png");
        this.setIcon(img);

        this.setSize(img.getIconWidth(), img.getIconHeight());
        this.setLocation(this.x, this.y);
        this.setVisible(true);

        this.width = img.getIconWidth();
        this.height = img.getIconHeight();
        this.r = new Rectangle(this.x, this.y, this.width, this.height);

        this.contador = 0;
        this.raqueta = 0;
    }

    public boolean intersectsVertical(Rectangle r) {
        int tw = this.r.width;
        int th = this.r.height;
        int rw = r.width;
        int rh = r.height;

        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.r.x - 2;
        int ty = this.r.y;
        int rx = r.x - 2;
        int ry = r.y;
        rw += rx + 2;
        rh += ry;
        tw += tx + 2;
        th += ty;

        if ((ty > ry && ty < rh) || (th > ry && th < rh)) {
            return ((tw > rx && tw < rw) || (tx > rx && tx < rw));
        }

        return false;
    }

    public boolean intersectsHorizontal(Rectangle r) {
        int tw = this.r.width;
        int th = this.r.height;
        int rw = r.width;
        int rh = r.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.r.x;
        int ty = this.r.y - 2;
        int rx = r.x;
        int ry = r.y - 2;
        rw += rx;
        rh += ry + 2;
        tw += tx;
        th += ty + 2;

        if ((tw > rx && tw < rw) || (tx > rx && tx < rw)) {
            return ((ty > ry && ty < rh) || (th > ry && th < rh));
        }

        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.x -= this.angulox;
        this.y -= this.anguloy;
        this.r = new Rectangle(this.x, this.y, this.width, this.height);
        this.setLocation(this.x, this.y);
        if (y < 15 || y > 460) {
            this.anguloy = -this.anguloy;
        }
    }

    public void setAngulox(int angulox) {
        this.angulox = angulox;
    }

    public void setAnguloy(int anguloy) {
        this.anguloy = anguloy;
    }

    public int getAngulox() {
        return angulox;
    }

    public int getAnguloy() {
        return anguloy;
    }

    public void setx(int x) {
        this.x = x;
    }

    public int getx() {
        return x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public int gety() {
        return y;
    }

    public Rectangle getR() {
        return r;
    }

    public int getRaqueta() {
        return raqueta;
    }

    public void setRaqueta(int raqueta) {
        this.raqueta = raqueta;
    }
    

    public void changePelota() {
        if (this.contador < 8) {
            this.contador++;
        } else {
            this.contador -= 7;
        }
        this.setIcon(new ImageIcon("imagenes/Pelotas/pelota_" + this.contador + ".png"));
    }
}
