package heroes;

import angels.Angel;
import strategies.Context;
import strategies.DeffenseStrategies;
import strategies.OffensiveStrategies;
import strategies.Strategy;

import static commons.WizardModifiers.*;


public class Wizard extends Hero {
    private float drainRogue = DRAIN_ROGUE;
    private float drainKnight = DRAIN_KNIGHT;
    private float drainPyromancer = DRAIN_PYROMANCER;
    private float drainWizard = DRAIN_WIZARD;
    private float deflectRogue = DEFLECT_ROGUE;
    private float deflectKnight = DEFLECT_KNIGHT;
    private float deflectPyromancer = DEFLECT_PYROMANCER;

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
        float drainPercent = DRAIN_PERCENT + (DRAIN_PERCENT_MIN * this.getLevel());
        float deflectPercent;
        if (enemy.getLevel() > LEVEL_MAX) {
            deflectPercent = DEFLECT_PERCENT;
        } else {
            deflectPercent = DEFLECT_MAX_PERCENT + (DEFLECT_MIN_PERCENT * this.getLevel());
        }

        if (enemy instanceof Rogue) {
            drainPercent = drainRogue * drainPercent;
            deflectPercent = deflectRogue * deflectPercent;
        } else if (enemy instanceof Knight) {
            drainPercent = drainKnight * drainPercent;
            deflectPercent = deflectKnight * deflectPercent;
        } else if (enemy instanceof Pyromancer) {
            drainPercent = drainPyromancer * drainPercent;
            deflectPercent = deflectPyromancer * deflectPercent;
        } else {
            drainPercent = drainWizard * drainPercent;
            deflectPercent = 0;
        }
        float drainDamage = drainPercent * (Math.min(MIN_DRAIN * enemy.getMaxHp(), enemy.getHp()));
        float deflectDamage = deflectPercent * enemy.getUnmodifiedDamage(landType);
        if (landType == 'D') {
            drainDamage = Math.round(drainDamage * LAND_MODIFIER);
            deflectDamage = Math.round(deflectDamage * LAND_MODIFIER);
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

    /**
     * Method that updates the modifiers.
     * @param percent
     */
    @Override
    public void changeModifiers(final float percent) {
        drainKnight += percent;
        drainPyromancer += percent;
        drainRogue += percent;
        drainWizard += percent;
        deflectKnight += percent;
        deflectPyromancer += percent;
        deflectRogue += percent;
    }

    /**
     * Method that chooses the correct strategy and applies it.
     */
    @Override
    public void applyStrategy() {
        if (getMaxHp() / INF_LIMIT < getHp() && getHp() < getMaxHp() / SUP_LIMIT) {
            Context context = new Context(new OffensiveStrategies());
            context.executeStrategy(this);
        } else if (getHp() < getMaxHp() / INF_LIMIT) {
            Context context = new Context(new DeffenseStrategies());
            context.executeStrategy(this);
        }
    }

    /**
     * Method that accepts an angel.
     * @param angel
     */
    @Override
    public void acceptAngel(final Angel angel) {
        angel.visit(this);
    }

    /**
     * Method that accepts strategy.
     * @param strategy
     */
    public void acceptStrategy(final Strategy strategy) {
        strategy.applyStrategy(this);
    }

    /**
     * toString() method.
     * @return type of hero
     */
    @Override
    public String toString() {
        return "Wizard";
    }
}
