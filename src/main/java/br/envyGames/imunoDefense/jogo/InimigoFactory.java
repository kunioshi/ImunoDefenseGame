package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.io.IOException;

import br.envyGames.imunoDefense.motor.Cenario;

public class InimigoFactory {
	public static Inimigo criarInimigo(TipoInimigo tipoInimigo, String ID, Point xy, Cenario cenario) {
		Inimigo inimigo = null;
		try {
			switch (tipoInimigo) {
			case CHAGAS:
				break;
				
			case EBOLA:
				break;
				
			case GRIPE:
				inimigo = new InimigoGripe(ID, xy, cenario);
				break;
				
			case MALARIA:
				inimigo = new InimigoMalaria(ID, xy, cenario);
				break;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return inimigo;
	}
}
