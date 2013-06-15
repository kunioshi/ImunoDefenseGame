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

public class CasaBusca {
	private Point casa = null;
	private CasaBusca antecessor = null;
	private double heuristica = 0;
	private int custoAcumulado = 0;
	
	/*
	 * Construtor<br/>
	 * Esta classe é utilizada para armazenar duas casas (<code>Point</scode>s) do tabuleiro, auxiliando a busca A*
	 * @param <code>praOnde</code> - Casa para onde a busca estará indo, caso não ache o caminho antes.
	 * @param <code>deOnde</code>  - Casa utilizada para chegar até a casa <code>praOnde</code>.
	 * @param <code>alvo</code>    - Casa final da busca (para calculo da heuristica).
	 */
	public CasaBusca(Point praOnde, CasaBusca deOnde, Point alvo) {
		casa = praOnde;
		antecessor = deOnde;
		
		
		if(deOnde == null || alvo == null) {
			heuristica = 0;
			custoAcumulado = 0;
		} else {
			heuristica = calculaHeuristica(alvo);
			custoAcumulado = deOnde.getAcumulado() + 1;
		}
	}
	
	public Point getCasa() { return casa; }
	public CasaBusca getAntecessor() { return antecessor; }
	public double getHeuristica() { return heuristica; }
	public int getAcumulado() { return custoAcumulado; }
	
	public void setAntecessor(CasaBusca novo) {
		if(novo.getAcumulado() + 1 < custoAcumulado) {
			antecessor = novo;
			custoAcumulado = novo.getAcumulado() + 1;
		}
	}
	
	public boolean mesmaCasa(Point obj) {
	    if(casa.equals(obj))
	    	return true;
	    
	    return false;
	}
	
	public double calculaHeuristica(Point alvo) {
		return  Math.sqrt( Math.pow( (casa.x - alvo.x), 2) + Math.pow( (casa.y - alvo.y), 2) );
	}
}
