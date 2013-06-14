package br.envyGames.imunoDefense.jogo.ia;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.IAAcao;
import br.envyGames.imunoDefense.motor.IAMensagem;

public class MedulaIA extends IAAcao {

	@Override
	public void doAction(Entidade entidade) {
		System.out.println(entidade.getName());
	}

	@Override
	public void receiveMessage(IAMensagem mensagem) {
		// TODO Auto-generated method stub
		
	}

}
