package com.oop_upb.main;

import com.oop_upb.players.HeroInfo;
import java.util.List;

public final class GameInput {
    int mLength;
    int mWidth;
    int mRounds;
    int mPlayersNumber;
    String[] mTerrainType;
    List<HeroInfo> mPlayers;
    List<String> mMoves;

    public GameInput() {
        int mLength = -1;
        int mWidth = -1;
        int mRounds = -1;
        int mPlayersNumber = -1;
        String[] mTerrainType = null;
        List<HeroInfo> mPlayers = null;
        List<String> mMoves = null;
    }

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

    public final int getLength() {
        return mLength;
    }

    public final List<String> getMoves() {
        return mMoves;
    }

    public final List<HeroInfo> getPlayers() {
        return mPlayers;
    }

    public final String[] getTerrainType() {
        return mTerrainType;
    }

    public final int getPlayersNumber() {
        return mPlayersNumber;
    }

    public final int getRounds() {
        return mRounds;
    }

    public final int getWidth() {
        return mWidth;
    }

    public final boolean isValidInput() {
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
