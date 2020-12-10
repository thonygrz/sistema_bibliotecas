/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author alexander
 */
public class TrazaMovimientos {
    public String destino;
    public String metodo;
    public String peticion;
    public Date fecha;
    
    public TrazaMovimientos(String destino, String metodo, String peticion, Date fecha) {
        this.destino = destino;
        this.metodo = metodo;
        this.peticion = peticion;
        this.fecha = fecha;
    }
    
    public void guardarTraza() {
        File archivo;
        FileWriter fw = null;
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        try {
            archivo = new File("src/Log/logs.txt");
            fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
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
