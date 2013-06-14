package br.envyGames.imunoDefense.jogo.ia;

import java.awt.Point;

public class CasaFila {
	Point casa;
	CasaFila antecessor;
	
	public CasaFila(Point praOnde, CasaFila deOnde) {
		casa = praOnde;
		antecessor = deOnde;
	}
	
	public Point getCasa() { return casa; }
	public CasaFila getAntecessor() { return antecessor; }
	
	public boolean mesmaCasa(Point obj) {
	    if(casa.equals(obj))
	    	return true;
	    
	    return false;
	}
}
