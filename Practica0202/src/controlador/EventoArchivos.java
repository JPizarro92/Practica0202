/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.VentanaArchivos;

/**
 *
 * @author saito
 */
public class EventoArchivos implements ActionListener {

    VentanaArchivos ventana;

    public EventoArchivos(VentanaArchivos ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource().equals(this.ventana.getBotonList().get(0))) {
                this.ventana.setRuta(this.ventana.selecionarRuta());
            }
            if (e.getSource().equals(this.ventana.getBotonList().get(1))) {
                if (this.ventana.getRuta() == null) {
                    throw new ExcepcionCamposVacios("");
                } else {
                    File a = new File(this.ventana.getRuta());
                    this.ventana.elimina(a);
                    this.ventana.getgD().guardarArchivoPaciente(this.ventana.getRuta());
                    this.ventana.getgD().guardarArchivoMedico(this.ventana.getRuta());
                    this.ventana.getgD().guardarArchivoConsulta(this.ventana.getRuta());
                }
            }
            if (e.getSource().equals(this.ventana.getBotonList().get(2))) {
                if (this.ventana.getRuta() == null) {
                    throw new ExcepcionCamposVacios("");
                } else {
                    File a = new File(this.ventana.getRuta());
                    this.ventana.elimina(a);
                    this.ventana.getgD().guardarArchivoPaciente(this.ventana.getRuta());
                    this.ventana.getgD().guardarArchivoMedico(this.ventana.getRuta());
                    this.ventana.getgD().guardarArchivoConsulta(this.ventana.getRuta());
                }
            }
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "Antes, seleccionar la ruta");
        }
    }

}
