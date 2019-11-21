package com.oop_upb.modifiers;

import com.oop_upb.heroes.Knight;
import com.oop_upb.heroes.Pyromancer;
import com.oop_upb.heroes.Rogue;
import com.oop_upb.heroes.Wizard;

public interface Modifiers {
    int modify(Knight knight);
    int modify(Rogue rogue);
    int modify(Wizard wizard);
    int modify(Pyromancer pyromancer);
}
