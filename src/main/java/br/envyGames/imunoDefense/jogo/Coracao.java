package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.JogoMotor;

public class Coracao extends FormaDeVida {

	private JogoMotor motor;
	
	public Coracao(Cenario cenario) {
		super("Coracao", new Point(Tabuleiro.getTabuleiroAtual().getWidth(), 0), cenario);
		
		vida = 20;
	}

	@Override
	public void morrer() {
		motor.loadCenario("GameOverCenario");
		motor.getEntidadeGerenciador().clear();
		
	}
}
