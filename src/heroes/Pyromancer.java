package heroes;

import angels.Angel;
import strategies.Context;
import strategies.DeffenseStrategies;
import strategies.OffensiveStrategies;

import static commons.PyromancerModifiers.FIREBLAST_DAMAGE_PER_LEVEL;
import static commons.PyromancerModifiers.FIREBLAST_DAMAGE;
import static commons.PyromancerModifiers.IGNITE_INSTANT;
import static commons.PyromancerModifiers.IGNITE_INSTANT_PER_LEVEL;
import static commons.PyromancerModifiers.IGNITE_PASSIVE;
import static commons.PyromancerModifiers.IGNITE_PASSIVE_PER_LEVEL;
import static commons.PyromancerModifiers.HEALTH;
import static commons.PyromancerModifiers.HEALTH_PER_LEVEL;
import static commons.PyromancerModifiers.LAND_MODIFIER;

public class Pyromancer extends Hero {
    private float fireblastDamage;
    private float igniteInstantDamage;
    private float ignitePassiveDamage;
    float fireblast_rogue = 0.8f;
    float fireblast_knight = 1.2f;
    float fireblast_pyromancer = 0.9f;
    float fireblast_wizard = 1.05f;
    float ignite_rogue = 0.8f;
    float ignite_pyromancer = 0.9f;
    float ignite_knight = 1.2f;
    float ignite_wizard = 1.05f;


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
            fireblastDamage = fireblastDamage * LAND_MODIFIER;
            ignitePassiveDamage = ignitePassiveDamage * LAND_MODIFIER;
            igniteInstantDamage = igniteInstantDamage * LAND_MODIFIER;
        }

         if (enemy instanceof  Rogue) {
            fireblastDamage = fireblastDamage * fireblast_rogue;
            igniteInstantDamage = igniteInstantDamage * ignite_rogue;
            ignitePassiveDamage = ignitePassiveDamage * ignite_rogue;
         } else if (enemy instanceof Knight) {
             fireblastDamage = fireblastDamage * fireblast_knight;
             igniteInstantDamage = igniteInstantDamage * ignite_knight;
             ignitePassiveDamage = ignitePassiveDamage * ignite_knight;
         } else if (enemy instanceof Wizard) {
             fireblastDamage = fireblastDamage * fireblast_wizard;
             igniteInstantDamage = igniteInstantDamage * ignite_wizard;
             ignitePassiveDamage = ignitePassiveDamage * ignite_wizard;
         } else if (enemy instanceof Pyromancer) {
             fireblastDamage = fireblastDamage * fireblast_pyromancer;
             igniteInstantDamage = igniteInstantDamage * ignite_pyromancer;
             ignitePassiveDamage = ignitePassiveDamage * ignite_pyromancer;
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
     * Update the damage modifiers by a certain percent.
     * @param percent
     */
    @Override
    public void changeModifiers(final float percent) {
        ignite_pyromancer += percent;
        ignite_wizard += percent;
        ignite_knight += percent;
        ignite_rogue += percent;
        fireblast_pyromancer += percent;
        fireblast_wizard += percent;
        fireblast_knight += percent;
        fireblast_rogue += percent;
    }

    @Override
    public void applyStrategy() {
        if (getMaxHp()/4 < getHp() && getHp() < getMaxHp()/3) {
            Context context = new Context(new OffensiveStrategies());
            context.executeStrategy(this);
        }
        if (getHp() < getMaxHp() / 4) {
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

    @Override
    public void acceptAngel(Angel angel) {
        angel.visit(this);
    }

    @Override
    public String toString() {
        return "Pyromancer";
    }
}
