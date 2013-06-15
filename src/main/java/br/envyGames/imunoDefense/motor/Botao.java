package br.envyGames.imunoDefense.motor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Botao extends Entidade implements MouseListener {

	public Botao(String nome, double x, double y, Cenario cenario) {
		super(nome, x, y, cenario);
		// TODO Auto-generated constructor stub
	}
	private int largura;
	private int altura;
	
	private boolean isBotao(int x, int y) {
		return (this.getX() >= x && this.getX() + largura <= x 
				&& this.getY() >= y && this.getY() - altura <= y);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (isBotao(e.getX(), e.getY())) {
			//Dispara o clicar
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
