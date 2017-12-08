package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaArchivos;
import vista.VentanaConsulta;
import vista.VentanaMedico;
import vista.VentanaPaciente;
import vista.VentanaPrincipal;

/**
 *
 * @author Jorge Pizarro
 */
public class EventoPrincipal implements ActionListener {

    VentanaPrincipal vPrincipal;

    public EventoPrincipal(VentanaPrincipal vPrincipal) {
        this.vPrincipal = vPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(0))) {
            VentanaPaciente ventana = new VentanaPaciente("AgregarPaciente", this.vPrincipal.getgD());
            ventana.setVisible(true);
            this.vPrincipal.getEscritorio().add(ventana);
        }
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(1))) {
            VentanaMedico ventana = new VentanaMedico("Agregar Médico", this.vPrincipal.getgD());
            ventana.setVisible(true);
            this.vPrincipal.getEscritorio().add(ventana);
        }
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(2))) {
            VentanaConsulta ventana = new VentanaConsulta("Asignar Consulta", this.vPrincipal.getgD());
            ventana.setVisible(true);
            this.vPrincipal.getEscritorio().add(ventana);
        }
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(3))) {
            VentanaArchivos ventana = new VentanaArchivos("Gestion Archivos", this.vPrincipal.getgD());
            ventana.setVisible(true);
            this.vPrincipal.getEscritorio().add(ventana);
        }
    }

}
