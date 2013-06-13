package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

public class CasaBusca {
	private Point casa = null;
	private CasaBusca antecessor = null;
	private double heuristica = 0;
	private int custoAcumulado = 0;
	
	/*
	 * Construtor<br/>
	 * Esta classe é utilizada para armazenar duas casas (<code>Point</scode>s) do tabuleiro, auxiliando a busca A*
	 * @param <code>praOnde</code> - Casa para onde a busca estará indo, caso não ache o caminho antes.
	 * @param <code>deOnde</code>  - Casa utilizada para chegar até a casa <code>praOnde</code>.
	 * @param <code>alvo</code>    - Casa final da busca (para calculo da heuristica).
	 */
	public CasaBusca(Point praOnde, CasaBusca deOnde, Point alvo) {
		casa = praOnde;
		antecessor = deOnde;
		
		
		if(deOnde == null) {
			heuristica = 0;
			custoAcumulado = 0;
		} else {
			heuristica = calculaHeuristica(alvo);
			custoAcumulado = deOnde.getAcumulado() + 1;
		}
	}
	
	public Point getCasa() { return casa; }
	public CasaBusca getAntecessor() { return antecessor; }
	public double getHeuristica() { return heuristica; }
	public int getAcumulado() { return custoAcumulado; }
	
	public void setAntecessor(CasaBusca novo) {
		if(novo.getAcumulado() + 1 < custoAcumulado) {
			antecessor = novo;
			custoAcumulado = novo.getAcumulado() + 1;
		}
	}
	
	public boolean mesmaCasa(Point obj) {
	    if(casa.equals(obj))
	    	return true;
	    
	    return false;
	}
	
	public double calculaHeuristica(Point alvo) {
		return  Math.sqrt( Math.pow( (casa.x - alvo.x), 2) + Math.pow( (casa.y - alvo.y), 2) );
	}
}
