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
package br.envyGames.imunoDefense.jogo.entidade.torre;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import br.envyGames.imunoDefense.jogo.entidade.FormaDeVida;
import br.envyGames.imunoDefense.jogo.entidade.Tiro;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemAnimada;
import br.envyGames.imunoDefense.motor.ImagemColecao;

public abstract class Torre extends FormaDeVida {
	protected Imagem imagemLevel1 = null;
	protected ImagemAnimada animacaoLevel1 = null;
	protected Imagem tiroImagem = null;
	protected int forca = 0;
	protected int velocidade = 0;
	protected int alcance = 0;
	protected TipoAtaque tipoAtaque;
	protected int custo;
	private int level = 1;
	
	private List<AtirarListener> atirarListeners;

	/*
	 * Construtor
	 * @param <code>nomeInstancia</code> - Nome do inimigo do qual será usado para encontra-lo na EntityCollection.
	 * @param <code>xy</code>   - Coordenadas "(x, y)" iniciais. 
	 */
	public Torre(String nomeInstancia, Point xy, Cenario cenario) {
		super(nomeInstancia, xy, cenario);
		
		this.vida = 10;
		atirarListeners = new ArrayList<AtirarListener>();
	}
	
	// Getters & Setters
	public int getForca() { return forca; }
	public int getLevel() { return level; }
	public int getVelocidade() { return velocidade; }
	public int getAlcance() { return alcance; }
	public TipoAtaque getTipoAtaque() { return tipoAtaque; }
	public int getCusto() { return custo; }
	
	public void setForca(int dano) { forca = dano; }
	public void upgrade() { 
		level++; 
		forca++;
		vida *= 1.5;
	}
	
	public boolean isUpgradable() {
		return level <= 2;
	}
	
	@Override
	public void receberDano(int dano) {
		super.receberDano(dano);
		
		if(getImageKey() == "dano")
			setImageKey("default");
		else
			setImageKey("dano");
	}
	
	public void addAtirarListener(AtirarListener listener) {
		atirarListeners.add(listener);
	}
	
	public void removeAtirarListener(AtirarListener listener) {
		atirarListeners.remove(listener);
	}
	
	public void atirar(Inimigo alvo) {
		fireRemoverAtirarEvent(criarTiro(alvo));
	}

	private Tiro criarTiro(Inimigo alvo) {
		return new Tiro(this.getX(), this.getY(), tiroImagem, alvo, forca, this.getCenario());
	}
	
	protected void carregarSequenciaImagem() {
		ImagemColecao imagemColecao = new ImagemColecao();
		imagemColecao.add("default", imagemLevel1);
		imagemColecao.add("dano", animacaoLevel1);
		imagemColecao.definirImagemPadrao("default");
		
		definirImagemColecao(imagemColecao);
	}
	
	private void fireRemoverAtirarEvent(Tiro tiro) {
		for (AtirarListener listener : atirarListeners)
			listener.handleAtirarEvent(tiro);
	}
}
