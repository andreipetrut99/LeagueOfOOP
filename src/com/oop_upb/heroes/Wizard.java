package com.oop_upb.heroes;

public class Wizard extends Hero {
    public Wizard(int x, int y, String landType) {
        super(x, y, landType);
    }

    @Override
    public int getHp() {
        return 0;
    }

    @Override
    public void setHp(int hp) {

    }

    @Override
    public void attack(Hero hero) {

    }

}
