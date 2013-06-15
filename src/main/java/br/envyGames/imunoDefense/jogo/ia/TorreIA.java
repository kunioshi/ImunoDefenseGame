package br.envyGames.imunoDefense.jogo.ia;

import java.awt.Point;

import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.entidade.torre.Torre;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.IAAcao;
import br.envyGames.imunoDefense.motor.IAMensagem;

public class TorreIA extends IAAcao {

	@Override
	public void doAction(Entidade entidade) {
		
		if (entidade instanceof Torre) {
			Torre torre = (Torre)entidade;
			
			Point xy = torre.getCasaAtual();
			//TODO: validar se nao ta fora do range
			for (int x = torre.getAlcance() * -1; x <= torre.getAlcance(); x++)
				for (int y = torre.getAlcance() * -1; y <= torre.getAlcance(); y++) {
					System.out.println(((int)xy.getX() + x) + "|" + ((int)xy.getY() + y));
					if (Tabuleiro.getTabuleiroAtual().hasInimigo((int)xy.getX() + x, (int)xy.getY() + y))
				 		System.out.println("inimigo");
				}
				 	
			
		}
	}

	@Override
	public void receiveMessage(IAMensagem mensagem) {
		// TODO Auto-generated method stub
		
	}

}
