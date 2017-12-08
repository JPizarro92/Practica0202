package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Consulta;
import vista.VentanaConsulta;

public class EventoConsulta implements ActionListener {

    VentanaConsulta ventana;

    public EventoConsulta(VentanaConsulta ventana) {
        this.ventana = ventana;
    }
    int cont = 0;

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource().equals(this.ventana.getBotonList().get(0))) {
                for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                    if (this.ventana.getTextoList().get(i).getText().equals("")) {
                        throw new ExcepcionCamposVacios("");
                    }
                }
                int codP = codigoPaciente();
                int codM = codigoMedico();
                int codigo = Integer.parseInt(this.ventana.getTextoList().get(0).getText());
                String fecha = this.ventana.getTextoList().get(1).getText();
                String hora = this.ventana.getTextoList().get(2).getText();
                for (int i = 0; i < this.ventana.getgD().getPacienteList().size(); i++) {
                    if (codP == this.ventana.getgD().getPacienteList().get(i).getCodigo()) {
                        for (int j = 0; j < this.ventana.getgD().getMedicoList().size(); j++) {
                            if (codM == this.ventana.getgD().getMedicoList().get(j).getCodigo()) {
                                Consulta c = new Consulta(codigo, fecha, hora, this.ventana.getgD().getPacienteList().get(i), this.ventana.getgD().getMedicoList().get(j));
                                for (Consulta co : this.ventana.getgD().getConsultaList()) {
                                    if (c.getCodigo() == co.getCodigo()) {
                                        throw new ExcepcionRepetidos("Dato Repetido");
                                    }
                                }
                                this.ventana.getgD().addConsulta(c);
                            }
                        }
                    }
                }
                for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                    this.ventana.getTextoList().get(i).setText(null);
                }
            }
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(ventana, "El código debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException NPE) {
            JOptionPane.showMessageDialog(ventana, "No dejar los ComboBox vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionRepetidos ex) {
            JOptionPane.showMessageDialog(ventana, "Aspirante ya inscrito", "Error", JOptionPane.INFORMATION_MESSAGE);
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "No dejar los campos vacios");
        }

        if (ae.getSource().equals(this.ventana.getBotonList().get(1))) {
            //CargaCombo
            this.ventana.cargarCombo();
        }

        Object[][] datosConsulta = this.ventana.cargarDatos(this.ventana.getgD().getConsultaList().size(), 5);
        this.ventana.setDatos(datosConsulta);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }

    private int codigoPaciente() {
        String datos = this.ventana.getCombo().get(0).getSelectedItem().toString();
        int codP = 0;
        for (int i = 0; i < datos.length(); i++) {
            if (datos.charAt(i) == 124) {
                codP = Integer.parseInt(datos.substring(0, i - 1));
            }
        }
        return codP;
    }

    private int codigoMedico() {
        String datos = this.ventana.getCombo().get(1).getSelectedItem().toString();
        int codM = 0;
        for (int i = 0; i < datos.length(); i++) {
            if (datos.charAt(i) == 124) {
                codM = Integer.parseInt(datos.substring(0, i - 1));
            }
        }
        return codM;
    }
}
