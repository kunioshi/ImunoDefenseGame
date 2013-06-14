package br.envyGames.imunoDefense.jogo.entidade.torre;

import java.awt.Point;
import java.io.IOException;

import s3t.graphicsElements.AnimImage;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemAnimada;
import br.envyGames.imunoDefense.motor.ImagemColecao;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class MiocardioTorre extends Torre {
	private static Imagem imagemLevel1 = null;
	private static ImagemAnimada animacaoLevel1 = null;

	public static Imagem getImagemLevel1() {
		if (imagemLevel1 == null)
			imagemLevel1 = ResourceManager.getImagem("/imagens/entidades/torres/MiocardioI0.png");

		return imagemLevel1;
	}

	public static ImagemAnimada getAnimacaoLevel1() {
		if (animacaoLevel1 == null) {
			try {
				animacaoLevel1 = loadAnimation("/imagens/entidades/torres/MiocardioI", ".png", 6, 20, AnimImage.STOP_AT_END);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return animacaoLevel1;
	}

	public MiocardioTorre(String nomeInstancia, Point xy, Cenario cenario)  {
		super(nomeInstancia, xy, cenario);
		
		ImagemColecao imagemColecao = new ImagemColecao();
		imagemColecao.add("default", getImagemLevel1());
		imagemColecao.add("dano", getAnimacaoLevel1());
		imagemColecao.definirImagemPadrao("default");
		
		definirImagemColecao(imagemColecao);
		   
        setDoNotStop(true);
	}
}
