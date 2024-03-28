package Scene;

import com.mygdx.game.*;

import InputOutput.InputOutputManager;

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