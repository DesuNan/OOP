package Scene;

public interface ISceneFactory {
    Scene createScene(String type, SceneManager sm);
}
