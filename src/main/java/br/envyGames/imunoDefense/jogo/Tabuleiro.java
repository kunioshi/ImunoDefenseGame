package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Entidade;

public class Tabuleiro {
	private static Tabuleiro tabuleiro;
	
	private int tamanhoCasa = 32;
	private Entidade[][] casas = new Entidade[13][23];
	private Point casaFinal = new Point(2, 0);
	
	public static Tabuleiro getTabuleiroAtual() {
		if (tabuleiro == null)
			tabuleiro = new Tabuleiro();
		
		return tabuleiro;
	}
	
	public void zerarTabuleiro() {
		for(int i = 0; i < casas.length; i++)
			for(int j = 0; j < casas[i].length; j++)
				casas[i][j] = null;
	}
	
	public int getHeight() { return casas.length; }
	public int getWidth() { return casas[0].length; }
	public Point getFinal() { return casaFinal; }
	public int getTamanhoCasa() { return tamanhoCasa; }
	public Entidade[][] getCasas() { return casas; }
	
	public boolean isCasaVazia(int x, int y) {
		return isCasaVazia(new Point(x, y));
	}
	
	public boolean isCasaVazia(Point casa) {
		return casas[casa.y][casa.x] == null;
	}
	
	public boolean isInimigo(int x, int y) {
		return isInimigo(new Point(x, y));
	}
	
	public boolean isInimigo(Point casa) {
		return tabuleiro.getCasa(casa) != null && tabuleiro.getCasa(casa) instanceof Inimigo;
	}
	
	public boolean isTorre(int x, int y) {
		return isTorre(new Point(x, y));
	}
	
	public boolean isTorre(Point casa) {
		return tabuleiro.getCasa(casa) != null && tabuleiro.getCasa(casa) instanceof Torre;
	}
	
	/*
	 * Verifica qual o estado/tipo da coordenada da <code>casa</code>.
	 * @return Retorna o tipo da casa em <code>Casa</code>.
	 */
	public Entidade getCasa(Point casa) {
		return casas[casa.y][casa.x];
	}
	
	/*
	 * Altera o tipo da <code>casa</code> para o <code>tipo</code>
	 * @param <code>casa</code> - Coordenadas (x, y) da casa no tabuleiro.
	 * @param <code>tipo</code> - Novo estado/tipo da casa alterada.
	 */
	public void setCasa(Point casa, Entidade entidade) {
		casas[casa.y][casa.x] = entidade; 
	}
	
	/*
	 * Converte as coordenadas da janela em coordenadas do tabuleiro (número de casas).
	 * @return Retorna as coordenadas do tabuleiro em formato <code>Point</code>.
	 */
	public Point converteCoord(int x, int y) {
		return new Point( (x / tamanhoCasa), (y / tamanhoCasa) );
	}
	
	/*
	 * Converte um <code>x</code>, ou um <code>y</code>, do tabuleiro (número de casas) em coordenadas da janela.
	 * @return Retorna o <code>x</code>, ou o <code>y</code>, em escada da janela.
	 */
	public int converteCoordToTab(int xy) {
		return xy * tamanhoCasa;
	}

	public int converteCoordToGrid(int xy) {
		return xy / tamanhoCasa;
	}
	
	/*
	 * Converte uma coordenada do tabuleiro para uma coordenada da janela. <br/>
	 * PS: Pronto para Inimigos, pois retorna a coordenada do final do que seria a casa da diagonal superior esquerda da coordenada passada.
	 * @return Retorna coordenada em escada da janela.
	 */
	public Point converteCoord(Point xy) {
		return new Point( xy.x * tamanhoCasa, xy.y * tamanhoCasa );
	}
}
