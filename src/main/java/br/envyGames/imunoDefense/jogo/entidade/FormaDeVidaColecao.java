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
package br.envyGames.imunoDefense.jogo.entidade;

import java.util.ArrayList;
import java.util.List;

import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;
import br.envyGames.imunoDefense.jogo.entidade.torre.Torre;

public class FormaDeVidaColecao {
	private List<FormaDeVida> lista = new ArrayList<FormaDeVida>();
	
	public void adicionar(FormaDeVida item) {
		lista.add(item);
	}
	
	public void remover(FormaDeVida item) {
		lista.remove(item);
	}
	
	public boolean isVazia() {
		return lista.isEmpty();
	}
	
	public boolean hasTorre() {
		for (FormaDeVida item : lista)
			if (item instanceof Torre)
				return true;
		
		return false;
	}
	
	public boolean hasInimigo() {
		for (FormaDeVida item : lista)
			if (item instanceof Inimigo)
				return true;
		
		return false;
	}
	
	public List<FormaDeVida> getList() {
		return lista;
	}

}
