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
import java.util.Arrays;

public class Cliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.connectServer();
    }
    
    private void connectServer() {
        try {
            String libro[];
            String autor;
            String biblioteca = "B";
            
            // SI ES de A --> A, no pasa por el middleware
            switch (biblioteca) {
                case "A":
                    {
                        // PEDIR LIBRO XX
                        Registry registro = LocateRegistry.getRegistry("192.168.99.1", 7777); //pedir al servidor A
                        Middleware interfaz = (Middleware)registro.lookup("RemoteRMI");
                        // llama a pedir libro en servidor A
                        // SI NO HAY EN SERVIDOR A, entonces va de A-->B por lo tanto pasa por el middleware
                        // Transformar a Z39
                        // Enviar A servidor B
                        
                        // ------------------------------------------------------------------
                        libro = interfaz.pedirLibro("100 años de soledad");
                        autor = interfaz.pedirAutor("Antonio Banderas");
                        System.out.println(Arrays.toString(libro));
                        System.out.println(autor);
                    }
                case "B":
                    {
                        Registry registro = LocateRegistry.getRegistry("192.168.99.1", 7778); //pedir al servidor B
                        Middleware interfaz = (Middleware)registro.lookup("RemoteRMIB");
                        // llama a pedir libro en servidor B
                        libro = interfaz.getTitle("100 años de soledad");
                        autor = interfaz.getAuthor("Antonio Banderas");
                        
                        //System.out.println("La suma es " + suma);
                        System.out.println(libro[0]);
                        System.out.println(libro[1]);
                        System.out.println(libro[2]);
                        System.out.println(libro[3]);
                        //System.out.println(autor);
                    }
                case "C":
                    {
                        Registry registro = LocateRegistry.getRegistry("192.168.99.1", 7778); //pedir al servidor c
                        Middleware interfaz = (Middleware)registro.lookup("RemoteRMIC");
                        // llama a pedir libro en servidor c
                        libro = interfaz.getTitle("100 años de soledad");
                        autor = interfaz.getAuthor("Antonio Banderas");
                        
                        System.out.println(libro);
                        System.out.println(autor);
                    }
            }
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}
