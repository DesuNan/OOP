package GameLayer;

import GameEngine.*;

public interface ISceneFactory {
    Scene createScene(String type, SceneManager sm);
}
