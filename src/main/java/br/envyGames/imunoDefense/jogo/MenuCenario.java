package br.envyGames.imunoDefense.jogo;

import java.awt.event.MouseEvent;

import java.io.IOException;

import s3t.gameControl.system.GameSystem;

import br.envyGames.imunoDefense.motor.ArquivoImagem;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.JogoMotor;

public class MenuCenario extends Cenario {

	public MenuCenario(int largura, int altura){
		super("MenuCenario", "Menu", largura, altura);
		
		try {			
			int x = 0;
			int y = 0;
			
			CenarioLayer background = CenarioLayer.criarSolidLayer("background");
			
			Imagem bg = new ArquivoImagem("/imagens/bgFixo.jpg");
			Imagem logo = new ArquivoImagem("/imagens/bgLogo.jpg");
			Imagem Menu = new ArquivoImagem("/imagens/Menu.jpg");
			Imagem menuJogar = new ArquivoImagem("/imagens/jogar.jpg");
			Imagem menuInstrucoes = new ArquivoImagem("/imagens/instrucoesMenu.jpg");
			Imagem menuCreditos = new ArquivoImagem("/imagens/creditosMenu.jpg");
			Imagem menuSair = new ArquivoImagem("/imagens/sair.jpg");		  	
			
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
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (isJogarButton(e.getX(), e.getY())) {
			JogoMotor.get().loadCenario("JogoCenario");
		}
		else if (isInstrucoesButton(e.getX(), e.getY())) {
			JogoMotor.get().loadCenario("InstrucoesCenario");
		}
		else if (isCreditosButton(e.getX(), e.getY())) {
			JogoMotor.get().loadCenario("CreditosCenario");
		}
		else if (isSairButton(e.getX(), e.getY())) {
			SairJogo();
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {		
		if (isJogarButton(e.getX(), e.getY())) {
			this.getLayerPorID("background").getItemPorNome("Menu").setVisible(false);
			this.getLayerPorID("background").getItemPorNome("menuJogar").setVisible(true);
		}
		else if (isInstrucoesButton(e.getX(), e.getY())) {
			this.getLayerPorID("background").getItemPorNome("Menu").setVisible(false);
			this.getLayerPorID("background").getItemPorNome("menuInstrucoes").setVisible(true);
		}
		else if (isCreditosButton(e.getX(), e.getY())) {
			this.getLayerPorID("background").getItemPorNome("Menu").setVisible(false);
			this.getLayerPorID("background").getItemPorNome("menuCreditos").setVisible(true);
		}
		else if (isSairButton(e.getX(), e.getY())) {
			this.getLayerPorID("background").getItemPorNome("Menu").setVisible(false);
			this.getLayerPorID("background").getItemPorNome("menuSair").setVisible(true);
		}
		else {
			this.getLayerPorID("background").getItemPorNome("Menu").setVisible(true);
			this.getLayerPorID("background").getItemPorNome("menuJogar").setVisible(false);
			this.getLayerPorID("background").getItemPorNome("menuInstrucoes").setVisible(false);
			this.getLayerPorID("background").getItemPorNome("menuCreditos").setVisible(false);
			this.getLayerPorID("background").getItemPorNome("menuSair").setVisible(false);
		}
	}
	
	private boolean isJogarButton(int x, int y) {
		return x >= 32 && x <= 160 && y >= 256 && y <= 288;
	}
	
	private boolean isInstrucoesButton(int x, int y) {
		return x >= 32 && x <= 224 && y >= 320 && y <= 352;
	}
	
	private boolean isCreditosButton(int x, int y) {
		return x >= 32 && x <= 192 && y >= 384 && y <= 416;
	}
	
	private boolean isSairButton(int x, int y) {
		return x >= 736 && x <= 768 && y >= 32 && y <= 64;
	}
	
	private void SairJogo() {
		System.exit(0);
	}
}
