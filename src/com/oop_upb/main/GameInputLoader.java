package com.oop_upb.main;

import com.oop_upb.players.HeroInfo;
import fileio.FileSystem;

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
}
