package br.envyGames.imunoDefense.jogo;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.JogoMotor;

public class Jogo implements Runnable
{	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 544;

	private JogoMotor motor;

	public void setup() {
		inicializarSistema();
		motor.criarJanela(WIDTH, HEIGHT);
		motor.exibirJanela();
	}
	
	@Override
	public void run() {  
		 //cria o cenário INTRO LOGO
		 Cenario logo = new LogoCenario(WIDTH, HEIGHT);
		 motor.adicionarCenario(logo);
		
		 //cria o cenário MENU
		 Cenario menu = new MenuCenario(WIDTH, HEIGHT);
		 motor.adicionarCenario(menu);
		 
		//cria o cenário JOGO
		 Cenario jogo = new JogoCenario(WIDTH, HEIGHT);
		 motor.adicionarCenario(jogo);
		 
		 //cria o cenário INSTRUÇÕES
		 Cenario instrucoes = new InstrucoesCenario(WIDTH, HEIGHT);
		 motor.adicionarCenario(instrucoes);
		 
		 //cria o cenário CRÉDITOS
		 Cenario creditos = new CreditosCenario(WIDTH, HEIGHT);
		 motor.adicionarCenario(creditos);		 
		 
		 //Carrega o cenário
		 motor.loadCenario(menu.getScenarioId());
		 
		/*
		 Cenario jogo = new JogoCenario(WIDTH, HEIGHT);
		 motor.adicionarCenario(jogo);
		 motor.loadCenario(jogo.getScenarioId());
		 */
	}
	
	private void inicializarSistema() {
		motor = JogoMotor.get();
		motor.inicializar();		 
	}
}
