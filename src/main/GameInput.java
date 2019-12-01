package main;

import info.HeroInfo;

import java.util.List;

public final class GameInput {
    private int mLength;
    private int mWidth;
    private int mRounds;
    private int mPlayersNumber;
    private String[] mTerrainType;
    private List<HeroInfo> mPlayers;
    private List<String> mMoves;

    public GameInput(final int length,
                     final int width,
                     final int rounds,
                     final int playersNumber,
                     final List<HeroInfo> players,
                     final String[] terrainType,
                     final List<String> moves) {
        mLength = length;
        mWidth = width;
        mRounds = rounds;
        mPlayersNumber = playersNumber;
        mPlayers = players;
        mTerrainType = terrainType;
        mMoves = moves;
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

    public boolean isValidInput() {
        boolean membersInstantiated = mPlayers != null
                && mTerrainType != null
                && mMoves != null;
        boolean membersNotEmpty = mLength > 0
                && mPlayersNumber > 0
                && mRounds > 0
                && mWidth > 0;

        return membersInstantiated && membersNotEmpty;
    }
}
