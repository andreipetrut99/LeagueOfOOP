package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DarkAngel implements Angel {
    @Override
    public void visit(Pyromancer hero) {
        hero.setInstantDamage(30);
    }

    @Override
    public void visit(Knight hero) {
        hero.setInstantDamage(40);
    }

    @Override
    public void visit(Rogue hero) {
        hero.setInstantDamage(10);
    }

    @Override
    public void visit(Wizard hero) {
        hero.setInstantDamage(20);
    }
}
