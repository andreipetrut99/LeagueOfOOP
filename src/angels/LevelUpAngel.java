package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(int x, int y) {
        super(x, y);
    }

    @Override
    public void visit(Knight hero) {
        observer.notifyAngelHelp(this, hero);
        hero.changeModifiers(0.1f);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
    }

    @Override
    public void visit(Pyromancer hero) {
        observer.notifyAngelHelp(this, hero);
        hero.changeModifiers(0.2f);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
    }

    @Override
    public void visit(Rogue hero) {
        observer.notifyAngelHelp(this, hero);
        hero.changeModifiers(0.15f);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
    }

    @Override
    public void visit(Wizard hero) {
        observer.notifyAngelHelp(this, hero);
        hero.changeModifiers(0.25f);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
    }

    @Override
    public String toString() {
        return "LevelUpAngel";
    }
}
