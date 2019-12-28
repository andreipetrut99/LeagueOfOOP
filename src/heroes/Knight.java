package heroes;

import angels.Angel;
import strategies.Context;
import strategies.DeffenseStrategies;
import strategies.OffensiveStrategies;

import static commons.Constants.EXECUTE_DAMAGE;
import static commons.Constants.EXECUTE_DAMAGE_PER_LEVEL;
import static commons.Constants.SLAM_DAMAGE;
import static commons.Constants.SLAM_DAMAGE_PER_LEVEL;
import static commons.Constants.MAX_LEVEL_FOR_HP_LIMIT;
import static commons.Constants.UNMODIFIED_HP_LIMIT;
import static commons.Constants.KNIGHT_HEALTH;
import static commons.Constants.KNIGHT_HEALTH_PER_LEVEL;
import static commons.Constants.CENT;

import static commons.KnightModifiers.HP_LIMIT_MODIFIER;
import static commons.KnightModifiers.HP_LIMIT_MODIFIER_MIN;
import static commons.KnightModifiers.LAND_MODIFIER;

public class Knight extends Hero {
    private float execute_rogue = 1.15f;
    private float execute_pyromancer = 1.1f;
    private float execute_wizard = 0.8f;
    private float slam_rogue = 0.8f;
    private float slam_knight = 1.2f;
    private float slam_pyromancer = 0.9f;
    private float slam_wizard = 1.05f;

    public Knight(final int x, final int y, final String heroType) {
        super(x, y, heroType);
        setHp(KNIGHT_HEALTH);
    }

    /**
     * Setter for Health Points.
     *
     * @param hp
     */
    @Override
    public void setHp(final int hp) {
        super.setHp(hp);
    }

    /**
     * Reset Health Points to default value.
     */
    @Override
    public void resetHp() {
        super.setHp(KNIGHT_HEALTH + (KNIGHT_HEALTH_PER_LEVEL * getLevel()));
    }

    /**
     * Getting the maximum health points a hero can have.
     *
     * @return
     */
    @Override
    public int getMaxHp() {
        return (KNIGHT_HEALTH + (KNIGHT_HEALTH_PER_LEVEL * getLevel()));
    }

    /**
     * Getter for the damage dealt without race modifiers.
     *
     * @param landType
     * @return damage dealt
     */
    @Override
    public float getUnmodifiedDamage(final char landType) {
        if (landType == 'L') {
            return Math.round(LAND_MODIFIER * (EXECUTE_DAMAGE
                    + (EXECUTE_DAMAGE_PER_LEVEL * this.getLevel())
                    + SLAM_DAMAGE + (SLAM_DAMAGE_PER_LEVEL * this.getLevel())));
        }
        return (float) (EXECUTE_DAMAGE
                + (EXECUTE_DAMAGE_PER_LEVEL * this.getLevel())
                + SLAM_DAMAGE + (SLAM_DAMAGE_PER_LEVEL * this.getLevel()));
    }

    /**
     * Method for updating the modifiers.
     * @param percent
     */
    @Override
    public void changeModifiers(float percent) {
        slam_wizard += percent;
        slam_knight += percent;
        slam_rogue += percent;
        slam_pyromancer += percent;
        execute_wizard += percent;
        execute_rogue += percent;
        execute_pyromancer += percent;
    }

    @Override
    public void applyStrategy() {
        if (getMaxHp()/3 < getHp() && getHp() < getMaxHp()/2) {
            Context context = new Context(new OffensiveStrategies());
            context.executeStrategy(this);
        }
        if (getHp() < getMaxHp() / 3) {
            Context context = new Context(new DeffenseStrategies());
            context.executeStrategy(this);
        }
    }

    /**
     * Method for attacking the enemy and decrease his health.
     *
     * @param enemy
     * @param landType
     */
    @Override
    public void attack(final Hero enemy, final char landType) {
        float executeDamage = EXECUTE_DAMAGE + (EXECUTE_DAMAGE_PER_LEVEL * this.getLevel());
        float slamDamage = SLAM_DAMAGE + (SLAM_DAMAGE_PER_LEVEL * this.getLevel());
        float hpLimit;
        float maxPercentage;

        if (enemy.getLevel() >= MAX_LEVEL_FOR_HP_LIMIT) {
            maxPercentage = HP_LIMIT_MODIFIER;
        } else {
            maxPercentage = HP_LIMIT_MODIFIER_MIN + (float) enemy.getLevel() / CENT;
        }
        hpLimit = UNMODIFIED_HP_LIMIT * maxPercentage;


        if (landType == 'L') {
            executeDamage = executeDamage * LAND_MODIFIER;
            slamDamage = slamDamage * LAND_MODIFIER;
        }

        if (enemy instanceof Pyromancer) {
            executeDamage = executeDamage * execute_pyromancer;
            slamDamage = slamDamage * slam_pyromancer;
        } else if (enemy instanceof Rogue) {
            executeDamage = executeDamage * execute_rogue;
            slamDamage = slamDamage * slam_rogue;
        } else if (enemy instanceof Wizard) {
            executeDamage = executeDamage * execute_wizard;
            slamDamage = slamDamage * slam_wizard;
        } else {
            slamDamage = slamDamage * slam_knight;
        }

        if (enemy.getHp() < Math.round(hpLimit)) {
            enemy.setInstantDamage(enemy.getHp());
        } else {
            enemy.setInstantDamage(Math.round(executeDamage));
        }
        enemy.setIncapacitation(1);
        enemy.setInstantDamage(Math.round(slamDamage));
    }

    @Override
    public void acceptAngel(Angel angel) {
        angel.visit(this);
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
