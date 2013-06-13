package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Cenario;

public class Coracao extends FormaDeVida {
	
	public Coracao(Cenario cenario) {
		super("Coracao", new Point(Tabuleiro.getTabuleiroAtual().getWidth(), 0), cenario);
		
		vida = 20;
	}

	@Override
	public void morrer() {
		
	}
}
