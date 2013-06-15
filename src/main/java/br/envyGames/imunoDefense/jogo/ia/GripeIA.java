package br.envyGames.imunoDefense.jogo.ia;

import java.awt.Point;

import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.cenario.JogoCenario;
import br.envyGames.imunoDefense.jogo.entidade.FormaDeVida;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.EstadoInimigo;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;
import br.envyGames.imunoDefense.jogo.entidade.torre.Torre;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.IAAcao;
import br.envyGames.imunoDefense.motor.IAMensagem;

public class GripeIA extends IAAcao {
	private EstadoInimigo estado = EstadoInimigo.PARADO;
	private Point proxCasa = null;
	private FormaDeVida alvo;
	private int cooldown = 700;
	
	@Override
	public void doAction(Entidade entidade) {
		Inimigo inimigo = (Inimigo)entidade;
		
		if(estado == EstadoInimigo.ANDANDO || estado == EstadoInimigo.ATACANDOTORRE)
			cooldown = 43;
		else
			cooldown = 700;
		
		try {
			Thread.sleep(cooldown);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(estado == EstadoInimigo.PARADO) {
			comecarAndar(inimigo);
		} else if(estado == EstadoInimigo.ANDANDO) {
			verificarCaminho(inimigo);
			if(estado == EstadoInimigo.ANDANDO)
				andar(inimigo);
		} else {
			atacar(inimigo);
		}
	}
	
	private void atacar(Inimigo inimigo) {
		alvo.receberDano(inimigo.getForca());

		if(alvo.isDead()) {
			//Tabuleiro.getTabuleiroAtual().setCasa(alvo.getCasaAtual(), null);
			estado = EstadoInimigo.ANDANDO;
		}
	}

	private void andar(Inimigo inimigo) {
		mudarCasa(inimigo);
		inimigo.doMove(inimigo.getVelocidade(), 0);
		
		if(chegouProx(inimigo))
			comecarAndar(inimigo);
	}

	private boolean chegouProx(Inimigo entity) {
		if( new Point((int)entity.getX(), (int)entity.getY()).equals(Tabuleiro.getTabuleiroAtual().converteCoord(proxCasa)) )
			return true;

		return false;
	}
	
	private void mudarCasa(Inimigo inimigo) {
		Tabuleiro.getTabuleiroAtual().removerFormaDeVida(inimigo.getCasaAtual(), inimigo);
		Tabuleiro.getTabuleiroAtual().adicionarFormaDeVida(proxCasa, inimigo);
	}

	private void comecarAndar(Inimigo inimigo) {
		if(proxCasa == null) {
			proxCasa = inimigo.getCasaAtual();
			proxCasa.x++;
		} else {
			proxCasa.x++;
		}

		verificarCaminho(inimigo);
	}

	private void verificarCaminho(Inimigo inimigo) {
		if(proxCasa.x == Tabuleiro.getTabuleiroAtual().getWidth()) {
			alvo = ((JogoCenario)inimigo.getScenario()).getCoracao();
			estado = EstadoInimigo.ATACANDO;
		} else if(Tabuleiro.getTabuleiroAtual().hasTorre(proxCasa)) {
			for (FormaDeVida item : Tabuleiro.getTabuleiroAtual().getCasa(proxCasa).getList())
				if (item instanceof Torre) {
					alvo = (Torre)item;
					break;
				}
					
			estado = EstadoInimigo.ATACANDO;
		} else {
			estado = EstadoInimigo.ANDANDO;
		}
	}

	@Override
	public void receiveMessage(IAMensagem msg) {}
}
