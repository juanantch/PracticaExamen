/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package validadorips;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ciclos
 */
public class ValidadorIPsTest {
    
    public ValidadorIPsTest() {
    }

    /**
     * Test of esIPValida method, of class ValidadorIPs.
     */
    @Test
    public void testEsIPValida_01() {
        System.out.println("IP valida sin octeto a 0");
        String direccionIP = "192.168.10.15";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertTrue(result);
    }

    @Test
    public void testEsIPValida_02a() {
        System.out.println("IP valida con octeto a 0 primero");
        String direccionIP = "0.168.10.15";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertTrue(result);
    }

    @Test
    public void testEsIPValida_02b() {
        System.out.println("IP valida con octeto a cero en medio");
        String direccionIP = "90.168.0.15";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertTrue(result);
    }

    @Test
    public void testEsIPValida_02c() {
        System.out.println("IP valida con octeto a cero al final");
        String direccionIP = "90.168.100.0";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void testEsIPValida_03() {
        System.out.println("Cadena nula");
        String direccionIP = null;

        ValidadorIPs.esIPValida(direccionIP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEsIPValida_04() {
        System.out.println("No valida - cadena vacia");
        String direccionIP = "";

        ValidadorIPs.esIPValida(direccionIP);
    }

    @Test
    public void testEsIPValida_05a() {
        System.out.println("No completa - 192");
        String direccionIP = "192";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertFalse(result);
    }

    @Test
    public void testEsIPValida_05b() {
        System.out.println("No completa - 192.122");
        String direccionIP = "192.122";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertFalse(result);
    }

    @Test
    public void testEsIPValida_05c() {
        System.out.println("No completa - 192.122.135");
        String direccionIP = "192.122.135";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertFalse(result);
    }

    @Test
    public void testEsIPValida_06a() {
        System.out.println("Valor octeto no valido - 192.500.135.45");
        String direccionIP = "192.500.135.45";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertFalse(result);
    }

    @Test
    public void testEsIPValida_06b() {
        System.out.println("Valor octeto no valido - 192.-55.135.45");
        String direccionIP = "192.-55.135.45";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertFalse(result);
    }

    @Test
    public void testEsIPValida_06c() {
        System.out.println("Valor octeto no valido - 192.4e.135.45");
        String direccionIP = "192.4e.135.45";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertFalse(result);
    }

    @Test
    public void testEsIPValida_07() {
        System.out.println("Separadores no validos - 192,168,10,11");
        String direccionIP = "192,168,10,11";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertFalse(result);
    }

    @Test
    public void testEsIPValida_08() {
        System.out.println("Direccion terminada en punto tras cuarto octeto - 192.168.10.11.");
        String direccionIP = "192.168.10.11.";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertFalse(result);
    }

    @Test
    public void testEsIPValida_09a() {
        System.out.println("Direccion con error octeto empieza con 0 - 192.05.10.11");
        String direccionIP = "192.05.10.11";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertFalse(result);
    }

    @Test
    public void testEsIPValida_09b() {
        System.out.println("Direccion con error octeto empieza con 0 - 092.5.10.11");
        String direccionIP = "092.5.10.11";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertFalse(result);
    }

    @Test
    public void testEsIPValida_09c() {
        System.out.println("Direccion con error octeto empieza con 0 - 192.05.10.11");
        String direccionIP = "92.5.10.08";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertFalse(result);
    }

    @Test
    public void testEsIPValida_09d() {
        System.out.println("Direccion con error octeto empieza con 0 - 76.14.200.00");
        String direccionIP = "76.14.200.00";

        boolean result = ValidadorIPs.esIPValida(direccionIP);
        assertFalse(result);
    }

    
}
