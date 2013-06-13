package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;
import s3t.graphicsElements.ImageCollection;

import br.envyGames.imunoDefense.motor.Cenario;

public class InimigoMalaria extends Inimigo {
	public InimigoMalaria(String name, Cenario cenario) throws IOException {
		super(name, new Point( 0, 0 ), cenario);
		
		ImageCollection imgCollection = new ImageCollection();
		
		imgCollection.add("malariaDefault", loadAnimation("/imagens/bolinha", ".png", 2, 20, AnimImage.GO_AND_BACK));
		
		setImageCollection(imgCollection);
        setDoNotStop(true);
		
		GameSystem.setAIforEntity(this, new AIMalaria());
	}
}
