package strategies;

import heroes.Hero;

public class PyromancerFirstStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        hero.setInstantDamage((int) (0.25 * hero.getHp()));
        hero.changeModifiers(0.7f);
    }
}
