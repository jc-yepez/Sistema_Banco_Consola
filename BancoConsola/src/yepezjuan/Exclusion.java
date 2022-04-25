/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yepezjuan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Exclusion {

    public static void eliminar() throws FileNotFoundException, IOException {
        Scanner puerta = new Scanner(System.in);
        String resultado, opcion, temp;
        int verif, posicion, i, k, j;
        char op;

        resultado = Busqueda.buscar();

        verif = (int) resultado.charAt(0);
        if ((verif <= 57) && (verif >= 48)) {
            op = '0';
            do {
                System.out.println("\nDesea eliminar el cliente  (S/N). ?");
                opcion = puerta.nextLine();
                if (!opcion.isEmpty()) {
                    op = opcion.toUpperCase().charAt(0);
                    if (op != 'S' && op != 'N') {
                        System.out.println("Erro:\n Ingrese la letra < S > o < N >");
                    }
                } else {
                    System.out.println("Elija una opcion...");
                }
            } while (op != 'S' && op != 'N');
            if (op == 'S') {

                Lista socio1 = new Lista();

                //crear archivo
                System.out.print("\nGrabar Datos(S/N)= ");
                do {
                    opcion = puerta.nextLine();
                    if (!opcion.isEmpty()) {
                        op = opcion.toUpperCase().charAt(0);
                        if (op != 'S' && op != 'N') {
                            System.out.println("Ingrese la letra << S >> o << N >>");
                        }
                    } else {
                        System.out.println("Elija una opción");
                        op = '0';
                    }
                } while (op != 'S' && op != 'N');

                if (op == 'S') {
                    File archivo = new File("datos1.txt");

                    System.out.println("\nEliminando cliente al archivo  " + archivo+"\n");
                    Scanner entrada = new Scanner(archivo);
                    posicion = Integer.parseInt(resultado);
                    String[] dato;
                    String cadena;
                    j = 0;
                    while (entrada.hasNext()) {

                        cadena = entrada.nextLine();
                        dato = cadena.split("::");
                        Cliente x = new Cliente();
                        socio1.add(x);
                        socio1.get(j).colocarNcuenta(dato[0]);
                        socio1.get(j).colocarNom(dato[1]);
                        socio1.get(j).colocarCedula(dato[2]);
                        socio1.get(j).colocarTipocuenta(dato[3].charAt(0));
                        socio1.get(j).colocarDeposito(Float.valueOf(dato[4]));
                        socio1.get(j).colocarRetiro(Float.valueOf(dato[5]));
                        socio1.get(j).colocarSaldo(Float.valueOf(dato[6]));
                        j++;
                    }

                    PrintWriter salida = new PrintWriter(archivo);

                    if (posicion != 0) {
                        if (posicion != j) {
                            for (k = 0; k < posicion; k++) {
                                temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                        + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                                salida.println(temp);
                            }

                            for (k = posicion + 1; k < j; k++) {
                                temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                        + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                                salida.println(temp);
                            }
                        } else {
                            for (k = 0; k < posicion; k++) {
                                temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                        + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                                salida.println(temp);
                            }

                        }
                    } else {

                        for (k = posicion + 1; k < j; k++) {
                            temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                    + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                            salida.println(temp);
                        }

                    }

                    salida.close();
                    System.out.println("Listo...!!!");
                }

            }

        }

    }

    public static void main(String[] args) throws IOException {
        eliminar();
    }
}
