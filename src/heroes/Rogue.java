package heroes;

import angels.Angel;
import strategies.Context;
import strategies.DeffenseStrategies;
import strategies.OffensiveStrategies;

import static commons.RogueModifiers.BACKSTAB;
import static commons.RogueModifiers.BACKSTAB_PER_LEVEL;
import static commons.RogueModifiers.PARALYSIS;
import static commons.RogueModifiers.PARALYSIS_MAX_ROUNDS;
import static commons.RogueModifiers.PARALYSIS_MIN_ROUNDS;
import static commons.RogueModifiers.PARALYSIS_PER_LEVEL;
import static commons.RogueModifiers.CRITICAL_HIT;
import static commons.RogueModifiers.LAND_MODIFIER;
import static commons.RogueModifiers.INITIAL_HITS;
import static commons.RogueModifiers.HEALTH;
import static commons.RogueModifiers.HEALTH_PER_LEVEL;

public class Rogue extends Hero {
    private float unmodifiedDamage;
    private float backstab_rogue = 1.2f;
    private float backstab_knight = 0.9f;
    private float backstab_pyromancer = 1.25f;
    private float backstab_wizard = 1.25f;
    private float paralysis_rogue = 0.9f;
    private float paralysis_knight = 0.8f;
    private float paralysis_pyromancer = 1.2f;
    private float paralysiss_wizard = 1.25f;
    private int backstabHits = INITIAL_HITS;
    private boolean attacked = false;
     public Rogue(final int x, final int y, final String landType) {
         super(x, y, landType);
         setHp(HEALTH);
     }

    /**
     * Resets hp to default value.
     */
    @Override
    public void resetHp() {
        setHp(HEALTH + (HEALTH_PER_LEVEL * getLevel()));
    }

    /**
     * Getter for maximum hp.
     * @return max hp
     */
    @Override
    public int getMaxHp() {
        return HEALTH + (HEALTH_PER_LEVEL * getLevel());
    }

    /**
     * Method where hero attacks enemy and give damage.
     * @param enemy
     * @param landType
     */
    @Override
    public void attack(final Hero enemy, final char landType) {
         float backstabDamage = BACKSTAB + (BACKSTAB_PER_LEVEL * getLevel());
        float paralysisDamage = PARALYSIS + (PARALYSIS_PER_LEVEL * getLevel());
        int paralysisRounds;
        attacked = true;

        if (backstabHits == INITIAL_HITS && landType == 'W') {
            backstabDamage = backstabDamage * CRITICAL_HIT;
            backstabHits = 0;
        } else if (backstabHits == INITIAL_HITS) {
            backstabHits = 0;
        }
        backstabHits++;

        if (landType == 'W') {
            paralysisRounds = PARALYSIS_MAX_ROUNDS;
            paralysisDamage = paralysisDamage * LAND_MODIFIER;
            backstabDamage = backstabDamage * LAND_MODIFIER;
        } else {
            paralysisRounds = PARALYSIS_MIN_ROUNDS;
        }
        unmodifiedDamage = Math.round(backstabDamage) + Math.round(paralysisDamage);

        if (enemy instanceof Rogue) {
            backstabDamage = backstabDamage * backstab_rogue;
            paralysisDamage = paralysisDamage * paralysis_rogue;
        } else if (enemy instanceof Knight) {
            backstabDamage = backstabDamage * backstab_knight;
            paralysisDamage = paralysisDamage * paralysis_knight;
        } else if (enemy instanceof Pyromancer) {
            backstabDamage = backstabDamage * backstab_pyromancer;
            paralysisDamage = paralysisDamage * paralysis_pyromancer;
        } else {
            backstabDamage = backstabDamage * backstab_wizard;
            paralysisDamage = paralysisDamage * paralysiss_wizard;
        }

        enemy.setInstantDamage(Math.round(backstabDamage));
        enemy.setInstantDamage(Math.round(paralysisDamage));
        enemy.setOvertimeDamage(Math.round(paralysisDamage), paralysisRounds);
        enemy.setIncapacitation(paralysisRounds);
    }

    /**
     * Getter for unmodified damage.
     * @param landType
     * @return
     */
    @Override
    public float getUnmodifiedDamage(final char landType) {
         float backstabDamage = BACKSTAB + (BACKSTAB_PER_LEVEL * getLevel());
         float paralysisDamage = PARALYSIS + (PARALYSIS_PER_LEVEL * getLevel());
         if (attacked) {
            if (((backstabHits - 1) == 0) && (landType == 'W')) {
                backstabDamage = backstabDamage * CRITICAL_HIT;
            }
         } else {
             if (backstabHits == INITIAL_HITS && landType == 'W') {
                 backstabDamage = backstabDamage * CRITICAL_HIT;
             }
         }
        if (landType == 'W') {
            backstabDamage = backstabDamage * LAND_MODIFIER;
            paralysisDamage = paralysisDamage * LAND_MODIFIER;
        }
        return Math.round(backstabDamage) + Math.round(paralysisDamage);
    }

    @Override
    public void changeModifiers(float percent) {
        backstab_wizard += percent;
        backstab_pyromancer += percent;
        backstab_knight += percent;
        backstab_rogue += percent;
        paralysiss_wizard += percent;
        paralysis_pyromancer += percent;
        paralysis_knight += percent;
        paralysis_rogue += percent;
    }
    @Override
    public void acceptAngel(Angel angel) {
        angel.visit(this);
    }

    @Override
    public void applyStrategy() {
        if (getMaxHp()/7 < getHp() && getHp() < getMaxHp()/5) {
            Context context = new Context(new OffensiveStrategies());
            context.executeStrategy(this);
        }
        if (getHp() < getMaxHp() / 7) {
            Context context = new Context(new DeffenseStrategies());
            context.executeStrategy(this);
        }
    }

    @Override
    public String toString() {
        return "Rogue";
    }
}
