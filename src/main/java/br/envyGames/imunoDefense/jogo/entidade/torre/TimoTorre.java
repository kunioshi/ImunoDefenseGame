package br.envyGames.imunoDefense.jogo.entidade.torre;

import java.awt.Point;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;

import br.envyGames.imunoDefense.jogo.ia.TorreIA;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class TimoTorre extends Torre {
	
	private static Imagem imagemMiniatura = null;
	
	public static Imagem getImagemMiniatura() {
		if (imagemMiniatura == null)
			imagemMiniatura = ResourceManager.getImagem("/imagens/entidades/torres/TimoI0.png");
		
		return imagemMiniatura;
	}

	public TimoTorre(String nome, Point xy, Cenario cenario) {
		super(nome, xy, cenario);
		
		forca = 2;
		velocidade = 5;
		alcance = 3;
		this.tipoAtaque = TipoAtaque.TerrestreEVoador;
		
		custo = 50;
		
		imagemLevel1 = getImagemMiniatura();
		animacaoLevel1 = loadAnimation("/imagens/entidades/torres/TimoI", ".png", 6, 20, AnimImage.STOP_AT_END);
		tiroImagem = ResourceManager.getImagem("/imagens/entidades/torres/tiroTimoI.png");
		carregarSequenciaImagem();
		
        setDoNotStop(true);
        
        GameSystem.setAIforEntity(this, new TorreIA());
	}

}
