package ar.uba.fi.cadenas;

public class BuscarCoincidenciasConAlgoritmoZ {

    private String texto;
    private String patron;
    private int coincidencias;

    public String texto() {

        return this.texto;
    }

    public String patron() {

        return this.patron;
    }

    public BuscarCoincidenciasConAlgoritmoZ enTexto(String texto) {

        this.texto = texto;
        
        return this;
    }

    public BuscarCoincidenciasConAlgoritmoZ usandoPatron(String patron) {

        this.patron = patron;
        
        return this;
    }

    public void ejecutar() {
        
        AlgoritmoZ algoritmo = new AlgoritmoZ(patron + "$" + texto);

        coincidencias = 0;
        
        int longitudPatron = patron.length();
        
        for (int i = longitudPatron + 1; i < algoritmo.longitud(); i++) {
        
            if (algoritmo.z(i) == longitudPatron) {
                
                coincidencias++;
            }
        }
    }

    public boolean encontroCoincidencia() {
        
        return coincidencias > 0;
    }

    public int coincidencias() {

        return this.coincidencias;
    }

}
