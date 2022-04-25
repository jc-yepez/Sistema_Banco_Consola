/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yepezjuan;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Busqueda {

    public static String buscar() throws FileNotFoundException {
        Scanner puerta = new Scanner(System.in);
        Lista socio = new Lista();
        String cuenta, cadena, posicion;
        String[] dato;
        int contador, n,i, aux,pos;
        File archivo = new File("datos1.txt");
        posicion = "a";
        if (archivo.exists()) {
            System.out.println("             Información Clientes\n");
            Scanner entrada = new Scanner(archivo);
            if (entrada.hasNext()) {
                do {
                    
                    contador = 0;
                    System.out.print("Número de cuenta ->>  ");
                    cuenta = puerta.nextLine();
                    if (!cuenta.isEmpty()) {
                        
                        for (i = 0; i < cuenta.length(); i++) {
                            aux = (int) cuenta.charAt(i);
                            if ((aux > 57) || (aux < 48)) {
                                contador++;
                            }
                        }
                        if (contador == 0) {
                            n = 0;
                            pos=0;
                            Scanner entrada1 = new Scanner(archivo);
                        while (entrada1.hasNext()) {
                            
                            cadena = entrada1.nextLine();
                            dato = cadena.split("::");
                            if (dato[0].compareTo(cuenta) == 0) {
                                Cliente x = new Cliente();
                                socio.add(x);
                                socio.get(0).colocarNcuenta(dato[0]);
                                socio.get(0).colocarNom(dato[1]);
                                socio.get(0).colocarCedula(dato[2]);
                                socio.get(0).colocarTipocuenta(dato[3].charAt(0));
                                socio.get(0).colocarDeposito(Float.valueOf(dato[4]));
                                socio.get(0).colocarRetiro(Float.valueOf(dato[5]));
                                socio.get(0).colocarSaldo(Float.valueOf(dato[6]));
                                n=1;
                                break;
                            } 
                            pos++;
                        }
                        if (n != 0) {
                            System.out.println("Cliente existe...\n");
                            System.out.printf("%5s%10s  %-20s%-15s %-10s%12s%12s%12s\n",
                                    "", "# Cuenta", "Nombre", "Cedula", "Tipo Cuenta", "Depósito", "Retiro", "Saldo");
                            System.out.printf("%8s%-7s  %-20s%-15s %-10c%12.2f%12.2f%12.2f\n",
                                    "", socio.get(0).obtenerNcuenta(), socio.get(0).obtenerNom(), socio.get(0).obtenerCedula(),
                                    socio.get(0).obtenerTipocuenta(), socio.get(0).obtenerDeposito(), socio.get(0).obtenerRetiro(), socio.get(0).obtenerSaldo());
                        posicion = String.valueOf(pos);
                        } else {
                            System.out.println("Cliente no existe..");
                        }
                        } else {
                            System.out.println("Error:\nIngrese un número entero sin espacios ni caracteres especiales");
                        }
                    } else {
                        System.out.println("Ingrese un número entero");
                        contador++;
                    }

                } while (contador != 0);
            } else {
                System.out.println("El archivo existe, pero está vacío...");
            }
        } else {
            System.out.println("El archivo no existe...");  
        }
        return posicion;
    }
    public static void main(String[] args) throws FileNotFoundException {
        String resultado;
        resultado = buscar();
    }
}
