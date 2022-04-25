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
public class Transferencia {

    public static void transferir() throws FileNotFoundException, IOException {
        Scanner puerta = new Scanner(System.in);
        String resultado, resultado1, opcion, temp;
        float cantidadF;
        int verif, posicion, posicion1, i, k;
        char op;

        System.out.println("\nCuenta para EXTRAER fondos ->>\n");
        resultado = Busqueda.buscar();
        verif = (int) resultado.charAt(0);
        if ((verif <= 57) && (verif >= 48)) {

            System.out.println("\nCuenta para DEPOSITAR fondos ->>\n");
            resultado1 = Busqueda.buscar();
            verif = (int) resultado1.charAt(0);
            if ((verif <= 57) && (verif >= 48)) {
                op = '0';
                do {
                    System.out.println("\nRealizar la Transferencia (S/N). ?");
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

                    posicion = Integer.parseInt(resultado);
                    posicion1 = Integer.parseInt(resultado1);
                    Cliente socio = new Cliente();
                    Cliente socio2 = new Cliente();
                    String[] dato;
                    String cadena, cantidad;
                    int j, contador, contador1, aux;

                    do {
                        do {
                            System.out.print("Cantidad->>  ");
                            contador = 0;
                            contador1 = 0;
                            cantidadF = 0f;
                            cantidad = (puerta.nextLine());
                            if (!cantidad.isEmpty()) {

                                for (i = 0; i < cantidad.length(); i++) {
                                    aux = (int) cantidad.charAt(i);
                                    if ((aux > 57) || (aux < 48)) {
                                        if (aux == 46) {
                                            contador1++;
                                            if (contador1 > 1) {
                                                contador++;
                                            }
                                        } else {
                                            contador++;
                                        }
                                    }
                                }
                                if (contador == 0) {
                                    cantidadF = Float.valueOf(cantidad);
                                } else {
                                    System.out.println("Error:\nIngrese un número  sin espacios ni caracteres especiales\nPara decimales utilice el punto\n");
                                }

                            } else {
                                System.out.println("Ingrese una cantidad en dolares");
                                contador++;
                            }

                        } while (contador != 0);

                        Lista socio1 = new Lista();

                        //crear archivo
                        if (op == 'S') {
                            File archivo = new File("datos1.txt");

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
                            if (socio1.get(posicion).obtenerSaldo() >= cantidadF) {

                                socio.colocarNcuenta(socio1.get(posicion).obtenerNcuenta());
                                socio.colocarNom(socio1.get(posicion).obtenerNom());
                                socio.colocarCedula(socio1.get(posicion).obtenerCedula());
                                socio.colocarTipocuenta(socio1.get(posicion).obtenerTipocuenta());
                                socio.colocarDeposito(socio1.get(posicion).obtenerDeposito());
                                socio.colocarRetiro(cantidadF);
                                socio.colocarSaldo(socio1.get(posicion).obtenerSaldo() - cantidadF);

                                socio2.colocarNcuenta(socio1.get(posicion1).obtenerNcuenta());
                                socio2.colocarNom(socio1.get(posicion1).obtenerNom());
                                socio2.colocarCedula(socio1.get(posicion1).obtenerCedula());
                                socio2.colocarTipocuenta(socio1.get(posicion1).obtenerTipocuenta());
                                socio2.colocarDeposito(cantidadF);
                                socio2.colocarRetiro(socio1.get(posicion1).obtenerRetiro());
                                socio2.colocarSaldo(socio1.get(posicion1).obtenerSaldo() + cantidadF);

                                System.out.printf("%5s%10s  %-20s%-15s %-10s%12s%12s%12s\n",
                                        "", "# Cuenta", "Nombre", "Cedula", "Tipo Cuenta", "Depósito", "Retiro", "Saldo");
                                System.out.printf("%8s%-7s  %-20s%-15s %-10c%12.2f%12.2f%12.2f\n",
                                        "", socio.obtenerNcuenta(), socio.obtenerNom(), socio.obtenerCedula(),
                                        socio.obtenerTipocuenta(), socio.obtenerDeposito(), socio.obtenerRetiro(), socio.obtenerSaldo());

                                System.out.printf("%8s%-7s  %-20s%-15s %-10c%12.2f%12.2f%12.2f\n",
                                        "", socio2.obtenerNcuenta(), socio2.obtenerNom(), socio2.obtenerCedula(),
                                        socio2.obtenerTipocuenta(), socio2.obtenerDeposito(), socio2.obtenerRetiro(), socio2.obtenerSaldo());

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

                                PrintWriter salida = new PrintWriter(archivo);
                                if (posicion < posicion1) {
                                    if (posicion != 0) {
                                        if (posicion1 != j) {
                                            for (k = 0; k < posicion; k++) {
                                                temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                                        + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                                                salida.println(temp);
                                            }
                                            temp = socio.obtenerNcuenta() + "::" + socio.obtenerNom() + "::" + socio.obtenerCedula() + "::"
                                                    + socio.obtenerTipocuenta() + "::" + socio.obtenerDeposito() + "::" + socio.obtenerRetiro() + "::" + socio.obtenerSaldo();
                                            salida.println(temp);
                                            for (k = posicion + 1; k < posicion1; k++) {
                                                temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                                        + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                                                salida.println(temp);
                                            }
                                            temp = socio2.obtenerNcuenta() + "::" + socio2.obtenerNom() + "::" + socio2.obtenerCedula() + "::"
                                                    + socio2.obtenerTipocuenta() + "::" + socio2.obtenerDeposito() + "::" + socio2.obtenerRetiro() + "::" + socio2.obtenerSaldo();
                                            salida.println(temp);
                                            for (k = posicion1 + 1; k < j; k++) {
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

                                            for (k = posicion + 1; k < posicion1; k++) {
                                                temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                                        + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                                                salida.println(temp);
                                            }
                                            temp = socio2.obtenerNcuenta() + "::" + socio2.obtenerNom() + "::" + socio2.obtenerCedula() + "::"
                                                    + socio2.obtenerTipocuenta() + "::" + socio2.obtenerDeposito() + "::" + socio2.obtenerRetiro() + "::" + socio2.obtenerSaldo();
                                            salida.println(temp);
                                        }
                                    } else {

                                        temp = socio.obtenerNcuenta() + "::" + socio.obtenerNom() + "::" + socio.obtenerCedula() + "::"
                                                + socio.obtenerTipocuenta() + "::" + socio.obtenerDeposito() + "::" + socio.obtenerRetiro() + "::" + socio.obtenerSaldo();
                                        salida.println(temp);

                                        for (k = posicion + 1; k < posicion1; k++) {
                                            temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                                    + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                                            salida.println(temp);
                                        }
                                        temp = socio2.obtenerNcuenta() + "::" + socio2.obtenerNom() + "::" + socio2.obtenerCedula() + "::"
                                                + socio2.obtenerTipocuenta() + "::" + socio2.obtenerDeposito() + "::" + socio2.obtenerRetiro() + "::" + socio2.obtenerSaldo();
                                        salida.println(temp);
                                        for (k = posicion1 + 1; k < j; k++) {
                                            temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                                    + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                                            salida.println(temp);
                                        }
                                    }
                                } else {

                                    if (posicion1 != 0) {
                                        if (posicion != j) {
                                            for (k = 0; k < posicion1; k++) {
                                                temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                                        + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                                                salida.println(temp);
                                            }
                                            temp = socio2.obtenerNcuenta() + "::" + socio2.obtenerNom() + "::" + socio2.obtenerCedula() + "::"
                                                    + socio2.obtenerTipocuenta() + "::" + socio2.obtenerDeposito() + "::" + socio2.obtenerRetiro() + "::" + socio2.obtenerSaldo();
                                            salida.println(temp);
                                            for (k = posicion1 + 1; k < posicion; k++) {
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
                                            for (k = 0; k < posicion1; k++) {
                                                temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                                        + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                                                salida.println(temp);
                                            }
                                            temp = socio2.obtenerNcuenta() + "::" + socio2.obtenerNom() + "::" + socio2.obtenerCedula() + "::"
                                                    + socio2.obtenerTipocuenta() + "::" + socio2.obtenerDeposito() + "::" + socio2.obtenerRetiro() + "::" + socio2.obtenerSaldo();
                                            salida.println(temp);

                                            for (k = posicion1 + 1; k < posicion; k++) {
                                                temp = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                                        + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                                                salida.println(temp);
                                            }
                                            temp = socio.obtenerNcuenta() + "::" + socio.obtenerNom() + "::" + socio.obtenerCedula() + "::"
                                                    + socio.obtenerTipocuenta() + "::" + socio.obtenerDeposito() + "::" + socio.obtenerRetiro() + "::" + socio.obtenerSaldo();
                                            salida.println(temp);
                                        }
                                    } else {

                                        temp = socio2.obtenerNcuenta() + "::" + socio2.obtenerNom() + "::" + socio2.obtenerCedula() + "::"
                                                + socio2.obtenerTipocuenta() + "::" + socio2.obtenerDeposito() + "::" + socio2.obtenerRetiro() + "::" + socio2.obtenerSaldo();
                                        salida.println(temp);

                                        for (k = posicion1 + 1; k < posicion; k++) {
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
                                    }
                                }
                                salida.close();
                                System.out.println("\nAñadiendo datos al archivo  " + archivo + "\n");
                                System.out.println("Listo...!!!");
                                op = 'N';
                            } else {
                                System.out.println("No se puede realizar la tranzacción.\n >>>> SALDO INSUFICIENTE\n");
                                do {
                                    System.out.println("\nDesea Continuar otro intento (S/N). ?");
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
                            }
                        }
                    } while (op != 'N');
                }

            }
        }
    }
public static void main(String[]args) throws IOException{
    transferir();
}
}
