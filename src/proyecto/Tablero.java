/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author sebastian
 */
public class Tablero extends JPanel implements ActionListener {

    private Timer timer;
    private Image img;
    private Raqueta r1, r2;
    private Pelota p;
    private final int width;
    private ArrayList<Bloque> bloque;
    private final String url;
    private JProgressBar timeBar;
    private int sc1 = 0;
    private int sc2 = 0;
    private JTextField score1;
    private JTextField score2;
    private int counter = 0;
    private int puntajeMayor;

    public Tablero(JFrame v, String url, String urlR) {
        super();
        this.url = url;
        this.width = v.getWidth();
        this.score1 = new JTextField("");
        this.score1.setBounds(0, 10, 30, 20);
        this.add(score1);
        this.score1.setFont(new Font("Monospaced", Font.BOLD, 15));
        this.score1.setText(String.valueOf(sc1));
        this.score1.setVisible(true);
        this.score2 = new JTextField("");
        this.score2.setBounds(970, 10, 30, 20);
        this.add(score2);
        this.score2.setFont(new Font("Monospaced", Font.BOLD, 15));
        this.score2.setText(String.valueOf(sc2));
        this.score2.setVisible(true);

        this.r1 = new Raqueta(urlR + "Raqueta1", 0, 180, 1);
        this.r2 = new Raqueta(urlR + "Raqueta2", 990, 180, 2);
        this.iniciar(v);
    }

    public Tablero(JFrame v, String url, String urlR, boolean host, String ip, int puerto) {
        super();
        this.url = url;
        this.width = v.getWidth();

        if (host) {
            this.r1 = new Raqueta(urlR + "Raqueta1", 0, 180, 1, ip, puerto);
            String ipSocket = this.r1.getIp();
            this.r2 = new Raqueta(urlR + "Raqueta2", 990, 180, 2, ipSocket, puerto + 1);
        } else {
            this.r1 = new Raqueta(urlR + "Raqueta1", 0, 180, 2, ip, puerto);
            this.r2 = new Raqueta(urlR + "Raqueta2", 990, 180, 1, ip, puerto + 1);
        }
        this.iniciar(v);
    }

    public void makeBloque() {
        Bloque newBloque = new Bloque(this);
        boolean libre = true;
        if (this.p.getR().intersects(newBloque.getR())) {
            libre = false;
        }
        for (Bloque b : this.bloque) {
            if (b.getR().intersects(newBloque.getR())) {
                libre = false;
            }
        }
        if (libre) {
            this.bloque.add(newBloque);
            for (Bloque b : this.bloque) {
                this.add(b);
                b.setVisible(false);
                b.setVisible(true);
            }

        } else {
            newBloque = null;
            System.gc();
        }
    }

    public void checkColision() {
        if (this.p.intersectsVertical(this.r1.getR())) {
            this.p.setAngulox(-this.p.getAngulox());
            this.p.setRaqueta(1);
            if (this.timer.getDelay() > 2) {
                this.timer.setDelay(this.timer.getDelay() - 2);
                counter++;
                this.timeBar.setValue(counter);
            }
            if (this.counter > 5) {
                counter++;
                this.timeBar.setValue(counter);
                JOptionPane.showMessageDialog(null, "Se acabo el tiempo. RONDA FINALIZADA!");
                if (this.puntajeMayor < sc1) {
                    if (sc1 < sc2) {
                        try {
                            File f = new File("text.txt");
                            PrintStream write = new PrintStream(f);
                            if (f.exists()) {
                                write.println(this.sc2);
                            } else {
                                FileWriter file = new FileWriter(f);
                                write.println(this.sc2);
                            }
                        } catch (IOException e) {
                        }
                    } else {
                        try {
                            File f = new File(url);
                            PrintStream write = new PrintStream(f);
                            if (f.exists()) {
                                write.println(this.sc1);
                            } else {
                                FileWriter file = new FileWriter(f);
                                write.println(this.sc1);
                            }
                        } catch (IOException e) {
                        }
                    }
                }
                if (this.puntajeMayor < sc2) {
                    if (sc2 < sc1) {
                        try {
                            File f = new File("text.txt");
                            PrintStream write = new PrintStream(f);
                            if (f.exists()) {
                                write.println(this.sc1);
                            } else {
                                FileWriter file = new FileWriter(f);
                                write.println(this.sc1);
                            }
                        } catch (IOException e) {
                        }
                    } else {
                        try {
                            File f = new File(url);
                            PrintStream write = new PrintStream(f);
                            if (f.exists()) {
                                write.println(this.sc2);
                            } else {
                                FileWriter file = new FileWriter(f);
                                write.println(this.sc2);
                            }
                        } catch (IOException e) {
                        }
                    }
                }
                this.timer.stop();
                this.r1.getTimer().stop();
                this.r2.getTimer().stop();
            }
        } else if (this.p.intersectsHorizontal(this.r1.getR())) {
            this.p.setAnguloy(-this.p.getAnguloy());
            this.p.setRaqueta(1);
        }

        if (this.p.intersectsVertical(this.r2.getR())) {
            this.p.setAngulox(-this.p.getAngulox());
            this.p.setRaqueta(2);
            if (this.timer.getDelay() > 2) {
                this.timer.setDelay(this.timer.getDelay() - 2);
                counter++;
                this.timeBar.setValue(counter);
            }
            if (this.counter > 75) {
                counter++;
                this.timeBar.setValue(counter);
                JOptionPane.showMessageDialog(null, "Se acabo el tiempo. RONDA FINALIZADA!");
                this.timer.stop();
                this.r1.getTimer().stop();
                this.r2.getTimer().stop();
            }
        } else if (this.p.intersectsHorizontal(this.r2.getR())) {
            this.p.setAnguloy(-this.p.getAnguloy());
            this.p.setRaqueta(2);
        }

        for (Bloque b : this.bloque) {
            if (this.p.intersectsVertical(b.getR())) {
                this.p.setAngulox(-this.p.getAngulox());
                b.MenosVida();
                break;
            } else if (this.p.intersectsHorizontal(b.getR())) {
                this.p.setAnguloy(-this.p.getAnguloy());
                b.MenosVida();
                break;
            }
        }
    }

