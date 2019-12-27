package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class TheDoomer implements Angel {
    @Override
    public void visit(Knight hero) {
        hero.setInstantDamage(hero.getHp());
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.setInstantDamage(hero.getHp());
    }

    @Override
    public void visit(Rogue hero) {
        hero.setInstantDamage(hero.getHp());
    }

    @Override
    public void visit(Wizard hero) {
        hero.setInstantDamage(hero.getHp());
    }
}
