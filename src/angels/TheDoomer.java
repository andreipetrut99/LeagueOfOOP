package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class TheDoomer extends Angel {
    public TheDoomer(final int x, final int y) {
        super(x, y);
    }

    /**
     * Visit if hero is instance of Knight.
     * @param hero
     */
    @Override
    public void visit(final Knight hero) {
        hero.setInstantDamage(hero.getHp());
        observer.notifyAngelHit(this, hero);
        observer.notifyAngelDeath(hero);
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Pyromancer hero) {
        hero.setInstantDamage(hero.getHp());
        observer.notifyAngelHit(this, hero);
        observer.notifyAngelDeath(hero);
    }

    /**
     * Visit if hero is instance of Rogue.
     * @param hero
     */
    @Override
    public void visit(final Rogue hero) {
        hero.setInstantDamage(hero.getHp());
        observer.notifyAngelHit(this, hero);
        observer.notifyAngelDeath(hero);
    }

    /**
     * Visit if hero is instance of Wizard.
     * @param hero
     */
    @Override
    public void visit(final Wizard hero) {
        hero.setInstantDamage(hero.getHp());
        observer.notifyAngelHit(this, hero);
        observer.notifyAngelDeath(hero);
    }

    /**
     * toString() method.
     * @return the type of angel.
     */
    @Override
    public String toString() {
        return "TheDoomer";
    }
}
