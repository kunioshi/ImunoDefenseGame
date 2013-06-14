package br.envyGames.imunoDefense.motor;

import s3t.gameEntities.IAMessage;

public class IAMensagem extends IAMessage {

	public IAMensagem(Entidade sender, Entidade toPlayer, String message, int ms) {
		super(sender, toPlayer, message, ms);
	}

}
