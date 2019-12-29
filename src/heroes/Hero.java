package heroes;

import admin.TheGreatWizard;
import angels.Angel;
import strategies.Strategy;

import static commons.Constants.*;

public abstract class Hero {
    private int x, y, id;
    private int xp = 0;
    private int level = 0;
    private int xpLevelUp;
    private int hp;
    private boolean isAlive = true;
    private String heroType;
    private int overtimeDamage;
    private boolean incapacitated = false;
    private TheGreatWizard observer = TheGreatWizard.getInstance();


    private int incapacitatedRounds;
    private int affectedRounds;
    private boolean overtimeAffected = false;


    public Hero(final int x, final int y, final String heroType) {
        this.x = x;
        this.y = y;
        this.heroType = heroType;
    }

    /**
     * Setting an instant damage to this hero.
     * @param damage taken instantly.
     */
    public void setInstantDamage(final int damage) {
        hp -= damage;
        if (hp <= 0) {
            this.isAlive = false;
        }
    }

    /**
     * Setting overtime damage for abilities like ignite or paralysis.
     * @param damage taken every round.
     * @param rounds to take damage.
     */
    public void setOvertimeDamage(final int damage, final int rounds) {
        this.affectedRounds = rounds;
        this.overtimeDamage = damage;
        this.overtimeAffected = true;
    }

    /**
     * Loop and add damage every round.
     */
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

    /**
     * Make a player incapacitated for a number of rounds.
     * @param incapacitatedRounds
     */
    public void setIncapacitation(final int incapacitatedRounds) {
        this.incapacitatedRounds = incapacitatedRounds;
        this.incapacitated = true;
    }
    /**
     * Loop through this method every round and decrease incapacitated rounds.
     */
    public void loopIncapacitation() {
        if (this.incapacitated) {
            incapacitatedRounds -= 1;
        }
        if (incapacitatedRounds == 0) {
            incapacitated = false;
        }
    }

    /**
     * Check if a player is incapacitated.
     * @return boolean incapacitated
     */
    public boolean isIncapacitated() {
        return incapacitated;
    }

    /**
     * Getter for hero level.
     * @return hero level.
     */
    public int getLevel() {
        return level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /**
     * Check if a hero is alive.
     * @return boolean isAlive.
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Get xPos of this hero.
     * @return integer x.
     */
    public int getX() {
        return x;
    }

    /**
     * Get yPos of this hero.
     * @return integer y.
     */
    public int getY() {
        return y;
    }

    /**
     * Add to a player experience points and level up if it is the case to.
     * @param xp to add.
     */
    public void addXp(final int xp) {
        this.xp += xp;
        xpLevelUp = MIN_XP + (level * XP_PER_LEVEL);
        while (this.xp >= xpLevelUp) {
            level += 1;
            xpLevelUp = MIN_XP + (level * XP_PER_LEVEL);
            resetHp();
            observer.notifyLevelUp(this);
        }

    }

    public int getXpLevelUp() {
        return MIN_XP + (level * XP_PER_LEVEL);
    }

    /**
     * Getter for hero experience points.
     * @return experience points.
     */
    public int getXp() {
        return this.xp;
    }

    /**
     * Set new yPos value.
     * @param y
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Set new xPos value.
     * @param x
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Set Health Points.
     * @param hp
     */
    public void setHp(final int hp) {
        if (hp > 0) {
            isAlive = true;
        }
        this.hp = hp;
    }

    /**
     * Getter for hero type.
     * @return
     */
    public String getHeroType() {
        return heroType;
    }

    /**
     * Getter for Health Points.
     * @return
     */
    public int getHp() {
        return this.hp;
    }


    public abstract void resetHp();
    public abstract int getMaxHp();
    public abstract void attack(Hero hero, char landType);
    public abstract float getUnmodifiedDamage(char landType);
    public abstract void changeModifiers(float percent);
    public abstract void applyStrategy();
    public abstract void acceptAngel(Angel angel);
    public abstract void acceptStrategy(Strategy strategy);
}
