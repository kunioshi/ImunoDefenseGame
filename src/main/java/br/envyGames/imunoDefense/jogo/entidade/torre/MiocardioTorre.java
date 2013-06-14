package br.envyGames.imunoDefense.jogo.entidade.torre;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemColecao;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class MiocardioTorre extends Torre {
	
	private static Imagem imagemLevel1 = null;
	
	public static Imagem getImagemLevel1() {
		   if (imagemLevel1 == null)
			   imagemLevel1 = ResourceManager.getImagem("/imagens/entidades/torres/MiocardioI0.png");
		   
		return imagemLevel1;
	}	

	public MiocardioTorre(String nomeInstancia, Point xy, Cenario cenario)  {
		super(nomeInstancia, xy, cenario);
		
		ImagemColecao imagemColecao = new ImagemColecao();
		imagemColecao.add("default", getImagemLevel1());
		imagemColecao.definirImagemPadrao("default");
		
		definirImagemColecao(imagemColecao);
		   
        setDoNotStop(true);
	}
}
