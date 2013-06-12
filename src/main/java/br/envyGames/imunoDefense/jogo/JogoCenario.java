package br.envyGames.imunoDefense.jogo;

import java.io.IOException;

import br.envyGames.imunoDefense.motor.ArquivoImagem;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;

public class JogoCenario extends Cenario {

	public JogoCenario(int largura, int altura) {
		super("JogoCenario", "Jogo", largura, altura);		

		try {
			carregarBackground(largura, altura);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void carregarBackground(int largura, int altura) throws IOException {		
		CenarioLayer background = CenarioLayer.criarSolidLayer("BackGround");
		
		//criando um HUD para teste
		Imagem gridImagem = new ArquivoImagem("/imagens/grid.jpg");
		Imagem coracaoImagem = new ArquivoImagem("/imagens/coracao.jpg");
		Imagem menuBarImagem = new ArquivoImagem("/imagens/menuBar.jpg");
		
		Imagem botaoTorre = new ArquivoImagem("/imagens/botaoTorre1.jpg");
		
		for (int i = 0; convertGridPixel(i) < largura; i++)
	    	for (int j = 0; convertGridPixel(j) < altura; j++) {
	    		if (i < 23) {
	    			if (j < 13)
	    				background.adicionarItem(new CenarioItem("grid_" + i + "_" + j, gridImagem, convertGridPixel(i), convertGridPixel(j)));
	    			else
	    				background.adicionarItem(new CenarioItem("menuBar_" + i + "_" + j, menuBarImagem, convertGridPixel(i), convertGridPixel(j)));
	    		}
	    		else
	    			background.adicionarItem(new CenarioItem("coracao_" + i + "_" + j, coracaoImagem, convertGridPixel(i), convertGridPixel(j)));
	    	}
		
		background.adicionarItem(new CenarioItem("botaoTorre_1", botaoTorre, 6, 420));
		
		adicionarLayer(background);
	}
	
	private int convertGridPixel(int n) {
		return n * 32;
	}
		
}
