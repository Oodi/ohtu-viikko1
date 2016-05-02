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
public class Summa extends Komento{

    public Summa(Sovelluslogiikka l, JTextField t, JTextField s) {
        super(l, t, s);
    }
    
  
    @Override
    public void suorita() {
        s.plus(super.getArvo());
        super.paivita(s.tulos());
    }

    @Override
    public void peru() {
        s.miinus(super.getEdellinen());
        super.paivita(s.tulos());
    }
    
}
