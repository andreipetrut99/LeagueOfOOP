package com.oop_upb.main;

import com.oop_upb.heroes.Hero;
import com.oop_upb.heroes.HeroFactory;
import com.oop_upb.heroes.Pyromancer;
import com.oop_upb.players.HeroInfo;

import java.util.LinkedList;
import java.util.List;

public class GameLogic {
    int length = 0;
    int width = 0;
    int rounds = 0;
    int playersNumber = 0;
    String[] terrainType = new String[0];
    List<HeroInfo> herosInfo = new LinkedList<HeroInfo>();
    List<Hero> heros = new LinkedList<Hero>();
    List<String> moves = new LinkedList<String>();

    public GameLogic(GameInput gameInput) {
        length = gameInput.getLength();
        width = gameInput.getWidth();
        rounds = gameInput.getRounds();
        playersNumber = gameInput.getPlayersNumber();
        terrainType = gameInput.getTerrainType();
        herosInfo = gameInput.getPlayers();
        moves = gameInput.getMoves();
    }

    public void startGame() {
        this.createHeros();
        for (int round = 0; round < rounds; round++) {
            moveHeros(moves.get(0));
            moves.remove(0);
            addOvertimeDamage();

            // Fight

            for (int i = 0; i < playersNumber - 1; i++) {
                for (int j = i + 1; j < playersNumber; j++) {
                    if (heros.get(i).isAlive() && heros.get(j).isAlive()) {
                        if (heros.get(i).getX() == heros.get(j).getX()
                                && heros.get(i).getY() == heros.get(j).getY()) {
                            // se ataca intre ei
                            heros.get(i).attack(heros.get(j));
                            heros.get(j).attack(heros.get(i));
                        }
                    }
                }
            }

            System.out.println(heros.get(0).getHp());
            System.out.println(heros.get(1).getHp());
        }
    }

    public void addOvertimeDamage() {
        for (Hero hero : heros) {
            hero.addOvertimeDamage();
        }
    }

    public void moveHeros(String move) {
        int heroIndex = -1;
        // Move every player by the rules of string move
        for (Hero hero : heros) {
            heroIndex++;
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

    public void createHeros() {
        HeroFactory heroFactory = HeroFactory.getInstance();
        for (HeroInfo heroInfo : herosInfo) {
            heros.add(heroFactory.createHero(
                    heroInfo.getType(),
                    heroInfo.getRow(),
                    heroInfo.getColumn()));
        }
    }

}
