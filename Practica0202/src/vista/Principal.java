/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author Jorge Pizarro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File f = new File(""); // Creamos un objeto file
        String ruta = f.getAbsolutePath();
        
        List<Paciente> pacienteList=new ArrayList<Paciente>();
        List<Medico> medicoList=new ArrayList<Medico>();
        List<Consulta> consultaList=new ArrayList<Consulta>();
        GestionDato gD=new GestionDato(pacienteList, medicoList, consultaList);
        VentanaPrincipal ventana=new VentanaPrincipal(gD,"Manejo de Archivos");
        
    }
    
}
