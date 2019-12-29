package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LevelUpAngel extends Angel {
    private static final float KNIGHT_MODIFIER = 0.1f;
    private static final float PYROMANCER_MODIFIER = 0.2f;
    private static final float ROGUE_MODIFIER = 0.15f;
    private static final float WIZARD_MODIFIER = 0.25f;
    public LevelUpAngel(final int x, final int y) {
        super(x, y);
    }

    /**
     * Visit if hero is instance of Knight.
     * @param hero
     */
    @Override
    public void visit(final Knight hero) {
        observer.notifyAngelHelp(this, hero);
        hero.changeModifiers(KNIGHT_MODIFIER);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Pyromancer hero) {
        observer.notifyAngelHelp(this, hero);
        hero.changeModifiers(PYROMANCER_MODIFIER);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
    }

    /**
     * Visit if hero is instance of Rogue.
     * @param hero
     */
    @Override
    public void visit(final Rogue hero) {
        observer.notifyAngelHelp(this, hero);
        hero.changeModifiers(ROGUE_MODIFIER);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
    }

    /**
     * Visit if hero is instance of Wizard.
     * @param hero
     */
    @Override
    public void visit(final Wizard hero) {
        observer.notifyAngelHelp(this, hero);
        hero.changeModifiers(WIZARD_MODIFIER);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
    }

    /**
     * toString() method.
     * @return the type of angel
     */
    @Override
    public String toString() {
        return "LevelUpAngel";
    }
}
