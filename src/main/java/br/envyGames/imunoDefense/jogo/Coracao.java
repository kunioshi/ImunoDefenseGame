package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemColecao;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class Coracao extends FormaDeVida {

	private static Imagem coracao = ResourceManager.getImagem("/imagens/entidades/CoracaoVivo.png");
	
	public Coracao(Point xy, Cenario cenario) {
		super("Coracao", xy, cenario);
		
		vida = 20;
		
		ImagemColecao imagemColecao = new ImagemColecao();
		imagemColecao.add("vivo", coracao);
		imagemColecao.definirImagemPadrao("vivo");
        
        definirImagemColecao(imagemColecao);
        setDoNotStop(true);
	}

	@Override
	public void morrer() {
//		motor.loadCenario("GameOverCenario");
//		motor.getEntidadeGerenciador().clear();
		
	}
}
