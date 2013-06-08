package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import s3t.gameControl.system.GameSystem;

public class InimigoGripe extends Inimigo {
	public InimigoGripe(String name, Point xy) {
		super(name, xy);
		
		GameSystem.setAIforEntity(this, new AIGripe());
	}
}
