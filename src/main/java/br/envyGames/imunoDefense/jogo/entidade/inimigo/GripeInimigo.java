package br.envyGames.imunoDefense.jogo.entidade.inimigo;

import java.awt.Point;
import java.io.IOException;

import br.envyGames.imunoDefense.jogo.ia.GripeIA;
import br.envyGames.imunoDefense.motor.Cenario;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;
import s3t.graphicsElements.ImageCollection;

public class GripeInimigo extends Inimigo {
	public GripeInimigo(String name, Point xy, Cenario cenario) throws IOException {
		super(name, xy, cenario);
		
		this.tipoLocomocao = TipoLocomocao.Terrestre;
		bonusDinheiroToKill = 100;
		bonusScoreToKill = 10;
		vida = 10;
		
		ImageCollection imgCollection = new ImageCollection();
		
		imgCollection.add("gripeDireita", loadAnimation("/imagens/inimigos/Gripe-direita", ".png", 2, 20, AnimImage.GO_AND_BACK));
		
		setImageCollection(imgCollection);
        setDoNotStop(true);
		
		GameSystem.setAIforEntity(this, new GripeIA());
	}
}
