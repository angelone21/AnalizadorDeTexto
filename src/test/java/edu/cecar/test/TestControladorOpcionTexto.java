/**
 * Clase: TestControladorOpcionTexto
 * 
 * @version: 0.1
 *  
 * @since: 24/08/2019
 * 
 * Fecha de Modificación:
 * 
 * @author: Vincenzo Angelone Salgado
 * 
 * Copyrigth: CECAR
 */

package edu.cecar.test;

import edu.cecar.controladores.ControladorOpcionesTexto;
import org.junit.Test;


public final class TestControladorOpcionTexto {
    
    @Test
    public void testOpcionSinOpcion(){
        ControladorOpcionesTexto controladorOpcionesTexto = new ControladorOpcionesTexto();
        controladorOpcionesTexto.mostrarContenido("archivoprueba.txt");
        controladorOpcionesTexto.opcionSinOpcion("archivoprueba.txt");
    }
    
    @Test
    public void testCadedaMasRepite(){
        ControladorOpcionesTexto controladorOpcionesTexto = new ControladorOpcionesTexto();
        controladorOpcionesTexto.cadenaMasRepite("ho", "archivoprueba.txt"); 
    }
    
    @Test
    public void testCadenaMasCorta(){
        ControladorOpcionesTexto controladorOpcionesTexto = new ControladorOpcionesTexto();
        controladorOpcionesTexto.cadenaMasCorta(3, "archivoprueba.txt");
    }
    
    @Test
    public void testCadenaMasLarga(){
        ControladorOpcionesTexto controladorOpcionesTexto = new ControladorOpcionesTexto();
        controladorOpcionesTexto.cadenaMasLarga(2, "archivoprueba.txt");
    }
    
    @Test
    public void testCadenaMasComun(){
        ControladorOpcionesTexto controladorOpcionesTexto = new ControladorOpcionesTexto();
        controladorOpcionesTexto.cadenaMasComun(2, "archivoprueba.txt"); 
    }
}
