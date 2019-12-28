package strategies;

import heroes.*;

public abstract class Strategy {
    void applyStrategy(Knight hero) {}
    void applyStrategy(Pyromancer hero) {}
    void applyStrategy(Rogue hero) {}
    void applyStrategy(Wizard hero) {}
    void applyStrategy(Hero hero) {}

}
