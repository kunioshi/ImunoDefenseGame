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
	
	private void atacar(Torre torre, Inimigo alvo) {
		torre.atirar(alvo);
	}
	
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

	@Override
	public void receiveMessage(IAMensagem mensagem) {}
}
