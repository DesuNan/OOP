package GameLayer.Scenes.SceneFactories;

import GameEngine.Scene.Scene;
import GameEngine.Scene.SceneManager;

public interface ISceneFactory {
    Scene createScene(String type, SceneManager sm);
}
