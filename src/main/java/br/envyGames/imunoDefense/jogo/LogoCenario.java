package br.envyGames.imunoDefense.jogo;

import java.awt.Rectangle;
import java.io.IOException;

import s3t.graphicsElements.AnimImage;
import s3t.graphicsElements.ImageCollection;
import s3t.graphicsElements.SimpleImage;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;

public class LogoCenario extends Cenario {

	public LogoCenario(int largura, int altura) {
		super("LogoCenario", "Logo", largura, altura);
		
		configurarCenario();
	}

	private void configurarCenario() {
		try {
			int x = 0;
			int y = 0;
			CenarioLayer logo = CenarioLayer.criarSolidLayer("logo");
			
			ImageCollection telaLogo = new ImageCollection();
			telaLogo.add("default", loadAnimation("/imagens/logo/logo", ".jpg", 15, 15, AnimImage.GO_AND_BACK));
			
			//Imagem telaLogo = new ArquivoImagem("/imagens/bgLogo.jpg");
			CenarioItem itemLogo = new CenarioItem("telaLogo", telaLogo, x, y);
			logo.adicionarItem(itemLogo);
			
			adicionarLayer(logo);			
		}
		catch (IOException e) {
			e.printStackTrace();
		
		}
	}
	
	private static AnimImage loadAnimation(String firstName, String extension, int endNumber, int period, int behavior) throws IOException {
        AnimImage animImage = new AnimImage();

        for (int i = 0; i <= endNumber; i++) {
            SimpleImage img = new SimpleImage(firstName + i + extension);
            img.setCollisionRectangle(new Rectangle(0, 10, 35, 40));
            animImage.addImage(img);
        }
        
        animImage.setPeriod(period);
        animImage.setBehavior(behavior);
        return animImage;
    }
}