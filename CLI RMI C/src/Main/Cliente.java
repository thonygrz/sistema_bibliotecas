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
import java.util.Date;

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
            TrazaMovimientos tm;
            
            // SI ES de A --> A, no pasa por el middleware
            switch (biblioteca) {
                case "A":
                    {
                        try {

                            Registry registro = LocateRegistry.getRegistry("10.0.0.3", 7777); //pedir al servidor B
                            Middleware interfaz = (Middleware)registro.lookup("RemoteRMI");
                            // llama a pedir libro en servidor B
                            final StringBuilder builder = new StringBuilder();

                            if (tipoBusqueda.equals("libro")){
                                libro = interfaz.getTitle(valor,"C");

                                tm = new TrazaMovimientos("A", "getTitle", valor, new Date());
                                tm.guardarTraza();

                                if (libro.size() == 0){
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
                                autorLibros = interfaz.getAuthor(valor,"C");

                                tm = new TrazaMovimientos("A", "getAuthor", valor, new Date());
                                tm.guardarTraza();

                                if (autorLibros.size() == 0){
                                    System.out.println("Autor no encontrado");
                                    return "Autor no encontrado";
                                }
                                else {
                                    builder.append("-------Resultado------- \n");
                                    for(int i=0 ; i < autorLibros.size() ; i++) {
                                        for(int j=0 ; j < autorLibros.get(i).size() ; j++) {
                                            System.out.println(autorLibros.get(i).get(j));
                                            builder.append(autorLibros.get(i).get(j) + "\n");
                                        } 
                                        builder.append("---------------------\n");
                                    }
                                }
                            }

                            String resultado = builder.toString();

                            System.out.println("Se va a enviar al cliente:"+resultado);
                            return resultado;
                        }
                        catch (Exception ex){
                            return "Hubo un error al conectar con el servidor de la biblioteca "+biblioteca + "\n\n" + ex.getMessage();
                        }
                    }
                case "B":
                    {
                        try{
                            Registry registro = LocateRegistry.getRegistry("10.0.0.2", 7778); //pedir al servidor B
                            Middleware interfaz = (Middleware)registro.lookup("RemoteRMIB");
                            // llama a pedir libro en servidor B
                            final StringBuilder builder = new StringBuilder();

                            if (tipoBusqueda.equals("libro")){
                                libro = interfaz.getTitle(valor,"C");
                                tm = new TrazaMovimientos("B", "getTitle", valor, new Date());
                                tm.guardarTraza();

                                if (libro.size() == 0){
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
                                autorLibros = interfaz.getAuthor(valor,"C");
                                tm = new TrazaMovimientos("B", "getAuthor", valor, new Date());
                                tm.guardarTraza();

                                if (autorLibros.size() == 0){
                                    System.out.println("Autor no encontrado");
                                    return "Autor no encontrado";
                                }
                                else {
                                    builder.append("-------Resultado------- \n");
                                    for(int i=0 ; i < autorLibros.size() ; i++) {
                                        for(int j=0 ; j < autorLibros.get(i).size() ; j++) {
                                            System.out.println(autorLibros.get(i).get(j));
                                            builder.append(autorLibros.get(i).get(j) + "\n");
                                        } 
                                        builder.append("---------------------\n");
                                    }
                                }
                            }

                            String resultado = builder.toString();

                            System.out.println("Se va a enviar al cliente:"+resultado);
                            return resultado;
                        }
                        catch (Exception ex){
                            return "Hubo un error al conectar con el servidor de la biblioteca "+biblioteca;
                        }
                    }
                case "C":
                    {
                       try{

                             Registry registro = LocateRegistry.getRegistry("10.0.0.4", 7779); //pedir al servidor B
                             Middleware interfaz = (Middleware)registro.lookup("RemoteRMIC");
                             // llama a pedir libro en servidor B
                             final StringBuilder builder = new StringBuilder();

                             if (tipoBusqueda.equals("libro")){
                                 libro = interfaz.encontrarVol(valor,"");
                                 tm = new TrazaMovimientos("C", "encontrarVol", valor, new Date());
                                 tm.guardarTraza();

                                 if (libro.size() == 0){
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
                                 autorLibros = interfaz.encontrarAutor(valor,"");
                                 tm = new TrazaMovimientos("C", "encontrarAutor", valor, new Date());
                                 tm.guardarTraza();

                                 if (autorLibros.size() == 0){
                                     System.out.println("Autor no encontrado");
                                     return "Autor no encontrado";
                                 }
                                 else {
                                     builder.append("-------Resultado------- \n");
                                     for(int i=0 ; i < autorLibros.size() ; i++) {
                                         for(int j=0 ; j < autorLibros.get(i).size() ; j++) {
                                             System.out.println(autorLibros.get(i).get(j));
                                             builder.append(autorLibros.get(i).get(j) + "\n");
                                         } 
                                         builder.append("---------------------\n");
                                     }
                                 }
                             }

                             String resultado = builder.toString();

                             System.out.println("Se va a enviar al cliente:"+resultado);
                             return resultado;
                        }
                        catch (Exception ex){
                            return "Hubo un error al conectar con el servidor de la biblioteca "+biblioteca;
                        }
                    }
                default:
                    return "Biblioteca no registrada";
            }
        } catch (Exception ex){
            System.out.println(ex);
        }
        return "nada";
    }
}
