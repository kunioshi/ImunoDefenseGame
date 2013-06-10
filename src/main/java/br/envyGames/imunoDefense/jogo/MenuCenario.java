package br.envyGames.imunoDefense.jogo;

import java.awt.Color;
import java.awt.SplashScreen;
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
		    setBackgroundColor(Color.black);
			
			CenarioLayer background = CenarioLayer.criarSolidLayer("BackGround");
			//Imagem grama = new ArquivoImagem("/imagens/grama.jpg");
			Imagem bg = new ArquivoImagem("/imagens/backgroundFixo.png");
			Imagem logo = new ArquivoImagem("/imagens/bgLogo.png");
			Imagem Menu = new ArquivoImagem("/imagens/Menu.png");
			Imagem menuJogar = new ArquivoImagem("/imagens/jogar.png");
			Imagem menuInstrucoes = new ArquivoImagem("/imagens/instrucoesMenu.png");
			Imagem menuCreditos = new ArquivoImagem("/imagens/creditosMenu.png");
			Imagem menuSair = new ArquivoImagem("/imagens/sair.png");
			Imagem telaInstrucoes = new ArquivoImagem("/imagens/instrucoes1.png");
			Imagem telaInstrucoes2 = new ArquivoImagem("/imagens/instrucoes2.png");
			Imagem telaCreditos = new ArquivoImagem("/imagens/Creditos.png");
	
		  	
			
			CenarioItem itemBg = new CenarioItem("background", bg, i, j);
			CenarioItem itemLogo = new CenarioItem("logo", logo, i, j);
			CenarioItem itemMenu = new CenarioItem("Menu", Menu, i, j);
			CenarioItem itemMenuJogar = new CenarioItem("menuJogar", menuJogar, i, j);
			CenarioItem itemMenuInstrucoes = new CenarioItem("menuInstrucoes", menuInstrucoes, i, j);
			CenarioItem itemMenuCreditos = new CenarioItem("menuCreditos", menuCreditos, i, j);
			CenarioItem itemMenuSair = new CenarioItem("menuSair", menuSair, i, j);
			CenarioItem itemTelaInstrucoes = new CenarioItem("telaInstrucoes", telaInstrucoes, i, j);
			CenarioItem itemTelaInstrucoes2 = new CenarioItem("telaInstrucoes2", telaInstrucoes2, i, j);
			CenarioItem itemTelaCreditos = new CenarioItem("telaCreditos", telaCreditos, i, j);
			
		    
			background.adicionarItem(itemMenu);
			adicionarLayer(background);
			
			//System.out.println("DAHFUIOAHEFUIOAEH");
			
			
			
			// for (int i = 0; i < largura; i += 32)
			  //  for (int j = 0; j < altura; j += 32) {
			  //  	CenarioItem item = new CenarioItem("grama" + i + "_" + j, grama, i, j);
			    		
			  //  background.adicionarItem(item);
			//}    	
			
			
			
			
		    	    
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	}

}
