package vista;

import controlador.EventoConsulta;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;

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
    private List<JComboBox> combo;
    private GestionDato gD;

    public VentanaConsulta(String title, GestionDato gD) {
        super(title, true, true, true, true);
        this.setSize(490, 360);
        this.setLocation(860, 10);
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
        this.textoList.add(new JTextField());
        this.textoList.add(new JTextField());
        this.textoList.add(new JTextField());

        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Asignar Consulta"));
        this.botonList.add(new JButton("Actualizar"));
        for (int i = 0; i < this.botonList.size(); i++) {
            this.botonList.get(i).addActionListener(new EventoConsulta(this));
        }
        
        this.combo= new ArrayList<JComboBox>();
        this.combo.add(new JComboBox());
        this.combo.add(new JComboBox());

        JPanel panelTitulo = new JPanel(new FlowLayout());
        JPanel panelIngreso = new JPanel(new GridLayout(6, 2));

        panelIngreso.add(this.labelList.get(0));
        panelIngreso.add(this.textoList.get(0));
        panelIngreso.add(this.labelList.get(1));
        panelIngreso.add(this.textoList.get(1));
        panelIngreso.add(this.labelList.get(2));
        panelIngreso.add(this.textoList.get(2));
        panelIngreso.add(this.labelList.get(3));
        panelIngreso.add(this.combo.get(0));
        panelIngreso.add(this.labelList.get(4));
        panelIngreso.add(this.combo.get(1));

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

        this.datos = cargarDatos(this.gD.getConsultaList().size(), this.encabezado.length);
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);

        this.panelInicial.add(panelNorte, BorderLayout.NORTH);
        this.panelInicial.add(this.scroll, BorderLayout.CENTER);

        this.add(this.panelInicial);

    }

    public Object[][] cargarDatos(int f, int k) {

        Object[][] retorno = new Object[f][k];
        int i = 0;
        for (Consulta c:this.gD.getConsultaList()) {
            retorno[i][0] = c.getCodigo();
            retorno[i][1] = c.getFechaConsulta();
            retorno[i][2] = c.getHoraConsulta();
            retorno[i][3] = c.getPaciente().getNombre()+" "+c.getPaciente().getApellido();
            retorno[i][4] = c.getMedico().getNombre()+" "+c.getMedico().getApellido();
            i++;
        }
        return retorno;
    }
    
    public void cargarCombo() {
        this.combo.get(0).removeAllItems();
        this.combo.get(1).removeAllItems();
        for (Paciente p : this.gD.getPacienteList()) {
            this.combo.get(0).addItem(p.getCodigo() + " | " + p.getNombre() + " " + p.getApellido());
        }
        for (Medico m : this.gD.getMedicoList()) {
            this.combo.get(1).addItem(m.getCodigo() + " | " + m.getNombre() + " " + m.getApellido());
        }
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JPanel getPanelInicial() {
        return panelInicial;
    }

    public void setPanelInicial(JPanel panelInicial) {
        this.panelInicial = panelInicial;
    }

    public List<JLabel> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<JLabel> labelList) {
        this.labelList = labelList;
    }

    public List<JTextField> getTextoList() {
        return textoList;
    }

    public void setTextoList(List<JTextField> textoList) {
        this.textoList = textoList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public List<JComboBox> getCombo() {
        return combo;
    }

    public void setCombo(List<JComboBox> combo) {
        this.combo = combo;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
}
