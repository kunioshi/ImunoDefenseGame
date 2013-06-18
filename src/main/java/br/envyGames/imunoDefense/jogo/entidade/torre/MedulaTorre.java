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

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;

import br.envyGames.imunoDefense.jogo.ia.TorreIA;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class MedulaTorre extends Torre {
	
	private static Imagem imagemMiniatura = null;
	
	public static Imagem getImagemMiniatura() {
		if (imagemMiniatura == null)
			imagemMiniatura = ResourceManager.getImagem("/imagens/entidades/torres/MedulaI0.png");
		
		return imagemMiniatura;
	}

	public MedulaTorre(String nomeInstancia, Point xy, Cenario cenario) {
		super(nomeInstancia, xy, cenario);
		
		forca = 1;
		velocidade = 3;
		alcance = 2;
		this.tipoAtaque = TipoAtaque.Terrestre;
		
		custo = 25;
		
		imagemLevel1 = getImagemMiniatura();
		animacaoLevel1 = loadAnimation("/imagens/entidades/torres/MedulaI", ".png", 6, 20, AnimImage.STOP_AT_END);
		tiroImagem = ResourceManager.getImagem("/imagens/entidades/torres/tiroMedulaI.png");
		carregarSequenciaImagem();
		
        setDoNotStop(true);
        
        GameSystem.setAIforEntity(this, new TorreIA());
	}
}
