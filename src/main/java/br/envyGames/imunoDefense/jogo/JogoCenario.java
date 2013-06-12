package br.envyGames.imunoDefense.jogo;

import java.awt.Color;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioLayer;

public class JogoCenario extends Cenario {

	public JogoCenario(int largura, int altura) {
		super("JogoCenario", "Jogo", largura, altura);
		

		carregarBackground();
	}
	
	private void carregarBackground() {		
		CenarioLayer background = CenarioLayer.criarSolidLayer("BackGround");
		
		adicionarLayer(background);
	}
		
}
