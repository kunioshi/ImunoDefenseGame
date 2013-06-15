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

import s3t.gameControl.system.GameSystem;
import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;
import br.envyGames.imunoDefense.jogo.ia.TiroIA;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemColecao;

public class Tiro extends Entidade {
	private static int id = 0;
	private int forca;
	private Inimigo alvo;

	public Tiro(double x, double y, Imagem imagem, Inimigo alvo, int forcaDano, Cenario cenario) {
		super("tiro"+id, x, y, cenario);
        
		this.alvo = alvo;
		this.forca = forcaDano;
		
		ImagemColecao imagemColecao = new ImagemColecao();
		imagemColecao.add("default", imagem);
		imagemColecao.definirImagemPadrao("default");
        
        definirImagemColecao(imagemColecao);
		
        GameSystem.setAIforEntity(this, new TiroIA());
        Tiro.id++;
	}
	
	public Inimigo getAlvo() { return alvo; }
	public int getForca() { return forca; }
	
	public Point getCasaAtual() {
		return Tabuleiro.getTabuleiroAtual().converteCoord((int)getX(), (int)getY());
	}
}
