package strategies;

import heroes.Hero;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Hero hero) {
        hero.acceptStrategy(strategy);
    }
}
