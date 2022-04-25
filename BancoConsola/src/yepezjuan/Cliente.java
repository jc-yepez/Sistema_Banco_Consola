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
public class Cliente {

    String ncuenta, nom, cedula;
    char tipocuenta;
    float retiro, deposito, saldo;

    
    
    public void colocarNcuenta(String ncuenta) {
        this.ncuenta = ncuenta;
    }

    public void colocarNom(String nom) {
        this.nom = nom;
    }

    public void colocarCedula(String cedula) {
        this.cedula = cedula;
    }

    public void colocarTipocuenta(char tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public void colocarRetiro(float retiro) {
        this.retiro = retiro;
    }

    public void colocarDeposito(float deposito) {
        this.deposito = deposito;
    }

    public void colocarSaldo(float saldo) {
        this.saldo = saldo;
    }

    
    
    public String obtenerNcuenta() {
        return ncuenta;
    }

    public String obtenerNom() {
        return nom;
    }

    public String obtenerCedula() {
        return cedula;
    }

    public char obtenerTipocuenta() {
        return tipocuenta;
    }

    public float obtenerRetiro() {
        return retiro;
    }

    public float obtenerDeposito() {
        return deposito;
    }

    public float obtenerSaldo() {
        return saldo;
    }
}
