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

public class Jogador {

	private int dinheiro;
	private int pontos;
	
	public void inicializarValores() {
		dinheiro = 10000;
		pontos = 0;
	}
	
	public int getDinheiro() {
		return dinheiro;
	}
	
	public void adicionarDinheiro(int valor) {
		dinheiro += valor;
	}
	
	public void removerDinheiro(int valor) {
		dinheiro -= valor;
	}
	
	public int getPontos() {
		return pontos;		
	}
	
	public void adicionarPontos(int valor) {
		pontos += valor;		
	}
}