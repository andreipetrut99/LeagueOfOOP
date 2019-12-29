package main;

import fileio.FileSystem;
import heroes.Hero;
import info.HeroInfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;
    private static GameInputLoader instance = null;

    private GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public static GameInputLoader getInstance(final String inputPath, final String outputPath) {
        if (instance == null) {
            instance = new GameInputLoader(inputPath, outputPath);
            return instance;
        }
        return instance;
    }

    public static GameInputLoader getInstance() {
        return instance;
    }

    /**
     * Load Game Input.
     * @return GameInput
     */
    public GameInput load() {
        int length = 0;
        int width = 0;
        int rounds = 0;
        int playersNumber = 0;
        String[] terrainType = new String[0];
        List<HeroInfo> players = new LinkedList<HeroInfo>();
        List<String> moves = new LinkedList<String>();
        List<Integer> angelsPerRound = new LinkedList<Integer>();
        List<List<String>> angels = new LinkedList<List<String>>();

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            width = fs.nextInt();
            length = fs.nextInt();
            terrainType = new String[width];
            for (int i = 0; i < width; i++) {
                terrainType[i] = fs.nextWord();
            }

            playersNumber = fs.nextInt();

            for (int i = 0; i < playersNumber; i++) {
                players.add(new HeroInfo(fs.nextWord(),
                        fs.nextInt(), fs.nextInt()));
            }

            rounds = fs.nextInt();

            for (int i = 0; i < rounds; i++) {
                moves.add(fs.nextWord());
            }

            for (int i = 0; i < rounds; i++) {
                angelsPerRound.add(fs.nextInt());
                if (angelsPerRound.get(i) != 0) {
                    List<String> aux = new LinkedList<String>();
                    for (int j = 0; j < angelsPerRound.get(i); j++) {
                        aux.add(fs.nextWord());
                    }
                    angels.add(aux);
                } else {
                    angels.add(null);
                }
            }
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameInput(length, width, rounds,
                playersNumber, players,
                terrainType, moves, angelsPerRound, angels);
    }

    /**
     * print the required output.
     * @param heroes
     */
    public void print(final List<Hero> heroes) {
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            for (Hero hero : heroes) {
                if (!hero.isAlive()) {
                    fs.writeWord(hero.getHeroType() + " " + "dead");
                    fs.writeNewLine();
                } else {
                    fs.writeWord(hero.getHeroType() + " "
                            + hero.getLevel() + " "
                            + hero.getXp() + " "
                            + hero.getHp() + " "
                            + hero.getX() + " "
                            + hero.getY());
                    fs.writeNewLine();
                }
            }
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printLine(final String s) {
        File log = new File(mOutputPath);

        try {
            if (!log.exists()) {
                log.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(log, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(s + "\n");
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("COULD NOT LOG!!");
        }
    }

}
