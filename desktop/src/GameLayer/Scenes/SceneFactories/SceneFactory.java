package GameLayer.Scenes.SceneFactories;

import GameEngine.GameLifecycle.GameLifeCycle;
import GameEngine.InputOutput.InputOutputManager;
import GameEngine.Scene.Scene;
import GameEngine.Scene.SceneManager;
import GameEngine.Scene.SceneType;
import GameLayer.Scenes.EndScene;
import GameLayer.Scenes.PauseScene;
import GameLayer.Scenes.PlayScene;
import GameLayer.Scenes.StartScene;

public class SceneFactory {

    public static Scene createScene(SceneType type, InputOutputManager ioman, GameLifeCycle gm, SceneManager sceneManager) {
        switch (type) {
            case START_SCENE:
                return new StartScene(ioman, gm, sceneManager);
            case PLAY_SCENE:
                return new PlayScene(ioman, gm, sceneManager);
            case PAUSE_SCENE:
                return new PauseScene(ioman, gm, sceneManager);
            case END_SCENE:
                return new EndScene(ioman, gm, sceneManager);
            // Add cases for other scenes
            default:
                return null;
        }
    }
}