    public void BorrarBloques() {
        int i = 0;
        Bloque b1 = null;
        for (Bloque b : this.bloque) {

            if (b.getVida() < 1) {
                b.setVisible(false);
                b1 = b;
                if (b.getNumero() == 2) {
                    if (this.p.getRaqueta() == 1) {
                        this.r1.changeLargo(1);
                    }
                    if (this.p.getRaqueta() == 2) {
                        this.r2.changeLargo(1);
                    }
                }
                if (this.p.getRaqueta() == 1) {
                    this.sc1++;
                }
                if (this.p.getRaqueta() == 2) {
                    this.sc2++;
                }

                break;
            }
        }
        this.bloque.remove(b1);
    }

    public void salida() {
        if (this.p.getx() < 0) {
            this.p.setx(this.width - this.r2.getWidth() - this.p.getWidth() - 10);
            this.p.sety(this.r2.getY() + (this.r2.getHeight() / 2) + 5);
            this.p.setAngulox(1 + (int) (Math.random() * 10) % 3);
            this.p.setAnguloy(1 + (int) (Math.random() * 10) % 3);
            this.timer.setDelay(10);
            this.timer.setDelay(10);
            this.p.changePelota();
            this.p.setRaqueta(2);
            this.r1.changeLargo(-1);
            this.sc2++;
        }

        if (this.p.getx() > 1010) {
            this.p.setx(this.r1.getWidth());
            this.p.sety(this.r1.getY() + (this.r1.getHeight() / 2) + 5);
            this.p.setAngulox(-1 * (1 + (int) (Math.random() * 10) % 3));
            this.p.setAnguloy(-1 * (1 + (int) (Math.random() * 10) % 3));
            this.timer.setDelay(10);
            this.timer.setDelay(10);
            this.p.changePelota();
            this.p.setRaqueta(1);
            this.r2.changeLargo(-1);
            this.sc1++;
        }
        this.r1.setVisible(false);
        this.r1.setVisible(true);
        this.r2.setVisible(false);
        this.r2.setVisible(true);
    }

    public void puntaje() {

       // this.score1.setText(String.valueOf(sc1));

       // this.score2.setText(String.valueOf(sc2));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.img, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.checkColision();
        this.BorrarBloques();
        this.salida();
        this.puntaje();
        if (this.bloque.size() < 10) {
            this.makeBloque();
        }
    }

    public final void iniciar(JFrame v) {
        File f = new File(url);
        Scanner in;
        if (f.exists()) {
            try {
                in = new Scanner(f);
                this.puntajeMayor = in.nextInt();
            } catch (IOException e) {
            }
        }
        this.setFocusable(true);
        this.bloque = new ArrayList<>();

        this.add(r1);
        this.add(r2);

        this.p = new Pelota(487, 220);
        this.add(p);

        ImageIcon i = new ImageIcon(url + "tablero_" + (int) (6 * Math.random()) + ".png");
        this.img = i.getImage();
        this.setSize(v.getSize());
        this.setLocation(0, 0);
        this.setLayout(null);
        this.setVisible(false);

        this.timer = new Timer(10, this);
        this.timer.start();
        this.timer.addActionListener(p);
        this.r1.getTimer().start();
        this.r2.getTimer().start();

        this.timeBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 5);
        this.add(timeBar);
        this.timeBar.setVisible(true);
        this.timeBar.setBounds(250, 10, 500, 10);

    }

    public Raqueta getR1() {
        return r1;
    }

    public Raqueta getR2() {
        return r2;
    }
}
