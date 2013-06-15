package br.envyGames.imunoDefense.jogo.entidade.torre;

import java.awt.Point;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;

import br.envyGames.imunoDefense.jogo.ia.TorreIA;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class MedulaTorre extends Torre {
	
	private static Imagem imagemMiniatura = null;
	
	public static Imagem getImagemMiniatura() {
		if (imagemMiniatura == null)
			imagemMiniatura = ResourceManager.getImagem("/imagens/entidades/torres/MedulaI0.png");
		
		return imagemMiniatura;
	}

	public MedulaTorre(String nomeInstancia, Point xy, Cenario cenario) {
		super(nomeInstancia, xy, cenario);
		
		forca = 1;
		velocidade = 3;
		alcance = 2;
		this.tipoAtaque = TipoAtaque.Terrestre;
		
		imagemLevel1 = getImagemMiniatura();
		animacaoLevel1 = loadAnimation("/imagens/entidades/torres/MedulaI", ".png", 6, 20, AnimImage.STOP_AT_END);
		carregarSequenciaImagem();
		
        setDoNotStop(true);
        
        GameSystem.setAIforEntity(this, new TorreIA());
	}
}
