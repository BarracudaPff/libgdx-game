package com.mygdx.game.units;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.AppConstants;

public class Player implements Creatable {
    private static final float WIDTH = 10f;
    private static final float HEIGHT = 20f;

    private Sprite sprite;
    private Body body;

    public Player() {
        sprite = new Sprite(new Texture("border.jpg"));
    }

    public void move(Vector2 vector2) {
        body.applyForceToCenter(vector2, false);
    }

    @Override
    public void create(World world) {
        body = BodyFactory.getInstance(world).makeBoxPolyBody(AppConstants.Material.RUBBER, BodyDef.BodyType.DynamicBody, true, 10, 10, 2, 2);
    }
}
