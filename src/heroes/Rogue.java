package heroes;

import angels.Angel;
import strategies.Context;
import strategies.DeffenseStrategies;
import strategies.OffensiveStrategies;
import strategies.Strategy;

import static commons.RogueModifiers.*;

public class Rogue extends Hero {
    private float backstabRogue = BACKSTAB_ROGUE;
    private float backstabKnight = BACKSTAB_KNIGHT;
    private float backstabPyromancer = BACKSTAB_PYROMANCER;
    private float backstabWizard = BACKSTAB_WIZARD;
    private float paralysisRogue = PARALYSIS_ROGUE;
    private float paralysisKnight = PARALYSIS_KNIGHT;
    private float paralysisPyromancer = PARALYSIS_PYROMANCER;
    private float paralysissWizard = PARALYSIS_WIZARD;
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
            backstabDamage = Math.round(backstabDamage * CRITICAL_HIT);
            backstabHits = 0;
        } else if (backstabHits == INITIAL_HITS) {
            backstabHits = 0;
        }
        backstabHits++;

        if (landType == 'W') {
            paralysisRounds = PARALYSIS_MAX_ROUNDS;
            paralysisDamage = Math.round(paralysisDamage * LAND_MODIFIER);
            backstabDamage = Math.round(backstabDamage * LAND_MODIFIER);
        } else {
            paralysisRounds = PARALYSIS_MIN_ROUNDS;
        }

        if (enemy instanceof Rogue) {
            backstabDamage = backstabDamage * backstabRogue;
            paralysisDamage = paralysisDamage * paralysisRogue;
        } else if (enemy instanceof Knight) {
            backstabDamage = backstabDamage * backstabKnight;
            paralysisDamage = paralysisDamage * paralysisKnight;
        } else if (enemy instanceof Pyromancer) {
            backstabDamage = backstabDamage * backstabPyromancer;
            paralysisDamage = paralysisDamage * paralysisPyromancer;
        } else {
            backstabDamage = backstabDamage * backstabWizard;
            paralysisDamage = paralysisDamage * paralysissWizard;
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
                backstabDamage = Math.round(backstabDamage * CRITICAL_HIT);
            }
         } else {
             if (backstabHits == INITIAL_HITS && landType == 'W') {
                 backstabDamage = Math.round(backstabDamage * CRITICAL_HIT);
             }
         }
        if (landType == 'W') {
            backstabDamage = Math.round(backstabDamage * LAND_MODIFIER);
            paralysisDamage = Math.round(paralysisDamage * LAND_MODIFIER);
        }
        return Math.round(backstabDamage) + Math.round(paralysisDamage);
    }

    /**
     * Method that updates the modifiers.
     * @param percent
     */
    @Override
    public void changeModifiers(final float percent) {
        backstabWizard += percent;
        backstabPyromancer += percent;
        backstabKnight += percent;
        backstabRogue += percent;
        paralysissWizard += percent;
        paralysisPyromancer += percent;
        paralysisKnight += percent;
        paralysisRogue += percent;
    }

    /**
     * Method that accept to get hero modified by angel.
     * @param angel
     */
    @Override
    public void acceptAngel(final Angel angel) {
        angel.visit(this);
    }

    /**
     * Method that accept to get hero modified by strategy.
     * @param strategy
     */
    @Override
    public void acceptStrategy(final Strategy strategy) {
        strategy.applyStrategy(this);
    }

    /**
     * Method which chooses the correct strategy.
     */
    @Override
    public void applyStrategy() {
        if (getMaxHp() / INF_STEP < getHp() && getHp() < getMaxHp() / SUP_STEP) {
            Context context = new Context(new OffensiveStrategies());
            context.executeStrategy(this);
        } else if (getHp() < getMaxHp() / INF_STEP) {
            Context context = new Context(new DeffenseStrategies());
            context.executeStrategy(this);
        }
    }

    /**
     * toString() method.
     * @return type of Hero
     */
    @Override
    public String toString() {
        return "Rogue";
    }
}
