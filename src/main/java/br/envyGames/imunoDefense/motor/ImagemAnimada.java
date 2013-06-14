package br.envyGames.imunoDefense.motor;

import s3t.graphicsElements.AnimImage;
import s3t.graphicsElements.SimpleImage;

public class ImagemAnimada extends AnimImage {

	public void adicionarImagem(Imagem imagem) {
		addImage((SimpleImage)imagem);
	}
}
