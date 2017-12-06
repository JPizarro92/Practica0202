package vista;

import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentanaConsulta extends JInternalFrame {

    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private JPanel panelInicial;
    private List<JLabel> labelList;
    private List<JTextField> textoList;
    private List<JButton> botonList;
    private GestionDato gD;

    public VentanaConsulta(String title, GestionDato gD) {
        super(title, true, true, true, true);
        this.setSize(490, 360);
        this.setLocation(290, 260);
        this.gD = gD;
        this.iniciaComponente();
    }

    public void iniciaComponente() {
        //Ingreso de datos
        this.panelInicial = new JPanel(new BorderLayout());
        JPanel panelNorte = new JPanel(new BorderLayout());

        this.labelList = new ArrayList<JLabel>();
        this.labelList.add(new JLabel("Código"));
        this.labelList.add(new JLabel("Fecha Asignada"));
        this.labelList.add(new JLabel("Hora de Consulta"));
        this.labelList.add(new JLabel("Código Paciente"));
        this.labelList.add(new JLabel("Código Médico"));
        this.labelList.add(new JLabel("Asignar Consulta"));

        this.textoList = new ArrayList<JTextField>();
        for (int i = 0; i < this.labelList.size() - 1; i++) {
            this.textoList.add(new JTextField());
        }

        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Asignar Consulta"));
        this.botonList.add(new JButton("Limpiar Formulario"));
        for (int i = 0; i < this.botonList.size(); i++) {
            //this.botonList.get(i).addActionListener(new EventoAspirante(this));
        }

        JPanel panelTitulo = new JPanel(new FlowLayout());
        JPanel panelIngreso = new JPanel(new GridLayout(7, 2));

        panelIngreso.add(this.labelList.get(0));
        panelIngreso.add(this.textoList.get(0));
        panelIngreso.add(this.labelList.get(1));
        panelIngreso.add(this.textoList.get(1));
        panelIngreso.add(this.labelList.get(2));
        panelIngreso.add(this.textoList.get(2));
        panelIngreso.add(this.labelList.get(3));
        panelIngreso.add(this.textoList.get(3));
        panelIngreso.add(this.labelList.get(4));
        panelIngreso.add(this.textoList.get(4));

        panelTitulo.add(this.labelList.get(5));
        panelIngreso.add(this.botonList.get(0));
        panelIngreso.add(this.botonList.get(1));

        panelNorte.add(panelTitulo, BorderLayout.NORTH);
        panelNorte.add(panelIngreso, BorderLayout.CENTER);

        //Tabla 
        this.encabezado = new Object[5];
        this.encabezado[0] = "Código";
        this.encabezado[1] = "Fecha";
        this.encabezado[2] = "Hora";
        this.encabezado[3] = "Paciente";
        this.encabezado[4] = "Médico";

        //this.datos = cargarDatos(this.gD.getPacienteList().size(), this.encabezado.length);
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);

        this.panelInicial.add(panelNorte, BorderLayout.NORTH);
        this.panelInicial.add(this.scroll, BorderLayout.CENTER);

        this.add(this.panelInicial);

    }

    public Object[][] cargarDatos(int f, int c) {

        Object[][] retorno = new Object[f][c];
        int i = 0;
        /*for (Aspirante a:this.gD.getAspiranteList()) {
            retorno[i][0] = a.getCodigo();
            retorno[i][1] = a.getCedula();
            retorno[i][2] = a.getNombre();
            retorno[i][3] = a.getApellido();
            retorno[i][4] = a.getFechaNac();
            retorno[i][5] = a.getColegio();
            retorno[i][6] = a.getTituloBachiller();
            i++;
        }*/
        return retorno;
    }
}
