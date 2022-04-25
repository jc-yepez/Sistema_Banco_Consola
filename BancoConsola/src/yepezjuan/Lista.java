/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yepezjuan;

/**
 *
 * @author PC
 */
public class Lista {

    Nodo inicio, fin;

    Lista() {
        inicio = null;
        fin = null;

    }

    boolean listaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void add(Cliente x) {
        Nodo a = new Nodo(x);

        if (inicio == null) {
            inicio = a;

            fin = inicio;

        } else {
            fin.sig = a;
            fin = a;

        }
    }

    public Cliente get(int x) {
        if (!listaVacia()) {
            Nodo reco = inicio;

            for (int i = 0; i < x; i++) {
                reco = reco.sig;
            }
            return reco.inf;
        }
        return null;
    }

    public int size() {
        if (!listaVacia()) {
            int pos = 0;
            Nodo reco = inicio;
            while (reco != null) {
                pos++;
                reco = reco.sig;
            }
            return pos;
        }
        return 0;
    }

    public void impresion() {
        if (!listaVacia()) {
            Nodo reco = inicio;
            System.out.printf("%5s%10s  %-20s%-15s %-10s%12s%12s%12s\n", "", "# Cuenta", "Nombre", "Cedula", "Tipo Cuenta", "Depósito", "Retiro", "Saldo");
            while (reco != null) {
                System.out.printf("%8s%-7s  %-20s%-15s %-10c%12.2f%12.2f%12.2f\n",
                        "", reco.inf.obtenerNcuenta(), reco.inf.obtenerNom(), reco.inf.obtenerCedula(),
                        reco.inf.obtenerTipocuenta(), reco.inf.obtenerDeposito(), reco.inf.obtenerRetiro(), reco.inf.obtenerSaldo());
                reco = reco.sig;
            }
        }
    }
}
