package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public interface Angel {
    void visit(Knight hero);
    void visit(Pyromancer hero);
    void visit(Rogue hero);
    void visit(Wizard hero);
}
