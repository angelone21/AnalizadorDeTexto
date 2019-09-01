/**
 * Clase: AnalizadorTexto
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

package edu.cecar.vistas;

import edu.cecar.controladores.ControladorOpcionesTexto;



public final class AnalizadorTexto {
    
    public static void main(String[] argumentos) {
        ControladorOpcionesTexto controladorOpcionesTexto = new ControladorOpcionesTexto();
        try{
            if(argumentos[0].equals("analizadorTexto") == false){
            System.out.println("Comando erroneo o incompleto");
        }
        else{
            if(argumentos[1].endsWith(".txt")==true){
                controladorOpcionesTexto.mostrarContenido(argumentos[1]);
                controladorOpcionesTexto.opcionSinOpcion(argumentos[1]);
            }
            else{
            for(int i = 1 ; i<argumentos.length;i++){
                switch(argumentos[i]){
                    case "-d":
                        try{
                            int entero = Integer.parseInt(argumentos[i+1]);
                            if(argumentos[i+2].endsWith(".txt") == true){
                                controladorOpcionesTexto.mostrarContenido(argumentos[i+2]);
                                controladorOpcionesTexto.cadenaMasComun(entero,argumentos[i+2]);                                    

                            }
                        }catch(NumberFormatException e){
                            if(argumentos[i+1].endsWith(".txt") == true){
                                controladorOpcionesTexto.mostrarContenido(argumentos[i+1]);
                                controladorOpcionesTexto.cadenaMasComun(1, argumentos[1+1]);
                            }
                            else{
                                System.out.println("Comando erroneo o incompleto");
                            }
                            
                        }
                        break;
                    case "-c":
                        if(argumentos[i+1].endsWith(".txt") == true){
                            System.out.println("Comando erroneo o incompleto");
                        }
                        else{
                            if(argumentos[i+2].endsWith(".txt") == true){
                                controladorOpcionesTexto.mostrarContenido(argumentos[i+2]);
                                controladorOpcionesTexto.cadenaMasRepite(argumentos[i+1], argumentos[i+2]);
 
                            }
                        }
                        break;
                    case "-l":
                        try{
                            int entero = Integer.parseInt(argumentos[i+1]);
                            if(argumentos[i+2].endsWith(".txt")==true){
                                controladorOpcionesTexto.mostrarContenido(argumentos[i+2]);
                                controladorOpcionesTexto.cadenaMasLarga(entero, argumentos[i+2]);
                            }
                        }catch(NumberFormatException e){
                            if(argumentos[i+1].endsWith(".txt")==true){
                                controladorOpcionesTexto.mostrarContenido(argumentos[i+1]);
                                controladorOpcionesTexto.cadenaMasLarga(1,argumentos[i+1]);
                            }
                            else{
                                System.out.println("Comando erroneo o incompleto");
                            }
                        }
                        break;
                    case "-s":
                        try{
                            int entero = Integer.parseInt(argumentos[i+1]);
                            if(argumentos[i+2].endsWith(".txt")==true){
                                controladorOpcionesTexto.mostrarContenido(argumentos[i+2]);
                                controladorOpcionesTexto.cadenaMasCorta(entero, argumentos[i+2]);
                            }
                        }catch(NumberFormatException e){
                            if(argumentos[i+1].endsWith(".txt")==true){
                                controladorOpcionesTexto.mostrarContenido(argumentos[i+1]);
                                controladorOpcionesTexto.cadenaMasCorta(1,argumentos[i+1]);
                            }
                            else{
                                System.out.println("Comando erroneo o incompleto");
                            }
                        }
                        break;
                }
            }                
            }
        }
            
            
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Comando erroneo o incompleto");
        }
    }

}
