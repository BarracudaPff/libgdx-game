package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.controllers.KeyboardController;
import com.mygdx.game.units.BodyFactory;
import com.mygdx.game.units.Player;
import com.mygdx.game.units.Wall;

public class WorldModel {
    private final KeyboardController controller;
    private Player player;

    public final World world;

    public WorldModel(KeyboardController controller) {
        world = new World(new Vector2(0, -9.8f), true);
        this.controller = controller;
        createWalls();
        for (int i = 0; i < 2; i++) {
            createMovingObject(new RandomXS128().nextInt(21) + 1, new RandomXS128().nextInt(21) + 1, i, -1.75f);
        }
        player = new Player();
        player.create(world);
        //createMovingObject(15, 15, 1f, -1.75f);
        //createMovingObject(15, 15, 1f, -0.75f);
    }

    public void render(float delta) {
        if (controller.isUp()) {
            player.move(new Vector2(0, 100));
        } else if (controller.isRight()) {
            player.move(new Vector2(100, 0));
        } else if (controller.isDown()) {
            player.move(new Vector2(0, -100));
        } else if (controller.isLeft()) {
            player.move(new Vector2(-100, 0));
        }
        world.step(delta, 3, 3);
    }

    private void createWalls() {
        new Wall(AppConstants.Direction.UP, Gdx.graphics.getHeight() / 20, new Vector2(0.5f, 0.5f)).create(world);
        new Wall(AppConstants.Direction.UP, Gdx.graphics.getHeight() / 20, new Vector2(Gdx.graphics.getWidth() / 20 - 0.5f, 0.5f)).create(world);
        new Wall(AppConstants.Direction.RIGHT, Gdx.graphics.getWidth() / 20, new Vector2(0.5f, 0.5f)).create(world);
        new Wall(AppConstants.Direction.LEFT, Gdx.graphics.getWidth() / 20, new Vector2(Gdx.graphics.getWidth() / 20 - 0.5f, Gdx.graphics.getHeight() / 20 - 0.5f)).create(world);
    }

    private void createMovingObject(float x, float y, float xSpeed, float ySpeed) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);

        Body bodyk = world.createBody(bodyDef);

        CircleShape shape = new CircleShape();
        shape.setRadius(0.5f);

        bodyk.createFixture(BodyFactory.getInstance(world).makeFixture(AppConstants.Material.RUBBER, shape));
        bodyk.setLinearVelocity(xSpeed, -ySpeed);

        shape.dispose();
    }
}
