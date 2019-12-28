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
        hero.changeModifiers(0.1f);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.changeModifiers(0.2f);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Rogue hero) {
        hero.changeModifiers(0.15f);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Wizard hero) {
        hero.changeModifiers(0.25f);
        hero.addXp(hero.getXpLevelUp() - hero.getXp());
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public String toString() {
        return "LevelUpAngel";
    }
}
