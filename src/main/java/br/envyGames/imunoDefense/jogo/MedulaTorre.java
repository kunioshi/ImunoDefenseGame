package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class MedulaTorre extends Torre {	

	private static Imagem imagem = null;

	public MedulaTorre(String nomeInstancia, Point xy, Cenario cenario) {
		super(nomeInstancia, xy, cenario);
		
		if (imagem == null)
			imagem = ResourceManager.getImagem("/imagens/torres/MedulaI.png");
	}

}
