/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import java.awt.HeadlessException;
import java.util.ArrayList;
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
        this.setVisible(true);
    }

    public void iniciaComponentes(){
        this.escritorio = new JDesktopPane();
        this.barraMenu = new JMenuBar ();
        this.menuList = new ArrayList();
        this.itemMenuList = new ArrayList();
        
        
        this.add(this.escritorio);
        this.asignarIdioma();
    }
    
    public void asignarIdioma(){
        
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuBar getBarraMenu() {
        return barraMenu;
    }

    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }

    public List<JMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }

    public List<JMenuItem> getItemMenuList() {
        return itemMenuList;
    }

    public void setItemMenuList(List<JMenuItem> itemMenuList) {
        this.itemMenuList = itemMenuList;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
}
