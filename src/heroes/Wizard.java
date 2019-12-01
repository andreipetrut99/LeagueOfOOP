package heroes;

import static commons.WizardModifiers.DRAIN_KNIGHT;
import static commons.WizardModifiers.DEFLECT_KNIGHT;
import static commons.WizardModifiers.DEFLECT_MAX_PERCENT;
import static commons.WizardModifiers.DEFLECT_MIN_PERCENT;
import static commons.WizardModifiers.DEFLECT_PERCENT;
import static commons.WizardModifiers.DEFLECT_PYROMANCER;
import static commons.WizardModifiers.DEFLECT_ROGUE;
import static commons.WizardModifiers.DEFLECT_WIZARD;
import static commons.WizardModifiers.DRAIN_PERCENT;
import static commons.WizardModifiers.DRAIN_PERCENT_MIN;
import static commons.WizardModifiers.DRAIN_PYROMANCER;
import static commons.WizardModifiers.LAND_MODIFIER;
import static commons.WizardModifiers.HEALTH_PER_LEVEL;
import static commons.WizardModifiers.HEALTH;
import static commons.WizardModifiers.LEVEL_MAX;
import static commons.WizardModifiers.DRAIN_ROGUE;
import static commons.WizardModifiers.DRAIN_WIZARD;
import static commons.WizardModifiers.MIN_DRAIN;


public class Wizard extends Hero {
    public Wizard(final int x, final int y, final String landType) {
        super(x, y, landType);
        setHp(HEALTH);
    }

    /**
     * Resets health points to default.
     */
    @Override
    public void resetHp() {
        super.setHp(HEALTH + (HEALTH_PER_LEVEL * getLevel()));
    }

    /**
     * Getter for maximum health points.
     * @return max hp
     */
    @Override
    public int getMaxHp() {
        return HEALTH + (HEALTH_PER_LEVEL * getLevel());
    }

    /**
     * Method for attacking the enemy and decrease his health.
     * @param enemy
     * @param landType
     */
    @Override
    public void attack(final Hero enemy, final char landType) {
        float drainPercent = DRAIN_PERCENT + (DRAIN_PERCENT_MIN * enemy.getLevel());
        float deflectPercent;
        if (enemy.getLevel() > LEVEL_MAX) {
            deflectPercent = DEFLECT_PERCENT;
        } else {
            deflectPercent = DEFLECT_MAX_PERCENT + (DEFLECT_MIN_PERCENT * enemy.getLevel());
        }

        if (enemy instanceof Rogue) {
            drainPercent = DRAIN_ROGUE * drainPercent;
            deflectPercent = DEFLECT_ROGUE * deflectPercent;
        } else if (enemy instanceof Knight) {
            drainPercent = DRAIN_KNIGHT * drainPercent;
            deflectPercent = DEFLECT_KNIGHT * deflectPercent;
        } else if (enemy instanceof Pyromancer) {
            drainPercent = DRAIN_PYROMANCER * drainPercent;
            deflectPercent = DEFLECT_PYROMANCER * deflectPercent;
        } else {
            drainPercent = DRAIN_WIZARD * drainPercent;
            deflectPercent = DEFLECT_WIZARD;
        }
        float drainDamage = drainPercent * (Math.min(MIN_DRAIN * enemy.getMaxHp(), enemy.getHp()));
        float deflectDamage = deflectPercent * enemy.getUnmodifiedDamage(landType);
        if (landType == 'D') {
            drainDamage = drainDamage * LAND_MODIFIER;
            deflectDamage = deflectDamage * LAND_MODIFIER;
        }

        enemy.setInstantDamage(Math.round(drainDamage) + Math.round(deflectDamage));

    }

    /**
     * Getter for unmodified damage.
     * @param landType
     * @return
     */
    @Override
    public float getUnmodifiedDamage(final char landType) {
        return 0;
    }

}
