package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Paciente;
import vista.VentanaPaciente;

public class EventoPaciente implements ActionListener {

    private VentanaPaciente ventana;

    public EventoPaciente(VentanaPaciente ventana) {
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
                String direccion = this.ventana.getTextoList().get(3).getText();
                String telefono = this.ventana.getTextoList().get(4).getText();
               
                Paciente p = new Paciente(codigo, nombre, apellido, direccion, telefono);
                for(Paciente pa: this.ventana.getgD().getPacienteList()) {
                    if(p.getCodigo()==pa.getCodigo()) {
                        throw new ExcepcionRepetidos("");
                    }
                }
                this.ventana.getgD().addPaciente(p);
            }
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(ventana, this.ventana.getrB().getString("etiqueta_31"), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, this.ventana.getrB().getString("etiqueta_32"));
        } catch (ExcepcionRepetidos ex) {
            JOptionPane.showMessageDialog(ventana, this.ventana.getrB().getString("etiqueta_33"), "Error", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource().equals(this.ventana.getBotonList().get(1))) {
            //Limpiar
            for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                this.ventana.getTextoList().get(i).setText(null);
            }
        }

        //Cargar la tabla
        Object[][] datosPersona = this.ventana.cargarDatos(this.ventana.getgD().getPacienteList().size(), 5);
        this.ventana.setDatos(datosPersona);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }
}

