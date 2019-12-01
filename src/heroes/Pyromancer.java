package heroes;

import static commons.PyromancerModifiers.FIREBLAST_DAMAGE_PER_LEVEL;
import static commons.PyromancerModifiers.FIREBLAST_DAMAGE;
import static commons.PyromancerModifiers.FIREBLAST_KNIGHT;
import static commons.PyromancerModifiers.FIREBLAST_PYROMANCER;
import static commons.PyromancerModifiers.FIREBLAST_ROGUE;
import static commons.PyromancerModifiers.FIREBLAST_WIZARD;
import static commons.PyromancerModifiers.IGNITE_INSTANT;
import static commons.PyromancerModifiers.IGNITE_INSTANT_PER_LEVEL;
import static commons.PyromancerModifiers.IGNITE_KNIGHT;
import static commons.PyromancerModifiers.IGNITE_PASSIVE;
import static commons.PyromancerModifiers.IGNITE_PASSIVE_PER_LEVEL;
import static commons.PyromancerModifiers.IGNITE_PYROMANCER;
import static commons.PyromancerModifiers.IGNITE_ROGUE;
import static commons.PyromancerModifiers.IGNITE_WIZARD;
import static commons.PyromancerModifiers.HEALTH;
import static commons.PyromancerModifiers.HEALTH_PER_LEVEL;
import static commons.PyromancerModifiers.LAND_MODIFIER;

public class Pyromancer extends Hero {
    private float fireblastDamage;
    private float igniteInstantDamage;
    private float ignitePassiveDamage;

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
            fireblastDamage = fireblastDamage * FIREBLAST_ROGUE;
            igniteInstantDamage = igniteInstantDamage * IGNITE_ROGUE;
            ignitePassiveDamage = ignitePassiveDamage * IGNITE_ROGUE;
         } else if (enemy instanceof Knight) {
             fireblastDamage = fireblastDamage * FIREBLAST_KNIGHT;
             igniteInstantDamage = igniteInstantDamage * IGNITE_KNIGHT;
             ignitePassiveDamage = ignitePassiveDamage * IGNITE_KNIGHT;
         } else if (enemy instanceof Wizard) {
             fireblastDamage = fireblastDamage * FIREBLAST_WIZARD;
             igniteInstantDamage = igniteInstantDamage * IGNITE_WIZARD;
             ignitePassiveDamage = ignitePassiveDamage * IGNITE_WIZARD;
         } else if (enemy instanceof Pyromancer) {
             fireblastDamage = fireblastDamage * FIREBLAST_PYROMANCER;
             igniteInstantDamage = igniteInstantDamage * IGNITE_PYROMANCER;
             ignitePassiveDamage = ignitePassiveDamage * IGNITE_PYROMANCER;
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
}
