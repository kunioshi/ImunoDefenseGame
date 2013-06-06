package br.envyGames.imunoDefense.game;

import br.envyGames.imunoDefense.motor.Janela;
import br.envyGames.imunoDefense.motor.JogoMotor;

public class Jogo implements Runnable {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 512;
	
	private Janela janelaPrincipal;
	private JogoMotor motor;

	public void setup() {
		inicializarSistema();
		janelaPrincipal = motor.criarJanelaPrincipal(WIDTH, HEIGHT);
		exibirJanela();
	}
	
	@Override
	public void run() {
		
	}
	
	private void inicializarSistema() {
		motor = new JogoMotor();
		motor.inicializar();
	}

	private void exibirJanela() {
		janelaPrincipal.setVisible(true);
	}
}
