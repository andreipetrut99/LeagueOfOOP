package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class SmallAngel implements Angel {
    @Override
    public void visit(Knight hero) {
        hero.setInstantDamage(10);
        hero.changeModifiers(0.1f);
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.changeModifiers(0.15);
        hero.setInstantDamage(-15);
    }

    @Override
    public void visit(Rogue hero) {
        hero.changeModifiers(0.05f);
        hero.setInstantDamage(20);
    }

    @Override
    public void visit(Wizard hero) {
        hero.setInstantDamage(-25);
        hero.changeModifiers(0.1f);
    }
}
