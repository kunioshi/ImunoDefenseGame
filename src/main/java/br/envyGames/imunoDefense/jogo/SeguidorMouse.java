package br.envyGames.imunoDefense.jogo;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemColecao;

public class SeguidorMouse extends Entidade {

	public SeguidorMouse(double x, double y, Imagem imagem, Cenario cenario) {
		super("SeguidorMouse", x, y, cenario);
        
        ImagemColecao imagemColecao = new ImagemColecao();
		imagemColecao.add("default", imagem);
		imagemColecao.definirImagemPadrao("default");
		
		definirImagemColecao(imagemColecao);
        setDoNotStop(true);
	}

}
