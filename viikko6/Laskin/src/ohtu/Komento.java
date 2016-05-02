/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author Simo
 */
public abstract class Komento {

    protected Sovelluslogiikka s;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;
    private int edellinenTulos;

    public Komento(Sovelluslogiikka l, JTextField t, JTextField s) {
        this.s = l;
        this.tuloskentta = t;
        this.syotekentta = s;
        this.edellinen = 0;
        this.edellinenTulos = 0;
    }

    protected int getArvo() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
            
        } catch (NumberFormatException e) {
        }
        this.edellinen = arvo;
        return arvo;
    }
    
    protected void paivita(int t) {
        edellinenTulos = Integer.parseInt(tuloskentta.getText());
        tuloskentta.setText("" + t);
        syotekentta.setText("");
    }

    public int getEdellinen() {
        return edellinen;
    }

    public int getEdellinenTulos() {
        return edellinenTulos;
    }
    
    
    

    public abstract void suorita();

    public abstract void peru();

}
