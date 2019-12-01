package main;

import fileio.FileSystem;
import heroes.Hero;
import info.HeroInfo;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
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

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameInput(length, width, rounds,
                playersNumber, players,
                terrainType, moves);
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

}
