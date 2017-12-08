/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author Jorge Pizarro
 */
public class GestionDato {

    private List<Paciente> pacienteList;
    private List<Medico> medicoList;
    private List<Consulta> consultaList;

    public GestionDato(List<Paciente> pacienteList, List<Medico> medicoList, List<Consulta> consultaList) {
        this.pacienteList = pacienteList;
        this.medicoList = medicoList;
        this.consultaList = consultaList;
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
    }

    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }

    public boolean addPaciente(Paciente p) {
        return this.pacienteList.add(p);
    }

    public boolean addMedico(Medico m) {
        return this.medicoList.add(m);
    }

    public boolean addConsulta(Consulta c) {
        return this.consultaList.add(c);
    }

    public boolean guardarArchivoPaciente() {
        try {
            File f = new File(""); // Creamos un objeto file
            String ruta = f.getAbsolutePath();
            FileWriter ae = new FileWriter(ruta+"\\ArchivoPaciente.txt", true);

            BufferedWriter escritura = new BufferedWriter(ae);
            for (Paciente p : this.pacienteList) {
                escritura.append(p.getCodigo() + " | " + p.getNombre() + " | " + p.getApellido() + " | " + p.getDireccion() + " | " + p.getTelefono());
                escritura.newLine();
            }
            escritura.close();
            return true;
        } catch (IOException e1) {

            return false;
        }
    }

    public boolean guardarArchivoMedico() {
        try {
            File f = new File(""); // Creamos un objeto file
            String ruta = f.getAbsolutePath();
            FileWriter ae = new FileWriter(ruta+"\\ArchivoMedico.txt", true);

            BufferedWriter escritura = new BufferedWriter(ae);
            for (Medico m : this.medicoList) {
                escritura.append(m.getCodigo() + " | " + m.getNombre() + " | " + m.getApellido() + " | " + m.getProfesion());
                escritura.newLine();
            }
            escritura.close();
            return true;
        } catch (IOException e1) {
            return false;
        }
    }

    public boolean guardarArchivoConsulta() {
        try {
            File f = new File(""); // Creamos un objeto file
            String ruta = f.getAbsolutePath();
            FileWriter ae = new FileWriter(ruta+"\\ArchivoConsulta.txt", true);

            BufferedWriter escritura = new BufferedWriter(ae);
            for (Consulta c : this.consultaList) {
                escritura.append(c.getCodigo()+ " | " + c.getFechaConsulta()+ " | " + c.getHoraConsulta()+ " | " +c.getPaciente().getCodigo()+ " | " +c.getMedico().getCodigo());
                escritura.newLine();
            }
            escritura.close();
            return true;
        } catch (IOException e1) {
            return false;
        }
    }

}
