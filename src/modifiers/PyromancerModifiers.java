package modifiers;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class PyromancerModifiers implements Modifiers {
    @Override
    public float modify(Knight knight) {
        return 0;
    }

    @Override
    public float modify(Rogue rogue) {
        return 0;
    }

    @Override
    public float modify(Wizard wizard) {
        return 0;
    }

    @Override
    public float modify(Pyromancer pyromancer) {
        return 0;
    }
}
