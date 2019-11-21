package com.oop_upb.heroes;

public class Pyromancer extends Hero {
    private int hp = 500;
    private int xp = 0;
    private int hpPerLever = 50;
    private Hero enemy;
    private int fireblastDamage;
    private int igniteInstantDamage;
    private int ignitePassiveDamage;

    public Pyromancer(int x, int y, String landType) {
        super(x, y, landType);
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void attack(Hero enemy) {
        fireblastDamage = (350 + (50 * this.getLevel()));
        igniteInstantDamage = (150 + (20 * this.getLevel()));
        ignitePassiveDamage = (50 + (30 * this.getLevel()));
        enemy.setHp(enemy.getHp() - fireblastDamage - igniteInstantDamage + ignitePassiveDamage);
        enemy.setOvertimeDamage(ignitePassiveDamage, 2);
    }

    public void getDamage() {
        fireblastDamage = (350 + (50 * this.getLevel()));
        igniteInstantDamage = (150 + (20 * this.getLevel()));
        ignitePassiveDamage = (50 + (30 * this.getLevel()));
    }

    public void setIgnitePassiveDamage(int ignitePassiveDamage) {
        this.ignitePassiveDamage = ignitePassiveDamage;
    }

    public void setIgniteInstantDamage(int igniteInstantDamage) {
        this.igniteInstantDamage = igniteInstantDamage;
    }

    public void setFireblastDamage(int fireblastDamage) {
        this.fireblastDamage = fireblastDamage;
    }

    public int getIgnitePassiveDamage() {
        return ignitePassiveDamage;
    }

    public int getIgniteInstantDamage() {
        return igniteInstantDamage;
    }

    public int getFireblastDamage() {
        return fireblastDamage;
    }
// todo: de adaugat metoda pt damage periodic

}
