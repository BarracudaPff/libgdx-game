package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.AppConstants;
import com.mygdx.game.MyGdxGame;

public class LoadingScreen extends BasicScreen {

    public LoadingScreen(final MyGdxGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.changeScreen(AppConstants.MENU);
            }
        }, 1f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}

