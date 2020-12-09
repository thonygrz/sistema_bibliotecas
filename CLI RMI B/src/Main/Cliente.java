package Main;

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
import java.util.ArrayList;

public class Cliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        //cliente.connectServer("100 años de soledad");
    }
    
    public String connectServer(String valor, String biblio, String tipoBusqueda) {
        try {
            ArrayList<String> libro = new ArrayList();
            ArrayList<ArrayList> autorLibros = new ArrayList();
            String biblioteca = biblio;
            
            // SI ES de A --> A, no pasa por el middleware
            switch (biblioteca) {
                case "A":
                    {
                        // PEDIR LIBRO XX
                        /*Registry registro = LocateRegistry.getRegistry("192.168.99.1", 7777); //pedir al servidor A
                        Middleware interfaz = (Middleware)registro.lookup("RemoteRMI");*/
                        // llama a pedir libro en servidor A
                        // SI NO HAY EN SERVIDOR A, entonces va de A-->B por lo tanto pasa por el middleware
                        // Transformar a Z39
                        // Enviar A servidor B
                        
                        // ------------------------------------------------------------------
                        /* libro = interfaz.pedirLibro("100 años de soledad");
                        autorLibros = interfaz.pedirAutor("Antonio Banderas","A"); */
                        
                       /*  if (libro == null){
                            System.out.println("Libro no encontrado");
                        }
                        else {
                            libro.forEach((item) -> System.out.println(item));
                            //System.out.println(autor);
                        }
                        
                        for(int i=0 ; i < autorLibros.size() ; i++) {
                            for(int j=0 ; j < autorLibros.get(i).size() ; j++) {
                                System.out.println(autorLibros.get(i).get(j));
                            } 
                        }  */
                    }
                case "B":
                    {
                        Registry registro = LocateRegistry.getRegistry("192.168.99.1", 7777); //pedir al servidor B
                        Middleware interfaz = (Middleware)registro.lookup("RemoteRMIB");
                        // llama a pedir libro en servidor B
                        final StringBuilder builder = new StringBuilder();

                        if (tipoBusqueda.equals("libro")){
                            libro = interfaz.getTitle(valor,"");

                            if (libro == null){
                                System.out.println("Libro no encontrado");
                                return "Libro no encontrado";
                            }
                            else {
                                 builder.append("-------Resultado------- \n");
                                 libro.forEach((item) -> {
                                     System.out.println(item);
                                     builder.append(item + "\n");
                                 });
                                //System.out.println(autor);
                            }
                        }
                        else if (tipoBusqueda.equals("autor")){
                            autorLibros = interfaz.getAuthor(valor,"");
                            builder.append("-------Resultado------- \n");
                            for(int i=0 ; i < autorLibros.size() ; i++) {
                                for(int j=0 ; j < autorLibros.get(i).size() ; j++) {
                                    System.out.println(autorLibros.get(i).get(j));
                                    builder.append(autorLibros.get(i).get(j) + "\n");
                                } 
                                builder.append("---------------------\n");
                            }

//                            for(ArrayList<ArrayList> items:autorLibros) {
//                                for(ArrayList<String> item: items) {
//                                    for(String i: item){
//                                        System.out.println(i);
////                                        builder.append(i + "\n");
//                                    }
//                                }  
//                            }
                        }
                        
                        String resultado = builder.toString();

                        System.out.println("Se va a enviar al cliente:"+resultado);
                        return resultado;
                    }
                case "C":
                    {
                       /*  Registry registro = LocateRegistry.getRegistry("192.168.56.1", 7778); //pedir al servidor c
                        Middleware interfaz = (Middleware)registro.lookup("RemoteRMIC");
                        // llama a pedir libro en servidor c
                        libro = interfaz.getTitle("100 años de soledad","C");
                        autorLibros = interfaz.getAuthor("Antonio Banderas","C");
                        
                        if (libro == null){
                            System.out.println("Libro no encontrado");
                        }
                        else {
                             libro.forEach((item) -> System.out.println(item));
                            //System.out.println(autor);
                        }
                        
                        for(int i=0 ; i < autorLibros.size() ; i++) {
                            for(int j=0 ; j < autorLibros.get(i).size() ; j++) {
                                System.out.println(autorLibros.get(i).get(j));
                            }  
                        } */
                    }
            }
        } catch (Exception ex){
            System.out.println(ex);
        }
        return "nada";
    }
}
