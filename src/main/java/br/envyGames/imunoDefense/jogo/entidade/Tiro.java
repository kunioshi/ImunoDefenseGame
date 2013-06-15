package br.envyGames.imunoDefense.jogo.entidade;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.Imagem;

public class Tiro extends Entidade {
	
	private int forca;
	private Imagem imagem;

	public Tiro(String nome, double x, double y, Cenario cenario) {
		super(nome, x, y, cenario);
	}

}
