package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Cenario;

public class TorreFactory {
	public static Torre criarMiocardio(String nomeInstancia, Point xy, Cenario cenario) {
		return new MiocardioTorre(nomeInstancia, xy, cenario);
	}
	
	public static Torre criarMedula(String nomeInstancia, Point xy, Cenario cenario) {
		return new MedulaTorre(nomeInstancia, xy, cenario);
	}
}
