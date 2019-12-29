package strategies;

import heroes.Hero;

public class Context {
    private Strategy strategy;

    public Context(final Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Execute the strategy on hero in this context.
     * @param hero
     */
    public void executeStrategy(final Hero hero) {
        hero.acceptStrategy(strategy);
    }
}
