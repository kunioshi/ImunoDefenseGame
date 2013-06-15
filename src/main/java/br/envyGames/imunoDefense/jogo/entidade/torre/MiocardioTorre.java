package br.envyGames.imunoDefense.jogo.entidade.torre;

import java.awt.Point;

import s3t.graphicsElements.AnimImage;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class MiocardioTorre extends Torre {
	
	private static Imagem imagemMiniatura = null;
	
	public static Imagem getImagemMiniatura() {
		if (imagemMiniatura == null)
			imagemMiniatura = ResourceManager.getImagem("/imagens/entidades/torres/MiocardioI0.png");
		
		return imagemMiniatura;
	}
	
	public MiocardioTorre(String nomeInstancia, Point xy, Cenario cenario)  {
		super(nomeInstancia, xy, cenario);
		
		this.vida *= 2;
		this.tipoAtaque = TipoAtaque.Nenhum;
		
		custo = 5;
		
		imagemLevel1 = getImagemMiniatura();
		animacaoLevel1 = loadAnimation("/imagens/entidades/torres/MiocardioI", ".png", 6, 20, AnimImage.STOP_AT_END);
		carregarSequenciaImagem();
		   
        setDoNotStop(true);
	}
}
