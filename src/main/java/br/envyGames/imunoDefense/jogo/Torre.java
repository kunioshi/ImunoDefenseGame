package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Entidade;

import s3t.gameControl.system.GameSystem;

public abstract class Torre extends Entidade {
	private int vida = 5;
	private int forca = 0;
	private int level = 1;

	/*
	 * Construtor
	 * @param <code>nomeInstancia</code> - Nome do inimigo do qual será usado para encontra-lo na EntityCollection.
	 * @param <code>xy</code>   - Coordenadas "(x, y)" iniciais. 
	 */
	public Torre(String nomeInstancia, Point xy, Cenario cenario) {
		super(nomeInstancia, xy.x, xy.y, cenario);
	}
	
	// Getters & Setters
	public int getForca() { return forca; }
	public int getLevel() { return level; }
	public int getVida() { return vida; }
	public Point getCasaAtual() { return Tabuleiro.getTabuleiroAtual().converteCoord((int)getX(), (int)getY()); }
	
	public void setForca(int dano) { forca = dano; }
	public void upgrade() { level++; forca++; }
	public void receberDano(int dano) {
		vida -= dano;
		
		isDead();
	}
	
	private void isDead() {
		if(vida <= 0)
			destroiTorre();
	}
	
	public void destroiTorre() {
		GameSystem.getEntityCollection().getEntityByName(getName());
	}
}
