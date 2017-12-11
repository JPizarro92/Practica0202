package vista;

import controlador.EventoPaciente;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Paciente;

public class VentanaPaciente extends JInternalFrame {

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
    private ResourceBundle rB;

    public VentanaPaciente(String title, GestionDato gD, String idioma) {
        super(title, true, true, true, true);
        this.setSize(440, 330);
        this.setLocation(5, 10);
        this.gD = gD;
        this.setrB(ResourceBundle.getBundle("" + idioma));
        this.iniciaComponente();
        this.cargaIdioma();
    }

    public void iniciaComponente() {
        //Ingreso de datos
        this.panelInicial = new JPanel(new BorderLayout());
        JPanel panelNorte = new JPanel(new BorderLayout());

        this.labelList = new ArrayList<JLabel>();
        this.labelList.add(new JLabel("Código"));
        this.labelList.add(new JLabel("Nombre"));
        this.labelList.add(new JLabel("Apellido"));
        this.labelList.add(new JLabel("Dirección"));
        this.labelList.add(new JLabel("Teléfono"));
        this.labelList.add(new JLabel("Agregar Paciente"));

        this.textoList = new ArrayList<JTextField>();
        for (int i = 0; i < this.labelList.size() - 1; i++) {
            this.textoList.add(new JTextField());
        }

        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Guardar Paciente"));
        this.botonList.add(new JButton("Limpiar Formulario"));
        for (int i = 0; i < this.botonList.size(); i++) {
            this.botonList.get(i).addActionListener(new EventoPaciente(this));
        }

        JPanel panelTitulo = new JPanel(new FlowLayout());
        JPanel panelIngreso = new JPanel(new GridLayout(6, 2));

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
        this.encabezado[0] = this.getrB().getString("etiqueta_13");
        this.encabezado[1] = this.getrB().getString("etiqueta_14");
        this.encabezado[2] = this.getrB().getString("etiqueta_15");
        this.encabezado[3] = this.getrB().getString("etiqueta_16");
        this.encabezado[4] = this.getrB().getString("etiqueta_17");

        this.datos = cargarDatos(this.gD.getPacienteList().size(), this.encabezado.length);
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
        for (Paciente p : this.gD.getPacienteList()) {
            retorno[i][0] = p.getCodigo();
            retorno[i][1] = p.getNombre();
            retorno[i][2] = p.getApellido();
            retorno[i][3] = p.getDireccion();
            retorno[i][4] = p.getTelefono();
            i++;
        }
        return retorno;
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

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public ResourceBundle getrB() {
        return rB;
    }

    public void setrB(ResourceBundle rB) {
        this.rB = rB;
    }

    public void cargaIdioma() {
        this.labelList.get(0).setText(rB.getString("etiqueta_13"));
        this.labelList.get(1).setText(rB.getString("etiqueta_14"));
        this.labelList.get(2).setText(rB.getString("etiqueta_15"));
        this.labelList.get(3).setText(rB.getString("etiqueta_16"));
        this.labelList.get(4).setText(rB.getString("etiqueta_17"));
        this.labelList.get(5).setText(rB.getString("etiqueta_9"));
        this.botonList.get(0).setText(rB.getString("etiqueta_24"));
        this.botonList.get(1).setText(rB.getString("etiqueta_26"));
    }
}
