package main;

import admin.TheGreatWizard;
import angels.Angel;
import angels.AngelFactory;
import heroes.Hero;
import heroes.HeroFactory;
import info.HeroInfo;

import java.util.LinkedList;
import java.util.List;

import static commons.Constants.XP_BONUS_PER_LEVEL;
import static commons.Constants.XP_CONSTANT;

public class GameLogic {
    private int length = 0;
    private int width = 0;
    private int rounds = 0;
    private int playersNumber = 0;
    private String[] terrainType;
    private List<HeroInfo> heroesInfo;
    private List<Hero> heroes = new LinkedList<Hero>();
    private List<String> moves;
    private int level;
    private List<Integer> angelsNumber;
    private List<List<String>> inputAngels;
    private List<Angel> currentAngels;
    private GameInputLoader outputFile = GameInputLoader.getInstance();

    public GameLogic(final GameInput gameInput) {
        length = gameInput.getLength();
        width = gameInput.getWidth();
        rounds = gameInput.getRounds();
        playersNumber = gameInput.getPlayersNumber();
        terrainType = gameInput.getTerrainType();
        heroesInfo = gameInput.getPlayers();
        moves = gameInput.getMoves();
        angelsNumber = gameInput.getAngelsNumber();
        inputAngels = gameInput.getAngels();
    }

    /**
     * Starting the game.
     */
    public void startGame() {
        TheGreatWizard observer = TheGreatWizard.getInstance();
        AngelFactory angelFactory = AngelFactory.getInstance();
        this.createHeroes();
        outputFile.printLine("~~ Round 1 ~~");
        for (int round = 0; round < rounds; round++) {
            moveHeroes(moves.get(0));
            moves.remove(0);
            addOvertimeDamage();
            playStrategies();
            decreaseIncapacitation();

            Hero hero1, hero2;
            // Fight
            for (int i = 0; i < playersNumber - 1; i++) {
                hero1 = heroes.get(i);
                for (int j = i + 1; j < playersNumber; j++) {
                    hero2 = heroes.get(j);
                    if (hero1.isAlive() && hero2.isAlive()) {
                        if (hero1.getX() == hero2.getX()
                                && hero1.getY() == hero2.getY()) {
                            // se ataca intre ei
                            hero1.attack(hero2,
                                    terrainType[hero1.getX()].charAt(hero1.getY()));
                            hero2.attack(hero1,
                                    terrainType[hero1.getX()].charAt(hero2.getY()));
                            level = hero2.getLevel();

                            if (!hero2.isAlive()) {
                                observer.notifyDeath(hero1, hero2);
                            }

                            if (!hero1.isAlive()) {
                                observer.notifyDeath(hero2, hero1);
                            }

                            if (!hero1.isAlive() && hero2.isAlive()) {
                                hero2.addXp(calcXp(hero1.getLevel(),
                                        hero2.getLevel()));
                            }

                            if (!hero2.isAlive() && hero1.isAlive()) {
                                hero1.addXp(calcXp(level, hero1.getLevel()));
                            }
                        }
                    }
                }
            }

            if (angelsNumber.get(round) != 0) {
                angelFactory.createAngels(inputAngels.get(round), heroes);
            } else {
                currentAngels = null;
            }

            outputFile.printLine("");
            if (round < rounds - 1) {
                outputFile.printLine("~~ Round " + (round + 2) + " ~~");
            }
        }
        outputFile.printLine("~~ Results ~~");
    }

    private void playStrategies() {
        for (Hero hero : heroes) {
            if (!hero.isIncapacitated() && hero.isAlive()) {
                hero.applyStrategy();
            }
        }
    }

    /**
     * Add overtime damage of each player.
     */
    private void addOvertimeDamage() {
        for (Hero hero : heroes) {
            hero.addOvertimeDamage();
        }
    }

    /**
     * Getter for a list of heroes.
     * @return a list of heroes
     */
    public List<Hero> getHeroes() {
        return heroes;
    }

    /**
     * Loop and decrease incapacitation rounds.
     */
    public void decreaseIncapacitation() {
        for (Hero hero : heroes) {
            hero.loopIncapacitation();
        }
    }

    /**
     * If a player kills another one he gets experience points.
     * @param levelLooser
     * @param levelWinner
     * @return xp for this battle.
     */
    private int calcXp(final int levelLooser, final int levelWinner) {
        return Math.max((XP_CONSTANT - (levelWinner - levelLooser) * XP_BONUS_PER_LEVEL), 0);
    }

    /**
     * After each round, the players move with this method.
     * @param move
     */
    private void moveHeroes(final String move) {
        int heroIndex = -1;
        // Move every player by the rules of string move
        for (Hero hero : heroes) {
            heroIndex++;
            if (!hero.isIncapacitated()) {
                switch (String.valueOf(move.charAt(heroIndex))) {
                    case "U":
                        hero.setX(hero.getX() - 1);
                        break;
                    case "D":
                        hero.setX(hero.getX() + 1);
                        break;
                    case "L":
                        hero.setY(hero.getY() - 1);
                        break;
                    case "R":
                        hero.setY(hero.getY() + 1);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * Create the heroes using their type and initial coordinates.
     */
    private void createHeroes() {
        HeroFactory heroFactory = HeroFactory.getInstance();
        int k = 0;
        for (HeroInfo heroInfo : heroesInfo) {
            heroes.add(heroFactory.createHero(
                    heroInfo.getType(),
                    heroInfo.getRow(),
                    heroInfo.getColumn()));
            heroes.get(k).setId(k);
            k++;
        }
    }

}
