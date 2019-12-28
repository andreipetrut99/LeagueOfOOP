package strategies;

import heroes.Hero;

public class WizardFirstStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        hero.setInstantDamage(hero.getHp() / 10);
        hero.changeModifiers(0.6f);
    }
}
