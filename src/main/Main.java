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
        GameInputLoader gameInputLoader = GameInputLoader.getInstance(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        GameLogic gameLogic = new GameLogic(gameInput);
        gameLogic.startGame();

        List<Hero> heroes;
        heroes = gameLogic.getHeroes();

        // print final results
        for (Hero hero : heroes) {
            if (!hero.isAlive()) {
                gameInputLoader.printLine(hero.getHeroType() + " " + "dead");
            } else {
                gameInputLoader.printLine(hero.getHeroType() + " "
                        + hero.getLevel() + " "
                        + hero.getXp() + " "
                        + hero.getHp() + " "
                        + hero.getX() + " "
                        + hero.getY());
            }
        }
    }
}
