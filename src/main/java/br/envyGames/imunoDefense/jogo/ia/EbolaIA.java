/*
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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

import s3t.gameEntities.AIAction;
import s3t.gameEntities.Entity;
import s3t.gameEntities.IAMessage;

public class EbolaIA extends AIAction {
	private ArrayList<Point> caminho = null;
	private EstadoInimigo estado = EstadoInimigo.PARADO;
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

		
		
		if(estado ==  EstadoInimigo.PARADO) {
			comecarAndar(inimigo);
			checarProx(inimigo);
		} else if(estado == EstadoInimigo.ANDANDO)
			andar(inimigo);
		else
			atacar(inimigo);
	}

	@Override
	public void receiveMessage(IAMessage arg0) {}
	
	private void atualizarCaminho(Inimigo entity) {
		caminho = busca.buscar(entity.getCasaAtual());
		
		verificarCaminho(entity);
	}
	
	private void verificarCaminho(Inimigo entity) {
		if(caminho == null) {
			estado = EstadoInimigo.ATACANDO;
			
			encontrarAlvo();
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
	
	private void encontrarAlvo() {
		if(proxCasa != null) {
			for (FormaDeVida item : Tabuleiro.getTabuleiroAtual().getCasa(proxCasa).getList())
				if (item instanceof Torre) {
					alvo = (Torre)item;
					break;
				}
		}
	}
	
	private void comecarAndar(Inimigo entity) {
		if(caminho.size() != 0)
			proxCasa = caminho.remove(0);
		else {
			alvo = ((JogoCenario)entity.getScenario()).getCoracao();
			estado = EstadoInimigo.ATACANDO;
		}
	}
	
	private void checarProx(Inimigo entity) {
		if(Tabuleiro.getTabuleiroAtual().hasTorre(proxCasa))
			atualizarCaminho(entity);
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
	
	private void andar(Inimigo entity) {
		checarProx(entity);
		
		System.out.println(estado.toString());
		if(estado == EstadoInimigo.ANDANDO) {
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
	
	private void mudarCasa(Inimigo inimigo) {
		Tabuleiro.getTabuleiroAtual().removerFormaDeVida(inimigo.getCasaAtual(), inimigo);
		Tabuleiro.getTabuleiroAtual().adicionarFormaDeVida(proxCasa, inimigo);
	}
	
	private boolean chegouProx(Inimigo entity) {
		if( new Point((int)entity.getX(), (int)entity.getY()).equals(Tabuleiro.getTabuleiroAtual().converteCoord(proxCasa)) )
			return true;
		
		return false;
	}
}
