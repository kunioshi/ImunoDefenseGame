package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.io.IOException;

import s3t.graphicsElements.ImageCollection;

import br.envyGames.imunoDefense.motor.ArquivoImagem;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;

public class MiocardioTorre extends Torre {
	
	private static Imagem imagem = null;

	public MiocardioTorre(String nomeInstancia, Point xy, Cenario cenario)  {
		super(nomeInstancia, xy, cenario);
		   
		   if (imagem == null)
			try {
				imagem = new ArquivoImagem("/imagens/Torre1.jpg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        ImageCollection imgCollection = new ImageCollection();
	        imgCollection.add("default", imagem);
	        imgCollection.setDefaultKey("default");
	        
	        setImageCollection(imgCollection);
	        setDoNotStop(true);
	}

}
