/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yepezjuan;
import java.io.*;
public class RegistroCedula {

    static boolean verificarCedula(String ced)throws IOException {
        BufferedReader puerta = new BufferedReader(new InputStreamReader(System.in));
        int acumulador = 0;
        int acumulador2 = 0;
        int suma, suma2, resta;
        int ds = 10;
        boolean verif;
        
        String cedula;
        
        
            
            cedula= ced.trim();
            if(cedula.length()!=10){
                System.out.println("El numero es incorrecto");
                verif = false;
                return verif ;
            }else{
        for (int x = 0; x <= 8; x = x + 2) {
            suma = (Character.digit(cedula.charAt(x), 10)) * 2;
            if (suma >= 10) {
                suma = suma - 9;
            }
            acumulador = acumulador + suma;
        }
        
        for (int x = 1; x <= 7; x = x + 2) {
            suma2 = (Character.digit(cedula.charAt(x), 10));

            acumulador2 = acumulador2 + suma2;
        }
        
        int var = acumulador + acumulador2;
        while (var > ds){
                ds = ds + 10;
        } 
        
        resta = ds - var;
        
        verif = (resta == Character.digit(cedula.charAt(9), 10));
        if(!verif){
            System.out.println("Cédula incorrecta");
        }
            
        return verif;
    }
    }

    public static void main(String[] args) throws IOException{
        boolean resultado = verificarCedula("1804724563");
        System.out.println("La cédula es:  " + resultado);
    }
}
