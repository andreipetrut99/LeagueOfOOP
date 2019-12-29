package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LifeGiver extends Angel {
    private static final int KNIGHT_HEALTH = -100;
    private static final int PYROMANCER_HEALTH = -80;
    private static final int ROGUE_HEALTH = -90;
    private static final int WIZARD_HEALTH = -120;
    public LifeGiver(final int x, final int y) {
        super(x, y);
    }

    /**
     * Visit if hero is instance of Knight.
     * @param hero
     */
    @Override
    public void visit(final Knight hero) {
        if (hero.getHp() - KNIGHT_HEALTH > hero.getMaxHp()) {
            hero.setHp(hero.getMaxHp());
        } else {
            hero.setInstantDamage(KNIGHT_HEALTH);
        }
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Pyromancer hero) {
        if (hero.getHp() - PYROMANCER_HEALTH > hero.getMaxHp()) {
            hero.setHp(hero.getMaxHp());
        } else {
            hero.setInstantDamage(PYROMANCER_HEALTH);
        }
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * Visit if hero is instance of Rogue.
     * @param hero
     */
    @Override
    public void visit(final Rogue hero) {
        if (hero.getHp() - ROGUE_HEALTH > hero.getMaxHp()) {
            hero.setHp(hero.getMaxHp());
        } else {
            hero.setInstantDamage(ROGUE_HEALTH);
        }
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * Visit if hero is instance of Wizard.
     * @param hero
     */
    @Override
    public void visit(final Wizard hero) {
        if (hero.getHp() - WIZARD_HEALTH > hero.getMaxHp()) {
            hero.setHp(hero.getMaxHp());
        } else {
            hero.setInstantDamage(WIZARD_HEALTH);
        }
        observer.notifyAngelHelp(this, hero);
    }

    /**
     * toString() method.
     * @return type of angel.
     */
    @Override
    public String toString() {
        return "LifeGiver";
    }
}
