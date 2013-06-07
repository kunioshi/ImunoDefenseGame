package br.envyGames.imunoDefense.jogo;

import java.awt.Color;
import java.io.IOException;

import br.envyGames.imunoDefense.motor.ArquivoImagem;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;

public class MenuCenario extends Cenario {

	public MenuCenario(int largura, int altura) {
		super("MenuCenario", "Menu", largura, altura);
		try {
		    setBackgroundColor(Color.black);
			
			CenarioLayer background = CenarioLayer.criarSolidLayer("BackGround");
			Imagem grama = new ArquivoImagem("/imagens/grama.jpg");
	
		    for (int i = 0; i < largura; i += 32)
		    	for (int j = 0; j < altura; j += 32) {
		    		CenarioItem item = new CenarioItem("grama" + i + "_" + j, grama, i, j);
	
		    		background.adicionarItem(item);
		    	}    		
		    
		    adicionarLayer(background);		    
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
