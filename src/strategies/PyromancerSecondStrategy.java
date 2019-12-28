package strategies;

import heroes.Hero;

public class PyromancerSecondStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        hero.changeModifiers(-0.3f);
        hero.setInstantDamage(- hero.getHp() / 3);
    }
}
