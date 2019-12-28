package strategies;

import heroes.Hero;

public class RogueSecondStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        hero.changeModifiers(-0.1f);
        hero.setInstantDamage(-hero.getHp()/2);
    }
}
