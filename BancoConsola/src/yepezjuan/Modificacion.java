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
public class Modificacion {

    public static void modificar() throws FileNotFoundException, IOException {
        Scanner puerta = new Scanner(System.in);
        String resultado, opcion, temp;
        int verif, posicion, i, k;
        char op;
        resultado = Busqueda.buscar();
        verif = (int) resultado.charAt(0);
        if ((verif <= 57) && (verif >= 48)) {
            op = '0';
            do {
                System.out.println("\nDesea modificar los datos  (S/N). ?");
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
                System.out.println("                        Ingreso de Nuevos Datos");
                posicion = Integer.parseInt(resultado);
                Cliente socio = new Cliente();

                String[] dato;
                String ced = null, cadena, cuenta, nombre, tcuenta;
                int j, contador, aux;
                boolean verificacion;

                op = '0';

                do {
                    System.out.print("Nombre->>         ");
                    contador = 0;
                    nombre = (puerta.nextLine());
                    if (!nombre.isEmpty()) {
                        for (i = 0; i < nombre.length(); i++) {
                            aux = (int) nombre.charAt(i);

                            if ((aux == 32) || (aux == 65533) || ((aux >= 65) && (aux <= 90))
                                    || ((aux >= 97) && (aux <= 122))) {

                            } else {
                                contador++;
                            }
                        }
                        if (contador == 0) {
                            socio.colocarNom(nombre);
                        } else {
                            System.out.println("Error:\nIngrese un nombre sin caracteres especiales");
                        }
                    } else {
                        System.out.println("Ingrese un nombre");
                        contador++;
                    }
                } while (contador != 0);

                verificacion = false;
                while (!verificacion) {
                    System.out.print("Cédula->>         ");
                    ced = puerta.nextLine();
                    if (!ced.isEmpty()) {
                        verificacion = RegistroCedula.verificarCedula(ced);
                    } else {
                        System.out.println("Ingrese una cédula");
                    }
                }
                socio.colocarCedula(ced);
                System.out.print("Tipo de Cuenta A/C \n(Ahorros/Corriente)->>   ");
                do {

                    tcuenta = puerta.nextLine();

                    if (!tcuenta.isEmpty()) {
                        op = tcuenta.toUpperCase().charAt(0);
                        socio.colocarTipocuenta(op);
                        if (op != 'A' && op != 'C') {
                            System.out.println("Error:\nIngrese la letra << A >> o << C >>");
                        }
                    } else {
                        System.out.println("Ingrese el tipo de cuenta");
                    }
                } while (op != 'A' && op != 'C');

                Lista socio1 = new Lista();

                //crear archivo
                System.out.print("Grabar Datos(S/N)= ");
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

                    System.out.println("Añadiendo datos al archivo  " + archivo+"\n");
                    Scanner entrada = new Scanner(archivo);
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
                    socio.colocarNcuenta(socio1.get(posicion).obtenerNcuenta());
                    socio.colocarDeposito(socio1.get(posicion).obtenerDeposito());
                    socio.colocarRetiro(socio1.get(posicion).obtenerRetiro());
                    socio.colocarSaldo(socio1.get(posicion).obtenerSaldo());

                    PrintWriter salida = new PrintWriter(archivo);

                    if (posicion != 0) {
                        if (posicion != j) {
                            for (k = 0; k < posicion; k++) {
                                temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                        + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                                salida.println(temp);
                            }
                            temp = socio.obtenerNcuenta() + "::" + socio.obtenerNom() + "::" + socio.obtenerCedula() + "::"
                                    + socio.obtenerTipocuenta() + "::" + socio.obtenerDeposito() + "::" + socio.obtenerRetiro() + "::" + socio.obtenerSaldo();
                            salida.println(temp);
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
                            temp = socio.obtenerNcuenta() + "::" + socio.obtenerNom() + "::" + socio.obtenerCedula() + "::"
                                    + socio.obtenerTipocuenta() + "::" + socio.obtenerDeposito() + "::" + socio.obtenerRetiro() + "::" + socio.obtenerSaldo();
                            salida.println(temp);
                        }
                    } else {

                        temp = socio.obtenerNcuenta() + "::" + socio.obtenerNom() + "::" + socio.obtenerCedula() + "::"
                                + socio.obtenerTipocuenta() + "::" + socio.obtenerDeposito() + "::" + socio.obtenerRetiro() + "::" + socio.obtenerSaldo();
                        salida.println(temp);

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
        modificar();
    }
}
