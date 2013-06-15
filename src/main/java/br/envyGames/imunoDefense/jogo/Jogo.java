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
package br.envyGames.imunoDefense.jogo;

import br.envyGames.imunoDefense.jogo.cenario.CreditosCenario;
import br.envyGames.imunoDefense.jogo.cenario.GameOverCenario;
import br.envyGames.imunoDefense.jogo.cenario.InstrucoesCenario;
import br.envyGames.imunoDefense.jogo.cenario.JogoCenario;
import br.envyGames.imunoDefense.jogo.cenario.LogoCenario;
import br.envyGames.imunoDefense.jogo.cenario.MenuCenario;
import br.envyGames.imunoDefense.motor.JogoMotor;

public class Jogo implements Runnable
{	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 540;

	private JogoMotor motor;

	public void setup() {
		inicializarSistema();
		motor.criarJanela(WIDTH, HEIGHT);		
	}

	@Override
	public void run() {  
		criarCenarios();

		motor.exibirJanela();
		motor.inicializar();

		
//		motor.loadCenario("JogoCenario");
		
		motor.loadCenario("LogoCenario");
	}

	private void criarCenarios() {
		//cria o cenário INTRO LOGO
		motor.adicionarCenario(new LogoCenario(WIDTH, HEIGHT));

		//cria o cenário MENU
		motor.adicionarCenario(new MenuCenario(WIDTH, HEIGHT));

		//cria o cenário JOGO
		motor.adicionarCenario(new JogoCenario(WIDTH, HEIGHT));

		//cria o cenário INSTRUÇÕES
		motor.adicionarCenario(new InstrucoesCenario(WIDTH, HEIGHT));

		//cria o cenário CRÉDITOS
		motor.adicionarCenario(new CreditosCenario(WIDTH, HEIGHT));
		
		//cria o cenário Game Over
		motor.adicionarCenario(new GameOverCenario(WIDTH, HEIGHT));
	}

	private void inicializarSistema() {
		motor = new JogoMotor();

	}
}
