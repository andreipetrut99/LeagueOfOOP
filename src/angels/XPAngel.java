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
        observer.notifyAngelHelp(this, hero);
        hero.addXp(45);
    }

    @Override
    public void visit(Pyromancer hero) {
        observer.notifyAngelHelp(this, hero);
        hero.addXp(50);
    }

    @Override
    public void visit(Rogue hero) {
        observer.notifyAngelHelp(this, hero);
        hero.addXp(40);
    }

    @Override
    public void visit(Wizard hero) {
        observer.notifyAngelHelp(this, hero);
        hero.addXp(60);
    }

    @Override
    public String toString() {
        return "XPAngel";
    }
}
