package br.envyGames.imunoDefense.jogo;


import br.envyGames.imunoDefense.motor.JogoMotor;

public class Jogo implements Runnable
{	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 540;

	private JogoMotor motor;

	public void setup() {
		inicializarSistema();
		motor.criarJanela(WIDTH, HEIGHT);		
	}

	@Override
	public void run() {  
		criarCenarios();

		motor.exibirJanela();
		motor.inicializar();

		
		motor.loadCenario("JogoCenario");
		
//		motor.loadCenario("LogoCenario");
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		motor.loadCenario("MenuCenario");
	}

	private void criarCenarios() {
		//cria o cenário INTRO LOGO
		motor.adicionarCenario(new LogoCenario(WIDTH, HEIGHT));

		//cria o cenário MENU
		motor.adicionarCenario(new MenuCenario(WIDTH, HEIGHT));

		//cria o cenário JOGO
		motor.adicionarCenario(new JogoCenario(WIDTH, HEIGHT));

		//cria o cenário INSTRUÇÕES
		motor.adicionarCenario(new InstrucoesCenario(WIDTH, HEIGHT));

		//cria o cenário CRÉDITOS
		motor.adicionarCenario(new CreditosCenario(WIDTH, HEIGHT));
		
		//cria o cenário Game Over
		motor.adicionarCenario(new GameOverCenario(WIDTH, HEIGHT));
	}

	private void inicializarSistema() {
		motor = new JogoMotor();

	}
}
