package ar.uba.fi.cadenas;

public class AlgoritmoZ {

    private String cadena;
    
    private int[] z;

    public AlgoritmoZ(String cadena) {

        this.cadena = cadena;

        if ((this.cadena != null) && (this.cadena.length() > 1)) {
         
            this.z = new int[this.cadena.length() - 1];

            this.calcular();
        }
    }
    
    public int longitud() {
        
        return this.cadena.length();
    }

    public String cadena() {
        
        return this.cadena;
    }

    public int z(int i) {

        if ((i < 1) || (i >= this.longitud())) {
            
            throw new IllegalArgumentException("La posicion debe estar en [1.." + (this.longitud() - 1) + "] :" + i );
        }
        
        return this.z[i - 1];
    }
    
    private void z(int i, int valor) {
        
        this.z[i - 1] = valor;
    }
    
    private int z1() {
        
        int k = 1;
        
        while ((k < this.cadena.length()) && 
               (this.cadena.charAt(k) == this.cadena.charAt(k - 1))) {
            
            k++;
        }
        
        return k - 1;
    }

    private void calcular() {
        
        this.z(1, this.z1());
    }
}
