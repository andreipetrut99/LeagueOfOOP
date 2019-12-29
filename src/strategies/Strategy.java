package strategies;

import heroes.*;

public abstract class Strategy {
    public void applyStrategy(final Knight hero) { }
    public void applyStrategy(final Pyromancer hero) { }
    public void applyStrategy(final Rogue hero) { }
    public void applyStrategy(final Wizard hero) { }
}
