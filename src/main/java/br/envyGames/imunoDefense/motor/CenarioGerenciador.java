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

import s3t.gameControl.system.GameSystem;

public class CenarioGerenciador {
	public void adicionarCenario(Cenario cenario) {
		GameSystem.getScenarioCollection().addScenario(cenario);
	}
	
	public void removerCenario(String id) {
		GameSystem.getScenarioCollection().removeScenario(id);
	}
	
	public void setCenarioAtual(String cenarioID) {
		GameSystem.getScenarioCollection().setScenarioAtual(cenarioID);
	}
	
	public Cenario getCenarioAtual() {		
		return (Cenario)GameSystem.getScenarioCollection().getScenarioAtual();
	}
	
	public Cenario getCenarioByID(String cenarioID) {		
		return (Cenario)GameSystem.getScenarioCollection().getScenario(cenarioID);
	}
}
