import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import s3t.gameEntities.Scenario;
import s3t.gameEntities.ScenarioItem;
import s3t.gameEntities.ScenarioLayer;
import s3t.gameEntities.eScenarioBehavior;
import s3t.graphicsElements.SimpleImage;


public class Cenario_Basico extends Scenario {

	public int count = 0;
	public Cenario_Basico(Dimension dimension) throws IOException {
	    super("cena1", "Cenario_Basico", (int) dimension.getWidth(), (int) dimension.getHeight() );
	    
	    setBackgroundColor(Color.black);
	    
	    ScenarioLayer background = new ScenarioLayer("back", eScenarioBehavior.PASS);
	    boolean aux = false; 
	    
	    SimpleImage img = new SimpleImage("/imagens/grama.jpg");
	    SimpleImage bgHud = new SimpleImage("/imagens/bgHud.jpg");
	    SimpleImage faixa = new SimpleImage("/imagens/faixa.png");
	    for (int i = 0; i < dimension.getWidth(); i += 32)
	    	for (int j = 0; j < dimension.getHeight(); j += 32) {
	    		ScenarioItem item = new ScenarioItem("grama" + i + "_" + j, img, i, j);
	    		ScenarioItem item2 = new ScenarioItem("grama" + i + "_" + j, bgHud, i, j);

	    		background.addScenarioItem(item);
	    		if (j > 351)
	    		{ 	    	
	    			background.addScenarioItem(item2);
	    			if(!aux && count <= 25 && j < 360)
	    			{
	    				count++;
	    				if (count == 25){ aux = true;}
	    	    		ScenarioItem item4 = new ScenarioItem("grama" + i + "_" + j, faixa, i, j);
		    			background.addScenarioItem(item4);
		    			
	    			}
	    		}
	    	}    		
	    
	    addScenarioLayer(background);
	}
	
}
