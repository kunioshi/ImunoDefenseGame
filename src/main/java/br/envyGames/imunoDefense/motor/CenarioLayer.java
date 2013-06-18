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
package br.envyGames.imunoDefense.motor;

import s3t.gameEntities.ScenarioLayer;
import s3t.gameEntities.eScenarioBehavior;

public class CenarioLayer extends ScenarioLayer {
	
	public static CenarioLayer criarSolidLayer(String id) {
		return new CenarioLayer(id, eScenarioBehavior.SOLID);
	}
	
	public static CenarioLayer criarPassLayer(String id) {
		return new CenarioLayer(id, eScenarioBehavior.PASS);
	}

	private CenarioLayer(String id, eScenarioBehavior behavior) {
		super(id, behavior);
	}
	
	public void adicionarItem(CenarioItem item) {
		addScenarioItem(item);
	}
	
	public CenarioItem getItemPorNome(String nome) {
		return (CenarioItem)this.getScenarioItem(nome);
	}
}
