package br.envyGames.imunoDefense.jogo.ia;

import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.entidade.Tiro;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.IAAcao;
import br.envyGames.imunoDefense.motor.IAMensagem;

public class TiroIA extends IAAcao {
	private final int passo = 4;
	
	@Override
	public void doAction(Entidade entity) {
		if (entity instanceof Tiro)
			andar((Tiro)entity);
	}

	@Override
	public void receiveMessage(IAMensagem arg0) {}
	

	@Override
	public int timeToWait() {
		return 30;
	}

	private void andar(Tiro tiro) {
		if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getX()) < Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getAlvo().getX())) {
			tiro.doMove(passo, 0);
		} else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getX()) > Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getAlvo().getX())) {
			tiro.doMove(-1*passo, 0);
		} else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getY()) < Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getAlvo().getY())) {
			tiro.doMove(0, passo);
		} else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getY()) > Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) tiro.getAlvo().getY())) {
			tiro.doMove(0, -1*passo);
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
