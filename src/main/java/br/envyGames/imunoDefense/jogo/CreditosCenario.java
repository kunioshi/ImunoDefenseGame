package br.envyGames.imunoDefense.jogo;

import java.io.IOException;

import br.envyGames.imunoDefense.motor.ArquivoImagem;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;

public class CreditosCenario extends Cenario {
	
	public int i = 0;
	public int j = 0;

	public CreditosCenario(int largura, int altura) {
		super("CreditosCenario", "Creditos", largura, altura);
		
		try{
			
			CenarioLayer creditos = CenarioLayer.criarSolidLayer("creditos");
			
			Imagem telaCreditos = new ArquivoImagem("/imagens/Creditos.jpg");
			CenarioItem itemTelaCreditos = new CenarioItem("telaCreditos", telaCreditos, i, j);
			creditos.adicionarItem(itemTelaCreditos);
			
			adicionarLayer(creditos);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
