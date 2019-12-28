package strategies;

import heroes.Hero;

public class RogueFirstStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        hero.setInstantDamage(hero.getHp() / 7);
        hero.changeModifiers(0.4f);
    }
}
