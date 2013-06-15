package br.envyGames.imunoDefense.jogo.entidade.torre;

import java.awt.Point;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;

import br.envyGames.imunoDefense.jogo.ia.TorreIA;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class LeucogenTorre extends Torre {
	
	private static Imagem imagemMiniatura = null;
	
	public static Imagem getImagemMiniatura() {
		if (imagemMiniatura == null)
			imagemMiniatura = ResourceManager.getImagem("/imagens/entidades/torres/LeucogenI0.png");
		
		return imagemMiniatura;
	}

	public LeucogenTorre(String nome, Point xy, Cenario cenario) {
		super(nome, xy, cenario);
		
		forca = 5;
		velocidade = 1;
		alcance = 3;
		
		this.tipoAtaque = TipoAtaque.Terrestre;
		
		imagemLevel1 = getImagemMiniatura();
		animacaoLevel1 = loadAnimation("/imagens/entidades/torres/LeucogenI", ".png", 6, 20, AnimImage.STOP_AT_END);
		carregarSequenciaImagem();
		
        setDoNotStop(true);
        
        GameSystem.setAIforEntity(this, new TorreIA());
	}

}
