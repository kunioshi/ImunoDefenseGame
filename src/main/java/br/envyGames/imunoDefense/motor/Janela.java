package br.envyGames.imunoDefense.motor;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

public class Janela extends JFrame {
	private static final long serialVersionUID = 1L;
    
    public Janela(int largura, int altura) {
        setLayout( new BorderLayout() );
        
        setSize(largura, altura);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation( (largura - getWidth())/2, (altura - getHeight())/2 );  
    }
    
    public void adicionarComponenteAoCentro(Component component) {
    	add(component, BorderLayout.CENTER);
    }
}