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
//-d -l -c -s archivoprueba.txt

    public static void main(String[] argumentos) {
        //analizadorTexto -d -c p -l 2 archivoprueba.txt
        ControladorOpcionesTexto controladorOpcionesTexto = new ControladorOpcionesTexto();
        int i = 1;
        boolean bandera_l = false;
        boolean bandera_s = false;
        boolean d = false;
        for (int j = 1; j < argumentos.length; j++) {
            if (argumentos[j].equals("-l")) {
                bandera_l = true;
            }
            if (argumentos[j].equals("-s")) {
                bandera_s = true;
            }
            if (argumentos[j].equals("-d")) {
                d = true;
            }
        }

        if (argumentos.length <= 8 && (bandera_l == false || bandera_s == false)) {
            try {
                if (argumentos[i].equals("-d") == false && argumentos[i].endsWith(".txt") == false && d == true) {
                    int posicion_d = 0;
                    //analizadorTexto -c a -d -l archivoprueba.txt
                    for (int j = 1; j < argumentos.length; j++) {
                        if (argumentos[j].equals("-d") == true) {
                            posicion_d = j;
                            break;
                        }
                    }
                    try {
                        Integer.parseInt(argumentos[posicion_d + 1]);
                        String anterior = argumentos[i];
                        argumentos[i] = argumentos[posicion_d];
                        for (int j = 2; j <= posicion_d; j++) {
                            String nuevo = argumentos[j];
                            argumentos[j] = anterior;
                            anterior = nuevo;
                        }
                        anterior = argumentos[i + 1];
                        argumentos[i + 1] = argumentos[posicion_d + 1];
                        for (int j = 3; j <= posicion_d + 1; j++) {
                            String nuevo = argumentos[j];
                            argumentos[j] = anterior;
                            anterior = nuevo;
                        }

                    } catch (NumberFormatException e) {
                        String anterior = argumentos[i];
                        argumentos[i] = argumentos[posicion_d];
                        for (int j = 2; j <= posicion_d; j++) {
                            String nuevo = argumentos[j];
                            argumentos[j] = anterior;
                            anterior = nuevo;
                        }
                    }
                }
                if (argumentos[0].equals("analizadorTexto") == false) {
                    System.out.println("Comando erroneo o incompleto");
                } else if (argumentos[1].endsWith(".txt")) {
                    controladorOpcionesTexto.mostrarContenido(argumentos[1]);
                    controladorOpcionesTexto.opcionSinOpcion(argumentos[1]);
                } else {
                    switch (argumentos[i]) {
                        case "-d":
                            try {
                                int entero = Integer.parseInt(argumentos[i + 1]);
                                if (entero > 0) {
                                    if (argumentos[i + 2].endsWith(".txt") == true) {
                                        controladorOpcionesTexto.mostrarContenido(argumentos[i + 2]);
                                        controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 2]);
                                    } else {
                                        switch (argumentos[i + 2]) {
                                            case "-c":
                                                if (argumentos[i + 3].endsWith(".txt") == true) {
                                                    System.out.println("Comando erroneo o incompleto");
                                                } else if (argumentos[i + 4].endsWith(".txt") == true && argumentos[i + 3].equals("-l") == false && argumentos[i + 3].equals("-d") == false && argumentos[i + 3].equals("-s") == false && argumentos[i + 3].equals("-c") == false) {

                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 4]);
                                                    controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 4]);
                                                    controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 3], argumentos[i + 4]);
                                                } else {
                                                    //analizadorTexto -d 2 -c a -l 2 archivoprueba.txt
                                                    switch (argumentos[i + 4]) {
                                                        case "-l":
                                                            try {
                                                                int entero_l = Integer.parseInt(argumentos[i + 5]);
                                                                if (entero_l > 0) {
                                                                    if (argumentos[i + 6].endsWith(".txt") == true) {
                                                                        controladorOpcionesTexto.mostrarContenido(argumentos[i + 6]);
                                                                        controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 6]);
                                                                        controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 3], argumentos[i + 6]);
                                                                        controladorOpcionesTexto.cadenaMasLarga(entero_l, argumentos[i + 6]);
                                                                    } else {
                                                                        System.out.println("Comando erroneo o incompleto");
                                                                    }
                                                                } else {
                                                                    System.out.println("Comando erroneo o incompleto");
                                                                }
                                                            } catch (NumberFormatException e) {
                                                                if (argumentos[i + 5].endsWith(".txt") == true) {
                                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 3], argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasLarga(1, argumentos[i + 5]);
                                                                } else {
                                                                    System.out.println("Comando erroneo o incompleto");
                                                                }
                                                            }
                                                            break;
                                                        case "-s":
                                                            try {
                                                                int entero_s = Integer.parseInt(argumentos[i + 5]);
                                                                if (entero_s > 0) {
                                                                    if (argumentos[i + 6].endsWith(".txt") == true) {
                                                                        controladorOpcionesTexto.mostrarContenido(argumentos[i + 6]);
                                                                        controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 6]);
                                                                        controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 3], argumentos[i + 6]);
                                                                        controladorOpcionesTexto.cadenaMasCorta(entero_s, argumentos[i + 6]);
                                                                    } else {
                                                                        System.out.println("Comando erroneo o incompleto");
                                                                    }
                                                                } else {
                                                                    System.out.println("comando erroneo o incompleto");
                                                                }
                                                            } catch (NumberFormatException e) {
                                                                if (argumentos[i + 5].endsWith(".txt") == true) {
                                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 3], argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasCorta(1, argumentos[i + 5]);
                                                                } else {
                                                                    System.out.println("Comando erroneo o incompleto");
                                                                }
                                                            }
                                                            break;
                                                    }
                                                }
                                                break;
                                            case "-l":
                                                try {
                                                    int entero_l = Integer.parseInt(argumentos[i + 3]);
                                                    if (entero_l > 0) {
                                                        if (argumentos[i + 4].endsWith(".txt") == true) {
                                                            controladorOpcionesTexto.mostrarContenido(argumentos[i + 4]);
                                                            controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 4]);
                                                            controladorOpcionesTexto.cadenaMasLarga(entero_l, argumentos[i + 4]);
                                                        } else {
                                                            switch (argumentos[i + 4]) {
                                                                //analizadorTexto -d 2 -l 2 -c a archivoprueba.txt
                                                                case "-c":
                                                                    if (argumentos[i + 5].endsWith(".txt") == true) {
                                                                        System.out.println("Comando erroneo o incompleto");
                                                                    } else if (argumentos[i + 6].endsWith(".txt") == true && argumentos[i + 5].equals("-l") == false && argumentos[i + 5].equals("-d") == false && argumentos[i + 5].equals("-s") == false && argumentos[i + 5].equals("-c") == false) {

                                                                        controladorOpcionesTexto.mostrarContenido(argumentos[i + 6]);
                                                                        controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 6]);
                                                                        controladorOpcionesTexto.cadenaMasLarga(entero_l, argumentos[i + 6]);
                                                                        controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 5], argumentos[i + 6]);
                                                                    } else {
                                                                        switch (argumentos[i + 4]) {
                                                                            case "-l":

                                                                                if (argumentos[i + 5].endsWith(".txt") == true) {
                                                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 5]);
                                                                                    controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 5]);
                                                                                    controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 3], argumentos[i + 5]);
                                                                                    controladorOpcionesTexto.cadenaMasLarga(1, argumentos[i + 5]);
                                                                                } else {
                                                                                    System.out.println("Comando erroneo o incompleto");
                                                                                }

                                                                                break;
                                                                            case "-s":
                                                                                if (argumentos[i + 5].endsWith(".txt") == true) {
                                                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 5]);
                                                                                    controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 5]);
                                                                                    controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 3], argumentos[i + 5]);
                                                                                    controladorOpcionesTexto.cadenaMasCorta(1, argumentos[i + 5]);
                                                                                } else {
                                                                                    System.out.println("Comando erroneo o incompleto");
                                                                                }

                                                                                break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("Comando erroneo o incompleto");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    if (argumentos[i + 5].endsWith(".txt") == true) {
                                                        controladorOpcionesTexto.mostrarContenido(argumentos[i + 5]);
                                                        controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 5]);
                                                        controladorOpcionesTexto.cadenaMasLarga(1, argumentos[i + 5]);
                                                        controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 4], argumentos[i + 5]);
                                                    } else {
                                                        System.out.println("Comando erroneo o incompleto");
                                                    }
                                                }
                                                break;
                                            case "-s":
                                                try {
                                                    int entero_s = Integer.parseInt(argumentos[i + 3]);
                                                    if (entero_s > 0) {
                                                        if (argumentos[i + 4].endsWith(".txt") == true) {
                                                            controladorOpcionesTexto.mostrarContenido(argumentos[i + 4]);
                                                            controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 4]);
                                                            controladorOpcionesTexto.cadenaMasCorta(entero_s, argumentos[i + 4]);
                                                        } else {
                                                            switch (argumentos[i + 4]) {
                                                                case "-c":
                                                                    if (argumentos[i + 5].endsWith(".txt") == true) {
                                                                        System.out.println("Comando erroneo o incompleto");
                                                                    } else if (argumentos[i + 6].endsWith(".txt") == true && argumentos[i + 5].equals("-l") == false && argumentos[i + 5].equals("-d") == false && argumentos[i + 5].equals("-s") == false && argumentos[i + 5].equals("-c") == false) {

                                                                        controladorOpcionesTexto.mostrarContenido(argumentos[i + 6]);
                                                                        controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 6]);
                                                                        controladorOpcionesTexto.cadenaMasCorta(entero_s, argumentos[i + 6]);
                                                                        controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 5], argumentos[i + 6]);
                                                                    } else {
                                                                        System.out.println("Comando erroneo o incompleto");
                                                                    }
                                                                    break;
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("Comando erroneo o incompleto");
                                                    }

                                                } catch (NumberFormatException e) {
                                                    if (argumentos[i + 5].endsWith(".txt") == true) {
                                                        controladorOpcionesTexto.mostrarContenido(argumentos[i + 5]);
                                                        controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 5]);
                                                        controladorOpcionesTexto.cadenaMasCorta(1, argumentos[i + 5]);
                                                        controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 4], argumentos[i + 5]);
                                                    } else {
                                                            switch (argumentos[i + 3]) {
                                                                case "-c":
                                                                    if (argumentos[i + 4].endsWith(".txt") == true) {
                                                                        System.out.println("Comando erroneo o incompleto");
                                                                    } else if (argumentos[i + 5].endsWith(".txt") == true && argumentos[i + 4].equals("-l") == false && argumentos[i + 4].equals("-d") == false && argumentos[i + 4].equals("-s") == false && argumentos[i + 4].equals("-c") == false) {

                                                                        controladorOpcionesTexto.mostrarContenido(argumentos[i + 5]);
                                                                        controladorOpcionesTexto.cadenaMasComun(entero, argumentos[i + 5]);
                                                                        controladorOpcionesTexto.cadenaMasCorta(1, argumentos[i + 5]);
                                                                        controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 4], argumentos[i + 5]);
                                                                    } else {
                                                                        System.out.println("Comando erroneo o incompleto");
                                                                    }
                                                                    break;
                                                            }
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    System.out.println("Comando erroneo o incompleto");
                                }
                            } catch (NumberFormatException e) {
                                if (argumentos[i + 1].endsWith(".txt") == true) {
                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 1]);
                                    controladorOpcionesTexto.cadenaMasComun(1, argumentos[1 + 1]);
                                } else {
                                    switch (argumentos[i + 1]) {
                                        case "-c":
                                            if (argumentos[i + 2].endsWith(".txt") == true) {
                                                System.out.println("Comando erroneo o incompleto");
                                            } else if (argumentos[i + 3].endsWith(".txt") == true && argumentos[i + 2].equals("-l") == false && argumentos[i + 2].equals("-d") == false && argumentos[i + 2].equals("-s") == false && argumentos[i + 2].equals("-c") == false) {

                                                controladorOpcionesTexto.mostrarContenido(argumentos[i + 3]);
                                                controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 3]);
                                                controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 2], argumentos[i + 3]);
                                            } else {
                                                //analizadorTexto -d -c a -l 5 archivoprueba.txt
                                                switch (argumentos[i + 3]) {
                                                    case "-l":

                                                        if (argumentos[i + 4].endsWith(".txt") == true) {
                                                            controladorOpcionesTexto.mostrarContenido(argumentos[i + 4]);
                                                            controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 4]);
                                                            controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 2], argumentos[i + 4]);
                                                            controladorOpcionesTexto.cadenaMasLarga(1, argumentos[i + 4]);
                                                        } else {
                                                            int entero_l = Integer.parseInt(argumentos[i + 4]);
                                                            if (entero_l > 0) {
                                                                if (argumentos[i + 5].endsWith(".txt")) {
                                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 2], argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasLarga(entero_l, argumentos[i + 5]);
                                                                }
                                                            }
                                                        }

                                                        break;
                                                    case "-s":
                                                        if (argumentos[i + 4].endsWith(".txt") == true) {
                                                            controladorOpcionesTexto.mostrarContenido(argumentos[i + 4]);
                                                            controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 4]);
                                                            controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 2], argumentos[i + 4]);
                                                            controladorOpcionesTexto.cadenaMasCorta(1, argumentos[i + 4]);
                                                        } else if (argumentos[i + 5].endsWith(".txt")) {
                                                            controladorOpcionesTexto.mostrarContenido(argumentos[i + 5]);
                                                            controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 5]);
                                                            controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 2], argumentos[i + 5]);
                                                            controladorOpcionesTexto.cadenaMasCorta(1, argumentos[i + 5]);
                                                        }

                                                        break;
                                                }
                                            }
                                            break;
                                        case "-l":
                                            try {
                                                int entero_l = Integer.parseInt(argumentos[i + 2]);
                                                if (entero_l > 0) {
                                                    //-d -l -c -s archivoprueba.txt
                                                    if (argumentos[i + 3].endsWith(".txt") == true) {
                                                        controladorOpcionesTexto.mostrarContenido(argumentos[i + 3]);
                                                        controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 3]);
                                                        controladorOpcionesTexto.cadenaMasLarga(entero_l, argumentos[i + 3]);
                                                    } else {
                                                        switch (argumentos[i + 3]) {
                                                            //analizadorTexto -d 2 -l 2 -c a archivoprueba.txt
                                                            case "-c":
                                                                if (argumentos[i + 4].endsWith(".txt") == true) {
                                                                    System.out.println("Comando erroneo o incompleto");
                                                                } else if (argumentos[i + 5].endsWith(".txt") == true && argumentos[i + 4].equals("-l") == false && argumentos[i + 4].equals("-d") == false && argumentos[i + 4].equals("-s") == false && argumentos[i + 4].equals("-c") == false) {

                                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasLarga(entero_l, argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 5], argumentos[i + 5]);
                                                                } else {
                                                                    System.out.println("Comando erroneo o incompleto");
                                                                }
                                                                break;
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Comando erroneo o incompleto");
                                                }

                                            } catch (NumberFormatException ex) {
                                                if (argumentos[i + 2].endsWith(".txt") == true) {
                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 2]);
                                                    controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 2]);
                                                    controladorOpcionesTexto.cadenaMasLarga(1, argumentos[i + 2]);
                                                } else {
                                                    switch (argumentos[i + 2]) {
                                                        //analizadorTexto -l -c a archivoprueba.txt
                                                        case "-c":
                                                            if (argumentos[i + 3].endsWith(".txt")) {
                                                                System.out.println("Comando erroneo o incompleto");
                                                            } else if (argumentos[i + 4].endsWith(".txt") == true && argumentos[i + 3].equals("-l") == false && argumentos[i + 3].equals("-d") == false && argumentos[i + 3].equals("-s") == false && argumentos[i + 3].equals("-c") == false) {

                                                                controladorOpcionesTexto.mostrarContenido(argumentos[i + 4]);
                                                                controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 4]);
                                                                controladorOpcionesTexto.cadenaMasLarga(1, argumentos[i + 4]);
                                                                controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 3], argumentos[i + 4]);
                                                            } else {
                                                                System.out.println("Comando erroneo o incompleto");
                                                            }
                                                            break;
                                                    }
                                                }
                                            }
                                            break;
                                        case "-s":
                                            try {
                                                int entero_s = Integer.parseInt(argumentos[i + 2]);
                                                if (entero_s > 0) {
                                                    if (argumentos[i + 3].endsWith(".txt") == true) {
                                                        controladorOpcionesTexto.mostrarContenido(argumentos[i + 3]);
                                                        controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 3]);
                                                        controladorOpcionesTexto.cadenaMasCorta(entero_s, argumentos[i + 3]);
                                                    } else {
                                                        switch (argumentos[i + 3]) {
                                                            case "-c":
                                                                if (argumentos[i + 4].endsWith(".txt") == true) {
                                                                    System.out.println("Comando erroneo o incompleto");
                                                                } else if (argumentos[i + 5].endsWith(".txt") == true && argumentos[i + 4].equals("-l") == false && argumentos[i + 4].equals("-d") == false && argumentos[i + 4].equals("-s") == false && argumentos[i + 4].equals("-c") == false) {

                                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasCorta(entero_s, argumentos[i + 5]);
                                                                    controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 4], argumentos[i + 5]);
                                                                } else {
                                                                    System.out.println("Comando erroneo o incompleto");
                                                                }
                                                                break;
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Comando erroneo o incompleto");
                                                }

                                            } catch (NumberFormatException ex) {
                                                if (argumentos[i + 2].endsWith(".txt") == true) {
                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 2]);
                                                    controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 2]);
                                                    controladorOpcionesTexto.cadenaMasCorta(1, argumentos[i + 2]);
                                                } else {
                                                    switch (argumentos[i + 2]) {
                                                        case "-c":
                                                            if (argumentos[i + 3].endsWith(".txt") == true) {
                                                                System.out.println("Comando erroneo o incompleto");
                                                            } else if (argumentos[i + 4].endsWith(".txt") == true && argumentos[i + 3].equals("-l") == false && argumentos[i + 3].equals("-d") == false && argumentos[i + 3].equals("-s") == false && argumentos[i + 3].equals("-c") == false) {

                                                                controladorOpcionesTexto.mostrarContenido(argumentos[i + 4]);
                                                                controladorOpcionesTexto.cadenaMasComun(1, argumentos[i + 4]);
                                                                controladorOpcionesTexto.cadenaMasCorta(1, argumentos[i + 4]);
                                                                controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 3], argumentos[i + 4]);
                                                            } else {
                                                                System.out.println("Comando erroneo o incompleto");
                                                            }
                                                            break;
                                                    }
                                                }
                                            }
                                            break;
                                    }
                                }

                            }
                            break;
                        case "-c":
                            if (argumentos[i + 1].endsWith(".txt") == true) {
                                System.out.println("Comando erroneo o incompleto");
                            } else if (argumentos[i + 2].endsWith(".txt") == true && argumentos[i + 1].equals("-l") == false && argumentos[i + 1].equals("-d") == false && argumentos[i + 1].equals("-s") == false && argumentos[i + 1].equals("-c") == false) {
                                controladorOpcionesTexto.mostrarContenido(argumentos[i + 2]);
                                controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 1], argumentos[i + 2]);

                            } else {
                                switch (argumentos[i + 2]) {
                                    case "-l":

                                        if (argumentos[i + 3].endsWith(".txt") == true) {
                                            controladorOpcionesTexto.mostrarContenido(argumentos[i + 3]);
                                            controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 1], argumentos[i + 3]);
                                            controladorOpcionesTexto.cadenaMasLarga(1, argumentos[i + 3]);
                                        } else {
                                            int entero_l = Integer.parseInt(argumentos[i + 3]);
                                            if (entero_l > 0) {
                                                if (argumentos[i + 4].endsWith(".txt")) {
                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 4]);
                                                    controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 1], argumentos[i + 4]);
                                                    controladorOpcionesTexto.cadenaMasLarga(entero_l, argumentos[i + 4]);
                                                } else {
                                                    System.out.println("Comando erroneo o incompleto");
                                                }
                                            } else {
                                                System.out.println("Comando erroneo o incompleto");
                                            }
                                        }

                                        break;
                                    case "-s":
                                        if (argumentos[i + 3].endsWith(".txt") == true) {
                                            controladorOpcionesTexto.mostrarContenido(argumentos[i + 3]);
                                            controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 1], argumentos[i + 3]);
                                            controladorOpcionesTexto.cadenaMasCorta(1, argumentos[i + 3]);
                                        } else {
                                            int entero_l = Integer.parseInt(argumentos[i + 3]);
                                            if (entero_l > 0) {
                                                if (argumentos[i + 4].endsWith(".txt")) {
                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 4]);
                                                    controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 1], argumentos[i + 4]);
                                                    controladorOpcionesTexto.cadenaMasCorta(entero_l, argumentos[i + 4]);
                                                } else {
                                                    System.out.println("Comando erroneo o incompleto");
                                                }
                                            } else {
                                                System.out.println("Comando erroneo o incompleto");
                                            }
                                        }

                                        break;
                                }
                            }
                            break;
                        case "-l":
                            try {
                                //-l 2 -c a .txt
                                int entero = Integer.parseInt(argumentos[i + 1]);
                                if (entero > 0) {
                                    if (argumentos[i + 2].endsWith(".txt") == true) {
                                        controladorOpcionesTexto.mostrarContenido(argumentos[i + 2]);
                                        controladorOpcionesTexto.cadenaMasLarga(entero, argumentos[i + 2]);
                                    } else {
                                        switch (argumentos[i + 2]) {
                                            case "-c":
                                                if (argumentos[i + 4].endsWith(".txt") && argumentos[i + 3].equals("-l") == false && argumentos[i + 3].equals("-d") == false && argumentos[i + 3].equals("-s") == false && argumentos[i + 3].equals("-c") == false) {
                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 4]);
                                                    controladorOpcionesTexto.cadenaMasLarga(entero, argumentos[i + 4]);
                                                    controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 3], argumentos[i + 4]);
                                                } else {
                                                    System.out.println("Comando erroneo o incompleto");
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    System.out.println("Comando erroneo o incompleto");
                                }
                                //-l -c a .txt
                            } catch (NumberFormatException e) {
                                if (argumentos[i + 1].endsWith(".txt") == true) {
                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 1]);
                                    controladorOpcionesTexto.cadenaMasLarga(1, argumentos[i + 1]);
                                } else {
                                    switch (argumentos[i + 1]) {
                                        case "-c":
                                            if (argumentos[i + 3].endsWith(".txt") && argumentos[i + 2].equals("-l") == false && argumentos[i + 2].equals("-d") == false && argumentos[i + 2].equals("-s") == false && argumentos[i + 2].equals("-c") == false) {
                                                controladorOpcionesTexto.mostrarContenido(argumentos[i + 3]);
                                                controladorOpcionesTexto.cadenaMasLarga(1, argumentos[i + 3]);
                                                controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 2], argumentos[i + 3]);
                                            } else {
                                                System.out.println("Comando erroneo o incompleto");
                                            }
                                            break;
                                    }
                                }
                            }
                            break;
                        case "-s":
                            try {
                                int entero = Integer.parseInt(argumentos[i + 1]);
                                if (entero > 0) {
                                    if (argumentos[i + 2].endsWith(".txt") == true) {
                                        controladorOpcionesTexto.mostrarContenido(argumentos[i + 2]);
                                        controladorOpcionesTexto.cadenaMasCorta(entero, argumentos[i + 2]);
                                    } else {
                                        switch (argumentos[i + 2]) {
                                            case "-c":
                                                if (argumentos[i + 4].endsWith(".txt") && argumentos[i + 3].equals("-l") == false && argumentos[i + 3].equals("-d") == false && argumentos[i + 3].equals("-s") == false && argumentos[i + 3].equals("-c") == false) {
                                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 4]);
                                                    controladorOpcionesTexto.cadenaMasCorta(entero, argumentos[i + 4]);
                                                    controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 3], argumentos[i + 4]);
                                                } else {
                                                    System.out.println("Comando erroneo o incompleto");
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    System.out.println("Comando erroneo o incompleto");
                                }
                            } catch (NumberFormatException e) {
                                if (argumentos[i + 1].endsWith(".txt") == true) {
                                    controladorOpcionesTexto.mostrarContenido(argumentos[i + 1]);
                                    controladorOpcionesTexto.cadenaMasCorta(1, argumentos[i + 1]);
                                } else {
                                    switch (argumentos[i + 1]) {
                                        case "-c":
                                            if (argumentos[i + 3].endsWith(".txt") && argumentos[i + 2].equals("-l") == false && argumentos[i + 2].equals("-d") == false && argumentos[i + 2].equals("-s") == false && argumentos[i + 2].equals("-c") == false) {
                                                controladorOpcionesTexto.mostrarContenido(argumentos[i + 3]);
                                                controladorOpcionesTexto.cadenaMasCorta(1, argumentos[i + 3]);
                                                controladorOpcionesTexto.cadenaMasRepite(argumentos[i + 2], argumentos[i + 3]);
                                            } else {
                                                System.out.println("Comando erroneo o incompleto");
                                            }
                                            break;
                                    }
                                }
                            }
                            break;

                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Comando erroneo o incompleto ");
            }
        } else {
            System.out.println("Comando erroneo o incompleto ");
        }
    }

}
