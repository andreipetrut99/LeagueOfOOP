package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DarkAngel extends Angel {
    private static final int PYROMANCER_HEALTH = 30;
    private static final int KNIGHT_HEALTH = 40;
    private static final int ROGUE_HEALTH = 10;
    private static final int WIZARD_HEALTH = 20;

    public DarkAngel(final int x, final int y) {
        super(x, y);
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Pyromancer hero) {
        hero.setInstantDamage(PYROMANCER_HEALTH);
        observer.notifyAngelHit(this, hero);
        if (!hero.isAlive()) {
            observer.notifyAngelDeath(hero);
        }
    }

    /**
     * Visit if hero is instance of Knight.
     * @param hero
     */
    @Override
    public void visit(final Knight hero) {
        hero.setInstantDamage(KNIGHT_HEALTH);
        observer.notifyAngelHit(this, hero);
        if (!hero.isAlive()) {
            observer.notifyAngelDeath(hero);
        }
    }

    /**
     * Visit if hero is instance of Rogue.
     * @param hero
     */
    @Override
    public void visit(final Rogue hero) {
        hero.setInstantDamage(ROGUE_HEALTH);
        observer.notifyAngelHit(this, hero);
        if (!hero.isAlive()) {
            observer.notifyAngelDeath(hero);
        }
    }

    /**
     * Visit if hero is instance of Wizard.
     * @param hero
     */
    @Override
    public void visit(final Wizard hero) {
        hero.setInstantDamage(WIZARD_HEALTH);
        observer.notifyAngelHit(this, hero);
        if (!hero.isAlive()) {
            observer.notifyAngelDeath(hero);
        }
    }

    /**
     * toString() method.
     * @return type of the angel.
     */
    @Override
    public String toString() {
        return "DarkAngel";
    }
}
