package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.util.ArrayList;

import s3t.gameEntities.AIAction;
import s3t.gameEntities.Entity;
import s3t.gameEntities.IAMessage;

public class AIEbola extends AIAction {
	private ArrayList<Point> caminho = null;
	private Estado estado = Estado.PARADO;
	private Point proxCasa = null;
	private FormaDeVida alvo = null;
	private BuscaTorre busca = new BuscaTorre();
	
	@Override
	public void doAction(Entity entity) {
		Inimigo inimigo = (Inimigo)entity;
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		if(caminho == null)
			atualizarCaminho(inimigo);

		
		
		if(estado ==  Estado.PARADO) {
			comecarAndar(inimigo);
			checarProx(inimigo);
		} else if(estado == Estado.ANDANDO)
			andar(inimigo);
		else
			atacar(inimigo);
	}

	@Override
	public void receiveMessage(IAMessage arg0) {}
	
	private void atualizarCaminho(Inimigo entity) {
		caminho = busca.buscar(entity);
		
		verificarCaminho(entity);
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
	
	private void comecarAndar(Inimigo entity) {
		if(caminho.size() != 0)
			proxCasa = caminho.remove(0);
		else {
			alvo = ((JogoCenario)entity.getScenario()).getCoracao();
			estado = Estado.ATACANDO;
		}
	}
	
	private void checarProx(Inimigo entity) {
		if(Tabuleiro.getTabuleiroAtual().isTorre(proxCasa))
			atualizarCaminho(entity);
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
	
	private void andar(Inimigo entity) {
		checarProx(entity);
		
		System.out.println(estado.toString());
		if(estado == Estado.ANDANDO) {
			mudarCasa(entity);
			
			if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) entity.getX()) < proxCasa.getX()) {
				entity.setImageKey("ebolaDireita");
				entity.doMove(entity.getVelocidade(), 0);
			} else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) entity.getX()) > proxCasa.getX()) {
				entity.setImageKey("ebolaEsquerda");
				entity.doMove(-entity.getVelocidade(), 0);
			} else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) entity.getY()) < proxCasa.getY()) {
				entity.setImageKey("ebolaBaixo");
				entity.doMove(0, entity.getVelocidade());
			} else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) entity.getY()) > proxCasa.getY()) {
				entity.setImageKey("ebolaCima");
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
	
	private boolean chegouProx(Inimigo entity) {
		if( new Point((int)entity.getX(), (int)entity.getY()).equals(Tabuleiro.getTabuleiroAtual().converteCoord(proxCasa)) )
			return true;
		
		return false;
	}
}
