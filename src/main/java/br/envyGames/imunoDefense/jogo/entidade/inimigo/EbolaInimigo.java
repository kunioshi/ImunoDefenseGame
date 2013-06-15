package br.envyGames.imunoDefense.jogo.entidade.inimigo;

import java.awt.Point;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;
import s3t.graphicsElements.ImageCollection;

import br.envyGames.imunoDefense.jogo.ia.MalariaIA;
import br.envyGames.imunoDefense.motor.Cenario;

public class EbolaInimigo extends Inimigo {
	public EbolaInimigo(String name, Point xy, Cenario cenario) throws IOException {
		super(name, xy, cenario);
		
		this.tipoLocomocao = TipoLocomocao.Terrestre;
		
		ImageCollection imgCollection = new ImageCollection();
		
		imgCollection.add("direita", loadAnimation("/imagens/inimigos/Ebola-direita", ".png", 2, 20, AnimImage.GO_AND_BACK));
		imgCollection.add("esquerda", loadAnimation("/imagens/inimigos/Ebola-esquerda", ".png", 2, 20, AnimImage.GO_AND_BACK));
		imgCollection.add("baixo", loadAnimation("/imagens/inimigos/Ebola-Costas", ".png", 2, 20, AnimImage.GO_AND_BACK));
		imgCollection.add("cima", loadAnimation("/imagens/inimigos/Ebola-frente", ".png", 2, 20, AnimImage.GO_AND_BACK));
		
		setImageCollection(imgCollection);
		setImageKey("direita");
        setDoNotStop(true);
		
		GameSystem.setAIforEntity(this, new MalariaIA());
	}
}
