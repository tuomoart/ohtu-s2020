/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author tuomoart
 */
public class Summa implements Komento {
    private TextField tk;
    private TextField sk;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    
    public Summa(TextField tk, TextField sk, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tk=tk;
        this.sk=sk;
        this.nollaa=nollaa;
        this.undo=undo;
        this.sovellus=sovellus;
    }
    
    @Override
    public void suorita() {
        sovellus.plus(Integer.valueOf(sk.getText()));
        int tulos = sovellus.tulos();
        tk.setText(String.valueOf(tulos));
        sk.setText("");
        
        if (tulos==0) {
        nollaa.disableProperty().set(true);
        } else {
        nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }
    
    @Override
    public void peru() {
        sovellus.peru();
        int tulos = sovellus.tulos();
        
        tk.setText(String.valueOf(tulos));
        sk.setText("");
        
        if (tulos==0) {
        nollaa.disableProperty().set(true);
        } else {
        nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(true);
    }
    
}
