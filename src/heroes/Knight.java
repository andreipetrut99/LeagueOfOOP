package heroes;


public class Knight extends Hero {
    public Knight(int x, int y, String heroType) {
        super(x, y, heroType);
        setHp(900);
    }

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }

    @Override
    public void resetHp() {
        super.setHp(900 + (80 * getLevel()));
    }

    @Override
    public int getMaxHp() {
        return (900 + (80 * getLevel()));
    }

    @Override
    public void attack(Hero enemy, char landType) {
        float executeDamage = 200 + (30 * this.getLevel());
        float slamDamage = 100 + (40 * this.getLevel());
        float hpLimit;
        float maxPercentage;

        if (enemy.getLevel() >= 40) {
            maxPercentage = 1.6f;
        } else {
            maxPercentage = 0.2f + (float)enemy.getLevel() / 100;
        }
        hpLimit = 500 * maxPercentage;

        if (enemy.getHp() < Math.round(hpLimit)) {
            enemy.setInstantDamage(enemy.getHp());
        }

        if (landType == 'L') {
            executeDamage = executeDamage * 1.15f;
            slamDamage = slamDamage * 1.15f;
        }

        if (enemy instanceof Pyromancer) {
            executeDamage = executeDamage * 1.1f;
            slamDamage = slamDamage * 0.9f;
        } else if (enemy instanceof Rogue) {
            executeDamage = executeDamage * 1.15f;
            slamDamage = slamDamage * 0.8f;
        } else if (enemy instanceof Wizard) {
            executeDamage = executeDamage * 0.8f;
            slamDamage = slamDamage * 1.05f;
        } else {
            slamDamage = slamDamage * 1.2f;
        }

        enemy.setInstantDamage(Math.round(executeDamage));
        enemy.setInstantDamage(Math.round(slamDamage));
    }

}
