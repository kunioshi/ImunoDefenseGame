package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;

import br.envyGames.imunoDefense.motor.Cenario;
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
		Cenario menu = new MenuCenario(WIDTH, HEIGHT);
		motor.getCenarioGerenciador().adicionarCenario(menu);
		motor.loadCenario(menu.getScenarioId());
		try {
			InimigoGripe gripe = new InimigoGripe("gripe", new Point(32, 32), menu);
			GameSystem.getEntityCollection().addEntity(gripe);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void inicializarSistema() {
		motor = new JogoMotor();
		motor.inicializar();
	}

	private void exibirJanela() {
		janelaPrincipal.setVisible(true);
	}
}
