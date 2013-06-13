package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.io.IOException;

import br.envyGames.imunoDefense.motor.Cenario;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;
import s3t.graphicsElements.ImageCollection;

public class InimigoGripe extends Inimigo {
	public InimigoGripe(String name, int y, Cenario cenario) throws IOException {
		super(name, new Point(0, y), cenario);
		
		ImageCollection imgCollection = new ImageCollection();
		
		imgCollection.add("gripeDireita", loadAnimation("/imagens/inimigos/Gripe-direita", ".png", 2, 20, AnimImage.GO_AND_BACK));
		
		setImageCollection(imgCollection);
        setDoNotStop(true);
		
		GameSystem.setAIforEntity(this, new AIGripe());
	}
}
