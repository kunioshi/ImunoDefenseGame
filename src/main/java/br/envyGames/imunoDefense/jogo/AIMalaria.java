package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.util.ArrayList;

import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.IAAcao;
import br.envyGames.imunoDefense.motor.IAMensagem;

public class AIMalaria extends IAAcao {
	private ArrayList<Point> caminho = null;
	private Estado estado = Estado.PARADO;
	private Point proxCasa = null;
	private FormaDeVida alvo = null;
	private BuscaAStar busca = new BuscaAStar();

	public void doAction(Entidade entidade) {
		Inimigo entity = (Inimigo)entidade;

		if(caminho == null)
			atualizarCaminho(entity);

		try {
			Thread.sleep(1300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if(estado ==  Estado.PARADO) {
			comecarAndar(entity);
			checarProx(entity);
		} else if(estado == Estado.ANDANDO)
			andar((Inimigo)entity);
		else
			atacar((Inimigo) entity);
	}

	public void receiveMessage(IAMensagem msg) {}

	private void atualizarCaminho(Inimigo entity) {
		caminho = busca.busca(Tabuleiro.getTabuleiroAtual().getCasas(), new Point( Tabuleiro.getTabuleiroAtual().converteCoord((int)entity.getX(), (int)entity.getY()) ), Tabuleiro.getTabuleiroAtual().getFinal());

		verificarCaminho(entity);
	}

	private void comecarAndar(Inimigo entity) {
		if(caminho.size() != 0)
			proxCasa = caminho.remove(0);
		else {
			alvo = ((JogoCenario)entity.getScenario()).getCoracao();
			estado = Estado.ATACANDO;
		}
	}

	private void andar(Inimigo entity) {
		checarProx(entity);

		if(estado == Estado.ANDANDO) {
			mudarCasa(entity);

			if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) entity.getX()) < proxCasa.getX()) {
				entity.setImageKey("direita");
				entity.doMove(entity.getVelocidade(), 0);
			} else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) entity.getX()) > proxCasa.getX()) {
				entity.setImageKey("esquerda");
				entity.doMove(-entity.getVelocidade(), 0);
			} else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) entity.getY()) < proxCasa.getY()) {
				entity.setImageKey("baixo");
				entity.doMove(0, entity.getVelocidade());
			} else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) entity.getY()) > proxCasa.getY()) {
				entity.setImageKey("cima");
				entity.doMove(0, -entity.getVelocidade());
			}

			if(chegouProx(entity) && caminho != null)
				comecarAndar(entity);
		}
	}

	private void mudarCasa(Inimigo entity) {
		if(Tabuleiro.getTabuleiroAtual().getCasa(entity.getCasaAtual()) == entity)
			Tabuleiro.getTabuleiroAtual().setCasa(entity.getCasaAtual(), null);
		Tabuleiro.getTabuleiroAtual().setCasa(proxCasa, entity);
	}

	private void atacar(Inimigo inimigo) {
		if(alvo instanceof Coracao)
			((Coracao)alvo).receberDano(inimigo.getForca());
		else if(alvo instanceof Torre)
			((Torre)alvo).receberDano(inimigo.getForca());
		alvo.receberDano(inimigo.getForca());

		if(alvo.getVida() <= 0) {
			Tabuleiro.getTabuleiroAtual().setCasa(alvo.getCasaAtual(), null);
			atualizarCaminho(inimigo);
		}
	}

	private boolean chegouProx(Inimigo entity) {
		if( new Point((int)entity.getX(), (int)entity.getY()).equals(Tabuleiro.getTabuleiroAtual().converteCoord(proxCasa)) )
			return true;

		return false;
	}

	private void checarProx(Inimigo entity) {
		if(Tabuleiro.getTabuleiroAtual().isTorre(proxCasa))
			atualizarCaminho(entity);
	}

	private void verificarCaminho(Inimigo entity) {
		if(caminho == null) {
			estado = Estado.ATACANDO;

			encontrarAlvo();
		} else {
			if( caminho.size() == 0 ) {
				estado = Estado.ATACANDO;
				alvo = ((JogoCenario)entity.getScenario()).getCoracao();
			} else {
				estado = Estado.ANDANDO;
				comecarAndar(entity);
			}
		}
	}

	private void encontrarAlvo() {
		if(proxCasa != null) {
			alvo = (Torre)Tabuleiro.getTabuleiroAtual().getCasa(proxCasa);
		}
	}
}
