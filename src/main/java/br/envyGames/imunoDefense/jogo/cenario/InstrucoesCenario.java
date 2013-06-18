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

import java.awt.event.MouseEvent;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class InstrucoesCenario extends Cenario{
	
	public int aux = 0;
	
	public InstrucoesCenario(int largura, int altura) {
		super("InstrucoesCenario", "Instrucoes", largura, altura);
		
		configurarCenario();
	}
	
	@Override
	public void run() {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		int gridX = (int) (e.getX() / 32);
		int gridY = (int) (e.getY() / 32);	
		
		if (isHomeButton(gridX, gridY)){
			HomeButtonClicked();
		}
		if (isNextButton(gridX, gridY)){
			NextButtonClicked();
		}
	}
	
	public void mouseMoved(MouseEvent e) {
		int gridX = (int) (e.getX() / 32);
		int gridY = (int) (e.getY() / 32);	
		
		
		//Primeira tela de Instrucoes
		if (aux == 0){
			this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2Home").setVisible(false);
			this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2").setVisible(false);
			this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2Back").setVisible(false);
			
			if (isHomeButton(gridX, gridY)) {			
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes").setVisible(false);	
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes1Home").setVisible(true);	
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes1Next").setVisible(false);
			}
			else if (isNextButton(gridX, gridY)) {				
					this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes1Home").setVisible(false);
					this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes").setVisible(false);
					this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes1Next").setVisible(true);
				}
			else{
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes1Home").setVisible(false);
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes").setVisible(true);
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes1Next").setVisible(false);
			}
			
		}
		
		
		//Segunda tela de Instrucoes
		if (aux == 1){
			this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes1Home").setVisible(false);
			this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes").setVisible(false);
			this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes1Next").setVisible(false);
			
			if (isHomeButton(gridX, gridY)) {			
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2").setVisible(false);	
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2Home").setVisible(true);	
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2Back").setVisible(false);
			}
		
			else if (isNextButton(gridX, gridY)) {
			
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2Home").setVisible(false);
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2").setVisible(false);
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2Back").setVisible(true);
			}
			else{
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2Home").setVisible(false);
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2").setVisible(true);
				this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2Back").setVisible(false);
			}
		}		
	}
	
	private void configurarCenario() {
		int x = 0;
		int y = 0;
		
		CenarioLayer instrucoes = CenarioLayer.criarSolidLayer("instrucoes");
		
		Imagem imgInstrucoes = ResourceManager.getImagem("/imagens/Instrucoes1.jpg");
		Imagem imgInstrucoes2 = ResourceManager.getImagem("/imagens/Instrucoes2.jpg");
		Imagem imgInstrucoes1Next = ResourceManager.getImagem("/imagens/Instrucoes1Next.jpg");
		Imagem imgInstrucoes1Home = ResourceManager.getImagem("/imagens/Instrucoes1Home.jpg");
		Imagem imgInstrucoes2Back = ResourceManager.getImagem("/imagens/Instrucoes2Back.jpg");
		Imagem imgInstrucoes2Home = ResourceManager.getImagem("/imagens/Instrucoes2Home.jpg");
		
		CenarioItem itemInstrucoes = new CenarioItem("imgInstrucoes", imgInstrucoes, x, y);
		CenarioItem itemInstrucoes2 = new CenarioItem("imgInstrucoes2", imgInstrucoes2, x, y);
		CenarioItem itemInstrucoes1Next = new CenarioItem("imgInstrucoes1Next", imgInstrucoes1Next, x, y);
		CenarioItem itemInstrucoes1Home = new CenarioItem("imgInstrucoes1Home", imgInstrucoes1Home, x, y);
		CenarioItem itemInstrucoes2Back = new CenarioItem("imgInstrucoes2Back", imgInstrucoes2Back, x, y);
		CenarioItem itemInstrucoes2Home = new CenarioItem("imgInstrucoes2Home", imgInstrucoes2Home, x, y);
		
		
		instrucoes.adicionarItem(itemInstrucoes);
		instrucoes.getItemPorNome("imgInstrucoes").setVisible(true);
		instrucoes.adicionarItem(itemInstrucoes2);
		instrucoes.getItemPorNome("imgInstrucoes2").setVisible(false);
		instrucoes.adicionarItem(itemInstrucoes1Next);
		instrucoes.getItemPorNome("imgInstrucoes1Next").setVisible(false);
		instrucoes.adicionarItem(itemInstrucoes1Home);
		instrucoes.getItemPorNome("imgInstrucoes1Home").setVisible(false);
		instrucoes.adicionarItem(itemInstrucoes2Back);
		instrucoes.getItemPorNome("imgInstrucoes2Back").setVisible(false);
		instrucoes.adicionarItem(itemInstrucoes2Home);
		instrucoes.getItemPorNome("imgInstrucoes2Home").setVisible(false);
		
		
		adicionarLayer(instrucoes);
	}
	
	private boolean isHomeButton(int x, int y) {
		return x >= 1 && x <= 2 && (y == 14 || y == 15);
	}
	private boolean isNextButton(int x, int y) {
		return x >= 21 && x <= 23 && (y == 14 || y == 15);
	}
	
	private void HomeButtonClicked() {
		carregarNovoCenario("MenuCenario");
		if (aux == 1){
			aux = 0;
		}
	}
	
	private void NextButtonClicked() {
		this.getLayerPorID("instrucoes").getItemPorNome("imgInstrucoes2").setVisible(true);
		if (aux == 0){
		aux = 1;
		}
		else{
		aux = 0;
		}
	}

}
