package br.envyGames.imunoDefense.jogo;

import java.awt.event.MouseEvent;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class MenuCenario extends Cenario {

	public MenuCenario(int largura, int altura){
		super("MenuCenario", "Menu", largura, altura);
		
		configurarCenario();
	}
	
	@Override
	public void run() {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int gridX = (int) (e.getX() / 32);
		int gridY = (int) (e.getY() / 32);
		
		if (isJogarButton(gridX, gridY)) {
			JogarButtonClicked();
		}
		else if (isInstrucoesButton(gridX, gridY)) {
			InstrucoesButtonClicked();
		}
		else if (isCreditosButton(gridX, gridY)) {
			CreditosButtonClicked();
		}
		else if (isSairButton(gridX, gridY)) {
			SairButtonClicked();
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {		
		
		int gridX = (int) (e.getX() / 32);
		int gridY = (int) (e.getY() / 32);	
		
		if (isJogarButton(gridX, gridY)) {
			this.getLayerPorID("background").getScenarioItem("Menu").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuJogar").setVisible(true);
			this.getLayerPorID("background").getScenarioItem("menuInstrucoes").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuCreditos").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuSair").setVisible(false);
		}
		else if (isInstrucoesButton(gridX, gridY)) {
			this.getLayerPorID("background").getScenarioItem("Menu").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuJogar").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuInstrucoes").setVisible(true);
			this.getLayerPorID("background").getScenarioItem("menuCreditos").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuSair").setVisible(false);
		}
		else if (isCreditosButton(gridX, gridY)) {
			this.getLayerPorID("background").getScenarioItem("Menu").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuJogar").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuInstrucoes").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuCreditos").setVisible(true);
			this.getLayerPorID("background").getScenarioItem("menuSair").setVisible(false);
		}
		else if (isSairButton(gridX, gridY)) {
			this.getLayerPorID("background").getScenarioItem("Menu").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuJogar").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuInstrucoes").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuCreditos").setVisible(false);
			this.getLayerPorID("background").getScenarioItem("menuSair").setVisible(true);
		}
		else {
			this.getLayerPorID("background").getItemPorNome("Menu").setVisible(true);
			this.getLayerPorID("background").getItemPorNome("menuJogar").setVisible(false);
			this.getLayerPorID("background").getItemPorNome("menuInstrucoes").setVisible(false);
			this.getLayerPorID("background").getItemPorNome("menuCreditos").setVisible(false);
			this.getLayerPorID("background").getItemPorNome("menuSair").setVisible(false);
		}
	}
	
	private void configurarCenario() {		
		int x = 0;
		int y = 0;
		
		CenarioLayer background = CenarioLayer.criarSolidLayer("background");
		
		Imagem bg = ResourceManager.getImagem("/imagens/bgFixo.jpg");
		Imagem logo = ResourceManager.getImagem("/imagens/bgLogo.jpg");
		Imagem Menu = ResourceManager.getImagem("/imagens/Menu.jpg");
		Imagem menuJogar = ResourceManager.getImagem("/imagens/jogar.jpg");
		Imagem menuInstrucoes = ResourceManager.getImagem("/imagens/instrucoesMenu.jpg");
		Imagem menuCreditos = ResourceManager.getImagem("/imagens/creditosMenu.jpg");
		Imagem menuSair = ResourceManager.getImagem("/imagens/sair.jpg");		  	
		
		CenarioItem itemBg = new CenarioItem("background", bg, x, y);
		CenarioItem itemLogo = new CenarioItem("logo", logo, x, y);
		CenarioItem itemMenu = new CenarioItem("Menu", Menu, x, y);
		CenarioItem itemMenuJogar = new CenarioItem("menuJogar", menuJogar, x, y);
		CenarioItem itemMenuInstrucoes = new CenarioItem("menuInstrucoes", menuInstrucoes, x, y);
		CenarioItem itemMenuCreditos = new CenarioItem("menuCreditos", menuCreditos, x, y);
		CenarioItem itemMenuSair = new CenarioItem("menuSair", menuSair, x, y);				
		
		background.adicionarItem(itemBg);
		background.getItemPorNome("background").setVisible(false);
		background.adicionarItem(itemLogo);
		background.getItemPorNome("logo").setVisible(false);
				
		background.adicionarItem(itemMenuJogar);
		background.getItemPorNome("menuJogar").setVisible(false);
		background.adicionarItem(itemMenuInstrucoes);
		background.getItemPorNome("menuInstrucoes").setVisible(false);
		background.adicionarItem(itemMenuCreditos);
		background.getItemPorNome("menuCreditos").setVisible(false);
		background.adicionarItem(itemMenuSair);
		background.getItemPorNome("menuSair").setVisible(false);		
	    
		background.adicionarItem(itemMenu);	
		
		adicionarLayer(background);
		
		background.getItemPorNome("Menu").setVisible(true);
	}
	
	private boolean isJogarButton(int x, int y) {
		return x >= 0 && x <= 5 && (y == 8 || y == 9);
	}
	
	private boolean isInstrucoesButton(int x, int y) {
		return x >= 1 && x <= 7 && (y == 10 || y == 11);
	}
	
	private boolean isCreditosButton(int x, int y) {
		return x >= 1 && x <= 6 && (y == 12 || y == 13);
	}
	
	private boolean isSairButton(int x, int y) {
		return x >= 22 && x <= 23 && (y == 1 || y == 2);
	}
	
	private void JogarButtonClicked() {
		carregarNovoCenario("JogoCenario");
	}
	
	private void InstrucoesButtonClicked() {
		carregarNovoCenario("InstrucoesCenario");
	}
	
	private void CreditosButtonClicked() {
		carregarNovoCenario("CreditosCenario");
	}
	
	private void SairButtonClicked() {
		SairJogo();
	}	
	
	private void SairJogo() {
		System.exit(0);
	}
}
