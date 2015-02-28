package ar.uba.fi.cadenas;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class TestAlgoritmoZ {

    @Test
    public void crear() {
        
        AlgoritmoZ algoritmo = new AlgoritmoZ("Z Algorithm");

        assertThat(algoritmo.cadena(), is( equalTo( "Z Algorithm" )));
    }
    
    @Test
    public void crearConCadenaVacia() {
        
        AlgoritmoZ algoritmo = new AlgoritmoZ("");

        assertThat(algoritmo.longitud(), is( equalTo( 0 )));
        assertThat(algoritmo.cadena(), is( equalTo( "" )));
    }
    
    @Test
    public void crearConCadenaDeLongitud1() {
        
        AlgoritmoZ algoritmo = new AlgoritmoZ("a");
        
        assertThat(algoritmo.longitud(), is( equalTo( 1 )));
        assertThat(algoritmo.cadena(), is( equalTo( "a" )));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void zEn0GeneraExcepcion() {
        
        AlgoritmoZ algoritmo = new AlgoritmoZ("casa");
        
        algoritmo.z(0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void zFueraDelRango() {
        
        AlgoritmoZ algoritmo = new AlgoritmoZ("mesa");
        
        algoritmo.z(4);
    }
    
    @Test
    public void zEn1ConLogitud2() {
        
        AlgoritmoZ algoritmo = new AlgoritmoZ("aa");
        
        assertThat(algoritmo.z(1), is( equalTo( 1 )));
    }
    
    @Test
    public void zEn1ConLogintud5() {
        
        AlgoritmoZ algoritmo = new AlgoritmoZ("aaaaa");
        
        assertThat(algoritmo.z(1), is( equalTo( 4 )));
    }

    @Test
    public void zEn1ConLogintud7() {
        
        AlgoritmoZ algoritmo = new AlgoritmoZ("aaaaaax");
        
        assertThat(algoritmo.z(1), is( equalTo( 5 )));
    }
}
