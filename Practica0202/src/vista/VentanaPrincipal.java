/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Jorge Pizarro
 */
public class VentanaPrincipal extends JFrame{
    
    private JDesktopPane    escritorio;
    private JMenuBar        barraMenu;
    private List<JMenu>     menuList;
    private List<JMenuItem> itemMenuList;
    private GestionDato     gD;

    public VentanaPrincipal(GestionDato gD, String title) throws HeadlessException {
        super(title);
        this.gD = gD;
        this.iniciaComponentes();
        this.setSize(600, 500);
        this.setDefaultCloseOperation(3);
        
    }
    
    public void iniciaComponentes(){
        this.asignarIdioma();
    }
    
    public void asignarIdioma(){
        
    }
    
}
