package br.envyGames.imunoDefense;

import br.envyGames.imunoDefense.game.Jogo;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		
		jogo.setup();
		jogo.run();

	}

}
