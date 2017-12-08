package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Medico;
import vista.VentanaMedico;

public class EventoMedico implements ActionListener {

    private VentanaMedico ventana;

    public EventoMedico(VentanaMedico ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource().equals(this.ventana.getBotonList().get(0))) {
                //Guardar
                for(int i = 0 ; i<this.ventana.getTextoList().size() ; i++) {
                    if(this.ventana.getTextoList().get(i).getText().equals("")){
                        throw new ExcepcionCamposVacios("");
                    }
                }
                int codigo = Integer.parseInt(this.ventana.getTextoList().get(0).getText());
                String nombre = this.ventana.getTextoList().get(1).getText();
                String apellido = this.ventana.getTextoList().get(2).getText();
                String profesion = this.ventana.getTextoList().get(3).getText();
               
                Medico m = new Medico(codigo, nombre, apellido, profesion);
                for(Medico me: this.ventana.getgD().getMedicoList()) {
                    if(m.getCodigo()==me.getCodigo()) {
                        throw new ExcepcionRepetidos("");
                    }
                }
                this.ventana.getgD().addMedico(m);
            }
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(ventana, "El código debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "No dejar los campos vacios");
        } catch (ExcepcionRepetidos ex) {
            JOptionPane.showMessageDialog(ventana, "Medico ya registrado", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource().equals(this.ventana.getBotonList().get(1))) {
            //Limpiar
            for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                this.ventana.getTextoList().get(i).setText(null);
            }
        }

        //Cargar la tabla
        Object[][] datosPersona = this.ventana.cargarDatos(this.ventana.getgD().getMedicoList().size(), 4);
        this.ventana.setDatos(datosPersona);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }
}
