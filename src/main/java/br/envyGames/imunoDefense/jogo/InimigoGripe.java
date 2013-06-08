package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Cenario;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.ImageCollection;

public class InimigoGripe extends Inimigo {
	public InimigoGripe(String name, Point xy, Cenario cenario) {
		super(name, xy, cenario);
		
		//ImageCollection imgCollection = ;
		
		GameSystem.setAIforEntity(this, new AIGripe());
	}
}
