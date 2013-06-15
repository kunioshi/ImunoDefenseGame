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

import s3t.graphicsElements.AnimImage;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class MiocardioTorre extends Torre {
	
	private static Imagem imagemMiniatura = null;
	
	public static Imagem getImagemMiniatura() {
		if (imagemMiniatura == null)
			imagemMiniatura = ResourceManager.getImagem("/imagens/entidades/torres/MiocardioI0.png");
		
		return imagemMiniatura;
	}
	
	public MiocardioTorre(String nomeInstancia, Point xy, Cenario cenario)  {
		super(nomeInstancia, xy, cenario);
		
		this.vida *= 2;
		this.tipoAtaque = TipoAtaque.Nenhum;
		
		custo = 5;
		
		imagemLevel1 = getImagemMiniatura();
		animacaoLevel1 = loadAnimation("/imagens/entidades/torres/MiocardioI", ".png", 6, 20, AnimImage.STOP_AT_END);
		carregarSequenciaImagem();
		   
        setDoNotStop(true);
	}
}
