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
				inimigo = new InimigoChagas(ID, xy, cenario);
				break;
				
			case EBOLA:
				inimigo = new InimigoEbola(ID, xy, cenario);
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
