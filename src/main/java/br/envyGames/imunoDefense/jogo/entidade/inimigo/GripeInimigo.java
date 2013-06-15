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
package br.envyGames.imunoDefense.jogo.entidade.inimigo;

import java.awt.Point;
import java.io.IOException;

import br.envyGames.imunoDefense.jogo.ia.GripeIA;
import br.envyGames.imunoDefense.motor.Cenario;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;
import s3t.graphicsElements.ImageCollection;

public class GripeInimigo extends Inimigo {
	public GripeInimigo(String name, Point xy, Cenario cenario) throws IOException {
		super(name, xy, cenario);
		
		this.tipoLocomocao = TipoLocomocao.Terrestre;
		bonusDinheiroToKill = 100;
		bonusScoreToKill = 10;
		vida = 10;
		forca = 1;
		
		ImageCollection imgCollection = new ImageCollection();
		
		imgCollection.add("gripeDireita", loadAnimation("/imagens/inimigos/Gripe-direita", ".png", 2, 20, AnimImage.GO_AND_BACK));
		
		setImageCollection(imgCollection);
        setDoNotStop(true);
		
		GameSystem.setAIforEntity(this, new GripeIA());
	}
}
