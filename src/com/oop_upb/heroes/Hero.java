package com.oop_upb.heroes;

public abstract class Hero {
    private int x, y;
    private int xp = 0;
    private int level = 0;
    private int xpLevelUp;
    private int hp;
    private boolean isAlive = true;
    private String landType;
    private int overtimeDamage;
    private int affectedRounds;
    private boolean overtimeAffected = false;


    public Hero(final int x, final int y, final String landType) {
        this.x = x;
        this.y = y;
        this.landType = landType;
    }

    public void setInstantDamage(int damage) {
        hp -= damage;
    }

    public void setOvertimeDamage(final int damage, final int rounds) {
        this.affectedRounds = rounds;
        this.overtimeDamage = damage;
        this.overtimeAffected = true;
    }

    public void addOvertimeDamage() {
        if (overtimeAffected) {
            this.setHp(this.getHp() - overtimeDamage);
            affectedRounds--;
            if (affectedRounds == 0) {
                overtimeAffected = false;
            }
        }
    }

    public int getLevel() {
        return level;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public String getLandType() {
        return landType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void checkLevel() {
        if (xp >= xpLevelUp) {
            level += 1;
            xp -= xpLevelUp;
            xpLevelUp = 250 + (level * 50);
        }
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public abstract int getHp();
    public abstract void setHp(int hp);
    public abstract void attack(Hero hero);
}
