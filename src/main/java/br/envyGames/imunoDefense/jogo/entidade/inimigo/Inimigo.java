package br.envyGames.imunoDefense.jogo.entidade.inimigo;

import java.awt.Point;

import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.entidade.FormaDeVida;
import br.envyGames.imunoDefense.motor.Cenario;

import s3t.gameControl.system.GameSystem;


enum Direcao {
	BAIXO, CIMA, DIREITA, ESQUERDA;
}

enum TipoLocomocao {
	Terrestre,
	Aerio
}

/*
 * Classe abstrata base dos inimigos
 */
public abstract class Inimigo extends FormaDeVida {
	private int forca = 1;
	private float velocidadeNatural = 32;
	private float lentidao = 1;
	private Direcao direcao = Direcao.DIREITA;
	private TipoLocomocao tipoLocomocao;
	
	/*
	 * Construtor<br/>
	 * Por padrão os inimigos iniciam com força 1, velocidade 1 e com 2 de vida.
	 * @param <code>name</code> - Nome do inimigo do qual será usado para encontra-lo na EntityCollection.
	 * @param <code>xy</code>   - Coordenadas "(x, y)" iniciais. 
	 */
	public Inimigo(String name, Point xy, Cenario cenario) {
		super(name, new Point(Tabuleiro.getTabuleiroAtual().converteCoordToTab(xy.x), Tabuleiro.getTabuleiroAtual().converteCoordToTab(xy.y)), cenario);
	}
	
	// Getters & Setters
	public int getForca() { return forca; }
	public float getVelocidade() { return velocidadeNatural * lentidao; }
	public Direcao getDirecao() { return direcao; }
	public TipoLocomocao getTipoLocomocao() { return tipoLocomocao; }
	
	public void setForca(int dano) { forca = dano; }
	public void setVelocidadeNormal(int vel) { velocidadeNatural = vel; }
	public void setDirecao(Direcao novaDirecao) { direcao = novaDirecao; }
	
	/*
	 * Aplica efeito de lentidão nesta unidade
	 * @param <code>porcentagem</code> - Quantos porcentos serão removidos da velocidade (0~1)
	 */
	public void addSlow(float porcentagem) {
		if(lentidao < (1 - porcentagem))
			lentidao = 1 - porcentagem;
	}
	public void removeSlow() {
		lentidao = 1;
	}
	
	@Override
	public void morrer() {
		GameSystem.getEntityCollection().getEntityByName(getName());
	}
}
