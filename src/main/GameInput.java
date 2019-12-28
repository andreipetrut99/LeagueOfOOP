package main;

import info.HeroInfo;

import java.util.List;

public final class GameInput {
    private int mLength;
    private int mWidth;
    private int mRounds;
    private int mPlayersNumber;
    private List<Integer> mAngelsNumber;
    private String[] mTerrainType;
    private List<HeroInfo> mPlayers;
    private List<String> mMoves;
    private List<List<String>> angels;

    public GameInput(final int length,
                     final int width,
                     final int rounds,
                     final int playersNumber,
                     final List<HeroInfo> players,
                     final String[] terrainType,
                     final List<String> moves,
                     final List<Integer> angelsNumber,
                     final List<List<String>> angels) {
        mLength = length;
        mWidth = width;
        mRounds = rounds;
        mPlayersNumber = playersNumber;
        mPlayers = players;
        mTerrainType = terrainType;
        mMoves = moves;
        mAngelsNumber = angelsNumber;
        this.angels = angels;
    }

    public int getLength() {
        return mLength;
    }

    public List<String> getMoves() {
        return mMoves;
    }

    public List<HeroInfo> getPlayers() {
        return mPlayers;
    }

    public String[] getTerrainType() {
        return mTerrainType;
    }

    public int getPlayersNumber() {
        return mPlayersNumber;
    }

    public int getRounds() {
        return mRounds;
    }

    public int getWidth() {
        return mWidth;
    }

    public List<Integer> getAngelsNumber() {
        return mAngelsNumber;
    }

    public List<List<String>> getAngels() {
        return angels;
    }

    public boolean isValidInput() {
        boolean membersInstantiated = mPlayers != null
                && mTerrainType != null
                && mMoves != null
                && angels != null
                && mAngelsNumber != null;
        boolean membersNotEmpty = mLength > 0
                && mPlayersNumber > 0
                && mRounds > 0
                && mWidth > 0;

        return membersInstantiated && membersNotEmpty;
    }
}
