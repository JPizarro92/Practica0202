/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaPrincipal;

/**
 *
 * @author Jorge Pizarro
 */
public class EventoPrincipal implements ActionListener{

    VentanaPrincipal vPrincipal;

    public EventoPrincipal(VentanaPrincipal vPrincipal) {
        this.vPrincipal = vPrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
