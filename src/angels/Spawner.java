package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Spawner extends Angel {
    public Spawner(int x, int y) {
        super(x, y);
    }

    @Override
    public void visit(Knight hero) {
        if (hero.getHp() <= 0) {
            hero.setHp(200);
            observer.notifyAngelHelp(this, hero);
            observer.notifyAngelRespawn(hero);
        }
    }

    @Override
    public void visit(Pyromancer hero) {
        if (hero.getHp() <= 0) {
            hero.setHp(150);
            observer.notifyAngelHelp(this, hero);
            observer.notifyAngelRespawn(hero);
        }
    }

    @Override
    public void visit(Rogue hero) {
        if (hero.getHp() <= 0) {
            hero.setHp(180);
            observer.notifyAngelHelp(this, hero);
            observer.notifyAngelRespawn(hero);
        }
    }

    @Override
    public void visit(Wizard hero) {
        if (hero.getHp() <= 0) {
            hero.setHp(120);
            observer.notifyAngelHelp(this, hero);
            observer.notifyAngelRespawn(hero);
        }
    }

    @Override
    public String toString() {
        return "Spawner";
    }
}
