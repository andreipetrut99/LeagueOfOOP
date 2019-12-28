package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class SmallAngel extends Angel {
    public SmallAngel(int x, int y) {
        super(x, y);
    }

    @Override
    public void visit(Knight hero) {
        hero.setInstantDamage(-10);
        hero.changeModifiers(0.1f);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.changeModifiers(0.15f);
        hero.setInstantDamage(-15);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Rogue hero) {
        hero.changeModifiers(0.05f);
        hero.setInstantDamage(20);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Wizard hero) {
        hero.setInstantDamage(-25);
        hero.changeModifiers(0.1f);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public String toString() {
        return "SmallAngel";
    }
}
