package br.envyGames.imunoDefense.jogo;

import java.io.IOException;

import br.envyGames.imunoDefense.motor.ArquivoImagem;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;

public class LogoCenario extends Cenario {
	
	public int i = 0;
	public int j = 0;

	public LogoCenario(int largura, int altura) {
		super("LogoCenario", "Logo", largura, altura);
		
		configurarCenario();
	}

	private void configurarCenario() {
		try{
			
			CenarioLayer logo = CenarioLayer.criarSolidLayer("logo");
			
			Imagem telaLogo = new ArquivoImagem("/imagens/bgLogo.jpg");
			CenarioItem itemLogo = new CenarioItem("telaLogo", telaLogo, i, j);
			logo.adicionarItem(itemLogo);
			
			adicionarLayer(logo);			
		}
		catch (IOException e) {
			e.printStackTrace();
		
		}
	}

}