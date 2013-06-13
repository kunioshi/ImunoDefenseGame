package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import s3t.graphicsElements.ImageCollection;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.JogoMotor;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class Coracao extends FormaDeVida {

	Imagem coracao = ResourceManager.getImagem("/imagens/entidades/CoracaoVivo.png");
	private JogoMotor motor;
	
	public Coracao(Cenario cenario) {
		super("Coracao", new Point(Tabuleiro.getTabuleiroAtual().getWidth(), 0), cenario);
		
		vida = 20;
		
        ImageCollection imgCollection = new ImageCollection();
        imgCollection.add("default", coracao);
        imgCollection.setDefaultKey("default");
        
        setImageCollection(imgCollection);
        setDoNotStop(true);
	}

	@Override
	public void morrer() {
		motor.loadCenario("GameOverCenario");
		motor.getEntidadeGerenciador().clear();
		
	}
}
