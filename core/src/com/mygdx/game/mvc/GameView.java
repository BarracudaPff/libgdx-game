package com.mygdx.game.mvc;

public class GameView implements View {
    private GameController controller;
    private GameModel model;

    public GameView(GameModel model, GameController controller) {
        this.controller = controller;
        this.model = model;
    }
}
