package Main;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

//Contiene toda la logica para guardar los Logs de las peticiones en el servidor
public class TrazaMovimientos {
    public String destino;
    public String metodo;
    public String peticion;
    public Date fecha;
    

    //Constructor de la clase
    public TrazaMovimientos(String destino, String metodo, String peticion, Date fecha) {
        this.destino = destino;
        this.metodo = metodo;
        this.peticion = peticion;
        this.fecha = fecha;
    }
    
    //metodo para guardar las peticiones del cliente en el log.txt
    public void guardarTraza() {
        //Definimos la clase File y FileWriter para buscar y escribir en el archivo
        File archivo;
        FileWriter fw = null;
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        try {
            //Definimos la clase File y FileWriter para buscar y escribir en el archivo
            archivo = new File("src/Log/logs.txt");
            fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            //Escribmos el log para cuando se vaya a realizar una respuesta
            bw.write("Destino: Biblioteca " + this.destino + " - Metodo: " + this.metodo + " - Peticion: " + this.peticion + " - Fecha: " + df.format(fecha) + "\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
	} finally {
            if (fw != null) {
                try {
                    fw.close();
		} catch (IOException e) {
                    e.printStackTrace();
		}
            }
	}
    } 
}
