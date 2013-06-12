package br.envyGames.imunoDefense.motor;

import s3t.gameEntities.ScenarioItem;
import s3t.graphicsElements.ImageCollection;

public class CenarioItem extends ScenarioItem {
	public CenarioItem(String nome, Imagem imagem, int xPosicao, int yPosicao) {
		super(nome, imagem, xPosicao, yPosicao);
	}
	
	public CenarioItem(String nome, ImageCollection imagem, int xPosicao, int yPosicao) {
		super(nome, imagem, xPosicao, yPosicao);
	}
}
