package br.envyGames.imunoDefense.jogo.entidade;

import java.awt.Point;

import s3t.gameControl.system.GameSystem;
import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;
import br.envyGames.imunoDefense.jogo.ia.TiroIA;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemColecao;

public class Tiro extends Entidade {
	private static int id = 0;
	private int forca;
	private Inimigo alvo;

	public Tiro(double x, double y, Imagem imagem, Inimigo alvo, int forcaDano, Cenario cenario) {
		super("tiro"+id, x, y, cenario);
        
		this.alvo = alvo;
		this.forca = forcaDano;
		
		ImagemColecao imagemColecao = new ImagemColecao();
		imagemColecao.add("default", imagem);
		imagemColecao.definirImagemPadrao("default");
        
        definirImagemColecao(imagemColecao);
		
        GameSystem.setAIforEntity(this, new TiroIA());
        Tiro.id++;
	}
	
	public Inimigo getAlvo() { return alvo; }
	public int getForca() { return forca; }
	
	public Point getCasaAtual() {
		return Tabuleiro.getTabuleiroAtual().converteCoord((int)getX(), (int)getY());
	}
}
