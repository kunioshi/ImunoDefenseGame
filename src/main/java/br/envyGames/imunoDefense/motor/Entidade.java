package br.envyGames.imunoDefense.motor;

import s3t.gameEntities.Entity;

public class Entidade extends Entity {

	public Entidade(String nome, double x, double y, Cenario cenario) {
		super(nome, x, y, cenario);
	}
	
	public void definirImagemColecao(ImagemColecao imagem) {
		setImageCollection(imagem);
	}

}
