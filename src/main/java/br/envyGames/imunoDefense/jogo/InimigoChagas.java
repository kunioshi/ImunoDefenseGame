package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;
import s3t.graphicsElements.ImageCollection;

import br.envyGames.imunoDefense.motor.Cenario;

public class InimigoChagas extends Inimigo {
	public InimigoChagas(String name, Point xy, Cenario cenario) throws IOException {
		super(name, xy, cenario);
		
		ImageCollection imgCollection = new ImageCollection();

		imgCollection.add("direita", loadAnimation("/imagens/inimigos/Chagas - Direita ", ".png", 2, 20, AnimImage.GO_AND_BACK));
		imgCollection.add("esquerda", loadAnimation("/imagens/inimigos/Chagas - esquerda ", ".png", 2, 20, AnimImage.GO_AND_BACK));
		imgCollection.add("baixo", loadAnimation("/imagens/inimigos/Chagas -Frente ", ".png", 2, 20, AnimImage.GO_AND_BACK));
		imgCollection.add("cima", loadAnimation("/imagens/inimigos/Chagas - Costas ", ".png", 2, 20, AnimImage.GO_AND_BACK));
		
		setImageCollection(imgCollection);
		setImageKey("direita");
        setDoNotStop(true);
		
		GameSystem.setAIforEntity(this, new AIMalaria());
	}
}
