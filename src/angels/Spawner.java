package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Spawner implements Angel {
    @Override
    public void visit(Knight hero) {
        if (hero.getHp() <= 0) {
            hero.setHp(200);
        }
    }

    @Override
    public void visit(Pyromancer hero) {
        if (hero.getHp() <= 0) {
            hero.setHp(150);
        }
    }

    @Override
    public void visit(Rogue hero) {
        if (hero.getHp() <= 0) {
            hero.setHp(180);
        }
    }

    @Override
    public void visit(Wizard hero) {
        if (hero.getHp() <= 0) {
            hero.setHp(120);
        }
    }
}
