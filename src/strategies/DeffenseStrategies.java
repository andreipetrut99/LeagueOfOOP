package strategies;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DeffenseStrategies extends Strategy {
    private static final int KNIGHT_HEALTH = 4;
    private static final int PYROMANCER_HEALTH = 3;
    private static final int ROGUE_HEALTH = 2;
    private static final int WIZARD_HEALTH = 5;
    private static final float KNIGHT_MODIFIER = -0.2f;
    private static final float PYROMANCER_MODIFIER = -0.3f;
    private static final float ROGUE_MODIFIER = -0.1f;
    private static final float WIZARD_MODIFIER = -0.2f;
    /**
     * Applies the strategy by runtime type.
     */
    @Override
    public void applyStrategy(final Knight hero) {
        hero.setInstantDamage((int) (-hero.getHp()) / KNIGHT_HEALTH);
        hero.changeModifiers(KNIGHT_MODIFIER);
    }

    /**
     * Applies the strategy by runtime type.
     */
    @Override
    public void applyStrategy(final Pyromancer hero) {
        hero.changeModifiers(PYROMANCER_MODIFIER);
        hero.setInstantDamage(-hero.getHp() / PYROMANCER_HEALTH);
    }

    /**
     * Applies the strategy by runtime type.
     */
    @Override
    public void applyStrategy(final Rogue hero) {
        hero.changeModifiers(ROGUE_MODIFIER);
        hero.setInstantDamage(-hero.getHp() / ROGUE_HEALTH);
    }

    /**
     * Applies the strategy by runtime type.
     */
    @Override
    public void applyStrategy(final Wizard hero) {
        hero.changeModifiers(WIZARD_MODIFIER);
        hero.setInstantDamage(-hero.getHp() / WIZARD_HEALTH);
    }
}
