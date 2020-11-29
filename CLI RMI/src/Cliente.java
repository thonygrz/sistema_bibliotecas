/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexis
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.connectServer();
    }
    
    private void connectServer() {
        try {
            int suma;
            String libro;
            String autor;
            
            // SI ES de A --> A, no pasa por el middleware
            // PEDIR LIBRO XX
            Registry registro = LocateRegistry.getRegistry("192.168.99.1", 7777); //pedir al servidor A
            RMI interfaz = (RMI)registro.lookup("RemoteRMI");
            suma = interfaz.sumar(8, 5); // llama a pedir libro en servidor A
            System.out.println("La suma es " + suma);
            
            // SI NO HAY EN SERVIDOR A, entonces va de A-->B por lo tanto pasa por el middleware
            // Transformar a Z39
            // Enviar A servidor B
            
            // ------------------------------------------------------------------
            libro = interfaz.pedirLibro("100 años de soledad");
            autor = interfaz.pedirAutor("Antonio Banderas");
            
            System.out.println(libro);
            System.out.println(autor);
            
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}
