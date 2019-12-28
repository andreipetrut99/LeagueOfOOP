package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DarkAngel extends Angel {

    public DarkAngel(int x, int y) {
        super(x, y);
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.setInstantDamage(30);
        observer.notifyAngelHit(this, hero);
    }

    @Override
    public void visit(Knight hero) {
        hero.setInstantDamage(40);
        observer.notifyAngelHit(this, hero);
    }

    @Override
    public void visit(Rogue hero) {
        hero.setInstantDamage(10);
        observer.notifyAngelHit(this, hero);
    }

    @Override
    public void visit(Wizard hero) {
        hero.setInstantDamage(20);
        observer.notifyAngelHit(this, hero);
    }

    @Override
    public String toString() {
        return "DarkAngel";
    }
}
