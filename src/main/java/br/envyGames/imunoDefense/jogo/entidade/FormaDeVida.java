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
package br.envyGames.imunoDefense.jogo.entidade;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemAnimada;
import br.envyGames.imunoDefense.motor.ResourceManager;

public abstract class FormaDeVida extends Entidade {
	private List<MorteListener> morteListeners;	
	protected int vida;

	public FormaDeVida(String nome, Point xy, Cenario cenario) {
		super(nome, xy.x, xy.y, cenario);
		
		morteListeners = new ArrayList<MorteListener>();
	}	

	public int getVida() { return vida; }
	public void setVida(int novaVida) { vida = novaVida; }
	
	public void receberDano(int dano) {
		vida -= dano;
		
		if (isDead())
			matarFormaDeVida();
	}
	
	public void receberCura(int heal) {
		vida += heal; 
	}
	
	public boolean isDead() {
		return vida <= 0;
	}
	
	public Point getCasaAtual() {
		return Tabuleiro.getTabuleiroAtual().converteCoord((int)getX(), (int)getY());
	}
	
	public void addMorteListener(MorteListener listener) {
		morteListeners.add(listener);
	}
	
	public void removeMorteListener(MorteListener listener) {
		morteListeners.remove(listener);
	}
	
	public void morrer() {
		//Para ser sobrescrito no filho
	}
	
	private void matarFormaDeVida() {
		morrer();
		
		fireMorteFormaDeVidaEvent();
		destruir();
	}
	
	private void fireMorteFormaDeVidaEvent() {
		for (MorteListener listener : morteListeners)
			listener.handleMorteFormaDeVida(this);
	}
	
	public static ImagemAnimada loadAnimation(String firstName, String extension, int endNumber, int period, int behavior) {
		ImagemAnimada animImage = new ImagemAnimada();

        for (int i = 0; i <= endNumber; i++) {
            Imagem img = ResourceManager.getImagem(firstName + i + extension);
            //img.setCollisionRectangle(new Rectangle(0, 0, Tabuleiro.getTabuleiroAtual().getTamanhoCasa(), Tabuleiro.getTabuleiroAtual().getTamanhoCasa()));
            animImage.adicionarImagem(img);
        }
        
        animImage.setPeriod(period);
        animImage.setBehavior(behavior);
        
        return animImage;
    }
}
