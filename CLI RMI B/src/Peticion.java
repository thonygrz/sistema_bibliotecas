import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

class Peticion extends Thread{

    String titulo;
    String autor;
    String biblioteca;
    ArrayList<String> libro = new ArrayList();
    ArrayList<ArrayList> autorLibros = new ArrayList();
    

    public Peticion(String biblioteca, String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.biblioteca = biblioteca;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getBiblioteca() {
        return biblioteca;
    }

    
    
    @Override
    public void run(){
        
        try{
            switch (this.getBiblioteca()) {
                case "A":
                    System.out.println("A");
                    break;
            
                case "B":
                    Registry registro = LocateRegistry.getRegistry("192.168.56.1", 7778);
                    Middleware interfaz = (Middleware)registro.lookup("RemoteRMIB");
                    if(this.getAutor() == null || this.getAutor() == ""){
                        if(this.getTitulo() != null && this.getTitulo() != ""){
                            libro = interfaz.getTitle(this.getTitulo());
                            this.imprimirLibro();
                        }
                    }
                    else {
                        autorLibros = interfaz.buscarAutor(this.getAutor());
                        this.imprimirAutor();
                    }
                    break;


                case "C":
                    System.out.println("C");
                    break;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private void imprimirLibro(){
        if (libro == null ){
            System.out.println("Libro no encontrado");
        }
        else {
            libro.forEach((item) -> System.out.println(item));
        }
    }

    private void imprimirAutor(){
        for(int i=0 ; i < autorLibros.size() ; i++) {
            for(int j=0 ; j < autorLibros.get(i).size() ; j++) {
                System.out.println(autorLibros.get(i).get(j));
            } 
        }
        
        for(ArrayList<ArrayList> items:autorLibros) {
            for(ArrayList<String> item: items) {
                for(String i: item){
                    System.out.println(i);
                }
            }  
        } 
    }
}