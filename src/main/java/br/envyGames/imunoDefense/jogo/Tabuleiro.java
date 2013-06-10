package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

public class Tabuleiro {
	private static int tamanhoCasa = 32;
	private static Casa[][] tabuleiro = new Casa[1][1];
	private static Point casaFinal = new Point(1, 1);
	
	public Tabuleiro() {
		zeraTabuleiro();
	}
	
	private static void zeraTabuleiro() {
		for(int i = 0; i < tabuleiro.length; i++)
			for(int j = 0; j < tabuleiro[i].length; j++)
				tabuleiro[i][j] = Casa.VAZIA;
	}
	
	public static int getHeight() { return tabuleiro.length; }
	public static int getWidth() { return tabuleiro[0].length; }
	public static Point getFinal() { return casaFinal; }
	public static int getTamanhoCasa() { return tamanhoCasa; }
	public static Casa[][] getTabuleiro() { return tabuleiro; }
	
	/*
	 * Verifica qual o estado/tipo da coordenada da <code>casa</code>.
	 * @return Retorna o tipo da casa em <code>Casa</code>.
	 */
	public static Casa checaCasa(Point casa) {
		return tabuleiro[casa.y][casa.x];
	}
	
	/*
	 * Altera o tipo da <code>casa</code> para o <code>tipo</code>
	 * @param <code>casa</code> - Coordenadas (x, y) da casa no tabuleiro.
	 * @param <code>tipo</code> - Novo estado/tipo da casa alterada.
	 */
	public static void mudaTipo(Point casa, Casa tipo) {
		tabuleiro[casa.y][casa.x] = tipo; 
	}
	
	/*
	 * Converte as coordenadas da janela em coordenadas do tabuleiro (número de casas).
	 * @return Retorna as coordenadas do tabuleiro em formato <code>Point</code>.
	 */
	public static Point converteCoord(int x, int y) {
		return new Point( (x / tamanhoCasa), (y / tamanhoCasa) );
	}
	
	/*
	 * Converte um <code>x</code>, ou um <code>y</code>, do tabuleiro (número de casas) em coordenadas da janela.
	 * @return Retorna o <code>x</code>, ou o <code>y</code>, em escada da janela.
	 */
	public static int converteCoord(int xy) {
		return xy * tamanhoCasa;
	}
	
	/*
	 * Converte uma coordenada do tabuleiro para uma coordenada da janela. <br/>
	 * PS: Pronto para Inimigos, pois retorna a coordenada do final do que seria a casa da diagonal superior esquerda da coordenada passada.
	 * @return Retorna coordenada em escada da janela.
	 */
	public static Point converteCoord(Point xy) {
		return new Point( (xy.x - 1) * tamanhoCasa, (xy.y - 1) * tamanhoCasa );
	}
}
