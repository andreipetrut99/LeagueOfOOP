package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class XPAngel implements Angel {
    @Override
    public void visit(Knight hero) {
        hero.addXp(45);
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.addXp(50);
    }

    @Override
    public void visit(Rogue hero) {
        hero.addXp(40);
    }

    @Override
    public void visit(Wizard hero) {
        hero.addXp(60);
    }
}
