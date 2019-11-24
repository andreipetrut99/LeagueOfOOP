package modifiers;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public interface Modifiers {
    float modify(Knight knight);
    float modify(Rogue rogue);
    float modify(Wizard wizard);
    float modify(Pyromancer pyromancer);
}
