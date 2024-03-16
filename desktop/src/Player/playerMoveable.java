package Player;

import InputOutput.InputOutputManager;

public interface playerMoveable {
	public void handleMovement(PlayersManager pm);
	public void handleGravity(PlayersManager pm);
}
