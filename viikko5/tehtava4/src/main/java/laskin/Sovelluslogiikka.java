package laskin;

public class Sovelluslogiikka {
    
    private int tulos;
    private int edellinen;
 
    public void plus(int luku) {
        paivita();
        tulos += luku;
    }
     
    public void miinus(int luku) {
        paivita();
        tulos -= luku;
    }
 
    public void nollaa() {
        paivita();
        tulos = 0;
    }
 
    public int tulos() {
        return tulos;
    }
    
    private void paivita() {
        edellinen = tulos;
    }
    
    public void peru() {
        this.tulos = edellinen;
    }
}