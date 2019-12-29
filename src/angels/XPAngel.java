package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class XPAngel extends Angel {
    private static final int KNIGHT_XP = 45;
    private static final int PYROMANCER_XP = 50;
    private static final int ROGUE_XP = 40;
    private static final int WIZARD_XP = 60;
    public XPAngel(final int x, final int y) {
        super(x, y);
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Knight hero) {
        observer.notifyAngelHelp(this, hero);
        hero.addXp(KNIGHT_XP);
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Pyromancer hero) {
        observer.notifyAngelHelp(this, hero);
        hero.addXp(PYROMANCER_XP);
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Rogue hero) {
        observer.notifyAngelHelp(this, hero);
        hero.addXp(ROGUE_XP);
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Wizard hero) {
        observer.notifyAngelHelp(this, hero);
        hero.addXp(WIZARD_XP);
    }

    /**
     * toString() method.
     * @return the type of angel.
     */
    @Override
    public String toString() {
        return "XPAngel";
    }
}
