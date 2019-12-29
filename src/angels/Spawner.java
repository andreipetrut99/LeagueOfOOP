package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Spawner extends Angel {
    private static final int KNIGHT_HEALTH = 200;
    private static final int PYROMANCER_HEALTH = 150;
    private static final int ROGUE_HEALTH = 180;
    private static final int WIZARD_HEALTH = 120;
    public Spawner(final int x, final int y) {
        super(x, y);
    }

    /**
     * Visit if hero is instance of Knight.
     * @param hero
     */
    @Override
    public void visit(final Knight hero) {
        if (hero.getHp() <= 0) {
            hero.setHp(KNIGHT_HEALTH);
            observer.notifyAngelHelp(this, hero);
            observer.notifyAngelRespawn(hero);
        }
    }

    /**
     * Visit if hero is instance of Pyromancer.
     * @param hero
     */
    @Override
    public void visit(final Pyromancer hero) {
        if (hero.getHp() <= 0) {
            hero.setHp(PYROMANCER_HEALTH);
            observer.notifyAngelHelp(this, hero);
            observer.notifyAngelRespawn(hero);
        }
    }

    /**
     * Visit if hero is instance of Rogue.
     * @param hero
     */
    @Override
    public void visit(final Rogue hero) {
        if (hero.getHp() <= 0) {
            hero.setHp(ROGUE_HEALTH);
            observer.notifyAngelHelp(this, hero);
            observer.notifyAngelRespawn(hero);
        }
    }

    /**
     * Visit if hero is instance of Wizard.
     * @param hero
     */
    @Override
    public void visit(final Wizard hero) {
        if (hero.getHp() <= 0) {
            hero.setHp(WIZARD_HEALTH);
            observer.notifyAngelHelp(this, hero);
            observer.notifyAngelRespawn(hero);
        }
    }

    /**
     * toString() method.
     * @return the type of angel.
     */
    @Override
    public String toString() {
        return "Spawner";
    }
}
