import s3t.gameEntities.AIAction;
import s3t.gameEntities.Entity;
import s3t.gameEntities.IAMessage;


public class ControleInimigo extends AIAction {

	@Override
	public void doAction(Entity entity) {
		double velX;
		double velY;
		
		double ang;
		
		
		//velX = Math.sin(ang)*2;
		//velY = Math.cos(ang)*2;
		
		//entity.doMove(velX, velY);
	}

	@Override
	public void receiveMessage(IAMessage arg0) {}
}
