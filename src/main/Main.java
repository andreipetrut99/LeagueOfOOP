package main;

import heroes.Hero;

import java.util.List;

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

        GameLogic gameLogic = new GameLogic(gameInput);
        gameLogic.startGame();

        List<Hero> heroes;
        heroes = gameLogic.getHeroes();
        gameInputLoader.print(heroes);
    }
}
