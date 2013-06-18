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

import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.entidade.FormaDeVida;
import br.envyGames.imunoDefense.jogo.entidade.FormaDeVidaColecao;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.TipoLocomocao;
import br.envyGames.imunoDefense.jogo.entidade.torre.TipoAtaque;
import br.envyGames.imunoDefense.jogo.entidade.torre.Torre;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.IAAcao;
import br.envyGames.imunoDefense.motor.IAMensagem;

public class TorreIA extends IAAcao {
	
	private int velocidade;

	@Override
	public void doAction(Entidade entidade) {
		if (entidade instanceof Torre) {
			Torre torre = (Torre)entidade;	
			
			if (torre.getTipoAtaque() != TipoAtaque.Nenhum) {
				Inimigo alvo = localizarAlvo(torre);
				if (alvo != null)
					atacar(torre, alvo);
			}			
		}
	}
	

	@Override
	public void receiveMessage(IAMensagem mensagem) { }

	@Override
	public int timeToWait() {
		return 3500 / velocidade;
	}
	
	@Override
	protected void doPreWait(Entidade entidade) {
		if (entidade instanceof Torre) {
			velocidade = ((Torre)entidade).getVelocidade();
		}
	}
	
	private void atacar(Torre torre, Inimigo alvo) {
		torre.atirar(alvo);
	}

	//TODO: refatorar isso qdo tiver com tanto sono
	private Inimigo localizarAlvo(Torre torre) {
		Point xy = torre.getCasaAtual();
		
		Inimigo inimigo = null;
		int x, y;
		for (int modificaoX = torre.getAlcance() * -1; modificaoX <= torre.getAlcance(); modificaoX++) {
			x = (int)xy.getX() + modificaoX;
			if (Tabuleiro.getTabuleiroAtual().isXValid(x))
				for (int modificaoY = torre.getAlcance() * -1; modificaoY <= torre.getAlcance(); modificaoY++) {
					y = (int)xy.getY() + modificaoY;
					if (Tabuleiro.getTabuleiroAtual().isYValid(y))						
						if (Tabuleiro.getTabuleiroAtual().hasInimigo(x, y)) {							
							FormaDeVidaColecao colecao = Tabuleiro.getTabuleiroAtual().getCasa(new Point(x, y));
							for (FormaDeVida item : colecao.getList())
								if (item instanceof Inimigo) {
									inimigo = (Inimigo)item;
									switch (torre.getTipoAtaque()) {
										case TerrestreEVoador:
											return inimigo;
											
										case Terrestre:
											if (inimigo.getTipoLocomocao() == TipoLocomocao.Terrestre)
												return inimigo;
											break;
											
										case Voador:
											if (inimigo.getTipoLocomocao() == TipoLocomocao.Aerio)
												return inimigo;
											break;
											
										default:
											break;										
									}
									
								}			 		
						}			
				}
		}
		
		return null;		
	}
}
