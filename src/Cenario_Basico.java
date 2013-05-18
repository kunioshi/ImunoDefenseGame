import java.awt.Color;
import java.io.IOException;

import s3t.gameEntities.Scenario;
import s3t.gameEntities.ScenarioItem;
import s3t.gameEntities.ScenarioLayer;
import s3t.gameEntities.eScenarioBehavior;
import s3t.graphicsElements.SimpleImage;


public class Cenario_Basico extends Scenario {

	public Cenario_Basico() throws IOException {
	    super("cena1", "Cenario_Basico", (int) Global.screen.getWidth(), (int) Global.screen.getHeight() );
	    
	    setBackgroundColor(Color.black);
	    
	    ScenarioLayer background = new ScenarioLayer("back", eScenarioBehavior.PASS);
	    
	    SimpleImage img = new SimpleImage("/imagens/grama.jpg");
	    for (int i = 0; i < Global.screen.getWidth(); i += 32)
	    	for (int j = 0; j < Global.screen.getHeight(); j += 32) {
	    		ScenarioItem item = new ScenarioItem("grama" + i + "_" + j, img, i, j);
	    		background.addScenarioItem(item);
	    	}
	    		
	    
	    addScenarioLayer(background);
	}
	
}
