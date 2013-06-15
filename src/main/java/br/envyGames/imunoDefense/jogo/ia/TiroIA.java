package br.envyGames.imunoDefense.jogo.ia;

import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.entidade.Tiro;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.IAAcao;
import br.envyGames.imunoDefense.motor.IAMensagem;
import s3t.gameEntities.AIAction;
import s3t.gameEntities.Entity;
import s3t.gameEntities.IAMessage;

public class TiroIA extends IAAcao {
	@Override
	public void doAction(Entidade entity) {
		if (entity instanceof Tiro)
			andar((Tiro)entity);
	}

	@Override
	public void receiveMessage(IAMensagem arg0) {}
	

	@Override
	public int timeToWait() {
		return 300;
	}

	private void andar(Tiro tiro) {
		if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getX()) < Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getAlvo().getX())) {
			tiro.doMove(32, 0);
		} else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getX()) > Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getAlvo().getX())) {
			tiro.doMove(-32, 0);
		} else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getY()) < Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getAlvo().getY())) {
			tiro.doMove(0, 32);
		} else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getY()) > Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getAlvo().getY())) {
			tiro.doMove(0, -32);
		}
		
		chegouProx(tiro);
	}

	private void chegouProx(Tiro tiro) {
		if( tiro.getCasaAtual().equals(Tabuleiro.getTabuleiroAtual().converteCoord((int)tiro.getAlvo().getX(), (int)tiro.getAlvo().getY())) ) {
			darDano(tiro);
			tiro.destruir();
		}
	}

	private void darDano(Tiro tiro) {
		tiro.getAlvo().receberDano(tiro.getForca());
	}
}
