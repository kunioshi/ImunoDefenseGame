package br.envyGames.imunoDefense.jogo;

import java.awt.event.MouseEvent;
import java.io.IOException;

import br.envyGames.imunoDefense.motor.ArquivoImagem;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;

public class GameOverCenario extends Cenario {
	
	public GameOverCenario(int largura, int altura) {
		super("GameOverCenario", "GameOver", largura, altura);
		
		configurarCenario();
	}
	
	public void mouseClicked(MouseEvent e) {
		int gridX = (int) (e.getX() / 32);
		int gridY = (int) (e.getY() / 32);
		
		System.out.println(gridX + "|" + gridY);
		
		if (isSimButton(gridX, gridY)){
			SimButtonClicked();
		}
		if (isNaoButton(gridX, gridY)){
			NaoButtonClicked();
		}
	}
	
	public void mouseMoved(MouseEvent e) {
		int gridX = (int) (e.getX() / 32);
		int gridY = (int) (e.getY() / 32);
		
		if (isSimButton(gridX, gridY)) {			
			this.getLayerPorID("gameover").getItemPorNome("telaGameOver").setVisible(false);	
			this.getLayerPorID("gameover").getItemPorNome("telaGameOverSim").setVisible(true);	
			this.getLayerPorID("gameover").getItemPorNome("telaGameOverNao").setVisible(false);
		}
		else if (isNaoButton(gridX, gridY)) {				
				this.getLayerPorID("gameover").getItemPorNome("telaGameOverSim").setVisible(false);
				this.getLayerPorID("gameover").getItemPorNome("telaGameOver").setVisible(false);
				this.getLayerPorID("gameover").getItemPorNome("telaGameOverNao").setVisible(true);
			}
		else{
			this.getLayerPorID("gameover").getItemPorNome("telaGameOverSim").setVisible(false);
			this.getLayerPorID("gameover").getItemPorNome("telaGameOver").setVisible(true);
			this.getLayerPorID("gameover").getItemPorNome("telaGameOverNao").setVisible(false);
		}
	}
	
	private void configurarCenario() {
		try{
			
			int x = 0;
			int y = 0;
			
			CenarioLayer gameover = CenarioLayer.criarSolidLayer("gameover");
			
			Imagem telaGameOver = new ArquivoImagem("/imagens/gameOver.jpg");
			Imagem telaGameOverSim = new ArquivoImagem("/imagens/gameOverSim.jpg");
			Imagem telaGameOverNao = new ArquivoImagem("/imagens/gameOverNao.jpg");
			
			
			CenarioItem itemGameOver = new CenarioItem("telaGameOver", telaGameOver, x, y);
			CenarioItem itemGameOverSim = new CenarioItem("telaGameOverSim", telaGameOverSim, x, y);
			CenarioItem itemGameOverNao = new CenarioItem("telaGameOverNao", telaGameOverNao, x, y);
			
			
			gameover.adicionarItem(itemGameOver);
			gameover.getItemPorNome("telaGameOver").setVisible(true);
			gameover.adicionarItem(itemGameOverSim);
			gameover.getItemPorNome("telaGameOverSim").setVisible(false);
			gameover.adicionarItem(itemGameOverNao);
			gameover.getItemPorNome("telaGameOverNao").setVisible(false);
			
			
			adicionarLayer(gameover);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean isSimButton(int x, int y) {
		return x >= 6 && x <= 8 && (y == 13 || y == 14);
	}
	private boolean isNaoButton(int x, int y) {
		return x >= 16 && x <= 19 && (y == 13 || y == 14);
	}
	
	private void SimButtonClicked() {
		carregarNovoCenario("JogoCenario");
	}
	
	private void NaoButtonClicked() {		
		carregarNovoCenario("MenuCenario");
	}

}
