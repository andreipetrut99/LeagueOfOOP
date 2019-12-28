package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class GoodBoy extends Angel {
    public GoodBoy(int x, int y) {
        super(x, y);
    }

    @Override
    public void visit(Knight hero) {
        hero.changeModifiers(0.4f);
        hero.setInstantDamage(-20);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Pyromancer hero) {
        hero.changeModifiers(0.5f);
        hero.setInstantDamage(-30);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Rogue hero) {
        hero.changeModifiers(0.4f);
        hero.setInstantDamage(-40);
        observer.notifyAngelHelp(this, hero);
    }

    @Override
    public void visit(Wizard hero) {
        hero.changeModifiers(0.3f);
        hero.setInstantDamage(-50);
        observer.notifyAngelHelp(this, hero);
    }
    @Override
    public String toString() {
        return "GoodBoy";
    }
}
