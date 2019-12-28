package strategies;

import heroes.Hero;

public class KnightFirstStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        hero.setInstantDamage((int) (0.2 * hero.getHp()));
        hero.changeModifiers(0.5f);
    }
}
