package br.envyGames.imunoDefense.jogo.ia;

import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.entidade.Tiro;
import s3t.gameEntities.AIAction;
import s3t.gameEntities.Entity;
import s3t.gameEntities.IAMessage;

public class TiroIA extends AIAction {
	@Override
	public void doAction(Entity entity) {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		andar((Tiro)entity);
	}

	@Override
	public void receiveMessage(IAMessage arg0) {}

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
		if( tiro.getCasaAtual().equals(Tabuleiro.getTabuleiroAtual().converteCoord((int)tiro.getAlvo().getX(), (int)tiro.getAlvo().getY())) )
			darDano(tiro);
	}

	private void darDano(Tiro tiro) {
		tiro.getAlvo().receberDano(tiro.getForca());
	}
}
