package br.envyGames.imunoDefense.jogo.entidade;

import java.awt.Point;

import s3t.gameControl.system.GameSystem;
import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;
import br.envyGames.imunoDefense.jogo.ia.TiroIA;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.Imagem;

public class Tiro extends Entidade {
	private int forca;
	private Imagem imagem;
	private Inimigo alvo;

	public Tiro(String nome, double x, double y, Cenario cenario) {
		super(nome, x, y, cenario);
        
        GameSystem.setAIforEntity(this, new TiroIA());
	}
	
	public Inimigo getAlvo() { return alvo; }
	public int getForca() { return forca; }
	
	public Point getCasaAtual() {
		return Tabuleiro.getTabuleiroAtual().converteCoord((int)getX(), (int)getY());
	}
}
