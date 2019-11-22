package com.oop_upb.modifiers;

import com.oop_upb.heroes.Knight;
import com.oop_upb.heroes.Pyromancer;
import com.oop_upb.heroes.Rogue;
import com.oop_upb.heroes.Wizard;

public interface Modifiers {
    float modify(Knight knight);
    float modify(Rogue rogue);
    float modify(Wizard wizard);
    float modify(Pyromancer pyromancer);
}
