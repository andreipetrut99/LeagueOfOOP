package com.oop_upb.heroes;

public class HeroFactory {
    private static HeroFactory instance = null;
    private HeroFactory() {
    }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    public Hero createHero(final String type, final int x, final int y) {
        switch (type) {
            case "P": return new Pyromancer(x,y, type);
            case "K": return new Knight(x, y, type);
            case "R": return new Rogue(x, y, type);
            case "W": return new Wizard(x, y, type);
            default: return null;
        }
    }
}
