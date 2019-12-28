package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class TheDoomer extends Angel {
    public TheDoomer(int x, int y) {
        super(x, y);
    }

    @Override
    public void visit(Knight hero) {
        hero.setInstantDamage(hero.getHp());
        observer.notifyAngelHit(this, hero);
        observer.notifyAngelDeath(hero);
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.setInstantDamage(hero.getHp());
        observer.notifyAngelHit(this, hero);
        observer.notifyAngelDeath(hero);
    }

    @Override
    public void visit(Rogue hero) {
        hero.setInstantDamage(hero.getHp());
        observer.notifyAngelHit(this, hero);
        observer.notifyAngelDeath(hero);
    }

    @Override
    public void visit(Wizard hero) {
        hero.setInstantDamage(hero.getHp());
        observer.notifyAngelHit(this, hero);
        observer.notifyAngelDeath(hero);
    }

    @Override
    public String toString() {
        return "TheDoomer";
    }
}
