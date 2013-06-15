package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.jogo.entidade.torre.LeucogenTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.MedulaTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.MiocardioTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.RochaganTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.TimoTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.TipoTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.Torre;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;

public class TorreFactory {
	
	public static Torre criarTorre(TipoTorre tipoTorre, String nomeInstancia, Point xy, Cenario cenario) {
		Torre torre = null;
		switch(tipoTorre) {
			case MIOCARDIO:
				torre = new MiocardioTorre(nomeInstancia, xy, cenario);
				break;
				
			case MEDULA:
				torre = new MedulaTorre(nomeInstancia, xy, cenario);
				break;
				
			case TIMO:
				torre = new TimoTorre(nomeInstancia, xy, cenario);
				break;

			case LEUCOGEN:
				torre = new LeucogenTorre(nomeInstancia, xy, cenario);
				break;
				
			case ROCHAGAN:
				torre = new RochaganTorre(nomeInstancia, xy, cenario);
				break;
				
			default:
				break;
		}
		
		return torre;
	}
	
	public static Imagem getTorreMiniatura(TipoTorre tipoTorre) {
		Imagem imagem = null;
		
		switch(tipoTorre) {
			case MIOCARDIO:
				imagem = MiocardioTorre.getImagemMiniatura();
				break;
				
			case MEDULA:
				imagem = MedulaTorre.getImagemMiniatura();
				break;
				
			case TIMO:
				imagem = TimoTorre.getImagemMiniatura();
				break;
	
			case LEUCOGEN:
				imagem = LeucogenTorre.getImagemMiniatura();
				break;
				
			case ROCHAGAN:
				imagem = RochaganTorre.getImagemMiniatura();
				break;
				
			default:
				break;
		}
		
		return imagem;
	}
}
