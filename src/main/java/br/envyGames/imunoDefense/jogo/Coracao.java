package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Cenario;

public class Coracao extends Torre {
	private int vida = 20;
	
	public Coracao(Cenario cenario) {
		super("Coracao", new Point(Tabuleiro.getTabuleiroAtual().getWidth(), 0), cenario);
	}
	
	public int getVida() { return vida; }
	public void setVida(int novaVida) { vida = novaVida; }
	
	public void receberDano(int dmg) { vida -= dmg; }
	
	public void receberCura(int heal) { vida += heal; }
}
