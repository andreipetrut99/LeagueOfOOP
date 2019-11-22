package com.oop_upb.modifiers;

import com.oop_upb.heroes.Knight;
import com.oop_upb.heroes.Pyromancer;
import com.oop_upb.heroes.Rogue;
import com.oop_upb.heroes.Wizard;

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
