package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;
import s3t.graphicsElements.ImageCollection;

import br.envyGames.imunoDefense.motor.Cenario;

public class InimigoMalaria extends Inimigo {
	public InimigoMalaria(String name, Point xy, Cenario cenario) throws IOException {
		super(name, xy, cenario);
		
		ImageCollection imgCollection = new ImageCollection();

		imgCollection.add("direita", loadAnimation("/imagens/inimigos/Malaria-direita", ".png", 1, 20, AnimImage.GO_AND_BACK));
		imgCollection.add("esquerda", loadAnimation("/imagens/inimigos/Malaria-esquerda", ".png", 1, 20, AnimImage.GO_AND_BACK));
		imgCollection.add("baixo", loadAnimation("/imagens/inimigos/Malaria-frente", ".png", 1, 20, AnimImage.GO_AND_BACK));
		imgCollection.add("cima", loadAnimation("/imagens/inimigos/Malaria-costas", ".png", 1, 20, AnimImage.GO_AND_BACK));
		
		setImageCollection(imgCollection);
		setImageKey("direita");
        setDoNotStop(true);
		
		GameSystem.setAIforEntity(this, new AIMalaria());
	}
}
