package br.envyGames.imunoDefense.motor;

import java.io.IOException;

public class ResourceManager {
	public static Imagem getImagem(String fullName) {
		try {
			return new ArquivoImagem(fullName);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
