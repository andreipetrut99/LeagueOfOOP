package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class GoodBoy extends Angel {
    private static final int KNIGHT_HEALTH = -20;
    private static final int PYROMANCER_HEALTH = -30;
    private static final int ROGUE_HEALTH = -40;
    private static final int WIZARD_HEALTH = -50;
    private static final float KNIGHT_MODIFIER = 0.4f;
    private static final float PYROMANCER_MODIFIER = 0.5f;
    private static final float ROGUE_MODIFIER = 0.4f;
    private static final float WIZARD_MODIFIER = 0.3f;
    public GoodBoy(final int x, final int y) {
        super(x, y);
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Knight hero) {
        hero.changeModifiers(KNIGHT_MODIFIER);
        hero.setInstantDamage(KNIGHT_HEALTH);
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Pyromancer hero) {
        hero.changeModifiers(PYROMANCER_MODIFIER);
        hero.setInstantDamage(PYROMANCER_HEALTH);
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Rogue hero) {
        hero.changeModifiers(ROGUE_MODIFIER);
        hero.setInstantDamage(ROGUE_HEALTH);
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Wizard hero) {
        hero.changeModifiers(WIZARD_MODIFIER);
        hero.setInstantDamage(WIZARD_HEALTH);
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * toString() method.
     * @return type of angel.
     */
    @Override
    public String toString() {
        return "GoodBoy";
    }
}
