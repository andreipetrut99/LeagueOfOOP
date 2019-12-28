package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LifeGiver extends Angel {
    public LifeGiver(int x, int y) {
        super(x, y);
    }

    @Override
    public void visit(Knight hero) {
        hero.setInstantDamage(-100);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.setInstantDamage(-80);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Rogue hero) {
        hero.setInstantDamage(-90);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Wizard hero) {
        hero.setInstantDamage(-120);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public String toString() {
        return "LifeGiver";
    }
}
