package admin;

import angels.Angel;
import heroes.Hero;
import main.GameInputLoader;

public final class TheGreatWizard {
    private static TheGreatWizard instance = null;
    private GameInputLoader gameInputLoader = GameInputLoader.getInstance();

    private TheGreatWizard() {
    }

    public static TheGreatWizard getInstance() {
        if (instance == null) {
            instance = new TheGreatWizard();
            return instance;
        }
        return instance;
    }

    public void notifyDeath(final Hero h2, final Hero h1) {
        gameInputLoader.printLine("Player " + h1.toString() + " " + h1.getId()
                + " was killed by " + h2.toString() + " " + h2.getId());
    }

    public void notifyLevelUp(final Hero h1) {
        gameInputLoader.printLine(h1.toString() + " " + h1.getId()
                + " reached level " + h1.getLevel());
    }

    public void notifyAngelSpawn(final Angel angel) {
        gameInputLoader.printLine("Angel " + angel.toString() + " was spawned at "
                + angel.getX() + " " + angel.getY());
    }

    public void notifyAngelHelp(final Angel angel, final Hero hero) {
        gameInputLoader.printLine(angel.toString() + " helped "
                + hero.toString() + " " + hero.getId());
    }

    public void notifyAngelHit(final Angel angel, final Hero hero) {
        gameInputLoader.printLine(angel.toString() + " hit "
                + hero.toString() + " " + hero.getId());
    }

    public void notifyAngelDeath(final Hero hero) {
        gameInputLoader.printLine("Player " + hero.toString() + " " + hero.getId()
                + " was killed by an angel");
    }

    public void notifyAngelRespawn(final Hero hero) {
        gameInputLoader.printLine("Player " + hero.toString() + " " + hero.getId()
                + " was brought to life by an angel");
    }
}
