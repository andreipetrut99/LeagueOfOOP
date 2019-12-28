package strategies;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DeffenseStrategies extends Strategy {
    @Override
    public void applyStrategy(Knight hero) {
        hero.setInstantDamage((int) (-0.25 * hero.getHp()));
        hero.changeModifiers(-0.2f);
    }

    @Override
    public void applyStrategy(Pyromancer hero) {
        hero.changeModifiers(-0.3f);
        hero.setInstantDamage(- hero.getHp() / 3);
    }

    @Override
    public void applyStrategy(Rogue hero) {
        hero.changeModifiers(-0.1f);
        hero.setInstantDamage(-hero.getHp()/2);
    }

    @Override
    public void applyStrategy(Wizard hero) {
        hero.changeModifiers(-0.2f);
        hero.setInstantDamage(-hero.getHp()/5);
    }
}
