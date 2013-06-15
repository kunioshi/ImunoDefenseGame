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

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemColecao;

public class SeguidorMouse extends Entidade {

	public SeguidorMouse(double x, double y, Imagem imagem, Cenario cenario) {
		super("SeguidorMouse", x, y, cenario);
        
        ImagemColecao imagemColecao = new ImagemColecao();
		imagemColecao.add("default", imagem);
		imagemColecao.definirImagemPadrao("default");
		
		definirImagemColecao(imagemColecao);
        setDoNotStop(true);
	}

}
