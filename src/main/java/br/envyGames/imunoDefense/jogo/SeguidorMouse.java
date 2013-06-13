package br.envyGames.imunoDefense.jogo;

import s3t.graphicsElements.ImageCollection;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.Imagem;

public class SeguidorMouse extends Entidade {

	public SeguidorMouse(double x, double y, Imagem imagem, Cenario cenario) {
		super("SeguidorMouse", x, y, cenario);
		
        ImageCollection imgCollection = new ImageCollection();
        imgCollection.add("default", imagem);
        imgCollection.setDefaultKey("default");
        
        setImageCollection(imgCollection);
        setDoNotStop(true);
	}

}
