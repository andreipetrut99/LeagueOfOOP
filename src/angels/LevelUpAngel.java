package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LevelUpAngel implements Angel {
    @Override
    public void visit(Knight hero) {
        hero.changeModifiers(0.1f);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.changeModifiers(0.2f);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
    }

    @Override
    public void visit(Rogue hero) {
        hero.changeModifiers(0.15f);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
    }

    @Override
    public void visit(Wizard hero) {
        hero.changeModifiers(0.25f);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
    }
}
