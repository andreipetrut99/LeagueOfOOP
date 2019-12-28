package strategies;

import heroes.Hero;
import heroes.Knight;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Hero hero) {
        strategy.applyStrategy(hero);
    }
}
