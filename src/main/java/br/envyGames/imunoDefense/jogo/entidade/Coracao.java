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

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemColecao;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class Coracao extends FormaDeVida {

	private static Imagem coracao = ResourceManager.getImagem("/imagens/entidades/CoracaoVivo.png");
	private static Imagem coracao50porcento = ResourceManager.getImagem("/imagens/entidades/Coracao50porcento.png");
	private static Imagem coracao20porcento = ResourceManager.getImagem("/imagens/entidades/Coracao20porcento.png");
	private ImagemColecao imagemColecao;
	private final int TOTAL_VIDA = 100;
	
	public Coracao(Point xy, Cenario cenario) {
		super("Coracao", xy, cenario);
		
		vida = TOTAL_VIDA;
		
		imagemColecao = new ImagemColecao();
		imagemColecao.add("100porcento", coracao);
		imagemColecao.add("50porcento", coracao50porcento);
		imagemColecao.add("20porcento", coracao20porcento);
		imagemColecao.definirImagemPadrao("100porcento");
        
        definirImagemColecao(imagemColecao);
        setDoNotStop(true);
	}
	
	@Override
	public void receberDano(int dano) {
		super.receberDano(dano);
		
		if (getVida() <= TOTAL_VIDA * 0.5) {
			if (getVida() <= TOTAL_VIDA * 0.2)
				setImageKey("20porcento");
			else 
				setImageKey("50porcento");
		}
	}
}
