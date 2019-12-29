package admin;

import angels.Angel;
import heroes.Hero;
import main.GameInputLoader;

public class TheGreatWizard {
    private static TheGreatWizard instance = null;
    private GameInputLoader gameInputLoader = GameInputLoader.getInstance();

    private TheGreatWizard() {
    }

    public static TheGreatWizard getInstance() {
        if (instance == null) {
            return instance = new TheGreatWizard();
        }
        return instance;
    }

    public void notifyDeath(Hero h2, Hero h1) {
        gameInputLoader.printLine("Player " + h1.toString() + " " + h1.getId()
                + " was killed by " + h2.toString() + " " + h2.getId());
    }

    public void notifyLevelUp(Hero h1) {
        gameInputLoader.printLine(h1.toString() + " "+ h1.getId() + " reached level " + h1.getLevel());
    }

    public void notifyAngelSpawn(Angel angel) {
        gameInputLoader.printLine("Angel " + angel.toString() + " was spawned at "
                + angel.getX() + " " + angel.getY());
    }

    public void notifyAngelHelp(Angel angel, Hero hero) {
        gameInputLoader.printLine(angel.toString() + " helped " + hero.toString() + " " + hero.getId());
    }

    public void notifyAngelHit(Angel angel, Hero hero) {
        gameInputLoader.printLine(angel.toString() + " hit " + hero.toString() + " " + hero.getId());
    }

    public void notifyAngelDeath(Hero hero) {
        gameInputLoader.printLine("Player " + hero.toString() + " " + hero.getId()
                + " was killed by an angel");
    }

    public void notifyAngelRespawn(Hero hero) {
        gameInputLoader.printLine("Player " + hero.toString() + " " + hero.getId()
                + " was brought to life by an angel");
    }
}
