package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Dracula extends Angel {
    public Dracula(int x, int y) {
        super(x, y);
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.changeModifiers(-0.3f);
        hero.setInstantDamage(40);
        observer.notifyAngelHit(this, hero);
    }

    @Override
    public void visit(Knight hero) {
        hero.changeModifiers(-0.2f);
        hero.setInstantDamage(60);
        observer.notifyAngelHit(this, hero);
    }

    @Override
    public void visit(Rogue hero) {
        hero.changeModifiers(-0.1f);
        hero.setInstantDamage(35);
        observer.notifyAngelHit(this, hero);
    }

    @Override
    public void visit(Wizard hero) {
        hero.changeModifiers(-0.4f);
        hero.setInstantDamage(20);
        observer.notifyAngelHit(this, hero);
    }
    @Override
    public String toString() {
        return "Dracula";
    }
}
