import java.io.IOException;

import s3t.gameControl.system.GameSystem;
import s3t.gameEntities.Entity;
import s3t.gameEntities.Scenario;
import s3t.graphicsElements.ImageCollection;
import s3t.graphicsElements.SimpleImage;


public class Spider extends Entity {

	private static SimpleImage img = null;
	
	public Spider(double x, double y, Scenario scenario) throws IOException {
		super("Spider" + x + "_" + y, x, y, scenario);

        if (img == null)
        	img = new SimpleImage("/imagens/spider.png");
		
        ImageCollection imgCollection = new ImageCollection();
        imgCollection.add("default", img);
        imgCollection.setDefaultKey("default");
        
        setImageCollection(imgCollection);
        setDoNotStop(true);

    	GameSystem.setAIforEntity(this, new ControleInimigo());
	}
}
