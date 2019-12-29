package angels;

import admin.TheGreatWizard;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public abstract class Angel {
    protected TheGreatWizard observer = TheGreatWizard.getInstance();
    private int x, y;

    public Angel(final int x, final int y) {
        this.x = x;
        this.y = y;
        observer.notifyAngelSpawn(this);
    }

    /**
     * Getter for x position of the angel.
     * @return xPos
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for y position of the angel.
     * @return yPos
     */
    public int getY() {
        return y;
    }

    public abstract void visit(Knight hero);
    public abstract void visit(Pyromancer hero);
    public abstract void visit(Rogue hero);
    public abstract void visit(Wizard hero);
}
