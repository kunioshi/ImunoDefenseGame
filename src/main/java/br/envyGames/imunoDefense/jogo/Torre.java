package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import s3t.gameControl.system.GameSystem;
import s3t.gameEntities.Entity;

public abstract class Torre extends Entity {
	private int vida = 5;
	private int forca = 0;
	private int level = 1;

	/*
	 * Construtor
	 * @param <code>nomeInstancia</code> - Nome do inimigo do qual será usado para encontra-lo na EntityCollection.
	 * @param <code>xy</code>   - Coordenadas "(x, y)" iniciais. 
	 */
	public Torre(String nomeInstancia, Point xy) {
		super(nomeInstancia, xy.x, xy.y, GameSystem.getScenarioCollection().getScenario("JogoCenario"));
		GameSystem.getEntityCollection().addEntity(this);
	}
	
	// Getters & Setters
	public int getForca() { return forca; }
	public int getLevel() { return level; }
	public int getVida() { return vida; }
	
	public void setForca(int dano) { forca = dano; }
	public void upgrade() { level++; forca++; }
	public void recebeDano(int dano) {
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
