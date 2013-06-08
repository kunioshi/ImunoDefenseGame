package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import br.envyGames.imunoDefense.motor.Cenario;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;
import s3t.graphicsElements.ImageCollection;
import s3t.graphicsElements.SimpleImage;

public class InimigoGripe extends Inimigo {
	public InimigoGripe(String name, Point xy, Cenario cenario) throws IOException {
		super(name, xy, cenario);
		
		ImageCollection imgCollection = new ImageCollection();
		
		imgCollection.add("default", loadAnimation("/imagens/bolinha", ".png", 2, 20, AnimImage.GO_AND_BACK));
		
		setImageCollection(imgCollection);
        setDoNotStop(true);
		
		GameSystem.setAIforEntity(this, new AIGripe());
	}
	
	private static AnimImage loadAnimation(String firstName, String extension, int endNumber, int period, int behavior) throws IOException {
        AnimImage animImage = new AnimImage();

        for (int i = 0; i <= endNumber; i++) {
            SimpleImage img = new SimpleImage(firstName + i + extension);
            img.setCollisionRectangle(new Rectangle(0, 10, 35, 40));
            animImage.addImage(img);
        }
        
        animImage.setPeriod(period);
        animImage.setBehavior(behavior);
        return animImage;
    }
}
