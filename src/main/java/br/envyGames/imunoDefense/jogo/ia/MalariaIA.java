package br.envyGames.imunoDefense.jogo.ia;

import java.awt.Point;
import java.util.ArrayList;

import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.cenario.JogoCenario;
import br.envyGames.imunoDefense.jogo.entidade.Coracao;
import br.envyGames.imunoDefense.jogo.entidade.FormaDeVida;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.EstadoInimigo;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;
import br.envyGames.imunoDefense.jogo.entidade.torre.Torre;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.IAAcao;
import br.envyGames.imunoDefense.motor.IAMensagem;

public class MalariaIA extends IAAcao {
	private ArrayList<Point> caminho = null;
	private EstadoInimigo estado = EstadoInimigo.PARADO;
	private Point proxCasa = null;
	private FormaDeVida alvo = null;
	private BuscaAStar busca = new BuscaAStar();
	private BuscaTorre buscaTorre = new BuscaTorre();

	public void doAction(Entidade entidade) {
		Inimigo entity = (Inimigo)entidade;

		if(caminho == null)
			atualizarCaminho(entity);

		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(estado ==  EstadoInimigo.PARADO) {
			comecarAndar(entity);
			checarProx(entity);
		} else if(estado == EstadoInimigo.ANDANDO || estado == EstadoInimigo.ATACANDOTORRE)
			andar(entity);
		else
			atacar(entity);
	}
	
	@Override
	public int timeToWait() {
		return 700;
	}

	@Override
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
			estado = EstadoInimigo.ATACANDO;
		}
	}

	private void andar(Inimigo entity) {
		checarProx(entity);

		if(estado == EstadoInimigo.ANDANDO || estado == EstadoInimigo.ATACANDOTORRE) {
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

	private void mudarCasa(Inimigo inimigo) {
		Tabuleiro.getTabuleiroAtual().removerFormaDeVida(inimigo.getCasaAtual(), inimigo);
		Tabuleiro.getTabuleiroAtual().adicionarFormaDeVida(proxCasa, inimigo);
	}

	private void atacar(Inimigo inimigo) {
		if(alvo instanceof Coracao)
			((Coracao)alvo).receberDano(inimigo.getForca());
		else if(alvo instanceof Torre)
			((Torre)alvo).receberDano(inimigo.getForca());
			
		alvo.receberDano(inimigo.getForca());

		if(alvo.getVida() <= 0) {
			//Tabuleiro.getTabuleiroAtual().setCasa(alvo.getCasaAtual(), null);
			atualizarCaminho(inimigo);
		}
	}

	private boolean chegouProx(Inimigo entity) {
		if( new Point((int)entity.getX(), (int)entity.getY()).equals(Tabuleiro.getTabuleiroAtual().converteCoord(proxCasa)) )
			return true;

		return false;
	}

	private void checarProx(Inimigo entity) {
		if(Tabuleiro.getTabuleiroAtual().hasTorre(proxCasa)) {
			if(estado == EstadoInimigo.ATACANDOTORRE) {
				estado = EstadoInimigo.ATACANDO;
				for (FormaDeVida item : Tabuleiro.getTabuleiroAtual().getCasa(proxCasa).getList())
					if (item instanceof Torre) {
						alvo = (Torre)item;
						break;
					}
			} else
				atualizarCaminho(entity);
		}
	}

	private void verificarCaminho(Inimigo entity) {
		if(caminho == null) {
			estado = EstadoInimigo.ATACANDO;

			encontrarAlvo(entity);
		} else {
			if( caminho.size() == 0 ) {
				estado = EstadoInimigo.ATACANDO;
				alvo = ((JogoCenario)entity.getScenario()).getCoracao();
			} else {
				estado = EstadoInimigo.ANDANDO;
				comecarAndar(entity);
			}
		}
	}

	private void encontrarAlvo(Inimigo inimigo) {
		if(proxCasa != null) {
			for (FormaDeVida item : Tabuleiro.getTabuleiroAtual().getCasa(proxCasa).getList())
				if (item instanceof Torre) {
					alvo = (Torre)item;
					break;
				}
		} else {
			caminho = buscaTorre.buscar(inimigo.getCasaAtual());
			estado = EstadoInimigo.ATACANDOTORRE;
			comecarAndar(inimigo);
		}
	}
}
