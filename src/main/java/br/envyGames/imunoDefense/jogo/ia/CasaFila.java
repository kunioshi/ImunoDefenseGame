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

public class CasaFila {
	Point casa;
	CasaFila antecessor;
	
	public CasaFila(Point praOnde, CasaFila deOnde) {
		casa = praOnde;
		antecessor = deOnde;
	}
	
	public Point getCasa() { return casa; }
	public CasaFila getAntecessor() { return antecessor; }
	
	public boolean mesmaCasa(Point obj) {
	    if(casa.equals(obj))
	    	return true;
	    
	    return false;
	}
}
