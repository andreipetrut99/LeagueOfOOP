package strategies;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class OffensiveStrategies extends Strategy {
    @Override
    public void applyStrategy(Knight hero) {
        hero.setInstantDamage((int) (0.2 * hero.getHp()));
        hero.changeModifiers(0.5f);
    }

    @Override
    public void applyStrategy(Pyromancer hero) {
        hero.setInstantDamage((int) (0.25 * hero.getHp()));
        hero.changeModifiers(0.7f);
    }

    @Override
    public void applyStrategy(Rogue hero) {
        hero.setInstantDamage(hero.getHp() / 7);
        hero.changeModifiers(0.4f);
    }

    @Override
    public void applyStrategy(Wizard hero) {
        hero.setInstantDamage(hero.getHp() / 10);
        hero.changeModifiers(0.6f);
    }
}
