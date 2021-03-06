/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.avicena.view.frames;

import br.udesc.ceavi.progii.avicena.view.painels.CRUDActionPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 * Esta classe define o JInternalFrame padrão que NÃO utilizam os botôes CRUD
 * @author Adroan, Mário, Vini, Raphael
 * @since 13/04/2018
 * @version 1.0
 */
public abstract class FrameSemCRUD extends JInternalFrame{
    
    private JPanel panelPrincipal;
    private Dimension dimension;
    private LayoutManager layout;
    
    private CRUDActionPanel panelBotoesCRUD;

    public FrameSemCRUD(String titulo, Dimension dimension) throws HeadlessException{
        this.dimension = dimension;
        
        initializeComponets();
        addComponets();
        
        super.setSize(dimension);
        super.setTitle(titulo);
        super.setLayout(layout);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setClosable(true);
        
    }

    private void initializeComponets() {
        panelPrincipal = new JPanel();
        layout = new BorderLayout();
        
        panelPrincipal.setSize(dimension);
        panelPrincipal.setLayout(layout);
        
        panelBotoesCRUD = new CRUDActionPanel(this);
    }

    private void addComponets() {
        
       this.setContentPane(panelPrincipal);
    }
    
    public void addFormulario(Container container){
        panelPrincipal.add(container, BorderLayout.CENTER);
    }
    
    public void addFormulario2(String layout, Container container){
        panelPrincipal.add(layout, container);
    }
   
    
    public CRUDActionPanel getPanelBotoesCRUD() {
        return panelBotoesCRUD;
    }
    
    public abstract void limparCampos();
    
    public abstract void carregarCampos();
    
}
