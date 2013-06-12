package br.envyGames.imunoDefense.jogo;

import java.awt.event.MouseEvent;
import java.io.IOException;

import br.envyGames.imunoDefense.motor.ArquivoImagem;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.JogoMotor;

public class CreditosCenario extends Cenario {
	
	public CreditosCenario(int largura, int altura) {
		super("CreditosCenario", "Creditos", largura, altura);
		
		try{
			
			int x = 0;
			int y = 0;
			
			CenarioLayer creditos = CenarioLayer.criarSolidLayer("creditos");
			
			Imagem telaCreditos = new ArquivoImagem("/imagens/Creditos.jpg");
			Imagem telaCreditos2 = new ArquivoImagem("/imagens/Creditos1.jpg");
			
			CenarioItem itemTelaCreditos = new CenarioItem("telaCreditos", telaCreditos, x, y);
			creditos.adicionarItem(itemTelaCreditos);
			creditos.getItemPorNome("telaCreditos").setVisible(true);
			
			CenarioItem itemTelaCreditos2 = new CenarioItem("telaCreditos2", telaCreditos2, x, y);
			creditos.adicionarItem(itemTelaCreditos2);
			creditos.getItemPorNome("telaCreditos2").setVisible(false);
			
			creditos.adicionarItem(itemTelaCreditos);
			
			adicionarLayer(creditos);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (isVoltarButton(e.getX(), e.getY())) {
			JogoMotor.get().loadCenario("MenuCenario");
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {		
		if (isVoltarButton(e.getX(), e.getY())) {
			this.getLayerPorID("creditos").getItemPorNome("telaCreditos").setVisible(true);
			this.getLayerPorID("creditos").getItemPorNome("telaCreditos2").setVisible(false);			
		}
		else
		{
			this.getLayerPorID("creditos").getItemPorNome("telaCreditos").setVisible(false);
			this.getLayerPorID("creditos").getItemPorNome("telaCreditos2").setVisible(true);
		}
	}
	
	private boolean isVoltarButton(int x, int y) {
		return x >= 0 && x <= 32 && y >= 480 && y <= 512;
	}

}
