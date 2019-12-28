package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DamageAngel extends Angel {

    public DamageAngel(int x, int y) {
        super(x, y);
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.changeModifiers(0.2f);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Knight hero) {
        hero.changeModifiers(0.15f);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Rogue hero) {
        hero.changeModifiers(0.3f);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Wizard hero) {
        hero.changeModifiers(0.4f);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public String toString() {
        return "DamageAngel";
    }
}
