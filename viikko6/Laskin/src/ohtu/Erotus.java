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
class Erotus extends Komento {

    public Erotus(Sovelluslogiikka l, JTextField t, JTextField s) {
        super(l, t, s);
    }

   

    @Override
    public void suorita() {
        s.miinus(super.getArvo());
        super.paivita(s.tulos());
    }

    @Override
    public void peru() {
        s.plus(super.getEdellinen());
        super.paivita(s.tulos());
    }
    
}
