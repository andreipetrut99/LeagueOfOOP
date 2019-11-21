package com.oop_upb.main;

/**
 * @author Andrei-Petrut Tita
 */

public final class Main {
    private Main() {
        //just to trick checkstyle
    }
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        //Interactiune prin Factory, efecte prin double dispatch;
        GameLogic gameLogic = new GameLogic(gameInput);
        gameLogic.startGame();
    }
}
