package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class BuscaAStar {
	private CasaBusca atual;
	private ArrayList<CasaBusca> lista_aberta;
	private ArrayList<CasaBusca> lista_fechada;
	
	/*
	 * Realiza a Busca A* no <code>tabuleiro</code>, tendo seu inico a casa <code>inicio</code> e ponto final <code>fim</code>.
	 * @param <code>tabuleiro</code> - A matriz de inteiros na qual a busca se baseará.
	 * @param <code>inicio</code>    - Coordenadas da casa no <code>tabuleiro</code> na qual a busca começará.
	 * @param <code>fim</code>       - Coordenadas da casa no <code>tabuleiro</code> na qual a busca buscará alcançar.
	 * @return <code>ArrayList<Point></code> - Caminho composto de casa por casa de onde a Entidade deverá passar para alcançar a casa <code>fim</code>, não obtendo a casa <code>inicio</code> em seu corpo.
	 */
	public ArrayList<Point> busca(int[][] tabuleiro, Point inicio, Point fim) {
		atual = null;
		lista_aberta = new ArrayList<CasaBusca>();
		lista_fechada = new ArrayList<CasaBusca>();
		
		lista_aberta.add(new CasaBusca(inicio, null, fim));
		
		boolean caminhoEncontrado = encontraCaminho(tabuleiro, fim);
		
		if(!caminhoEncontrado)
			return null;
		else
			return obtemCaminho();
	}
	
	private ArrayList<Point> obtemCaminho() {
		ArrayList<Point> caminho = new ArrayList<Point>();
		CasaBusca aux = atual;
		
		while(aux.getAntecessor() != null) {
			caminho.add(aux.getCasa());
			aux = aux.getAntecessor();
		}
		Collections.reverse(caminho);
		
		return caminho;
	}
	
	private boolean encontraCaminho(int[][] tabuleiro, Point fim) {
		while(!lista_aberta.isEmpty()) {
			atual = lista_aberta.remove(0);
			lista_fechada.add(atual);
			
			if(atual.getCasa().equals(fim)) {
				return true;
			} else {
				verificaCasa(new Point(-1, 0), fim, tabuleiro);
				verificaCasa(new Point(0, -1), fim, tabuleiro);
				verificaCasa(new Point(1, 0), fim, tabuleiro);
				verificaCasa(new Point(0, 1), fim, tabuleiro);
			}
		}
		
		return false;
	}
	
	private void verificaCasa(Point soma, Point fim, int[][] tabuleiro) {
		int x = atual.getCasa().x + soma.x;
		int y = atual.getCasa().y + soma.y;
		
		if(x < 0 || x >= tabuleiro[0].length  ||  y < 0 || y >= tabuleiro.length) {
			Point casaAux = new Point(x, y);
			
			if(casaLivre(casaAux, tabuleiro))
				if(!existeNaListaFechada(casaAux))
					adicionaCasa(casaAux, fim);
		}
	}
	
	private boolean casaLivre(Point casa, int[][] tabuleiro) {
		if(tabuleiro[casa.y][casa.x] == 0)
			return true;
		
		return false;
	}
	
	private void adicionaCasa(Point casaAux, Point fim) {
		if(!existeNaListaAberta(casaAux))
			lista_aberta.add(new CasaBusca(casaAux, atual, fim));
		else {
			pegaIndexDaCasa(casaAux).setAntecessor(atual);
		}
	}
	
	private CasaBusca pegaIndexDaCasa(Point casa) {
		for(CasaBusca n : lista_aberta) {
			if(n.mesmaCasa(casa))
				return n;
		}
		
		return null;
	}
	
	private boolean existeNaListaFechada(Point vizinho) {
		boolean existenaFechada = false;
		for(CasaBusca n : lista_fechada) {
			if(n.mesmaCasa(vizinho))
				existenaFechada = true;
		}
		
		return existenaFechada;
	}
	
	private boolean existeNaListaAberta(Point vizinho) {
		boolean existeNaAberta = false;
		for(CasaBusca n : lista_aberta) {
			if(n.mesmaCasa(vizinho))
				existeNaAberta = true;
		}
		
		return existeNaAberta;
	}
}