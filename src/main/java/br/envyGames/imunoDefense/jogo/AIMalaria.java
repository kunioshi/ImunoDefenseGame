package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.util.ArrayList;

import s3t.gameEntities.AIAction;
import s3t.gameEntities.Entity;
import s3t.gameEntities.IAMessage;

public class AIMalaria extends AIAction {
	private ArrayList<Point> caminho = null;
	private Estado estado = Estado.PARADO;
	private Point proxCasa = null;
	private Entity alvo = null;
	private BuscaAStar busca = new BuscaAStar();
	
	@Override
	public void doAction(Entity entity) {
		if(caminho == null)
			atualizaCaminho(entity);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(estado ==  Estado.PARADO) {
			comecaAndar();
			checaCaminho(entity);
		}
		else if(estado == Estado.ANDANDO)
			anda((InimigoMalaria)entity);
		else
			ataca();
	}

	@Override
	public void receiveMessage(IAMessage msg) {}
	
	private void atualizaCaminho(Entity entity) {
		caminho = busca.busca(Tabuleiro.getTabuleiroAtual().getCasas(), new Point( Tabuleiro.getTabuleiroAtual().converteCoord((int)entity.getX(), (int)entity.getY()) ), Tabuleiro.getTabuleiroAtual().getFinal());
		
		if(caminho == null)
			estado = Estado.ATACANDO;
		else {
			estado = Estado.ANDANDO;
			comecaAndar();
		}
//		if( caminho.get(0).equals( Tabuleiro.getTabuleiroAtual().converteCoord((int)entity.getX(), (int)entity.getY()) ) ) {
//			estado = Estado.ATACANDO;
//			alvo = 
//		}
	}
	
	private void comecaAndar() {
		if(caminho.size() != 0)
			proxCasa = caminho.remove(0);
		else
			estado = Estado.ATACANDO;
	}
	
	private void anda(InimigoMalaria entity) {
		checaCaminho(entity);
		
		if(estado != Estado.ANDANDO) {
			if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) entity.getX()) < proxCasa.getX())
				entity.doMove(entity.getVelocidade(), 0);
			else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) entity.getX()) > proxCasa.getX())
				entity.doMove(-entity.getVelocidade(), 0);
			else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) entity.getY()) < proxCasa.getY())
				entity.doMove(0, entity.getVelocidade());
			else if(Tabuleiro.getTabuleiroAtual().converteCoordToGrid((int) entity.getY()) > proxCasa.getY())
				entity.doMove(0, -entity.getVelocidade());

			if(chegouProx(entity) && caminho != null)
				comecaAndar();
		}
	}
	
	private void ataca() {
		//Ataca(alvo);
	}
	
	private boolean chegouProx(InimigoMalaria entity) {
		if( new Point((int)entity.getX(), (int)entity.getY()).equals(Tabuleiro.getTabuleiroAtual().converteCoord(proxCasa)) )
			return true;
		
		return false;
	}
	
	private void checaCaminho(Entity entity) {
		if(Tabuleiro.getTabuleiroAtual().isTorre(proxCasa))
			atualizaCaminho(entity);
	}
}