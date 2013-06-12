package br.envyGames.imunoDefense.jogo;

import java.io.IOException;


import br.envyGames.imunoDefense.motor.ArquivoImagem;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;

public class InstrucoesCenario extends Cenario {

	public int i = 0;
	public int j = 0;
	
	public InstrucoesCenario(int largura, int altura){
		super("InstrucoesCenario", "Instrucoes", largura, altura);
		
		try{
			
			CenarioLayer instrucoes = CenarioLayer.criarSolidLayer("instrucoes");
			
			Imagem imgInstrucoes = new ArquivoImagem("/imagens/Instrucoes1.jpg");
			Imagem imgInstrucoes2 = new ArquivoImagem("/imagens/Instrucoes2.jpg");
			
			CenarioItem itemInstrucoes = new CenarioItem("imgInstrucoes", imgInstrucoes, i, j);
			CenarioItem itemInstrucoes2 = new CenarioItem("imgInstrucoes2", imgInstrucoes2, i, j);
			
			instrucoes.adicionarItem(itemInstrucoes);
			instrucoes.getScenarioItem("imgInstrucoes").setVisible(true);
			instrucoes.adicionarItem(itemInstrucoes2);
			instrucoes.getScenarioItem("imgInstrucoes2").setVisible(false);
			
			adicionarLayer(instrucoes);
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}