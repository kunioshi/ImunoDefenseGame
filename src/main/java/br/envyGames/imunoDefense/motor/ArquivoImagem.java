package br.envyGames.imunoDefense.motor;

import java.io.IOException;

import s3t.graphicsElements.SimpleImage;

public class ArquivoImagem extends SimpleImage implements Imagem {

	public ArquivoImagem(String path) throws IOException {
		super(path);
	}

}