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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class ControladorOpcionesTexto {

    public void mostrarContenido(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        FileReader lector = null;
        BufferedReader bf = null;
        try {
            lector = new FileReader(archivo);
            bf = new BufferedReader(lector);
            try {
                String contenido;
                System.out.println("Contenido del archivo: ");
                System.out.println();
                while ((contenido = bf.readLine()) != null) {
                    System.out.println(contenido);
                }
                System.out.println();
                lector.close();
            } catch (IOException e) {
                System.out.println("No se encontró el archivo " + archivo.getName() + ".");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo " + archivo.getName() + ".");
        }
    }

    public void opcionSinOpcion(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        FileReader lector;
        BufferedReader bf = null;

        try {
            lector = new FileReader(archivo);
            bf = new BufferedReader(lector);
            String contenido;
            String lineamaslarga = "";
            while ((contenido = bf.readLine()) != null) {
                if (contenido.length() > lineamaslarga.length()) {
                    lineamaslarga = contenido;
                }
            }
            System.out.print("Resultado: " + lineamaslarga);
            System.out.println();
            lector.close();
        } catch (IOException e) {

        }
    }

    public void cadenaMasRepite(String cadena, String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        FileReader lector;
        File archivo_resultado = new File("Archivo_resultado.txt");
        PrintWriter pw;
        BufferedReader bf;
        try {
            lector = new FileReader(archivo);
            bf = new BufferedReader(lector);
            pw = new PrintWriter(archivo_resultado);
            String contenido;
            String linea;
            while ((contenido = bf.readLine()) != null) {
                linea = contenido + "»";
                String cadenas[];
                cadenas = linea.split(cadena);
                pw.println(cadenas.length - 1 + " " + contenido);
            }
            lector.close();
            pw.close();
            lector = new FileReader(archivo_resultado);
            bf = new BufferedReader(lector);
            while ((contenido = bf.readLine()) != null) {
                System.out.println(contenido);
            }
            lector.close();
        } catch (IOException e) {

        }
    }

    public void cadenaMasCorta(int entero, String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        File archivo_resultado = new File("cadenaMasCorta.txt");
        FileReader lector;
        BufferedReader bf;
        PrintWriter pw;
        try {
            if (entero == 1) {
                lector = new FileReader(archivo);
                bf = new BufferedReader(lector);
                pw = new PrintWriter(archivo_resultado);
                String contenido;
                String lineamascorta = bf.readLine();
                while ((contenido = bf.readLine()) != null) {
                    if (contenido.length() < lineamascorta.length()) {
                        lineamascorta = contenido;
                    }
                }
                pw.println(lineamascorta);
                lector.close();
                pw.close();
                System.out.println("Archivo resultado: " + lineamascorta);
            } else {
                lector = new FileReader(archivo);
                bf = new BufferedReader(lector);
                pw = new PrintWriter(archivo_resultado);
                String contenido;
                ArrayList<String> cadenas = new ArrayList<String>();
                while ((contenido = bf.readLine()) != null) {
                    cadenas.add(contenido);
                }
                Collections.sort(cadenas, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.length() - o2.length();
                    }
                });
                System.out.println("Archivo resultado: ");
                try {
                    for (int i = 0; i < entero; i++) {
                        pw.println(cadenas.get(i));
                        System.out.println(cadenas.get(i));
                    }
                } catch (IndexOutOfBoundsException e) {

                }
                lector.close();
                pw.close();
            }
        } catch (IOException e) {

        }
    }

    public void cadenaMasLarga(int entero, String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        File archivo_resultado = new File("cadenaMasLarga.txt");
        FileReader lector;
        BufferedReader bf;
        PrintWriter pw;
        try {
            if (entero == 1) {
                lector = new FileReader(archivo);
                bf = new BufferedReader(lector);
                pw = new PrintWriter(archivo_resultado);
                String contenido;
                String lineamaslarga = bf.readLine();
                while ((contenido = bf.readLine()) != null) {
                    if (contenido.length() > lineamaslarga.length()) {
                        lineamaslarga = contenido;
                    }
                }
                pw.println(lineamaslarga);
                lector.close();
                pw.close();
                System.out.println("Archivo resultado: " + lineamaslarga);
            } else {
                lector = new FileReader(archivo);
                bf = new BufferedReader(lector);
                pw = new PrintWriter(archivo_resultado);
                String contenido;
                ArrayList<String> cadenas = new ArrayList<String>();
                while ((contenido = bf.readLine()) != null) {
                    cadenas.add(contenido);
                }
                Collections.sort(cadenas, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.length() - o1.length();
                    }
                });
                System.out.println("Archivo resultado: ");
                try {
                    for (int i = 0; i < entero; i++) {
                        pw.println(cadenas.get(i));
                        System.out.println(cadenas.get(i));
                    }
                } catch (IndexOutOfBoundsException e) {

                }
                lector.close();
                pw.close();
            }
        } catch (IOException e) {
        }
    }

    public void cadenaMasComun(int entero, String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        FileReader lector;
        BufferedReader bf;
        try {
            if (entero == 1) {
                lector = new FileReader(archivo);
                bf = new BufferedReader(lector);
                String contenido;
                HashMap<String, Integer> palabras = new HashMap<>();
                while ((contenido = bf.readLine()) != null) {
                    String[] linea = contenido.split(" ");
                    for (String linea1 : linea) {
                        if (palabras.containsKey(linea1) == true) {
                            palabras.replace(linea1, palabras.get(linea1), palabras.get(linea1) + 1);
                        } else {
                            palabras.put(linea1, 1);
                        }
                    }
                }
                LinkedHashMap<String, Integer> mapaOrdenado = new LinkedHashMap<>();
                ArrayList<String> lista = new ArrayList<>();
                for (Map.Entry<String, Integer> entrada : palabras.entrySet()) {
                    lista.add(entrada.getValue().toString());
                }
                Collections.sort(lista, new Comparator<String>() {
                    @Override
                    public int compare(String str, String str1) {
                        return Integer.parseInt(str1) - Integer.parseInt(str);
                    }
                });
                for (String str : lista) {
                    for (Entry<String, Integer> entry : palabras.entrySet()) {
                        if (entry.getValue() == (Integer.parseInt(str))) {
                            mapaOrdenado.put(entry.getKey(), Integer.parseInt(str));
                        }
                    }
                }
                System.out.println("");
                System.out.print("Resultado: ");
                Iterator iterator = mapaOrdenado.keySet().iterator();
                while (iterator.hasNext()) {
                    Object clave = iterator.next();
                    System.out.println(clave);
                    break;
                }
                System.out.println();
            } else {
                lector = new FileReader(archivo);
                bf = new BufferedReader(lector);
                String contenido;
                HashMap<String, Integer> palabras = new HashMap<String, Integer>();
                while ((contenido = bf.readLine()) != null) {
                    String[] linea = contenido.split(" ");
                    for (String linea1 : linea) {
                        if (palabras.containsKey(linea1.toString()) == true) {
                            palabras.replace(linea1.toString(), palabras.get(linea1.toString()), palabras.get(linea1.toString()) + 1);
                        } else {
                            palabras.put(linea1.toString(), 1);
                        }
                    }
                }
                LinkedHashMap<String, Integer> mapaOrdenado = new LinkedHashMap<>();
                ArrayList<String> lista = new ArrayList<>();
                for (Map.Entry<String, Integer> entry : palabras.entrySet()) {
                    lista.add(entry.getValue().toString());
                }
                Collections.sort(lista, new Comparator<String>() {
                    @Override
                    public int compare(String str, String str1) {
                        return Integer.parseInt(str1) - Integer.parseInt(str);
                    }
                });
                for (String str : lista) {
                    for (Entry<String, Integer> entry : palabras.entrySet()) {
                        if (entry.getValue() == (Integer.parseInt(str))) {
                            mapaOrdenado.put(entry.getKey(), Integer.parseInt(str));
                        }
                    }
                }
                System.out.println("");
                System.out.print("Resultado: ");
                Iterator iterator = mapaOrdenado.keySet().iterator();
                int contador = 0;
                while (iterator.hasNext()) {
                    Object llave = iterator.next();
                    System.out.print(llave + " ");
                    contador++;
                    if (contador == entero) {
                        break;
                    }

                }
                System.out.println();
            }

        } catch (IOException e) {
        }

    }

}
