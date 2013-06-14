package br.envyGames.imunoDefense.jogo.ia;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;

public class BuscaTorre {
	private CasaFila atual;
	private ArrayList<CasaFila> fila;
	private ArrayList<CasaFila> visitados;
	
	public ArrayList<Point> buscar(Inimigo entity) {
		zerarBusca();
		
		fila.add(new CasaFila(entity.getCasaAtual(), null));
		
		boolean caminhoEncontrado = false;
		while(!fila.isEmpty()) {
			atual = fila.remove(0);
			
			if(Tabuleiro.getTabuleiroAtual().isTorre(atual.getCasa())) {
				caminhoEncontrado = true;
				break;
			} else {
				verificaCasa(new Point(-1, 0));
				verificaCasa(new Point(0, -1));
				verificaCasa(new Point(1, 0));
				verificaCasa(new Point(0, 1));
			}
		}
		
		if(!caminhoEncontrado)
			return null;
		else
			return obtemCaminho();
	}
	
	private ArrayList<Point> obtemCaminho() {
		ArrayList<Point> caminho = new ArrayList<Point>();
		CasaFila aux = atual;
		
		while(aux.getAntecessor() != null) {
			caminho.add(aux.getCasa());
			aux = aux.getAntecessor();
		}
		Collections.reverse(caminho);
		
		return caminho;
	}
	
	private void verificaCasa(Point soma) {
		int x = atual.getCasa().x + soma.x;
		int y = atual.getCasa().y + soma.y;
		
		if(x >= 0 && x < Tabuleiro.getTabuleiroAtual().getWidth() &&  y >= 0 && y < Tabuleiro.getTabuleiroAtual().getHeight()) {
			Point casaAux = new Point(x, y);

			if (Tabuleiro.getTabuleiroAtual().isCasaVazia(casaAux) || Tabuleiro.getTabuleiroAtual().isInimigo(casaAux))
				if(!existeNosVisitados(casaAux))
					adicionarCasa(casaAux);
		}
	}
	
	private boolean existeNosVisitados(Point vizinho) {
		boolean existenaFechada = false;
		for(CasaFila n : visitados) {
			if(n.mesmaCasa(vizinho))
				existenaFechada = true;
		}
		
		return existenaFechada;
	}
	
	private boolean existeNaFila(Point vizinho) {
		boolean existeNaAberta = false;
		for(CasaFila n : fila) {
			if(n.mesmaCasa(vizinho))
				existeNaAberta = true;
		}
		
		return existeNaAberta;
	}
	
	private void adicionarCasa(Point casaAux) {
		if(!existeNaFila(casaAux))
			fila.add(new CasaFila(casaAux, atual));
	}

	private void zerarBusca() {
		fila = new ArrayList<CasaFila>();
		visitados =  new ArrayList<CasaFila>();
		atual = null;
	}
}
