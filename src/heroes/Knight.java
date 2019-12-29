package heroes;

import angels.Angel;
import strategies.Context;
import strategies.DeffenseStrategies;
import strategies.OffensiveStrategies;
import strategies.Strategy;

import static commons.Constants.EXECUTE_DAMAGE;
import static commons.Constants.EXECUTE_DAMAGE_PER_LEVEL;
import static commons.Constants.SLAM_DAMAGE;
import static commons.Constants.SLAM_DAMAGE_PER_LEVEL;
import static commons.Constants.MAX_LEVEL_FOR_HP_LIMIT;
import static commons.Constants.UNMODIFIED_HP_LIMIT;
import static commons.Constants.KNIGHT_HEALTH;
import static commons.Constants.KNIGHT_HEALTH_PER_LEVEL;
import static commons.Constants.CENT;
import static commons.KnightModifiers.*;

public class Knight extends Hero {
    private float executeRogue = EXECUTE_ROGUE;
    private float executePyromancer = EXECUTE_PYROMANCER;
    private float executeWizard = EXECUTE_WIZARD;
    private float slamRogue = SLAM_ROGUE;
    private float slamKnight = SLAM_KNIGHT;
    private float slamPyromancer = SLAM_PYROMANCER;
    private float slamWizard = SLAM_WIZARD;

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
     *
     * @param percent
     */
    @Override
    public void changeModifiers(final float percent) {
        slamWizard += percent;
        slamKnight += percent;
        slamRogue += percent;
        slamPyromancer += percent;
        executeWizard += percent;
        executeRogue += percent;
        executePyromancer += percent;
    }

    /**
     * Method which chooses the correct strategy.
     */
    @Override
    public void applyStrategy() {
        if (getMaxHp() / STRATEGY_STEP < getHp() && getHp() < getMaxHp() / 2) {
            Context context = new Context(new OffensiveStrategies());
            context.executeStrategy(this);
        } else if (getHp() < getMaxHp() / STRATEGY_STEP) {
            Context context = new Context(new DeffenseStrategies());
            context.executeStrategy(this);
        }
    }

    /**
     * Method that accept that hero will be modified by strategy.
     *
     * @param strategy
     */
    public void acceptStrategy(final Strategy strategy) {
        strategy.applyStrategy(this);
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
            executeDamage = Math.round(executeDamage * LAND_MODIFIER);
            slamDamage = Math.round(slamDamage * LAND_MODIFIER);
        }

        if (enemy instanceof Pyromancer) {
            executeDamage = executeDamage * executePyromancer;
            slamDamage = slamDamage * slamPyromancer;
        } else if (enemy instanceof Rogue) {
            executeDamage = executeDamage * executeRogue;
            slamDamage = slamDamage * slamRogue;
        } else if (enemy instanceof Wizard) {
            executeDamage = executeDamage * executeWizard;
            slamDamage = slamDamage * slamWizard;
        } else {
            slamDamage = slamDamage * slamKnight;
        }

        if (enemy.getHp() < Math.round(hpLimit)) {
            enemy.setInstantDamage(enemy.getHp());
        } else {
            enemy.setInstantDamage(Math.round(executeDamage));
        }
        enemy.setIncapacitation(1);
        enemy.setInstantDamage(Math.round(slamDamage));
    }

    /**
     * Method that accept that hero will be modified by angel.
     *
     * @param angel
     */
    @Override
    public void acceptAngel(final Angel angel) {
        angel.visit(this);
    }

    /**
     * toString method.
     *
     * @return type of hero.
     */
    @Override
    public String toString() {
        return "Knight";
    }
}
