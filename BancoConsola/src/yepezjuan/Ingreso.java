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
public class Ingreso {
    
     public static Lista socios() throws FileNotFoundException, IOException {
        Scanner puerta = new Scanner(System.in);
//declaracion de variables

        Lista clientes = new Lista();

        String  opcion;
      
        char op;

        System.out.println("               Igreso de Datos al Sistema\n");
     

        op = 'S';
        while (op == 'S') {
            
            clientes.add(nuevo());

        
            System.out.println("Desea Ingresar otro Cliente (S/N). ?");

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
        }
    return clientes;
    }

    public static Cliente nuevo() throws FileNotFoundException, IOException {
        Scanner puerta = new Scanner(System.in);
//declaracion de variables

        Cliente socio = new Cliente();

        String[] dato;
        String ced = null, cadena, cuenta, nombre, tcuenta, opcion;
        int i, j, contador, aux;
        char op ;
        boolean resultado;

        

        op='0';

            do {
                System.out.print("Numero Cuenta->>  ");
                contador = 0;
                cuenta = (puerta.nextLine());
                if (!cuenta.isEmpty()) {
                    File archivo = new File("datos1.txt");
                    j = 0;
                    if (archivo.exists()) {
                        Scanner entrada = new Scanner(archivo);

                        while (entrada.hasNext()) {

                            cadena = entrada.nextLine();
                            dato = cadena.split("::");
                            if (dato[0].compareTo(cuenta) == 0) {
                                j++;
                            }
                        }
                    }
                    if (j == 0) {
                        for (i = 0; i < cuenta.length(); i++) {
                            aux = (int) cuenta.charAt(i);
                            if ((aux > 57) || (aux < 48)) {
                                contador++;
                            }
                        }
                        if (contador == 0) {
                            socio.colocarNcuenta(cuenta);
                        } else {
                            System.out.println("Error:\nIngrese un número entero sin espacios ni caracteres especiales");
                        }
                    } else {
                        System.out.println("El número de cuenta ya existe");
                        contador++;
                    }
                } else {
                    System.out.println("Ingrese un número entero");
                    contador++;
                }

            } while (contador != 0);

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

            resultado = false;
            while (!resultado) {
                System.out.print("Cédula->>         ");
                ced = puerta.nextLine();
                if (!ced.isEmpty()) {
                    resultado = RegistroCedula.verificarCedula(ced);
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

            socio.colocarDeposito(0f);
            socio.colocarRetiro(0f);
            socio.colocarSaldo(0f);

           
            
      
    return socio;
    }
    
        //salida
        public static void grabar(Lista socio) throws FileNotFoundException, IOException {
        
            Scanner puerta = new Scanner(System.in);
//declaracion de variables
        

        Lista socio1 = new Lista();

        String[] dato;
        String  cadena, temp, temp1, opcion;
        int   k, j;
        char op;
        
            System.out.printf("%5s%10s  %-20s%-15s %-10s%12s%12s%12s\n", "", "# Cuenta", "Nombre", "Cedula", "Tipo Cuenta", "Depósito", "Retiro", "Saldo");

        for (k = 0; k < socio.size(); k++) {

            System.out.printf("%8s%-7s  %-20s%-15s %-10c%12.2f%12.2f%12.2f\n",
                    "", socio.get(k).obtenerNcuenta(), socio.get(k).obtenerNom(), socio.get(k).obtenerCedula(),
                    socio.get(k).obtenerTipocuenta(), socio.get(k).obtenerDeposito(), socio.get(k).obtenerRetiro(), socio.get(k).obtenerSaldo());

        }

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

            if (archivo.exists()) {
                System.out.println("Añadiendo datos al archivo  " + archivo);
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
                PrintWriter salida = new PrintWriter(archivo);
                if (j != 0) {
                    for (k = 0; k <= j - 1; k++) {
                        temp1 = socio1.get(k).obtenerNcuenta() + "::" + socio1.get(k).obtenerNom() + "::" + socio1.get(k).obtenerCedula() + "::"
                                + socio1.get(k).obtenerTipocuenta() + "::" + socio1.get(k).obtenerDeposito() + "::" + socio1.get(k).obtenerRetiro() + "::" + socio1.get(k).obtenerSaldo();
                        salida.println(temp1);
                    }

                }
                for (k = 0; k < socio.size(); k++) {
                    temp = socio.get(k).obtenerNcuenta() + "::" + socio.get(k).obtenerNom() + "::" + socio.get(k).obtenerCedula() + "::"
                            + socio.get(k).obtenerTipocuenta() + "::" + socio.get(k).obtenerDeposito() + "::" + socio.get(k).obtenerRetiro() + "::" + socio.get(k).obtenerSaldo();
                    salida.println(temp);
                }

                salida.close();
                System.out.println("Listo...!!!");
            } else {
                System.out.println("Creando Archivo  " + archivo);
                PrintWriter salida = new PrintWriter(archivo);
                for (k = 0; k < socio.size(); k++) {
                    temp = socio.get(k).obtenerNcuenta() + "::" + socio.get(k).obtenerNom() + "::" + socio.get(k).obtenerCedula() + "::"
                            + socio.get(k).obtenerTipocuenta() + "::" + socio.get(k).obtenerDeposito() + "::" + socio.get(k).obtenerRetiro() + "::" + socio.get(k).obtenerSaldo();
                    salida.println(temp);
                }

                salida.close();
                System.out.println("Listo...!!!");
            }

        }

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        grabar(socios());
    }

}
