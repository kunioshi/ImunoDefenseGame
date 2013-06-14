package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemColecao;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class Coracao extends FormaDeVida {

	private static Imagem coracao = ResourceManager.getImagem("/imagens/entidades/CoracaoVivo.png");
	private static Imagem coracao50porcento = ResourceManager.getImagem("/imagens/entidades/Coracao50porcento.png");
	private static Imagem coracao20porcento = ResourceManager.getImagem("/imagens/entidades/Coracao20porcento.png");
	private ImagemColecao imagemColecao;
	private final int TOTAL_VIDA = 20;
	
	public Coracao(Point xy, Cenario cenario) {
		super("Coracao", xy, cenario);
		
		vida = TOTAL_VIDA;
		
		imagemColecao = new ImagemColecao();
		imagemColecao.add("vivo", coracao);
		imagemColecao.add("50porcento", coracao50porcento);
		imagemColecao.add("20porcento", coracao20porcento);
		imagemColecao.definirImagemPadrao("vivo");
        
        definirImagemColecao(imagemColecao);
        setDoNotStop(true);
	}
	
	@Override
	public void receberDano(int dano) {
		super.receberDano(dano);
		
		if (getVida() <= TOTAL_VIDA * 0.5) {
			
			if (getVida() <= TOTAL_VIDA * 0.2)
				imagemColecao.definirImagemPadrao("50porcento");
			else 
				imagemColecao.definirImagemPadrao("20porcento");
		}
	}
}
