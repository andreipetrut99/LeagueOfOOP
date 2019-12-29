package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class SmallAngel extends Angel {
    private static final int KNIGHT_HEALTH = -10;
    private static final int PYROMANCER_HEALTH = -15;
    private static final int ROGUE_HEALTH = -20;
    private static final int WIZARD_HEALTH = -25;
    private static final float KNIGHT_MODIFIER = 0.1f;
    private static final float PYROMANCER_MODIFIER = 0.15f;
    private static final float ROGUE_MODIFIER = 0.05f;
    private static final float WIZARD_MODIFIER = 0.1f;
    public SmallAngel(final int x, final int y) {
        super(x, y);
    }

    /**
     * Visit if hero is instance of Knight.
     * @param hero
     */
    @Override
    public void visit(final Knight hero) {
        hero.setInstantDamage(KNIGHT_HEALTH);
        hero.changeModifiers(KNIGHT_MODIFIER);
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
     * Visit if hero is instance of Rogue.
     * @param hero
     */
    @Override
    public void visit(final Rogue hero) {
        hero.changeModifiers(ROGUE_MODIFIER);
        hero.setInstantDamage(ROGUE_HEALTH);
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * Visit if hero is instance of Wizard.
     * @param hero
     */
    @Override
    public void visit(final Wizard hero) {
        hero.setInstantDamage(WIZARD_HEALTH);
        hero.changeModifiers(WIZARD_MODIFIER);
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * toString() method.
     * @return the type of angel
     */
    @Override
    public String toString() {
        return "SmallAngel";
    }
}
