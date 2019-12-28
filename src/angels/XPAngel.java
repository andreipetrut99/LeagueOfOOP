package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class XPAngel extends Angel {
    public XPAngel(int x, int y) {
        super(x, y);
    }

    @Override
    public void visit(Knight hero) {
        hero.addXp(45);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.addXp(50);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Rogue hero) {
        hero.addXp(40);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Wizard hero) {
        hero.addXp(60);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public String toString() {
        return "XPAngel";
    }
}
