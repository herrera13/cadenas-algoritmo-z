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
        
        /* límites derecho e izquierdo de la última Z-Caja identificada */
        int r = 0;
        int l = 0;
        
        for (int k = 1; k < cadena.length(); k++) {
            
            /* cadena[k] está dentro de una Z-Caja anterior? */
            if (k > r) {

                /* cadena[k] NO está dentro de una Z-Caja */
                extenderCaja(k, k, 0);
                
                if (z[k] > 0) {
                    
                    r = k + z[k] - 1;
                    l = k;
                }
                
            } else {
                
                /* cadena[k] forma parte de otra Z-Caja? */

                int distanciaK_R = r - k + 1;
                int kPrima = k - l;
                
                if (z[kPrima] < distanciaK_R) {
                    
                    /* la Z-Caja ya fue calculada */
                    
                    z[k] = z[kPrima];
                    
                } else {
                    
                    /* la Z-Caja puede más extensa */
                    
                    z[k] = distanciaK_R;
                    
                    extenderCaja(k, r + 1, distanciaK_R + 1);
                 
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
