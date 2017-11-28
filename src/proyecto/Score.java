/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Oscar Mancera
 */
public class Score {
    private int sc;
    private String nombre;
    private JLabel score;

    public Score(int sc, String nombre) {
        this.sc = sc;
        this.nombre = nombre;
        this.score = new JLabel(String.valueOf(sc));
    }
    
    public void addScore(String nombre, int sc){
      Score score = new Score(sc, nombre);
    }

   
    public int getSc() {
        return sc;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JLabel getScore() {
        return score;
    }

    public void setScore(JLabel score) {
        this.score = score;
    }

    
    
    
    
}
