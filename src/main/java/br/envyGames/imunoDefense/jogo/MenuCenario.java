package br.envyGames.imunoDefense.jogo;

import java.awt.Color;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;


import br.envyGames.imunoDefense.motor.ArquivoImagem;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;

public class MenuCenario extends Cenario {

	public int i = 0;
	public int j = 0;

	public MenuCenario(int largura, int altura){
		super("MenuCenario", "Menu", largura, altura);
		
		try {
			CenarioLayer background = CenarioLayer.criarSolidLayer("background");
			
			Imagem bg = new ArquivoImagem("/imagens/bgFixo.jpg");
			Imagem logo = new ArquivoImagem("/imagens/bgLogo.jpg");
			Imagem Menu = new ArquivoImagem("/imagens/Menu.jpg");
			Imagem menuJogar = new ArquivoImagem("/imagens/jogar.jpg");
			Imagem menuInstrucoes = new ArquivoImagem("/imagens/instrucoesMenu.jpg");
			Imagem menuCreditos = new ArquivoImagem("/imagens/creditosMenu.jpg");
			Imagem menuSair = new ArquivoImagem("/imagens/sair.jpg");
	
		  	
			
			CenarioItem itemBg = new CenarioItem("background", bg, i, j);
			CenarioItem itemLogo = new CenarioItem("logo", logo, i, j);
			CenarioItem itemMenu = new CenarioItem("Menu", Menu, i, j);
			CenarioItem itemMenuJogar = new CenarioItem("menuJogar", menuJogar, i, j);
			CenarioItem itemMenuInstrucoes = new CenarioItem("menuInstrucoes", menuInstrucoes, i, j);
			CenarioItem itemMenuCreditos = new CenarioItem("menuCreditos", menuCreditos, i, j);
			CenarioItem itemMenuSair = new CenarioItem("menuSair", menuSair, i, j);		
			
			
			background.adicionarItem(itemBg);
			background.getScenarioItem("background").setVisible(false);
			background.adicionarItem(itemLogo);
			background.getScenarioItem("logo").setVisible(false);
					
			background.adicionarItem(itemMenuJogar);
			background.getScenarioItem("menuJogar").setVisible(false);
			background.adicionarItem(itemMenuInstrucoes);
			background.getScenarioItem("menuInstrucoes").setVisible(false);
			background.adicionarItem(itemMenuCreditos);
			background.getScenarioItem("menuCreditos").setVisible(false);
			background.adicionarItem(itemMenuSair);
			background.getScenarioItem("menuSair").setVisible(false);		
		    
			background.adicionarItem(itemMenu);	
			
			adicionarLayer(background);
			
			background.getScenarioItem("Menu").setVisible(true);		    	    
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
