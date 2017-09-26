/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sebastian
 */
public class Tablero extends JPanel {
    
    private Image img;
    
    public Tablero(JFrame v,String url){
        super();
        ImageIcon i = new ImageIcon(url);
        this.img = i.getImage();
        setSize(v.getSize());
        setLocation(0,0);
        setLayout(null);
        //setBackground(Color.red);
        setVisible(true);
        
    }
    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(this.img, 0, 0, null);
    }
}
