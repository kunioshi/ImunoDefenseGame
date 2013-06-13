package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Entidade;

public abstract class FormaDeVida extends Entidade {
	protected int vida;

	public FormaDeVida(String nome, Point xy, Cenario cenario) {
		super(nome, xy.x, xy.y, cenario);
	}	

	public int getVida() { return vida; }
	public void setVida(int novaVida) { vida = novaVida; }
	
	public void receberDano(int dano) {
		vida -= dano;
		
		if (isDead())
			morrer();
	}
	
	public void receberCura(int heal) {
		vida += heal; 
	}
	
	public boolean isDead() {
		return vida <= 0;
	}
	
	public Point getCasaAtual() {
		return Tabuleiro.getTabuleiroAtual().converteCoord((int)getX(), (int)getY());
	}
	
	public abstract void morrer();
}
