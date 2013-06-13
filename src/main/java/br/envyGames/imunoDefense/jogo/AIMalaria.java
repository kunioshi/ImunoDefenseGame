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
			try {
				atualizaCaminho(entity);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(estado ==  Estado.PARADO) {
			comecaAndar();
			try {
				checaCaminho(entity);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(estado == Estado.ANDANDO)
			anda((InimigoMalaria)entity);
		else
			ataca();
	}

	@Override
	public void receiveMessage(IAMessage msg) {}
	
	private void atualizaCaminho(Entity entity) throws InterruptedException {
		caminho = busca.busca(Tabuleiro.getTabuleiroAtual().getCasas(), new Point((int)entity.getX(), (int)entity.getY()), Tabuleiro.getTabuleiroAtual().getFinal());
		
		Thread.sleep(1000);
		
		if(caminho == null)
			estado = Estado.ATACANDO;
		else {
			estado = Estado.ANDANDO;
			comecaAndar();
		}
		//if( caminho.get(0).equals( Tabuleiro.converteCoord((int)entity.getX(), (int)entity.getY()) ) )
		//	alvo = Coração;
	}
	
	private void comecaAndar() {
		if(caminho.size() != 0)
			proxCasa = caminho.remove(0);
		else
			estado = Estado.ATACANDO;
	}
	
	private void anda(InimigoMalaria entity) {
		if(entity.getX() < proxCasa.getX())
			entity.doMove(entity.getVelocidade(), 0);
		else if(entity.getX() > proxCasa.getX())
			entity.doMove(-entity.getVelocidade(), 0);
		
		if(entity.getY() < proxCasa.getY())
			entity.doMove(0, entity.getVelocidade());
		else if(entity.getY() > proxCasa.getY())
			entity.doMove(0, -entity.getVelocidade());

		if(chegouProx(entity))
			comecaAndar();
	}
	
	private void ataca() {
		//Ataca(alvo);
	}
	
	private boolean chegouProx(InimigoMalaria entity) {
		if( new Point((int)entity.getX(), (int)entity.getY()).equals(Tabuleiro.getTabuleiroAtual().converteCoord(proxCasa)) )
			return true;
		
		return false;
	}
	
	private void checaCaminho(Entity entity) throws InterruptedException {
		if(Tabuleiro.getTabuleiroAtual().checaCasa(proxCasa) != Casa.VAZIA || Tabuleiro.getTabuleiroAtual().checaCasa(proxCasa) != Casa.INIMIGO)
			atualizaCaminho(entity);
	}
}