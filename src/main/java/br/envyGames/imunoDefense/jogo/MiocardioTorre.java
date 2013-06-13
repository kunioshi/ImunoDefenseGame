package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.io.IOException;

import s3t.graphicsElements.ImageCollection;

import br.envyGames.imunoDefense.motor.ArquivoImagem;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class MiocardioTorre extends Torre {
	
	private static Imagem imagem = null;

	public MiocardioTorre(String nomeInstancia, Point xy, Cenario cenario)  {
		super(nomeInstancia, xy, cenario);
		   
		   if (imagem == null)
				imagem = ResourceManager.getImagem("/imagens/torres/MiocardioI.png");
			
	        ImageCollection imgCollection = new ImageCollection();
	        imgCollection.add("default", imagem);
	        imgCollection.setDefaultKey("default");
	        
	        setImageCollection(imgCollection);
	        setDoNotStop(true);
	}

}
