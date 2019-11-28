package main;

import heroes.Hero;
import heroes.HeroFactory;
import Info.HeroInfo;

import java.util.LinkedList;
import java.util.List;

public class GameLogic {
    int length = 0;
    int width = 0;
    int rounds = 0;
    int playersNumber = 0;
    String[] terrainType = new String[0];
    List<HeroInfo> heroesInfo = new LinkedList<HeroInfo>();
    List<Hero> heroes = new LinkedList<Hero>();
    List<String> moves = new LinkedList<String>();
    int level;

    public GameLogic(GameInput gameInput) {
        length = gameInput.getLength();
        width = gameInput.getWidth();
        rounds = gameInput.getRounds();
        playersNumber = gameInput.getPlayersNumber();
        terrainType = gameInput.getTerrainType();
        heroesInfo = gameInput.getPlayers();
        moves = gameInput.getMoves();
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void startGame() {
        this.createHeroes();
        for (int round = 0; round < rounds; round++) {
            System.out.println("Round: " + round);

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

                            heroes.get(i).attack(heroes.get(j), terrainType[heroes.get(i).getX()].charAt(heroes.get(i).getY()));
                            heroes.get(j).attack(heroes.get(i), terrainType[heroes.get(i).getX()].charAt(heroes.get(i).getY()));
                            level = heroes.get(j).getLevel();
                            if (!heroes.get(i).isAlive()) {
                                heroes.get(j).addXp(calcXp(heroes.get(i).getLevel(), heroes.get(j).getLevel()));
                            }
                            if (!heroes.get(j).isAlive()) {
                                heroes.get(i).addXp(calcXp(level, heroes.get(i).getLevel()));
                            }
                        }
                    }
                }
            }
            for (Hero hero : heroes) {
               /* if (!hero.isAlive()) {
                    System.out.println(hero.getHeroType() + " " + "dead");
                } else */{
                    System.out.println(hero.getHeroType() + " "
                            + hero.getLevel() + " "
                            + hero.getXp() + " "
                            + hero.getHp() + " "
                            + hero.getX() + " "
                            + hero.getY());

                }
            }
            System.out.println("-----------END ROUND--------");
        }
    }

    private void addOvertimeDamage() {
        for (Hero hero : heroes) {
            hero.addOvertimeDamage();
        }
    }

    public void decreaseIncapacitation() {
        for (Hero hero : heroes) {
            hero.loopIncapactiation();
        }
    }

    private int calcXp(int levelLooser, int levelWinner) {
        return Math.max((200 - (levelWinner - levelLooser) * 40), 0);
    }

    private void moveHeroes(String move) {
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
