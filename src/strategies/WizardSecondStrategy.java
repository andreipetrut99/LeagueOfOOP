package strategies;

import heroes.Hero;

public class WizardSecondStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        hero.changeModifiers(-0.2f);
        hero.setInstantDamage(-hero.getHp()/5);
    }
}
