package heroes;

import angels.Angel;
import strategies.Context;
import strategies.DeffenseStrategies;
import strategies.OffensiveStrategies;

import static commons.WizardModifiers.DEFLECT_MAX_PERCENT;
import static commons.WizardModifiers.DEFLECT_MIN_PERCENT;
import static commons.WizardModifiers.DEFLECT_PERCENT;
import static commons.WizardModifiers.DRAIN_PERCENT;
import static commons.WizardModifiers.DRAIN_PERCENT_MIN;
import static commons.WizardModifiers.LAND_MODIFIER;
import static commons.WizardModifiers.HEALTH_PER_LEVEL;
import static commons.WizardModifiers.HEALTH;
import static commons.WizardModifiers.LEVEL_MAX;
import static commons.WizardModifiers.MIN_DRAIN;


public class Wizard extends Hero {
    private float drain_rogue = 0.8f;
    private float drain_knight = 1.2f;
    private float drain_pyromancer = 0.9f;
    private float drain_wizard = 1.05f;
    private float deflect_rogue = 1.2f;
    private float deflect_knight = 1.4f;
    private float deflect_pyromancer = 1.3f;
    private float deflect_wizard = 0f;

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
            drainPercent = drain_rogue * drainPercent;
            deflectPercent = deflect_rogue * deflectPercent;
        } else if (enemy instanceof Knight) {
            drainPercent = drain_knight * drainPercent;
            deflectPercent = deflect_knight * deflectPercent;
        } else if (enemy instanceof Pyromancer) {
            drainPercent = drain_pyromancer * drainPercent;
            deflectPercent = deflect_pyromancer * deflectPercent;
        } else {
            drainPercent = drain_wizard * drainPercent;
            deflectPercent = deflect_wizard;
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

    @Override
    public void changeModifiers(float percent) {
        drain_knight += percent;
        drain_pyromancer += percent;
        drain_rogue += percent;
        drain_wizard += percent;
        deflect_knight += percent;
        deflect_pyromancer += percent;
        deflect_rogue += percent;
    }

    @Override
    public void applyStrategy() {
        if (getMaxHp()/4 < getHp() && getHp() < getMaxHp()/2) {
            Context context = new Context(new OffensiveStrategies());
            context.executeStrategy(this);
        }
        if (getHp() < getMaxHp() / 4) {
            Context context = new Context(new DeffenseStrategies());
            context.executeStrategy(this);
        }
    }

    @Override
    public void acceptAngel(Angel angel) {
        angel.visit(this);
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}
