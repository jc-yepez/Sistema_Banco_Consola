/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yepezjuan;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Menu {

    public static void menu() throws IOException {

        Scanner puerta = new Scanner(System.in);
        String opcion, continuar;
        char op;
        op = '0';
        do {
            System.out.printf("%15s%20s\n", "", "SISTEMA >> DEPOSITOS Y RETIROS <<");
            System.out.println("   MENU");
            System.out.printf("%15s%-20s\n%15s%-20s\n%15s%-20s\n%15s%-20s\n%15s%-20s\n%15s%-20s\n\n",
                    "", "1.- Clientes", "", "2.- Depositos", "", "3.- Retiros", "", "4.- Reportes", "", "5.- Transferencia entre cuentas", "", "6.- Salir");
            do {

                System.out.print("  ---->>>>>  ");
                opcion = puerta.nextLine();
                if (!opcion.isEmpty()) {
                    op = opcion.toUpperCase().charAt(0);
                    if (op != '1' && op != '2' && op != '3' && op != '4' && op != '5' && op != '6') {
                        System.out.println("Erro:\n Ingrese el un número del menú < 1 > ,< 2 > ,< 3 > ,< 4 >, < 5 >, < 6 >");
                    }
                } else {
                    System.out.println("Elija una opcion...");
                }
            } while (op != '1' && op != '2' && op != '3' && op != '4' && op != '5' && op != '6');

            switch (op) {
                case '1':
                    do {
                        System.out.printf("%20s%20s\n\n", "", "CLIENTES ");
                        System.out.println("   SUB - MENU");
                        System.out.printf("%15s%-20s\n%15s%-20s\n%15s%-20s\n%15s%-20s\n%15s%-20s\n\n",
                                "", "1.- Nuevo", "", "2.- Buscar", "", "3.- Modificar", "", "4.- Eliminar", "", "5.- Regresar al menú principal");
                        do {

                            System.out.print("  ---->>>>>  ");
                            opcion = puerta.nextLine();
                            if (!opcion.isEmpty()) {
                                op = opcion.toUpperCase().charAt(0);
                                if (op != '1' && op != '2' && op != '3' && op != '4' && op != '5') {
                                    System.out.println("Erro:\n Ingrese el un número del menú < 1 > ,< 2 > ,< 3 > ,< 4 >, < 5 >");
                                }
                            } else {
                                System.out.println("Elija una opcion...");
                            }
                        } while (op != '1' && op != '2' && op != '3' && op != '4' && op != '5');
                        switch (op) {
                            case '1':
                                Ingreso.grabar(Ingreso.socios());
                                do {
                                    System.out.print("\nPresione enter para continuar...");
                                    continuar = puerta.nextLine();

                                } while (!continuar.isEmpty());
                                break;
                            case '2':
                                String resultado;
                                resultado = Busqueda.buscar();
                                do {
                                    System.out.print("\nPresione enter para continuar...");
                                    continuar = puerta.nextLine();

                                } while (!continuar.isEmpty());
                                break;
                            case '3':
                                Modificacion.modificar();
                                do {
                                    System.out.print("\nPresione enter para continuar...");
                                    continuar = puerta.nextLine();

                                } while (!continuar.isEmpty());
                                break;
                            case '4':
                                Exclusion.eliminar();
                                do {
                                    System.out.print("\nPresione enter para continuar...");
                                    continuar = puerta.nextLine();

                                } while (!continuar.isEmpty());
                                break;
                            case '5':
                                op = '0';
                                break;
                        }
                    } while (op != '0');
                    break;
                case '2':
                    do {
                        Depositos.depositar();
                        System.out.println("Desea realizar otro Depósito (S/N) ?\n");
                        do {
                            System.out.print("  ---->>>>>  ");
                            opcion = puerta.nextLine();
                            if (!opcion.isEmpty()) {
                                op = opcion.toUpperCase().charAt(0);
                                if (op != 'S' && op != 'N') {
                                    System.out.println("Erro:\n Ingrese la letra < S > o < N > ");
                                }
                            } else {
                                System.out.println("Elija una opcion...");
                            }
                        } while (op != 'S' && op != 'N');

                    } while (op != 'N');
                    do {
                        System.out.print("\nPresione enter para continuar...");
                        continuar = puerta.nextLine();

                    } while (!continuar.isEmpty());
                    break;
                case '3':
                    do {
                        Retiros.retirar();
                        System.out.println("Desea realizar otro Retiro (S/N) ?\n");
                        do {
                            System.out.print("  ---->>>>>  ");
                            opcion = puerta.nextLine();
                            if (!opcion.isEmpty()) {
                                op = opcion.toUpperCase().charAt(0);
                                if (op != 'S' && op != 'N') {
                                    System.out.println("Erro:\n Ingrese la letra < S > o < N > ");
                                }
                            } else {
                                System.out.println("Elija una opcion...");
                            }
                        } while (op != 'S' && op != 'N');

                    } while (op != 'N');
                    do {
                        System.out.print("\nPresione enter para continuar...");
                        continuar = puerta.nextLine();

                    } while (!continuar.isEmpty());
                    break;
                case '4':
                    do {
                        System.out.printf("%20s%20s\n\n", "", "REPORTES ");
                        System.out.println("   SUB - MENU");
                        System.out.printf("%15s%-20s\n%15s%-20s\n%15s%-20s\n%15s%-20s\n\n",
                                "", "1.- Todas las cuentas", "", "2.- Cuentas de Ahorro", "", "3.- Cuentas Corrientes", "", "4.- Regresar al menú principal");
                        do {

                            System.out.print("  ---->>>>>  ");
                            opcion = puerta.nextLine();
                            if (!opcion.isEmpty()) {
                                op = opcion.toUpperCase().charAt(0);
                                if (op != '1' && op != '2' && op != '3' && op != '4') {
                                    System.out.println("Erro:\n Ingrese el un número del menú < 1 > ,< 2 > ,< 3 > ,< 4 >");
                                }
                            } else {
                                System.out.println("Elija una opcion...");
                            }
                        } while (op != '1' && op != '2' && op != '3' && op != '4');
                        switch (op) {
                            case '1':
                                Reporte.total();
                                do {
                                    System.out.print("\nPresione enter para continuar...");
                                    continuar = puerta.nextLine();

                                } while (!continuar.isEmpty());
                                break;
                            case '2':
                                Reporte.ahorro();
                                do {
                                    System.out.print("\nPresione enter para continuar...");
                                    continuar = puerta.nextLine();

                                } while (!continuar.isEmpty());
                                break;
                            case '3':
                                Reporte.corriente();
                                do {
                                    System.out.print("\nPresione enter para continuar...");
                                    continuar = puerta.nextLine();
                                } while (!continuar.isEmpty());
                                break;

                            case '4':
                                break;
                        }
                    } while (op != '4');
                    break;
                case '5':
                    do {
                        Transferencia.transferir();
                        System.out.println("Desea realizar otra Transferencia (S/N) ?\n");
                        do {
                            System.out.print("  ---->>>>>  ");
                            opcion = puerta.nextLine();
                            if (!opcion.isEmpty()) {
                                op = opcion.toUpperCase().charAt(0);
                                if (op != 'S' && op != 'N') {
                                    System.out.println("Erro:\n Ingrese la letra < S > o < N > ");
                                }
                            } else {
                                System.out.println("Elija una opcion...");
                            }
                        } while (op != 'S' && op != 'N');

                    } while (op != 'N');
                    do {
                        System.out.print("\nPresione enter para continuar...");
                        continuar = puerta.nextLine();

                    } while (!continuar.isEmpty());
                    break;
                case '6':
                    break;
            }

        } while (op != '6');
        System.out.println("Aplicación Cerrada...");
    }
    public static void main(String[] args) throws IOException {
        menu();
    }
}
