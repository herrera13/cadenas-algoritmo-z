package ar.uba.fi.cadenas;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class TestBuscarCoincidenciasConAlgoritmoZ {

    private BuscarCoincidenciasConAlgoritmoZ buscar;

    @Before
    public void inicializar() {
     
        buscar = new BuscarCoincidenciasConAlgoritmoZ();
    }
    
    @Test
    public void construirSinParametros() {
        
        BuscarCoincidenciasConAlgoritmoZ buscar = new BuscarCoincidenciasConAlgoritmoZ();

        assertThat(buscar.texto(), is( nullValue( )));
        assertThat(buscar.patron(), is( nullValue( )));
    }

    @Test
    public void enTexto() {
        
        buscar.enTexto("Este es el texto");
        assertThat(buscar.texto(), is( equalTo( "Este es el texto" )));
    }
    
    @Test
    public void usandoPatron() {
        
        buscar.usandoPatron("Este es el patron");
        assertThat(buscar.patron(), is( equalTo( "Este es el patron" )));
    }
    
    @Test
    public void noEncuentraCoincidencias() {
        
        buscar.enTexto("un texto").usandoPatron("un patron").ejecutar();
        assertThat("no existe coincidencia", ! buscar.encontroCoincidencia());
    }
    
    @Test
    public void patronEsIgualAlTexto() {
        
        buscar.enTexto("casa").usandoPatron("casa").ejecutar();
        
        assertThat("existe coincidencia", buscar.encontroCoincidencia());
    }
    
    @Test
    public void patronEsPrefijoDelTexto() {
        
        buscar.enTexto("esta sobre la mesa").usandoPatron("esta").ejecutar();
        
        assertThat("existe coincidencia", buscar.encontroCoincidencia());
    }
    
    @Test
    public void patronEsSufijoDelTexto() {
        
        buscar.enTexto("falta poco para terminar").usandoPatron("terminar").ejecutar();
        
        assertThat("existe coincidencia", buscar.encontroCoincidencia());
    }
    
    @Test
    public void patronEstaEnMedioDelTexto() {
        
        buscar.enTexto("la puerta esta abierta").usandoPatron("puerta").ejecutar();
        
        assertThat("existe coincidencia", buscar.encontroCoincidencia());        
    }
    
    @Test
    public void patronEstaMultiplesVecesEnElTexto() {
        
        buscar.enTexto("una casa con una puerta y una ventana").usandoPatron("una").ejecutar();
        
        assertThat("existe coincidencia", buscar.encontroCoincidencia());
        assertThat(buscar.coincidencias(), is( equalTo( 3 )));
    }
}
