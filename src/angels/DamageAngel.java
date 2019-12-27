package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DamageAngel implements Angel {
    @Override
    public void visit(Pyromancer hero) {
        hero.changeModifiers(0.2f);
    }

    @Override
    public void visit(Knight hero) {
        hero.changeModifiers(0.15f);
    }

    @Override
    public void visit(Rogue hero) {
        hero.changeModifiers(0.3f);
    }

    @Override
    public void visit(Wizard hero) {
        hero.changeModifiers(0.4f);
    }
}
