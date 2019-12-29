package heroes;

import angels.Angel;
import strategies.Context;
import strategies.DeffenseStrategies;
import strategies.OffensiveStrategies;
import strategies.Strategy;

import static commons.PyromancerModifiers.*;

public class Pyromancer extends Hero {
    private float fireblastDamage;
    private float igniteInstantDamage;
    private float ignitePassiveDamage;
    private float fireblastRogue = FIREBLAST_ROGUE;
    private float fireblastKnight = FIREBLAST_KNIGHT;
    private float fireblastPyromancer = FIREBLAST_PYROMANCER;
    private float fireblastWizard = FIREBLAST_WIZARD;
    private float igniteRogue = IGNITE_ROGUE;
    private float ignitePyromancer = IGNITE_PYROMANCER;
    private float igniteKnight = IGNITE_KNIGHT;
    private float igniteWizard = IGNITE_WIZARD;


    public Pyromancer(final int x, final int y, final String landType) {
        super(x, y, landType);
        super.setHp(HEALTH);
    }

    /**
     * Getter for the damage dealt without race modifiers.
     * @param landType
     * @return damage dealt
     */
    public void attack(final Hero enemy, final char landType) {
        fireblastDamage = (FIREBLAST_DAMAGE
                + (FIREBLAST_DAMAGE_PER_LEVEL * this.getLevel()));
        igniteInstantDamage = (IGNITE_INSTANT
                + (IGNITE_INSTANT_PER_LEVEL * this.getLevel()));
        ignitePassiveDamage = (IGNITE_PASSIVE
                + (IGNITE_PASSIVE_PER_LEVEL * this.getLevel()));

        if (landType == 'V') {
            fireblastDamage = Math.round(fireblastDamage * LAND_MODIFIER);
            ignitePassiveDamage = Math.round(ignitePassiveDamage * LAND_MODIFIER);
            igniteInstantDamage = Math.round(igniteInstantDamage * LAND_MODIFIER);
        }

         if (enemy instanceof  Rogue) {
            fireblastDamage = fireblastDamage * fireblastRogue;
            igniteInstantDamage = igniteInstantDamage * igniteRogue;
            ignitePassiveDamage = ignitePassiveDamage * igniteRogue;
         } else if (enemy instanceof Knight) {
             fireblastDamage = fireblastDamage * fireblastKnight;
             igniteInstantDamage = igniteInstantDamage * igniteKnight;
             ignitePassiveDamage = ignitePassiveDamage * igniteKnight;
         } else if (enemy instanceof Wizard) {
             fireblastDamage = fireblastDamage * fireblastWizard;
             igniteInstantDamage = igniteInstantDamage * igniteWizard;
             ignitePassiveDamage = ignitePassiveDamage * igniteWizard;
         } else if (enemy instanceof Pyromancer) {
             fireblastDamage = fireblastDamage * fireblastPyromancer;
             igniteInstantDamage = igniteInstantDamage * ignitePyromancer;
             ignitePassiveDamage = ignitePassiveDamage * ignitePyromancer;
         }

         enemy.setInstantDamage(Math.round(fireblastDamage));
         enemy.setInstantDamage(Math.round(igniteInstantDamage));
         enemy.setOvertimeDamage(Math.round(ignitePassiveDamage), 2);
    }

    /**
     * Getter for unmodified damage.
     * @param landType
     * @return
     */
    @Override
    public float getUnmodifiedDamage(final char landType) {
        if (landType == 'V') {
            return  Math.round(LAND_MODIFIER * (FIREBLAST_DAMAGE
                    + (FIREBLAST_DAMAGE_PER_LEVEL * this.getLevel())))
                    + Math.round(LAND_MODIFIER * (IGNITE_INSTANT
                    + (IGNITE_INSTANT_PER_LEVEL * this.getLevel())));
        }
        return (FIREBLAST_DAMAGE + (FIREBLAST_DAMAGE_PER_LEVEL * this.getLevel()))
                + (IGNITE_INSTANT + (IGNITE_INSTANT_PER_LEVEL * this.getLevel()));
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
     * Update the damage modifiers by a certain percent.
     * @param percent
     */
    @Override
    public void changeModifiers(final float percent) {
        ignitePyromancer += percent;
        igniteWizard += percent;
        igniteKnight += percent;
        igniteRogue += percent;
        fireblastPyromancer += percent;
        fireblastWizard += percent;
        fireblastKnight += percent;
        fireblastRogue += percent;
    }

    /**
     * Method which chooses the correct strategy.
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
     * Reset health points to default value.
     */
    @Override
    public void resetHp() {
        super.setHp(HEALTH + (HEALTH_PER_LEVEL * this.getLevel()));
    }

    /**
     * Getter for maximum health.
     * @return max health
     */
    @Override
    public int getMaxHp() {
        return (HEALTH + (HEALTH_PER_LEVEL * this.getLevel()));
    }

    /**
     * Method that accept angel as a modifier.
     * @param angel
     */
    @Override
    public void acceptAngel(final Angel angel) {
        angel.visit(this);
    }

    /**
     * toString() method.
     * @return thype of hero
     */
    @Override
    public String toString() {
        return "Pyromancer";
    }
}
