package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;
import s3t.graphicsElements.ImageCollection;

import br.envyGames.imunoDefense.motor.Cenario;

public class InimigoEbola extends Inimigo {
	public InimigoEbola(String name, int y, Cenario cenario) throws IOException {
		super(name, new Point( 0, y ), cenario);
		
		ImageCollection imgCollection = new ImageCollection();
		
		imgCollection.add("direita", loadAnimation("/imagens/inimigos/Ebola-direita", ".png", 2, 20, AnimImage.GO_AND_BACK));
		imgCollection.add("esquerda", loadAnimation("/imagens/inimigos/Ebola-esquerda", ".png", 2, 20, AnimImage.GO_AND_BACK));
		imgCollection.add("baixo", loadAnimation("/imagens/inimigos/Ebola-Costas", ".png", 2, 20, AnimImage.GO_AND_BACK));
		imgCollection.add("cima", loadAnimation("/imagens/inimigos/Ebola-frente", ".png", 2, 20, AnimImage.GO_AND_BACK));
		
		setImageCollection(imgCollection);
		setImageKey("direita");
        setDoNotStop(true);
		
		GameSystem.setAIforEntity(this, new AIMalaria());
	}
}
