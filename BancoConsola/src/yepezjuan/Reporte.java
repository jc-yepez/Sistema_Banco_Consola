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
public class Reporte {

    public static void total() throws FileNotFoundException {
        File archivo = new File("datos1.txt");
       
        int j, k;
        Lista socio = new Lista();
        String cadena;
        String[] dato;
        if (archivo.exists()) {

            Scanner entrada = new Scanner(archivo);
            if (entrada.hasNext()) {

                j = 0;
                while (entrada.hasNext()) {

                    cadena = entrada.nextLine();
                    dato = cadena.split("::");
                    Cliente x = new Cliente();
                    socio.add(x);
                    socio.get(j).colocarNcuenta(dato[0]);
                    socio.get(j).colocarNom(dato[1]);
                    socio.get(j).colocarCedula(dato[2]);
                    socio.get(j).colocarTipocuenta(dato[3].charAt(0));
                    socio.get(j).colocarDeposito(Float.valueOf(dato[4]));
                    socio.get(j).colocarRetiro(Float.valueOf(dato[5]));
                    socio.get(j).colocarSaldo(Float.valueOf(dato[6]));
                    j++;
                }
                System.out.printf("%30s%20s\n\n", "", "REPORTE CUENTAS DE AHORRO Y CREDITO");
                System.out.printf("%5s%10s  %-20s%-15s %-10s%12s%12s%12s\n", "", "# Cuenta", "Nombre", "Cedula", "Tipo Cuenta", "Depósito", "Retiro", "Saldo");

                for (k = 0; k < socio.size(); k++) {

                    System.out.printf("%8s%-7s  %-20s%-15s %-10c%12.2f%12.2f%12.2f\n",
                            "", socio.get(k).obtenerNcuenta(), socio.get(k).obtenerNom(), socio.get(k).obtenerCedula(),
                            socio.get(k).obtenerTipocuenta(), socio.get(k).obtenerDeposito(), socio.get(k).obtenerRetiro(), socio.get(k).obtenerSaldo());
                }
                Runtime r = Runtime.getRuntime();
                Process p = null;
                String comando[] = {"C:\\Program Files\\Microsoft Office\\Office14\\WINWORD.EXE", "ReporteTotal.doc"};
                PrintWriter salida = new PrintWriter("D:\\Documents\\Proyecto Final Estructura de Datos\\YepezMiguel\\ReporteTotal.doc");

                salida.printf("%18s%20s", "", "REPORTE CUENTAS DE AHORRO Y CREDITO\n\n");
                salida.printf("%-5s%-17s%-10s%7s%11s%11s%10s\n\n", "#", "Nombre", "Cedula", "Cuenta", "Depósito", "Retiro", "Saldo");

                for (k = 0; k < socio.size(); k++) {

                    salida.printf("%-5s%-17s%-10s%7c%11.2f%11.2f%10.2f\n\n",
                            socio.get(k).obtenerNcuenta(), socio.get(k).obtenerNom(), socio.get(k).obtenerCedula(),
                            socio.get(k).obtenerTipocuenta(), socio.get(k).obtenerDeposito(), socio.get(k).obtenerRetiro(), socio.get(k).obtenerSaldo());

                }
                salida.close();
                try {
                    p = r.exec(comando);
                } catch (Exception e) {
                    System.out.println("\n\nError al ejecutar " + comando[0]);
                }

            } else {
                System.out.println("El archivo " + archivo + " existe, pero está vacío");
            }

        } else {
            System.out.println("El archivo " + archivo + " no existe");
        }
    }

    public static void ahorro() throws FileNotFoundException {
        File archivo = new File("datos1.txt");
        int j, k;
        Lista socio = new Lista();
        String cadena;
        String[] dato;
        if (archivo.exists()) {

            Scanner entrada = new Scanner(archivo);
            if (entrada.hasNext()) {

                j = 0;
                while (entrada.hasNext()) {

                    cadena = entrada.nextLine();
                    dato = cadena.split("::");
                    if (dato[3].charAt(0) == 'A') {
                        Cliente x = new Cliente();
                        socio.add(x);
                        socio.get(j).colocarNcuenta(dato[0]);
                        socio.get(j).colocarNom(dato[1]);
                        socio.get(j).colocarCedula(dato[2]);
                        socio.get(j).colocarTipocuenta(dato[3].charAt(0));
                        socio.get(j).colocarDeposito(Float.valueOf(dato[4]));
                        socio.get(j).colocarRetiro(Float.valueOf(dato[5]));
                        socio.get(j).colocarSaldo(Float.valueOf(dato[6]));
                        j++;
                    }
                }
                if (j != 0) {
                    System.out.printf("%30s%20s\n\n", "", "REPORTE CUENTAS DE AHORRO ");
                    System.out.printf("%5s%10s  %-20s%-15s %-10s%12s%12s%12s\n", "", "# Cuenta", "Nombre", "Cedula", "Tipo Cuenta", "Depósito", "Retiro", "Saldo");

                    for (k = 0; k < socio.size(); k++) {

                        System.out.printf("%8s%-7s  %-20s%-15s %-10c%12.2f%12.2f%12.2f\n",
                                "", socio.get(k).obtenerNcuenta(), socio.get(k).obtenerNom(), socio.get(k).obtenerCedula(),
                                socio.get(k).obtenerTipocuenta(), socio.get(k).obtenerDeposito(), socio.get(k).obtenerRetiro(), socio.get(k).obtenerSaldo());
                    }
                    Runtime r = Runtime.getRuntime();
                    Process p = null;
                    String comando[] = {"C:\\Program Files\\Microsoft Office\\Office14\\WINWORD.EXE", "ReporteAhorro.doc"};
                    PrintWriter salida = new PrintWriter("D:\\Documents\\Proyecto Final Estructura de Datos\\YepezMiguel\\ReporteAhorro.doc");

                    salida.printf("%18s%20s", "", "REPORTE CUENTAS DE AHORRO \n\n");
                    salida.printf("%-5s%-17s%-10s%7s%11s%11s%10s\n\n", "#", "Nombre", "Cedula", "Cuenta", "Depósito", "Retiro", "Saldo");

                    for (k = 0; k < socio.size(); k++) {

                        salida.printf("%-5s%-17s%-10s%7c%11.2f%11.2f%10.2f\n\n",
                                socio.get(k).obtenerNcuenta(), socio.get(k).obtenerNom(), socio.get(k).obtenerCedula(),
                                socio.get(k).obtenerTipocuenta(), socio.get(k).obtenerDeposito(), socio.get(k).obtenerRetiro(), socio.get(k).obtenerSaldo());

                    }
                    salida.close();
                    try {
                        p = r.exec(comando);
                    } catch (Exception e) {
                        System.out.println("\n\nError al ejecutar " + comando[0]);
                    }
                } else {
                    System.out.println("El archivo " + archivo + " existe, pero no existen cuentas de ahorro");
                }
            } else {
                System.out.println("El archivo " + archivo + " existe, pero está vacío");
            }

        } else {
            System.out.println("El archivo " + archivo + " no existe");
        }

    }
    
