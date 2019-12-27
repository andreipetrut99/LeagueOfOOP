package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LifeGiver implements Angel {
    @Override
    public void visit(Knight hero) {
        hero.setInstantDamage(-100);
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.setInstantDamage(-80);
    }

    @Override
    public void visit(Rogue hero) {
        hero.setInstantDamage(-90);
    }

    @Override
    public void visit(Wizard hero) {
        hero.setInstantDamage(-120);
    }
}
