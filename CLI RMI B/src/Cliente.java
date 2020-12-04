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
        cliente.connectServer();
    }
    
    private void connectServer() {
        try { 
            Peticion request = new Peticion("B","100 años de soledad","");
            Peticion request2 = new Peticion("B","Luna lunera","");
            request.start();
            request2.start();
            
            
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}
