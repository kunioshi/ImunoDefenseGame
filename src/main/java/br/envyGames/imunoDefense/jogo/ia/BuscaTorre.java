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
package br.envyGames.imunoDefense.jogo.ia;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

import br.envyGames.imunoDefense.jogo.Tabuleiro;

public class BuscaTorre {
	private CasaFila atual;
	private ArrayList<CasaFila> fila;
	private ArrayList<CasaFila> visitados;
	
	public ArrayList<Point> buscar(Point casa) {
		zerarBusca();
		
		fila.add(new CasaFila(casa, null));
		
		boolean caminhoEncontrado = false;
		while(!fila.isEmpty()) {
			atual = fila.remove(0);
			visitados.add(atual);
			
			if(Tabuleiro.getTabuleiroAtual().hasTorre(atual.getCasa())) {
				caminhoEncontrado = true;
				break;
			} else {
				verificaCasa(new Point(1, 0));
				verificaCasa(new Point(0, -1));
				verificaCasa(new Point(0, 1));
				verificaCasa(new Point(-1, 0));
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
