package ar.uba.fi.cadenas;

import java.util.Arrays;
import java.util.Collection;

public class TestConParametros {

    protected static Object[] test(Object... parametros) {
        
        return parametros;
    }
    
    protected static Collection<Object[]> tests(Object[]... parametros) {
        
        return Arrays.asList(parametros);
    }
}
