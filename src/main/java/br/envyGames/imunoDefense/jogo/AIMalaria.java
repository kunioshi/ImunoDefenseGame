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
	
	@Override
	public void doAction(Entity entity) {
		if(caminho == null)
			atualizaCaminho(entity);
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
		caminho = BuscaAStar.busca(Tabuleiro.getTabuleiroAtual().getCasas(), new Point((int)entity.getX(), (int)entity.getY()), Tabuleiro.getTabuleiroAtual().getFinal());
		
		if(caminho == null)
			estado = Estado.ATACANDO;
		//if( caminho.get(0).equals( Tabuleiro.converteCoord((int)entity.getX(), (int)entity.getY()) ) )
		//	alvo = Coração;
	}
	
	private void comecaAndar() {
		proxCasa = caminho.remove(0);
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
			estado = Estado.PARADO;
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
		if(Tabuleiro.getTabuleiroAtual().checaCasa(proxCasa) != Casa.VAZIA || Tabuleiro.getTabuleiroAtual().checaCasa(proxCasa) != Casa.INIMIGO)
			atualizaCaminho(entity);
	}
}