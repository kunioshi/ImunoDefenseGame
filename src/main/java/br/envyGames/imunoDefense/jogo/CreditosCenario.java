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
			Imagem telaCreditos2 = new ArquivoImagem("/imagens/Creditos1.jpg");
			
			CenarioItem itemTelaCreditos = new CenarioItem("telaCreditos", telaCreditos, i, j);
			creditos.adicionarItem(itemTelaCreditos);
			creditos.getScenarioItem("telaCreditos").setVisible(true);
			
			CenarioItem itemTelaCreditos2 = new CenarioItem("telaCreditos2", telaCreditos2, i, j);
			creditos.adicionarItem(itemTelaCreditos2);
			creditos.getScenarioItem("telaCreditos2").setVisible(false);
			
			creditos.adicionarItem(itemTelaCreditos);
			
			adicionarLayer(creditos);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
