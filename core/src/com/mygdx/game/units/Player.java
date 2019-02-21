package com.mygdx.game.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private static final float WIDTH = 10f;
    private static final float HEIGHT = 20f;

    private Sprite sprite;
    private Rectangle borders;
    private float speed;

    public Player() {
        sprite = new Sprite(new Texture("border.jpg"));
        speed = 0;
        borders = new Rectangle(0, 0, WIDTH, HEIGHT);
        sprite.setBounds(borders.x, borders.y, borders.width, borders.height);
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
        handleInput();
    }

    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            borders.y -= 3f;
            sprite.setPosition(borders.x, borders.y);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            borders.y += 3f;
            sprite.setPosition(borders.x, borders.y);
        }
    }
}
