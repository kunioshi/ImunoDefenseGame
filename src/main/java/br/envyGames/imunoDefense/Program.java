package br.envyGames.imunoDefense;

import br.envyGames.imunoDefense.jogo.Jogo;

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
