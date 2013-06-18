/*
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.jogo.entidade.FormaDeVida;
import br.envyGames.imunoDefense.jogo.entidade.FormaDeVidaColecao;

public class Tabuleiro {
	private static Tabuleiro tabuleiro;
	
	private int tamanhoCasa = 32;
	private FormaDeVidaColecao[][] casas = new FormaDeVidaColecao[13][23];
	private Point casaFinal = new Point(22, 6);
	
	public static Tabuleiro getTabuleiroAtual() {
		if (tabuleiro == null)
			tabuleiro = new Tabuleiro();
		
		return tabuleiro;
	}
	
	private Tabuleiro() {
		zerarTabuleiro();
	}
	
	public void zerarTabuleiro() {
		for(int i = 0; i < casas.length; i++)
			for(int j = 0; j < casas[i].length; j++)
				casas[i][j] = new FormaDeVidaColecao();
	}
	
	public int getHeight() { return casas.length; }
	public int getWidth() { return casas[0].length; }
	public Point getFinal() { return casaFinal; }
	public int getTamanhoCasa() { return tamanhoCasa; }
	public FormaDeVidaColecao[][] getCasas() { return casas; }
	
	public boolean isCasaVazia(int x, int y) {
		return isCasaVazia(new Point(x, y));
	}
	
	public boolean isCasaVazia(Point casa) {
		return casas[casa.y][casa.x].isVazia();
	}
	
	public boolean hasInimigo(int x, int y) {
		return hasInimigo(new Point(x, y));
	}
	
	public boolean hasInimigo(Point casa) {
		return tabuleiro.getCasa(casa).hasInimigo();
	}
	
	public boolean hasTorre(int x, int y) {
		return hasTorre(new Point(x, y));
	}
	
	public boolean hasTorre(Point casa) {
		return tabuleiro.getCasa(casa).hasTorre();
	}
	
	/*
	 * Verifica qual o estado/tipo da coordenada da <code>casa</code>.
	 * @return Retorna o tipo da casa em <code>Casa</code>.
	 */
	public FormaDeVidaColecao getCasa(Point casa) {
		return casas[casa.y][casa.x];
	}
	
	/*
	 * Altera o tipo da <code>casa</code> para o <code>tipo</code>
	 * @param <code>casa</code> - Coordenadas (x, y) da casa no tabuleiro.
	 * @param <code>tipo</code> - Novo estado/tipo da casa alterada.
	 */
	public void adicionarFormaDeVida(Point casa, FormaDeVida formaDeVida) {
		casas[casa.y][casa.x].adicionar(formaDeVida); 
	}
	
	public void removerFormaDeVida(Point casa, FormaDeVida formaDeVida) {
		casas[casa.y][casa.x].remover(formaDeVida); 
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
	
	public boolean isXValid(int x) {
		return x >= 0 && x < 23;
	}
	
	public boolean isYValid(int y) {
		return y >= 0 && y < 13;
	}
}