    public static void corriente() throws FileNotFoundException {
        File archivo = new File("datos1.txt");
        int j, k;
        Lista socio = new Lista();
        String cadena;
        String[] dato;
        if (archivo.exists()) {

            Scanner entrada = new Scanner(archivo);
            if (entrada.hasNext()) {

                j = 0;
                while (entrada.hasNext()) {

                    cadena = entrada.nextLine();
                    dato = cadena.split("::");
                    if (dato[3].charAt(0) == 'C') {
                        Cliente x = new Cliente();
                        socio.add(x);
                        socio.get(j).colocarNcuenta(dato[0]);
                        socio.get(j).colocarNom(dato[1]);
                        socio.get(j).colocarCedula(dato[2]);
                        socio.get(j).colocarTipocuenta(dato[3].charAt(0));
                        socio.get(j).colocarDeposito(Float.valueOf(dato[4]));
                        socio.get(j).colocarRetiro(Float.valueOf(dato[5]));
                        socio.get(j).colocarSaldo(Float.valueOf(dato[6]));
                        j++;
                    }
                }
                if (j != 0) {
                    System.out.printf("%30s%20s\n\n", "", "REPORTE CUENTAS CORRIENTES ");
                    System.out.printf("%5s%10s  %-20s%-15s %-10s%12s%12s%12s\n", "", "# Cuenta", "Nombre", "Cedula", "Tipo Cuenta", "Depósito", "Retiro", "Saldo");

                    for (k = 0; k < socio.size(); k++) {

                        System.out.printf("%8s%-7s  %-20s%-15s %-10c%12.2f%12.2f%12.2f\n",
                                "", socio.get(k).obtenerNcuenta(), socio.get(k).obtenerNom(), socio.get(k).obtenerCedula(),
                                socio.get(k).obtenerTipocuenta(), socio.get(k).obtenerDeposito(), socio.get(k).obtenerRetiro(), socio.get(k).obtenerSaldo());
                    }
                    Runtime r = Runtime.getRuntime();
                    Process p = null;
                    String comando[] = {"C:\\Program Files\\Microsoft Office\\Office14\\WINWORD.EXE", "ReporteCorriente.doc"};
                    PrintWriter salida = new PrintWriter("D:\\Documents\\Proyecto Final Estructura de Datos\\YepezMiguel\\ReporteCorriente.doc");

                    salida.printf("%18s%20s", "", "REPORTE CUENTAS CORRIENTES \n\n");
                    salida.printf("%-5s%-17s%-10s%7s%11s%11s%10s\n\n", "#", "Nombre", "Cedula", "Cuenta", "Depósito", "Retiro", "Saldo");

                    for (k = 0; k < socio.size(); k++) {

                        salida.printf("%-5s%-17s%-10s%7c%11.2f%11.2f%10.2f\n\n",
                                socio.get(k).obtenerNcuenta(), socio.get(k).obtenerNom(), socio.get(k).obtenerCedula(),
                                socio.get(k).obtenerTipocuenta(), socio.get(k).obtenerDeposito(), socio.get(k).obtenerRetiro(), socio.get(k).obtenerSaldo());

                    }
                    salida.close();
                    try {
                        p = r.exec(comando);
                    } catch (Exception e) {
                        System.out.println("\n\nError al ejecutar " + comando[0]);
                    }
                } else {
                    System.out.println("El archivo " + archivo + " existe, pero no existen cuentas corrientes");
                }
            } else {
                System.out.println("El archivo " + archivo + " existe, pero está vacío");
            }

        } else {
            System.out.println("El archivo " + archivo + " no existe");
        }

    }

    public static void main(String[] args) throws IOException {
        total();
        ahorro();
        corriente();
    }
}
