package Main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;

public class Cliente {
    
    public String connectServer(String valor, String biblio, String tipoBusqueda) {
        try {
            ArrayList<String> libro = new ArrayList();
            ArrayList<ArrayList> autorLibros = new ArrayList();
            String biblioteca = biblio;
            TrazaMovimientos tm;
            
            switch (biblioteca) {
                case "A":
                    {
                        try {
                            // Se hace la conexión RMI
                            Registry registro = LocateRegistry.getRegistry("10.2.126.73", 7777);
                            Middleware interfaz = (Middleware)registro.lookup("RemoteRMI");
                            
                            final StringBuilder builder = new StringBuilder();
                            
                            // Si la peticion fue de libro
                            if (tipoBusqueda.equals("libro")){
                                // se ejecuta el método con lenguaje Z39 con RMI
                                libro = interfaz.encontrarVol(valor,"");
                                
                                // se ejecutan los logs del cliente
                                tm = new TrazaMovimientos("A", "pedirLibro", valor, new Date());
                                tm.guardarTraza();
                                
                                // se arregla el mensaje a mostrar
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
                                }
                            } // Si la peticion fue de autor
                            else if (tipoBusqueda.equals("autor")){
                                // se ejecuta el método con lenguaje Z39 con RMI 
                                autorLibros = interfaz.encontrarAutor(valor,"");
                                
                                // se ejecutan los logs del cliente
                                tm = new TrazaMovimientos("A", "pedirAutor", valor, new Date());
                                tm.guardarTraza();
                                
                                // se arregla el mensaje a mostrar
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

                            return resultado;
                        }
                        catch (Exception ex){
                            return "Hubo un error al conectar con el servidor de la biblioteca "+biblioteca + "\n\n" + ex.getMessage();
                        }
                    }
                case "B":
                    {
                        try{
                            // Se hace la conexión RMI
                            Registry registro = LocateRegistry.getRegistry("10.2.126.84", 7778); //pedir al servidor B
                            Middleware interfaz = (Middleware)registro.lookup("RemoteRMIB");
                            
                            final StringBuilder builder = new StringBuilder();

                            // Si la peticion fue de libro
                            if (tipoBusqueda.equals("libro")){
                                // se ejecuta el método con lenguaje Z39 con RMI
                                libro = interfaz.getTitle(valor,"A");
                                
                                // se ejecutan los logs del cliente
                                tm = new TrazaMovimientos("B", "getTitle", valor, new Date());
                                tm.guardarTraza();

                                // se arregla el mensaje a mostrar
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
                                }
                            } // Si la peticion fue de autor
                            else if (tipoBusqueda.equals("autor")){
                                // se ejecuta el método con lenguaje Z39 con RMI 
                                autorLibros = interfaz.getAuthor(valor,"A");
                                
                                // se ejecutan los logs del cliente
                                tm = new TrazaMovimientos("B", "getAuthor", valor, new Date());
                                tm.guardarTraza();
                                
                                // se arregla el mensaje a mostrar
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

                            return resultado;
                        }
                        catch (Exception ex){
                            return "Hubo un error al conectar con el servidor de la biblioteca "+biblioteca;
                        }
                    }
                case "C":
                    {
                       try{
                            // Se hace la conexión RMI
                            Registry registro = LocateRegistry.getRegistry("10.2.126.74", 7779); //pedir al servidor B
                             Middleware interfaz = (Middleware)registro.lookup("RemoteRMIC");
                             
                             final StringBuilder builder = new StringBuilder();
                             
                             // Si la peticion fue de libro
                             if (tipoBusqueda.equals("libro")){
                                 // se ejecuta el método del mismo servidor con RMI 
                                 libro = interfaz.getTitle(valor,"A");
                                 
                                 // se ejecutan los logs del cliente
                                 tm = new TrazaMovimientos("C", "getTitle", valor, new Date());
                                 tm.guardarTraza();

                                 // se arregla el mensaje a mostrar
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
                                 }
                             } // Si la peticion fue de libro
                             else if (tipoBusqueda.equals("autor")){
                                 // se ejecuta el método del mismo servidor con RMI 
                                 autorLibros = interfaz.getAuthor(valor,"A");
                                 
                                 // se ejecutan los logs del cliente
                                 tm = new TrazaMovimientos("C", "getAuthor", valor, new Date());
                                 tm.guardarTraza();
                                 
                                 // se arregla el mensaje a mostrar
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