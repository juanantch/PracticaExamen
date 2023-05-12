/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package validadorips;

import java.util.Scanner;

/**
 *
 * @author ciclos
 */
public class ValidadorIPs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCasos;
        String direccionIP;

        numCasos = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numCasos; i++) {

            direccionIP = sc.nextLine();

            try {
                if (esIPValida(direccionIP)) {
                    System.out.println(direccionIP + " es una IP VALIDA");
                } else {
                    System.out.println(direccionIP + " es una IP NO VALIDA");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(direccionIP + " es una cadena VACIA");
            }

        }
        

    }
    
    /**
     * El método esIPValida comprueba si una dirección IP es válida o no. Una dirección IP válida es una cadena que tiene cuatro octetos separados por puntos, donde cada octeto es un número entero entre 0 y 255. Si una dirección IP es válida, devuelve true, de lo contrario, devuelve false.
     * 
     * @param direccionIP la dirección IP a validar
     * @return true si la dirección IP es válida, false de lo contrario
     * @throws NullPointerException si la dirección IP es nula
     * @throws IllegalArgumentException si la dirección IP es una cadena vacía
     */

    public static boolean esIPValida(String direccionIP) throws NullPointerException {
        String octeto1;
        String octeto2;
        String octeto3;
        String octeto4;
        int octeto1Num = 0;
        int octeto2Num = 0;
        int octeto3Num = 0;
        int octeto4Num = 0;
        String cadena;
        boolean IPValida = true;
        int contPuntos = 0;
        int i = 0;

        if ("".equals(direccionIP)) {
            throw new IllegalArgumentException();
        }

        while (i < direccionIP.length() && contPuntos < 4) {
            if (direccionIP.charAt(i) == '.') {
                contPuntos++;
            }
            i++;
        }

        if (contPuntos != 3) {
            IPValida = false;
        }

        if (IPValida) {

            octeto1 = direccionIP.substring(0, direccionIP.indexOf("."));
            octeto4 = direccionIP.substring(direccionIP.lastIndexOf(".") + 1, direccionIP.length());
            cadena = direccionIP.substring(octeto1.length() + 1, direccionIP.lastIndexOf("."));
            octeto3 = cadena.substring(cadena.indexOf(".") + 1);
            octeto2 = cadena.substring(0, cadena.indexOf("."));

            if ((octeto1.length() > 1 && octeto1.startsWith("0")) || (octeto2.length() > 1 && octeto2.startsWith("0")) || (octeto3.length() > 1 && octeto3.startsWith("0")) || (octeto4.length() > 1 && octeto4.startsWith("0"))) {
                IPValida = false;
            }

            if (IPValida) {

                try {
                    octeto1Num = Integer.parseInt(octeto1);
                    octeto2Num = Integer.parseInt(octeto2);
                    octeto3Num = Integer.parseInt(octeto3);
                    octeto4Num = Integer.parseInt(octeto4);
                } catch (IllegalArgumentException e) {
                    IPValida = false;
                }

            }

            if (IPValida) {

                if ((octeto1Num < 0 || octeto1Num > 255) || (octeto2Num < 0 || octeto2Num > 255) || (octeto3Num < 0 || octeto3Num > 255) || (octeto4Num < 0 || octeto4Num > 255)) {
                    IPValida = false;
                }

            }

        }

        return IPValida;

    }

}
