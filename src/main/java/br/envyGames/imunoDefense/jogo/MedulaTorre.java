package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import s3t.gameControl.system.GameSystem;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemColecao;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class MedulaTorre extends Torre {	

	private static Imagem imagemLevel1 = null;
	
	public static Imagem getImagemLevel1() {
		   if (imagemLevel1 == null)
			   imagemLevel1 = ResourceManager.getImagem("/imagens/entidades/torres/MedulaI.png");
		   
		return imagemLevel1;
	}	

	public MedulaTorre(String nomeInstancia, Point xy, Cenario cenario) {
		super(nomeInstancia, xy, cenario);
		
		ImagemColecao imagemColecao = new ImagemColecao();
		imagemColecao.add("default", getImagemLevel1());
		imagemColecao.definirImagemPadrao("default");
		
		definirImagemColecao(imagemColecao);
        setDoNotStop(true);
        
        GameSystem.setAIforEntity(this, new IAMedula());
	}

	@Override
	public boolean isUpgradable() {
		return true;
	}

}
