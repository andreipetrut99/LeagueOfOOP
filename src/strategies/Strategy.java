package strategies;

import heroes.*;

public abstract class Strategy {
    public void applyStrategy(Knight hero) {}
    public void applyStrategy(Pyromancer hero) {}
    public void applyStrategy(Rogue hero) {}
    public void applyStrategy(Wizard hero) {}
}
