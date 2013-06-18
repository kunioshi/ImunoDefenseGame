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
package br.envyGames.imunoDefense.motor;

import java.util.ArrayList;
import java.util.List;

import s3t.gameEntities.Entity;

public class Entidade extends Entity {
	
	private List<DestruirEntidadeListener> destruirEntidadeListeners;

	public Entidade(String nome, double x, double y, Cenario cenario) {
		super(nome, x, y, cenario);
		
		destruirEntidadeListeners = new ArrayList<DestruirEntidadeListener>();
	}
	
	public void definirImagemColecao(ImagemColecao imagem) {
		setImageCollection(imagem);
	}
	
	public Cenario getCenario() {
		return (Cenario) this.getScenario();
	}
	
	public void destruir() {
		fireRemoverAtirarEvent();
	}
	
	public void addDestruirEntidadeListener(DestruirEntidadeListener listener) {
		destruirEntidadeListeners.add(listener);
	}
	
	public void removeDestruirEntidadeListener(DestruirEntidadeListener listener) {
		destruirEntidadeListeners.remove(listener);
	}
	
	private void fireRemoverAtirarEvent() {
		for (DestruirEntidadeListener listener : destruirEntidadeListeners)
			listener.handleDestruirEntidade(this);
	}

}
