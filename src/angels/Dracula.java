package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Dracula implements Angel {
    @Override
    public void visit(Pyromancer hero) {
        hero.changeModifiers(-0.3f);
        hero.setInstantDamage(40);
    }

    @Override
    public void visit(Knight hero) {
        hero.changeModifiers(-0.2f);
        hero.setInstantDamage(60);
    }

    @Override
    public void visit(Rogue hero) {
        hero.changeModifiers(-0.1f);
        hero.setInstantDamage(35);
    }

    @Override
    public void visit(Wizard hero) {
        hero.changeModifiers(-0.4f);
        hero.setInstantDamage(20);
    }
}
