import java.awt.Rectangle;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;
import s3t.gameEntities.Entity;
import s3t.graphicsElements.ImageCollection;
import s3t.graphicsElements.SimpleImage;


public class Inimigo extends Entity {
	public Inimigo(String id, double x, double y) throws IOException {
		super(id, x, y, GameSystem.getScenarioCollection().getScenarioAtual());
		
        ImageCollection imgCollection = new ImageCollection();
        
        SimpleImage img = new SimpleImage("/imagens/inimigo.png");
        img.addAttackRect(new Rectangle(0, 0, 32, 32));
        imgCollection.add("inimigo", img);
        imgCollection.setDefaultKey("inimigo");
        
        setImageCollection(imgCollection);
        setDoNotStop(true);

    	GameSystem.setAIforEntity(this, new ControleInimigo());
	}
}
