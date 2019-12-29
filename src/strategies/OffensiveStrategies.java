package strategies;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class OffensiveStrategies extends Strategy {
    private static final double KNIGHT_HEALTH = 0.2;
    private static final double PYROMANCER_HEALTH = 0.25;
    private static final int ROGUE_HEALTH = 7;
    private static final int WIZARD_HEALTH = 10;
    private static final float KNIGHT_MODIFIER = 0.5f;
    private static final float PYROMANCER_MODIFIER = 0.7f;
    private static final float ROGUE_MODIFIER = 0.4f;
    private static final float WIZARD_MODIFIER = 0.6f;
    /**
     * Applies the strategy by runtime type.
     */
    @Override
    public void applyStrategy(final Knight hero) {
        hero.setInstantDamage((int) (KNIGHT_HEALTH * hero.getHp()));
        hero.changeModifiers(KNIGHT_MODIFIER);
    }

    /**
     * Applies the strategy by runtime type.
     */
    @Override
    public void applyStrategy(final Pyromancer hero) {
        hero.setInstantDamage((int) (PYROMANCER_HEALTH * hero.getHp()));
        hero.changeModifiers(PYROMANCER_MODIFIER);
    }

    /**
     * Applies the strategy by runtime type.
     */
    @Override
    public void applyStrategy(final Rogue hero) {
        hero.setInstantDamage(hero.getHp() / ROGUE_HEALTH);
        hero.changeModifiers(ROGUE_MODIFIER);
    }

    /**
     * Applies the strategy by runtime type.
     */
    @Override
    public void applyStrategy(final Wizard hero) {
        hero.setInstantDamage(hero.getHp() / WIZARD_HEALTH);
        hero.changeModifiers(WIZARD_MODIFIER);
    }
}
