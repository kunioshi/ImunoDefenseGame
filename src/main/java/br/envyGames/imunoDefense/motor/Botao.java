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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Botao extends Entidade implements MouseListener {

	public Botao(String nome, double x, double y, Cenario cenario) {
		super(nome, x, y, cenario);
		// TODO Auto-generated constructor stub
	}
	private int largura;
	private int altura;
	
	private boolean isBotao(int x, int y) {
		return (this.getX() >= x && this.getX() + largura <= x 
				&& this.getY() >= y && this.getY() - altura <= y);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (isBotao(e.getX(), e.getY())) {
			//Dispara o clicar
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
