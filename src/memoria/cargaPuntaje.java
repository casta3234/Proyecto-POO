/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto.Score;

/**
 *
 * @author Oscar Mancera
 */
public class cargaPuntaje {
    private Score highscore;

    public cargaPuntaje(Score highscore) {
        this.highscore = new Score(0, null);
    }
    
    
    public void Cargar(String ruta){
        File lectura = new File(ruta);
        Scanner flujoEntrada = null;
        if(lectura.exists()){
            try{
                flujoEntrada = new Scanner(lectura);
                flujoEntrada.useDelimiter(",");
                String nombre = null;
                int puntaje = 0,pos=0;
                while(flujoEntrada.hasNext()){
                    pos = flujoEntrada.nextInt();
                    nombre = flujoEntrada.next().trim();
                    puntaje = flujoEntrada.nextInt();
                    
                    Score score = new Score(pos, nombre);

                }
            } catch (FileNotFoundException e){
                Logger.getLogger(cargaPuntaje.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
}
