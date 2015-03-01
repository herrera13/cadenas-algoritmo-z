package ar.uba.fi.cadenas;

public class AlgoritmoZ {

    private String cadena;
    
    private int[] z;
    
    public AlgoritmoZ(String cadena) {

        this.cadena = cadena;

        if ((cadena != null) && (cadena.length() > 1)) {
         
            z = new int[cadena.length()];

            calcular();
        }
    }
    
    public int longitud() {
        
        return cadena.length();
    }

    public String cadena() {
        
        return cadena;
    }

    public int z(int i) {

        if ((i < 1) || (i >= cadena.length())) {
            
            throw new IllegalArgumentException("La posicion debe estar en [1.." + (cadena.length() - 1) + "] :" + i );
        }
        
        return z[i];
    }
    
    private int z1() {
        
        int k = 1;
        
        while ((k < cadena.length()) && 
               (cadena.charAt(k) == cadena.charAt(k - 1))) {
            
            k++;
        }
        
        return k - 1;
    }
    
    private void calcular() {
        
        this.z[1] = this.z1();
        
        // límites de la última z-caja
        int r = this.z(1);
        int l = 1;
        
        for (int k = 2; k < cadena.length(); k++) {
            
            if (k > r) {
                
                for (int i = k; i < cadena.length() && (cadena.charAt(i) == cadena.charAt(i - k)); i++) {
                    
                    z[k]++;
                }
                
                if (z[k] > 0) {
                    
                    r = k + z[k] - 1;
                    l = k;
                }
                
            } else {
                
                int moduloBeta = r - k + 1;

                if (z[k - l] < moduloBeta) {
                    
                    z[k] = z[k - l];
                    
                } else {
                    
                    z[k] = moduloBeta;
                    
                    for (int i = 1; coincide(r + i, moduloBeta + i); i++) {
                        
                        z[k]++;
                    }
                    
                    l = k;
                    r = l + z[k] - 1;
                }
            }
        }
    }
    
    private boolean coincide(int i, int j) {
        
        return i < cadena.length() && j < cadena.length() &&
               cadena.charAt(i) == cadena.charAt(j);
    }
}
