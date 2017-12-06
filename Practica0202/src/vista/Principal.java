/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;

/**
 *
 * @author Jorge Pizarro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestionDato gD=new GestionDato();
        VentanaPrincipal ventana=new VentanaPrincipal(gD,"Manejo de Archivos");
        
    }
    
}
