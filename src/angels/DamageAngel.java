package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DamageAngel extends Angel {
    private static final float PYROMANCER_MODIFIER = 0.2f;
    private static final float KNIGHT_MODIFIER = 0.15f;
    private static final float ROGUE_MODIFIER = 0.3f;
    private static final float WIZARD_MODIFIER = 0.4f;

    public DamageAngel(final int x, final int y) {
        super(x, y);
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Pyromancer hero) {
        hero.changeModifiers(PYROMANCER_MODIFIER);
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * Visit if hero is instance of Knight.
     * @param hero
     */
    @Override
    public void visit(final Knight hero) {
        hero.changeModifiers(KNIGHT_MODIFIER);
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * Visit if hero is instance of Rogue.
     * @param hero
     */
    @Override
    public void visit(final Rogue hero) {
        hero.changeModifiers(ROGUE_MODIFIER);
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * Visit if hero is instance of Wizard.
     * @param hero
     */
    @Override
    public void visit(final Wizard hero) {
        hero.changeModifiers(WIZARD_MODIFIER);
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * toString() method.
     * @return angel type as a string
     */
    @Override
    public String toString() {
        return "DamageAngel";
    }
}
