package heroes;

public class Rogue extends Hero {
    private float unmodifiedDamage;
    private int backstabHits = 3;
    private boolean attacked = false;
     public Rogue(int x, int y, String landType) {
         super(x, y, landType);
         setHp(600);
     }

    @Override
    public void resetHp() {
        setHp(600 + (40 * getLevel()));
    }

    @Override
    public int getMaxHp() {
        return 600 + (40 * getLevel());
    }

    @Override
    public void attack(Hero enemy, char landType) {
         float backstabDamage = 200 + (20 * getLevel());
        float paralysisDamage = 40 + (10 * getLevel());
        int paralysisRounds;
        attacked = true;

        if (backstabHits == 3 && landType == 'W') {
            backstabDamage = backstabDamage * 1.5f;
            backstabHits = 0;
        } else if (backstabHits == 3) {
            backstabHits = 0;
        }
        backstabHits++;

        if (landType == 'W') {
            paralysisRounds = 6;
            paralysisDamage = paralysisDamage * 1.15f;
            backstabDamage = backstabDamage * 1.15f;
        } else {
            paralysisRounds = 3;
        }
        unmodifiedDamage = Math.round(backstabDamage) + Math.round(paralysisDamage);

        if (enemy instanceof Rogue) {
            backstabDamage = backstabDamage * 1.2f;
            paralysisDamage = paralysisDamage * 0.9f;
        } else if (enemy instanceof Knight) {
            backstabDamage = backstabDamage * 0.9f;
            paralysisDamage = paralysisDamage * 0.8f;
        } else if (enemy instanceof Pyromancer) {
            backstabDamage = backstabDamage * 1.25f;
            paralysisDamage = paralysisDamage * 1.2f;
        } else {
            backstabDamage = backstabDamage * 1.25f;
            paralysisDamage = paralysisDamage * 1.25f;
        }

        enemy.setInstantDamage(Math.round(backstabDamage));
        enemy.setInstantDamage(Math.round(paralysisDamage));
        enemy.setOvertimeDamage(Math.round(paralysisDamage), paralysisRounds);
        enemy.setIncapacitation(paralysisRounds);
    }

    @Override
    public float getUnmodifiedDamage(char landType) {
         float backstabDamage = 200 + (20 * getLevel());
         float paralysisDamage = 40 + (10 * getLevel());
         if (attacked) {
            if (((backstabHits - 1) == 0) && (landType =='W')) {
                backstabDamage = backstabDamage * 1.5f;
            }
         } else {
             if (backstabHits == 3 && landType == 'W') {
                 backstabDamage = backstabDamage * 1.5f;
             }
         }

        if (landType == 'W') {
            backstabDamage = backstabDamage * 1.15f;
            paralysisDamage = paralysisDamage * 1.15f;
        }

        return Math.round(backstabDamage) + Math.round(paralysisDamage);
    }
}
