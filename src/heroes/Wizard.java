package heroes;

public class Wizard extends Hero {
    public Wizard(int x, int y, String landType) {
        super(x, y, landType);
        setHp(400);
    }

    @Override
    public void resetHp() {
        super.setHp(400 + (30 * getLevel()));
    }

    @Override
    public int getMaxHp() {
        return 400 + (30 * getLevel());
    }

    @Override
    public void attack(Hero enemy, char landType) {
        float drainPercent = 0.2f + (0.05f * enemy.getLevel());
        float deflectPercent;
        if (enemy.getLevel() > 17) {
            deflectPercent = 0.7f;
        } else {
            deflectPercent = 0.35f + (0.02f * enemy.getLevel());
        }

        if (enemy instanceof Rogue) {
            drainPercent = 0.8f * drainPercent;
            deflectPercent = 1.2f * deflectPercent;
        } else if (enemy instanceof Knight) {
            drainPercent = 1.2f * drainPercent;
            deflectPercent = 1.4f * deflectPercent;
        } else if (enemy instanceof Pyromancer) {
            drainPercent = 0.9f * drainPercent;
            deflectPercent = 1.3f * deflectPercent;
        } else {
            drainPercent = 1.05f * drainPercent;
            deflectPercent = 0f;
        }
        float drainDamage = drainPercent * (Math.min(0.3f * enemy.getMaxHp(), enemy.getHp()));
        float deflectDamage = deflectPercent * enemy.getUnmodifiedDamage(landType);
        if (landType == 'D') {
            drainDamage = drainDamage * 1.1f;
            deflectDamage = deflectDamage * 1.1f;
        }

        enemy.setInstantDamage(Math.round(drainDamage) + Math.round(deflectDamage));

    }

    @Override
    public float getUnmodifiedDamage(char landType) {
        return 0;
    }

}
