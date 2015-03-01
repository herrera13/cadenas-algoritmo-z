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
    
    private void calcular() {
        
        extenderCaja(1, 1, 0);
        
        // límites iniciales de la Z-caja
        int r = z[1];
        int l = z[1] > 0 ? 1 : 0;
        
        for (int k = 2; k < cadena.length(); k++) {
            
            if (k > r) {
                
                extenderCaja(k, k, 0);
                
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
                    
                    extenderCaja(k, r + 1, moduloBeta + 1);
                 
                    l = k;
                    r = l + z[k] - 1;
                }
            }
        }
    }
    
    private void extenderCaja(int caja, int desdePosicion, int conPosicion) {
        
        for (int i = 0; coincide(desdePosicion + i, conPosicion + i); i++) {
            
            z[caja]++;
        }
    }
    private boolean coincide(int i, int j) {
        
        return i < cadena.length() && j < cadena.length() &&
               cadena.charAt(i) == cadena.charAt(j);
    }
}
