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
        if (hero.getHp() + 100 > hero.getMaxHp()) {
            hero.setHp(hero.getMaxHp());
        } else {
            hero.setInstantDamage(-100);
        }
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Pyromancer hero) {
        if (hero.getHp() + 80 > hero.getMaxHp()) {
            hero.setHp(hero.getMaxHp());
        } else {
            hero.setInstantDamage(-80);
        }
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Rogue hero) {
        if (hero.getHp() + 90 > hero.getMaxHp()) {
            hero.setHp(hero.getMaxHp());
        } else {
            hero.setInstantDamage(-90);
        }
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Wizard hero) {
        if (hero.getHp() + 120 > hero.getMaxHp()) {
            hero.setHp(hero.getMaxHp());
        } else {
            hero.setInstantDamage(-120);
        }
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public String toString() {
        return "LifeGiver";
    }
}
