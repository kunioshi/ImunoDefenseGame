package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Cenario;

public abstract class Torre extends FormaDeVida {
	private int forca = 0;
	private int level = 1;

	/*
	 * Construtor
	 * @param <code>nomeInstancia</code> - Nome do inimigo do qual será usado para encontra-lo na EntityCollection.
	 * @param <code>xy</code>   - Coordenadas "(x, y)" iniciais. 
	 */
	public Torre(String nomeInstancia, Point xy, Cenario cenario) {
		super(nomeInstancia, xy, cenario);
	}
	
	// Getters & Setters
	public int getForca() { return forca; }
	public int getLevel() { return level; }
	
	public void setForca(int dano) { forca = dano; }
	public void upgrade() { level++; forca++; }
	
	public abstract boolean isUpgradable();
	
	@Override
	public void morrer() {

	}
}
