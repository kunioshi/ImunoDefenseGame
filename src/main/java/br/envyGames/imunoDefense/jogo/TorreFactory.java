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

import br.envyGames.imunoDefense.jogo.entidade.torre.LeucogenTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.MedulaTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.MiocardioTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.RochaganTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.TimoTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.TipoTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.Torre;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;

public class TorreFactory {
	
	public static Torre criarTorre(TipoTorre tipoTorre, String nomeInstancia, Point xy, Cenario cenario) {
		Torre torre = null;
		switch(tipoTorre) {
			case MIOCARDIO:
				torre = new MiocardioTorre(nomeInstancia, xy, cenario);
				break;
				
			case MEDULA:
				torre = new MedulaTorre(nomeInstancia, xy, cenario);
				break;
				
			case TIMO:
				torre = new TimoTorre(nomeInstancia, xy, cenario);
				break;

			case LEUCOGEN:
				torre = new LeucogenTorre(nomeInstancia, xy, cenario);
				break;
				
			case ROCHAGAN:
				torre = new RochaganTorre(nomeInstancia, xy, cenario);
				break;
				
			default:
				break;
		}
		
		return torre;
	}
	
	public static Imagem getTorreMiniatura(TipoTorre tipoTorre) {
		Imagem imagem = null;
		
		switch(tipoTorre) {
			case MIOCARDIO:
				imagem = MiocardioTorre.getImagemMiniatura();
				break;
				
			case MEDULA:
				imagem = MedulaTorre.getImagemMiniatura();
				break;
				
			case TIMO:
				imagem = TimoTorre.getImagemMiniatura();
				break;
	
			case LEUCOGEN:
				imagem = LeucogenTorre.getImagemMiniatura();
				break;
				
			case ROCHAGAN:
				imagem = RochaganTorre.getImagemMiniatura();
				break;
				
			default:
				break;
		}
		
		return imagem;
	}
}
