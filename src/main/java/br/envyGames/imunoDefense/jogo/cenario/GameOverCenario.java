package br.envyGames.imunoDefense.jogo.cenario;

import java.awt.event.MouseEvent;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class GameOverCenario extends Cenario {
	
	private final int xInicialBotao = 350;
	private final int yInicialBotao = 300;
	
	public GameOverCenario(int largura, int altura) {
		super("GameOverCenario", "GameOver", largura, altura);
		
		configurarCenario();
	}
	
	@Override
	public void run() {
		
	}
	
	public void mouseClicked(MouseEvent e) {

		if (isSairButton(e.getX(), e.getY()))
			sairButtonClicked();
	}
		
	private void sairButtonClicked() {
		System.exit(0);		
	}

	private boolean isSairButton(int x, int y) {
		return x >= xInicialBotao && x <= xInicialBotao + 120  && y >= yInicialBotao && y <= yInicialBotao + 60;
	}

	private void configurarCenario() {
		int x = 0;
		int y = 0;
		
		CenarioLayer gameover = CenarioLayer.criarSolidLayer("gameover");
		
		Imagem telaGameOver = ResourceManager.getImagem("/imagens/GameOverSair.jpg");
		Imagem sairBotao = ResourceManager.getImagem("/imagens/SairBtn.png");
		
		CenarioItem itemGameOver = new CenarioItem("telaGameOver", telaGameOver, x, y);
		CenarioItem itemSairBotao = new CenarioItem("telaGameOverSim", sairBotao, xInicialBotao, yInicialBotao);
		
		gameover.adicionarItem(itemGameOver);
		gameover.adicionarItem(itemSairBotao);
		
		
		adicionarLayer(gameover);
	}


}
