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
class Nollaa extends Komento {

    public Nollaa(Sovelluslogiikka l, JTextField t, JTextField s) {
        super(l, t, s);
    }

  

    @Override
    public void suorita() {
        s.nollaa();
        super.paivita(s.tulos());
    }

    @Override
    public void peru() {
        s.plus(super.getEdellinenTulos());
        super.paivita(s.tulos());
    }
    
}
