package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

public class Tabuleiro {
	private static Tabuleiro tabuleiro;
	
	private int tamanhoCasa = 32;
	private Casa[][] casas = new Casa[1][1];
	private Point casaFinal = new Point(1, 1);
	
	public static Tabuleiro getTabuleiroAtual() {
		if (tabuleiro == null)
			tabuleiro = new Tabuleiro();
		
		return tabuleiro;
	}
	
	private Tabuleiro() {
		zeraTabuleiro();
	}
	
	private void zeraTabuleiro() {
		for(int i = 0; i < casas.length; i++)
			for(int j = 0; j < casas[i].length; j++)
				casas[i][j] = Casa.VAZIA;
	}
	
	public int getHeight() { return casas.length; }
	public int getWidth() { return casas[0].length; }
	public Point getFinal() { return casaFinal; }
	public int getTamanhoCasa() { return tamanhoCasa; }
	public Casa[][] getCasas() { return casas; }
	
	/*
	 * Verifica qual o estado/tipo da coordenada da <code>casa</code>.
	 * @return Retorna o tipo da casa em <code>Casa</code>.
	 */
	public Casa checaCasa(Point casa) {
		return casas[casa.y][casa.x];
	}
	
	/*
	 * Altera o tipo da <code>casa</code> para o <code>tipo</code>
	 * @param <code>casa</code> - Coordenadas (x, y) da casa no tabuleiro.
	 * @param <code>tipo</code> - Novo estado/tipo da casa alterada.
	 */
	public void mudaTipo(Point casa, Casa tipo) {
		casas[casa.y][casa.x] = tipo; 
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
	public int converteCoord(int xy) {
		return xy * tamanhoCasa;
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
