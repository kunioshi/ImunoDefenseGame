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
import java.io.IOException;

import br.envyGames.imunoDefense.jogo.entidade.inimigo.ChagasInimigo;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.EbolaInimigo;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.GripeInimigo;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.MalariaInimigo;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.TipoInimigo;
import br.envyGames.imunoDefense.motor.Cenario;

public class InimigoFactory {
	public static Inimigo criarInimigo(TipoInimigo tipoInimigo, String ID, Point xy, Cenario cenario) {
		Inimigo inimigo = null;
		try {
			switch (tipoInimigo) {
			case CHAGAS:
				inimigo = new ChagasInimigo(ID, xy, cenario);
				break;
				
			case EBOLA:
				inimigo = new EbolaInimigo(ID, xy, cenario);
				break;
				
			case GRIPE:
				inimigo = new GripeInimigo(ID, xy, cenario);
				break;
				
			case MALARIA:
				inimigo = new MalariaInimigo(ID, xy, cenario);
				break;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return inimigo;
	}
}
