package main;

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
    private String[] terrainType = new String[0];
    private List<HeroInfo> heroesInfo = new LinkedList<HeroInfo>();
    private List<Hero> heroes = new LinkedList<Hero>();
    private List<String> moves = new LinkedList<String>();
    private int level;

    public GameLogic(final GameInput gameInput) {
        length = gameInput.getLength();
        width = gameInput.getWidth();
        rounds = gameInput.getRounds();
        playersNumber = gameInput.getPlayersNumber();
        terrainType = gameInput.getTerrainType();
        heroesInfo = gameInput.getPlayers();
        moves = gameInput.getMoves();
    }

    /**
     * Starting the game.
     */
    public void startGame() {
        this.createHeroes();
        for (int round = 0; round < rounds; round++) {
            moveHeroes(moves.get(0));
            moves.remove(0);
            addOvertimeDamage();
            decreaseIncapacitation();

            // Fight
            for (int i = 0; i < playersNumber - 1; i++) {
                for (int j = i + 1; j < playersNumber; j++) {
                    if (heroes.get(i).isAlive() && heroes.get(j).isAlive()) {
                        if (heroes.get(i).getX() == heroes.get(j).getX()
                                && heroes.get(i).getY() == heroes.get(j).getY()) {
                            // se ataca intre ei
                            heroes.get(i).attack(heroes.get(j),
                                    terrainType[heroes.get(i).getX()].charAt(heroes.get(i).getY()));
                            heroes.get(j).attack(heroes.get(i),
                                    terrainType[heroes.get(i).getX()].charAt(heroes.get(i).getY()));
                            level = heroes.get(j).getLevel();
                            if (!heroes.get(i).isAlive()) {
                                heroes.get(j).addXp(calcXp(heroes.get(i).getLevel(),
                                        heroes.get(j).getLevel()));
                            }
                            if (!heroes.get(j).isAlive()) {
                                heroes.get(i).addXp(calcXp(level, heroes.get(i).getLevel()));
                            }
                        }
                    }
                }
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
    public void createHeroes() {
        HeroFactory heroFactory = HeroFactory.getInstance();
        for (HeroInfo heroInfo : heroesInfo) {
            heroes.add(heroFactory.createHero(
                    heroInfo.getType(),
                    heroInfo.getRow(),
                    heroInfo.getColumn()));
        }
    }

}
