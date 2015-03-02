package ar.uba.fi.cadenas;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestBuscarPatronEnTextoConAlgoritmoZ extends TestConParametros {

    private BuscarCoincidenciasConAlgoritmoZ buscar;
    private int coincidenciasEsperadas;
    
    public TestBuscarPatronEnTextoConAlgoritmoZ(String texto, String patron, int coincidencias) {
        
        buscar = new BuscarCoincidenciasConAlgoritmoZ().enTexto(texto).usandoPatron(patron);
        coincidenciasEsperadas = coincidencias;
    }
    
    @Test
    public void buscar() {
        
        buscar.ejecutar();
        
        assertThat("coincidencias", buscar.coincidencias(), is( equalTo( coincidenciasEsperadas )));
    }
    
    @Parameters(name = "{1} <-> {0}")
    public static Collection<Object[]> obtenerParametros() {

        return tests(
                    test("La Saga de la Fundaci�n", 
                         "Saga", 1),
                    test("La Saga de la Fundaci�n es una serie de por lo menos 16 libros de ciencia ficci�n",
                         "de", 3),
                    test("En la saga se aborda y desarrolla la primera y re�ida expansi�n humana en la Galaxia mediante la colonizaci�n de los primeros mundos espaciales.", 
                         "fundaci�n", 0),
                    test("En la saga se aborda y desarrolla la primera y re�ida expansi�n humana en la Galaxia mediante la colonizaci�n de los primeros mundos espaciales.", 
                         "me", 3),
                    test("En la saga se aborda y desarrolla la primera y re�ida expansi�n humana en la Galaxia mediante la colonizaci�n de los primeros mundos espaciales.", 
                         "la", 6),
                    test("En la saga se aborda y desarrolla la primera y re�ida expansi�n humana en la Galaxia mediante la colonizaci�n de los primeros mundos espaciales.", 
                         "m", 5),
                    test("La saga se cierra con un enlace entre el ciclo de los robots y el de la Fundaci�n propiamente dicha.",
                         "saga", 1) 
                );
    }
    
}
