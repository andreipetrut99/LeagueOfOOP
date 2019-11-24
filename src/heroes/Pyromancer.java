package heroes;

public class Pyromancer extends Hero {
    private int xp = 0;
    private int hpPerLever = 50;
    private Hero enemy;
    private float fireblastDamage;
    private float igniteInstantDamage;
    private float ignitePassiveDamage;
    private float damageDealt;

    public Pyromancer(int x, int y, String landType) {
        super(x, y, landType);
        super.setHp(500);
    }

    public void attack(Hero enemy, char terainType) {
        fireblastDamage = (350 + (50 * this.getLevel()));
        igniteInstantDamage = (150 + (20 * this.getLevel()));
        ignitePassiveDamage = (50 + (30 * this.getLevel()));
        if (terainType == 'V') {
            fireblastDamage = fireblastDamage * 1.25f;
            ignitePassiveDamage = ignitePassiveDamage * 1.25f;
            igniteInstantDamage = igniteInstantDamage * 1.25f;
        }

         if (enemy instanceof  Rogue) {
            fireblastDamage = fireblastDamage * 0.80f;
            igniteInstantDamage = igniteInstantDamage * 0.80f;
            ignitePassiveDamage = ignitePassiveDamage * 0.80f;
         } else if (enemy instanceof Knight) {
             fireblastDamage = fireblastDamage * 1.2f;
             igniteInstantDamage = igniteInstantDamage * 1.2f;
             ignitePassiveDamage = ignitePassiveDamage * 1.2f;
         } else if (enemy instanceof Wizard) {
             fireblastDamage = fireblastDamage * 1.05f;
             igniteInstantDamage = igniteInstantDamage * 1.05f;
             ignitePassiveDamage = ignitePassiveDamage * 1.05f;
         } else if (enemy instanceof Pyromancer) {
             fireblastDamage = fireblastDamage * 0.90f;
             igniteInstantDamage = igniteInstantDamage * 0.90f;
             ignitePassiveDamage = ignitePassiveDamage * 0.90f;
         }

         enemy.setInstantDamage(Math.round(fireblastDamage));
         enemy.setInstantDamage(Math.round(igniteInstantDamage));
         enemy.setOvertimeDamage(Math.round(ignitePassiveDamage), 3);
    }

    @Override
    public void resetHp() {
        super.setHp(500 + (50 * this.getLevel()));
    }

    @Override
    public int getMaxHp() {
        return (500 + (50 * this.getLevel()));
    }
// todo: de adaugat metoda pt damage periodic

}
