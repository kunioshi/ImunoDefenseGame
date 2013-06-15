/*
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.envyGames.imunoDefense.jogo.cenario;

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
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		carregarNovoCenario("MenuCenario");
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