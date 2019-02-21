package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.WorldModel;
import com.mygdx.game.MyGdxGame;

public class GameScreen extends BasicScreen {
    private final WorldModel model;
    private final OrthographicCamera cam;
    private final Box2DDebugRenderer debugRenderer;
    private Stage stage;

    public GameScreen(MyGdxGame game) {
        super(game);

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        model = new WorldModel();
        cam  =new OrthographicCamera(Gdx.graphics.getWidth()/20,Gdx.graphics.getHeight()/20);
        cam.setToOrtho(false);
        debugRenderer = new Box2DDebugRenderer(true,true,true,true,true,true);
    }

    @Override
    public void render(float delta) {
        model.render(delta);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        debugRenderer.render(model.world, cam.combined);
    }

    @Override
    public void resize(int width, int height) {
        cam.setToOrtho(false,Gdx.graphics.getWidth()/20,Gdx.graphics.getHeight()/20);
    }
}
