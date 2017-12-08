package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
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
        this.vPrincipal.setIdioma("internacionalizacion.etiquetas_ES");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(0))) {
            this.vPrincipal.setrB(ResourceBundle.getBundle("internacionalizacion.etiquetas_ES"));
            this.vPrincipal.cargaIdioma();
            this.vPrincipal.setIdioma("internacionalizacion.etiquetas_ES");
        }
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(1))) {
            this.vPrincipal.setrB(ResourceBundle.getBundle("internacionalizacion.etiquetas_EN"));
            this.vPrincipal.cargaIdioma();
            this.vPrincipal.setIdioma("internacionalizacion.etiquetas_EN");
        }
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(2))) {
            this.vPrincipal.setrB(ResourceBundle.getBundle("internacionalizacion.etiquetas_FR"));
            this.vPrincipal.cargaIdioma();
            this.vPrincipal.setIdioma("internacionalizacion.etiquetas_FR");
        }
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(3))) {
            VentanaPaciente ventana = new VentanaPaciente(this.vPrincipal.getrB().getString("etiqueta_9"), this.vPrincipal.getgD(), this.vPrincipal.getIdioma());
            ventana.setVisible(true);
            this.vPrincipal.getEscritorio().add(ventana);            
        }
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(4))) {
            VentanaMedico ventana = new VentanaMedico(this.vPrincipal.getrB().getString("etiqueta_10"), this.vPrincipal.getgD(), this.vPrincipal.getIdioma());
            ventana.setVisible(true);
            this.vPrincipal.getEscritorio().add(ventana);
        }
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(5))) {
            VentanaConsulta ventana = new VentanaConsulta(this.vPrincipal.getrB().getString("etiqueta_11"), this.vPrincipal.getgD(), this.vPrincipal.getIdioma());
            ventana.setVisible(true);
            this.vPrincipal.getEscritorio().add(ventana);
        }
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(6))) {
            VentanaArchivos ventana = new VentanaArchivos(this.vPrincipal.getrB().getString("etiqueta_23"), this.vPrincipal.getgD(), this.vPrincipal.getIdioma());
            ventana.setVisible(true);
            this.vPrincipal.getEscritorio().add(ventana);
        }
    }

}
