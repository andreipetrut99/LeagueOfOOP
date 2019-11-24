package heroes;

public abstract class Hero {
    private int x, y;
    private int xp = 0;
    private int level = 0;
    private int xpLevelUp;
    private int hp;
    private boolean isAlive = true;
    private String landType;
    private String heroType;
    private int overtimeDamage;
    private boolean incapacitated = false;
    private int incapacitatedRounds;
    private int affectedRounds;
    private boolean overtimeAffected = false;


    public Hero(final int x, final int y, final String heroType) {
        this.x = x;
        this.y = y;
        this.heroType = heroType;
    }

    public void setInstantDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            this.isAlive = false;
        }
    }

    public void setOvertimeDamage(final int damage, final int rounds) {
        this.affectedRounds = rounds;
        this.overtimeDamage = damage;
        this.overtimeAffected = true;
    }

    public void addOvertimeDamage() {
        if (overtimeAffected) {
            setInstantDamage(overtimeDamage);
            affectedRounds--;
            if (affectedRounds == 0) {
                overtimeAffected = false;
            }
        }
        if (hp <= 0) {
            this.isAlive = false;
        }
    }

    public void setIncapacitation(int incapacitatedRounds) {
        this.incapacitatedRounds = incapacitatedRounds;
        this.incapacitated = true;
    }

    public void loopIncapactiation() {
        if (this.incapacitated) {
            incapacitatedRounds -= 1;
        }
        if (incapacitatedRounds == 0) {
            incapacitated = false;
        }
    }

    public boolean isIncapacitated() {
        return incapacitated;
    }

    public String getHeroType() {
        return heroType;
    }


    public int getLevel() {
        return level;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addXp(int xp) {
        this.xp += xp;
        xpLevelUp = 250 + (level * 50);
        while (xp >= xpLevelUp) {
            level += 1;
            xpLevelUp = 250 + (level * 50);
            resetHp();
        }

    }

    public int getXp() {
        return this.xp;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    }

    public abstract void resetHp();
    public abstract int getMaxHp();
    public abstract void attack(Hero hero, char landType);
}
