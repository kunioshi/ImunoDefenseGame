import s3t.gameEntities.AIAction;
import s3t.gameEntities.Entity;
import s3t.gameEntities.IAMessage;


public class ControleCompraTorre extends AIAction {
	@Override
	public void doAction(Entity entity) {
		entity.setX(MouseHandler.mousePos.x);
		entity.setY(MouseHandler.mousePos.y);
	}

	@Override
	public void receiveMessage(IAMessage arg0) {}
}
