package com.mygdx.game.mvc;

public class GameController implements Controller {
    private GameModel model;

    public GameController(GameModel model) {
        this.model = model;
    }
}
