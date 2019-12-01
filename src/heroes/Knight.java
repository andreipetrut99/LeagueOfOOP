package heroes;

import static commons.Constants.EXECUTE_DAMAGE;
import static commons.Constants.EXECUTE_DAMAGE_PER_LEVEL;
import static commons.Constants.SLAM_DAMAGE;
import static commons.Constants.SLAM_DAMAGE_PER_LEVEL;
import static commons.Constants.MAX_LEVEL_FOR_HP_LIMIT;
import static commons.Constants.UNMODIFIED_HP_LIMIT;
import static commons.Constants.KNIGHT_HEALTH;
import static commons.Constants.KNIGHT_HEALTH_PER_LEVEL;
import static commons.Constants.CENT;

import static commons.KnightModifiers.EXECUTE_ROGUE;
import static commons.KnightModifiers.EXECUTE_PYROMANCER;
import static commons.KnightModifiers.EXECUTE_WIZARD;
import static commons.KnightModifiers.SLAM_KNIGHT;
import static commons.KnightModifiers.SLAM_PYROMANCER;
import static commons.KnightModifiers.SLAM_ROGUE;
import static commons.KnightModifiers.SLAM_WIZARD;
import static commons.KnightModifiers.HP_LIMIT_MODIFIER;
import static commons.KnightModifiers.HP_LIMIT_MODIFIER_MIN;
import static commons.KnightModifiers.LAND_MODIFIER;

public class Knight extends Hero {
    public Knight(final int x, final int y, final String heroType) {
        super(x, y, heroType);
        setHp(KNIGHT_HEALTH);
    }

    /**
     * Setter for Health Points.
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
     * @return
     */
    @Override
    public int getMaxHp() {
        return (KNIGHT_HEALTH + (KNIGHT_HEALTH_PER_LEVEL * getLevel()));
    }

    /**
     * Getter for the damage dealt without race modifiers.
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
     * Method for attacking the enemy and decrease his health.
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
            executeDamage = executeDamage * EXECUTE_PYROMANCER;
            slamDamage = slamDamage * SLAM_PYROMANCER;
        } else if (enemy instanceof Rogue) {
            executeDamage = executeDamage * EXECUTE_ROGUE;
            slamDamage = slamDamage * SLAM_ROGUE;
        } else if (enemy instanceof Wizard) {
            executeDamage = executeDamage * EXECUTE_WIZARD;
            slamDamage = slamDamage * SLAM_WIZARD;
        } else {
            slamDamage = slamDamage * SLAM_KNIGHT;
        }

        if (enemy.getHp() < Math.round(hpLimit)) {
            enemy.setInstantDamage(enemy.getHp());
        } else {
            enemy.setInstantDamage(Math.round(executeDamage));
        }
        enemy.setIncapacitation(1);
        enemy.setInstantDamage(Math.round(slamDamage));
    }

}
