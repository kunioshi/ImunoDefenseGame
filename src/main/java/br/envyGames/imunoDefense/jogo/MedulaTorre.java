package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import s3t.graphicsElements.ImageCollection;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
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
		
        ImageCollection imgCollection = new ImageCollection();
        imgCollection.add("default", getImagemLevel1());
        imgCollection.setDefaultKey("default");
        
        setImageCollection(imgCollection);
        setDoNotStop(true);
	}

	@Override
	public boolean isUpgradable() {
		return true;
	}

}
