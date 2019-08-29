/**
 * Clase: ControladorOpcionesTexto
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

package edu.cecar.controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class ControladorOpcionesTexto {
    
    public void mostrarContenido(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        FileReader lector = null;
        BufferedReader bf = null;
        try{
            lector = new FileReader(archivo);
            bf = new BufferedReader(lector);
        }catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo "+archivo.getName()+".");
        }
        try{
            String contenido;
            System.out.println("Contenido del archivo: ");
            while((contenido = bf.readLine())!=null){
                System.out.println(contenido);
            }
            lector.close();
        }catch(IOException e){
            System.err.println(e);
        }
    }
    
    public void opcionSinOpcion(String nombreArchivo){
        File archivo =  new File(nombreArchivo);
        FileReader lector;
        BufferedReader bf = null;
        
        try{
            lector = new FileReader(archivo);
            bf = new BufferedReader(lector);
            String contenido;
            String lineamaslarga="";
            while((contenido = bf.readLine())!=null){
                if(contenido.length() > lineamaslarga.length()){
                    lineamaslarga=contenido;
                }
            }
            System.out.print("Resultado: "+lineamaslarga);
            lector.close();
        }catch(IOException e){
            System.err.println(e);
        }
    }
    
    public void cadenaMasRepite(String cadena,String nombreArchivo){
        File archivo =  new File(nombreArchivo);
        FileReader lector;
        File archivo2 = new File("Nuevo_Archivo.txt");
        PrintWriter pw = null;
        BufferedReader bf = null;
        try{
            lector = new FileReader(archivo);
            bf = new BufferedReader(lector);
            pw = new PrintWriter(archivo2);
            String contenido;
            while((contenido = bf.readLine())!=null){
                StringTokenizer linea = new StringTokenizer(contenido);
                int contador = 0;
                while(linea.hasMoreTokens()){
                    if(linea.nextToken().equals(cadena)){
                        contador++;
                    }
                }
                pw.println(contador+" "+contenido);
            }
            pw.close();
        }catch(IOException e){
            System.err.println(e);
        }      
    }
    
    public void cadenaMasCorta(int entero,String nombreArchivo){
        File archivo =  new File(nombreArchivo);
        FileReader lector;
        BufferedReader bf = null;
        try{
            if(entero == 1){
            lector = new FileReader(archivo);
            bf = new BufferedReader(lector);
            String contenido;
            String lineamascorta= bf.readLine();
            while((contenido = bf.readLine())!=null){
                if(contenido.length() < lineamascorta.length()){
                    lineamascorta=contenido;
                }
            }
            System.out.print("Resultado: "+lineamascorta);
            lector.close();                
            }
            else{
            lector = new FileReader(archivo);
            bf = new BufferedReader(lector);
            String contenido;
            ArrayList<String> cadenas = new ArrayList<String>();
            while((contenido = bf.readLine())!=null){
                cadenas.add(contenido);
            }
            Collections.sort(cadenas, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length()-o2.length();
                }
            });
            System.out.print("Resultado: ");   
            for(int i = 0 ; i<entero;i++){
                System.out.print(cadenas.get(i)+" ");
            }
            lector.close();                
            }
        }catch(IOException e){
            System.err.println(e);
        }        
    }
    
    
    
    public void cadenaMasLarga(int entero,String nombreArchivo){
        File archivo =  new File(nombreArchivo);
        FileReader lector;
        BufferedReader bf = null;
        try{
            if(entero == 1){
            lector = new FileReader(archivo);
            bf = new BufferedReader(lector);
            String contenido;
            String lineamaslarga= bf.readLine();
            while((contenido = bf.readLine())!=null){
                if(contenido.length() > lineamaslarga.length()){
                    lineamaslarga=contenido;
                }
            }
            System.out.print("Resultado: "+lineamaslarga);
            lector.close();                
            }
            else{
            lector = new FileReader(archivo);
            bf = new BufferedReader(lector);
            String contenido;
            ArrayList<String> cadenas = new ArrayList<String>();
            while((contenido = bf.readLine())!=null){
                cadenas.add(contenido);
            }
            Collections.sort(cadenas, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.length()-o1.length();
                }
            });
            System.out.print("Resultado: ");   
            for(int i = 0 ; i<entero;i++){
                System.out.print(cadenas.get(i)+" ");
            }
            lector.close();                
            }
        }catch(IOException e){
            System.err.println(e);
        }        
    }

}
